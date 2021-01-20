package strategies;

import game.producer.Producer;

import java.util.List;

public class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public Producer executeStrategy(List<Producer> producers) {
        return strategy.chooseStrategy(producers);
    }
}
