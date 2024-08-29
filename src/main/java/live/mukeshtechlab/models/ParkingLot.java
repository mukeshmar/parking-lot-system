package live.mukeshtechlab.models;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ParkingLot extends BaseModel {
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus status;
    private List<Gate> gates;
    private List<VehicleType> supportedVehicleType;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;
    private FeeCalculationStrategyType feeCalculationStrategyType;
}
