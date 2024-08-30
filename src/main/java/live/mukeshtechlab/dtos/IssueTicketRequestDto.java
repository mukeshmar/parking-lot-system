package live.mukeshtechlab.dtos;

import live.mukeshtechlab.models.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueTicketRequestDto {
    private Long gateId;
    private String registrationNumber;
    private String ownerName;
    private VehicleType vehicleType;
}
