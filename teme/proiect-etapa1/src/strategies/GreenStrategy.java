package strategies;

import game.producer.Producer;

import java.util.ArrayList;
import java.util.List;

public final class GreenStrategy implements Strategy {

    @Override
    public Producer chooseStrategy(List<Producer> producers) {
        List<Producer> producersToPrice = new ArrayList<>();
        PriceStrategy strategy = new PriceStrategy();

        for (Producer producer : producers) {
            if (producer.getEnergyType().isRenewable()) {
                producersToPrice.add(producer);
            }
        }
        if (producersToPrice.size() > 1) {
            return strategy.chooseStrategy(producersToPrice);
        } else if (producersToPrice.size() == 0) {
            return strategy.chooseStrategy(producers);
        } else {
            return producersToPrice.get(0);
        }
    }
}
