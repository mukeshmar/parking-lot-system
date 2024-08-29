package live.mukeshtechlab.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel {
    private int florNumber;
    private ParkingFloorStatus status;
    private List<ParkingSpot> parkingSpots;
}
