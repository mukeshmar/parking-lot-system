package live.mukeshtechlab.services.factories;

import live.mukeshtechlab.models.SpotAssignmentStrategyType;
import live.mukeshtechlab.services.strategies.spotAssignmentStrategy.NearestSpotAssignmentStrategy;
import live.mukeshtechlab.services.strategies.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import live.mukeshtechlab.services.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType type){
        switch (type){
            case RANDOM -> {
                return new RandomSpotAssignmentStrategy();
            }
            case NEAREST -> {
                return new NearestSpotAssignmentStrategy();
            }
            default -> {
                return null;
            }
        }
    }
}
