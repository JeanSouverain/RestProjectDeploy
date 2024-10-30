import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
public class VehicleController {

    // POST method to add a new vehicle
    @PostMapping("/addVehicle")
    public Vehicle addVehicle(@RequestBody Vehicle newVehicle) throws IOException {
        // Logic to add the new vehicle (e.g., writing to file)
        saveVehicleToFile(newVehicle);
        return newVehicle;
    }

    // DELETE method to delete a vehicle by ID
    @DeleteMapping("/deleteVehicle/{id}")
    public void deleteVehicle(@PathVariable int id) throws IOException {
        // Logic to delete the vehicle (e.g., removing from file)
        removeVehicleFromFile(id);
    }

    // PUT method to update an existing vehicle
    @PutMapping("/updateVehicle")
    public Vehicle updateVehicle(@RequestBody Vehicle updatedVehicle) throws IOException {
        // Logic to update the vehicle in file
        updateVehicleInFile(updatedVehicle);
        return updatedVehicle;
    }

    // GET method to retrieve a vehicle by ID
    @GetMapping("/getVehicle/{id}")
    public Vehicle getVehicle(@PathVariable int id) throws IOException {
        // Logic to find and return the vehicle from the file
        return findVehicleById(id);
    }

    // Helper methods for file operations (pseudo-code)
    private void saveVehicleToFile(Vehicle vehicle) throws IOException {
        // Code to serialize and write vehicle to file
    }

    private void removeVehicleFromFile(int id) throws IOException {
        // Code to remove vehicle by id from file
    }

    private void updateVehicleInFile(Vehicle vehicle) throws IOException {
        // Code to update vehicle in file
    }

    private Vehicle findVehicleById(int id) throws IOException {
        // Code to find and return vehicle by id
        return null; // Replace with actual return
    }
}
