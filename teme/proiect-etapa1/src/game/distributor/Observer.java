package game.distributor;

import game.producer.Producer;

import java.util.List;

public interface Observer {
    /**
     * the distributor updates his list of producers
     * @param producers list of all producers in the game
     */
    void update(List<Producer> producers);
}
