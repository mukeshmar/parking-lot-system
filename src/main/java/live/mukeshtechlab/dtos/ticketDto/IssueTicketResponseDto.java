package live.mukeshtechlab.dtos.ticketDto;

import live.mukeshtechlab.dtos.ResponseStatus;
import live.mukeshtechlab.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
