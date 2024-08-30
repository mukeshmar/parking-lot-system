package live.mukeshtechlab.dtos;

import live.mukeshtechlab.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
