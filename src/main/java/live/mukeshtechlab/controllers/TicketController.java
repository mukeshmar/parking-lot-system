package live.mukeshtechlab.controllers;

import live.mukeshtechlab.dtos.IssueTicketRequestDto;
import live.mukeshtechlab.dtos.IssueTicketResponseDto;
import live.mukeshtechlab.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto){
        return null;
    }
}
