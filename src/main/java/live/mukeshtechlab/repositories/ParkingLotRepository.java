package live.mukeshtechlab.repositories;

import live.mukeshtechlab.models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap;
    private Long previousId;

    public ParkingLotRepository(){
        this.parkingLotMap = new TreeMap<>();
        this.previousId = 0L;
    }

    public ParkingLot save(ParkingLot parkingLot){
        if(parkingLot.getId() == null){
            // Add new parking Lot
            parkingLot.setId(++previousId);
        }

        parkingLotMap.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }

    public Optional<ParkingLot> findById(Long parkingLotId){
        if(parkingLotMap.containsKey(parkingLotId)){
            return Optional.of(parkingLotMap.get(parkingLotId));
        }
        return Optional.empty();
    }

    public Optional<ParkingLot> delete(Long parkingLotId){
        if(parkingLotMap.containsKey(parkingLotId)){
            return Optional.of(parkingLotMap.remove(parkingLotId));
        }

        return Optional.empty();
    }
}
