package strategies;

import game.producer.Producer;

import java.util.List;

public final class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * executes the function through which the distributor chooses his producer
     * @param producers list of producers to choose from
     * @return the chosen producer
     */
    public Producer executeStrategy(List<Producer> producers) {
        return strategy.chooseStrategy(producers);
    }
}
