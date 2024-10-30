import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Random;

@Component
public class MyTasks {

    private static int nextVehicleId = 1;
    private final RestTemplate restTemplate = new RestTemplate();
    private final Random random = new Random();

    // Scheduled task to add a vehicle at fixed intervals
    @Scheduled(fixedRate = 10000)
    public void addVehicle() {
        Vehicle newVehicle = generateRandomVehicle();
        restTemplate.postForObject("http://localhost:8080/addVehicle", newVehicle, Vehicle.class);
        System.out.println("Added vehicle: " + newVehicle);
    }

    // Scheduled task to delete a vehicle at fixed intervals
    @Scheduled(fixedRate = 15000)
    public void deleteVehicle() {
        int randomId = generateRandomId(100);
        restTemplate.delete("http://localhost:8080/deleteVehicle/" + randomId);
        System.out.println("Deleted vehicle with ID: " + randomId);
    }

    // Scheduled task to update a vehicle at fixed intervals
    @Scheduled(fixedRate = 20000)
    public void updateVehicle() {
        int randomId = generateRandomId(100);
        Vehicle updatedVehicle = new Vehicle(randomId, "Updated Model", 2015, 32000);
        restTemplate.put("http://localhost:8080/updateVehicle", updatedVehicle);
        Vehicle updatedFromServer = restTemplate.getForObject("http://localhost:8080/getVehicle/" + randomId, Vehicle.class);
        System.out.println("Updated vehicle: " + updatedFromServer);
    }

    // Helper method to generate a random vehicle
    private Vehicle generateRandomVehicle() {
        String makeModel = "Model" + random.nextInt(1000);
        int year = random.nextInt(2016 - 1986) + 1986;
        double retailPrice = 15000 + random.nextDouble() * 30000;
        return new Vehicle(nextVehicleId++, makeModel, year, retailPrice);
    }

    // Helper method to generate a random ID
    private int generateRandomId(int upperBound) {
        return random.nextInt(upperBound);
    }
}
