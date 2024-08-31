package live.mukeshtechlab.controllers;

import live.mukeshtechlab.dtos.ticketDto.IssueTicketRequestDto;
import live.mukeshtechlab.dtos.ticketDto.IssueTicketResponseDto;
import live.mukeshtechlab.dtos.ResponseStatus;
import live.mukeshtechlab.exceptions.GateNotFoundException;
import live.mukeshtechlab.models.Ticket;
import live.mukeshtechlab.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {

        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();

        try {
            Ticket ticket = ticketService.issueTicket(
                    issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getRegistrationNumber(),
                    issueTicketRequestDto.getOwnerName(),
                    issueTicketRequestDto.getVehicleType()
            );

            issueTicketResponseDto.setTicket(ticket);
            issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (GateNotFoundException ex) {
            System.out.println(ex.getMessage());
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return issueTicketResponseDto;
    }
}
