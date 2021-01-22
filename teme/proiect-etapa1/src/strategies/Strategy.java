package strategies;

import game.producer.Producer;

import java.util.List;

public interface Strategy {
    /**
     * chooses the producer according to the distributor's strategy
     *
     * @param producers list of producers to choose from
     * @return the chosen producer
     */
    Producer chooseStrategy(List<Producer> producers);

}
