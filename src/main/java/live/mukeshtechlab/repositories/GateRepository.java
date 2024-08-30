package live.mukeshtechlab.repositories;

import live.mukeshtechlab.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private Map<Long, Gate> gateMap;
    private Long previousId;

    public GateRepository() {
        this.gateMap = new TreeMap<>();
        this.previousId = 0L;
    }

    // Create or Update
    public Gate save(Gate gate) {
        if (gate.getId() == null) {
            // This gate is not saved in DB, hence Store it with new Id
            gate.setId(++previousId);
        }

        gateMap.put(gate.getId(), gate);
        return gate;
    }

    // Read
    public Optional<Gate> findById(Long gateId) {
        if (gateMap.containsKey(gateId)) {
            return Optional.of(gateMap.get(gateId));
        }
        return Optional.empty();
    }

    // Delete
    public Optional<Gate> delete(Long gateId) {
        if (gateMap.containsKey(gateId)) {
            return Optional.of(gateMap.remove(gateId));
        }
        return Optional.empty();
    }

}
