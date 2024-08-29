package live.mukeshtechlab.models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingSpot extends BaseModel {
    private String spotNumber; // e.g A1, A2, B1, B2 etc
    private ParkingSpotStatus status;
    private List<VehicleType> supportedVehicleType;
    private Long parkingFloorId;
}
