package live.mukeshtechlab.repositories;

import live.mukeshtechlab.models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    private Map<String, Vehicle> vehicleMap;
    private Long previousId;

    public VehicleRepository() {
        this.vehicleMap = new TreeMap<>();
        this.previousId = 0L;
    }

    public Vehicle save(Vehicle vehicle) {
        if (vehicle.getId() == null) {
            // Create a new Vehicle
            vehicle.setId(++previousId);
        }

        vehicleMap.put(vehicle.getRegistrationNumber(), vehicle);
        return vehicle;
    }

    public Optional<Vehicle> findByRegistrationNumber(String vehicleRegistrationNumber) {
        if (vehicleMap.containsKey(vehicleRegistrationNumber)) {
            return Optional.of(vehicleMap.get(vehicleRegistrationNumber));
        }

        return Optional.empty();
    }

    public Optional<Vehicle> delete(String vehicleRegistrationNumber) {
        if (vehicleMap.containsKey(vehicleRegistrationNumber)) {
            return Optional.of(vehicleMap.remove(vehicleRegistrationNumber));
        }

        return Optional.empty();
    }

}
