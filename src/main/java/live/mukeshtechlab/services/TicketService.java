package live.mukeshtechlab.services;

import live.mukeshtechlab.exceptions.GateNotFoundException;
import live.mukeshtechlab.models.*;
import live.mukeshtechlab.repositories.GateRepository;
import live.mukeshtechlab.repositories.ParkingLotRepository;
import live.mukeshtechlab.repositories.VehicleRepository;
import live.mukeshtechlab.services.factories.SpotAssignmentStrategyFactory;
import live.mukeshtechlab.services.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(
            GateRepository gateRepository,
            VehicleRepository vehicleRepository,
            ParkingLotRepository parkingLotRepository
    ) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket issueTicket(
            Long gateId,
            String registrationNumber,
            String ownerName,
            VehicleType vehicleType
    ) throws GateNotFoundException {
        // Create Ticket
        Ticket ticket = new Ticket();
        ticket.setTicketNumber("AYX999Y");
        ticket.setEntryTime(new Date());

        // Gate
        // check if Gate is already present
        Optional<Gate> optionalGate = gateRepository.findById(gateId);
        if (optionalGate.isEmpty()) {
            // Throw Exception
            throw new GateNotFoundException("Gate Id " + gateId + " not found!");
        }
        Gate entryGate = optionalGate.get();
        ticket.setEntryGate(entryGate);

        // Operator generatedBy
        ticket.setGeneratedBy(entryGate.getOperator());

        // Vehicle
        Optional<Vehicle> optionalSavedVehicle = vehicleRepository.findByRegistrationNumber(registrationNumber);
        if (optionalSavedVehicle.isEmpty()) {
            // Create Vehicle
            Vehicle vehicle = new Vehicle();
            vehicle.setRegistrationNumber(registrationNumber);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save(vehicle);
            optionalSavedVehicle = Optional.of(vehicle);
        }
        Vehicle savedVehicle = optionalSavedVehicle.get();
        ticket.setVehicle(savedVehicle);

        // ParkingSpot
        Long parkingLotId = entryGate.getParkingLot().getId();
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findById(parkingLotId);

        ParkingLot savedParkingLot = optionalParkingLot.get();
        SpotAssignmentStrategyType spotAssignmentStrategyType = savedParkingLot.getSpotAssignmentStrategyType();

        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(
                spotAssignmentStrategyType
        );
        ticket.setParkingSpot(spotAssignmentStrategy.assignSpot(vehicleType));

        return ticket;
    }

}
