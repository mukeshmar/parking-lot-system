package live.mukeshtechlab.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ticket extends BaseModel {
    private String ticketNumber;
    private Date entryTime;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private Gate entryGate;
    private Operator generatedBy;
}
