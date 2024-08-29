package live.mukeshtechlab.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel {
    private GateStatus status;
    private GateType gateType;
    private ParkingLot parkingLot;
    private Operator operator;
}
