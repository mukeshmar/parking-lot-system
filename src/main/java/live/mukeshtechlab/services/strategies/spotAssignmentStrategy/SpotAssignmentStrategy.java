package live.mukeshtechlab.services.strategies.spotAssignmentStrategy;

import live.mukeshtechlab.models.ParkingSpot;
import live.mukeshtechlab.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType);
}
