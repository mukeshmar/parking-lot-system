package live.mukeshtechlab;

import live.mukeshtechlab.controllers.TicketController;
import live.mukeshtechlab.dtos.ticketDto.IssueTicketRequestDto;
import live.mukeshtechlab.dtos.ticketDto.IssueTicketResponseDto;
import live.mukeshtechlab.models.VehicleType;
import live.mukeshtechlab.repositories.GateRepository;
import live.mukeshtechlab.repositories.ParkingLotRepository;
import live.mukeshtechlab.repositories.VehicleRepository;
import live.mukeshtechlab.services.TicketService;

public class Client {
    public static void main(String[] args) {
        bookTicket();
    }
    private static void bookTicket() {
        TicketService ticketService = new TicketService(
                new GateRepository(),
                new VehicleRepository(),
                new ParkingLotRepository()
        );

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto ticketRequestDto = new IssueTicketRequestDto();
        ticketRequestDto.setGateId(1L);
        ticketRequestDto.setOwnerName("Mukesh");
        ticketRequestDto.setRegistrationNumber("RJ07-SJ-1515");
        ticketRequestDto.setVehicleType(VehicleType.FOUR_WHEELER);

        IssueTicketResponseDto responseDto = ticketController.issueTicket(ticketRequestDto);
        System.out.println(responseDto.getTicket());
        System.out.println(responseDto.getResponseStatus());
    }
}