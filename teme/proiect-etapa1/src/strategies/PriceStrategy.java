package strategies;

import game.producer.Producer;

import java.util.ArrayList;
import java.util.List;

public class PriceStrategy implements Strategy{
    @Override
    public Producer chooseStrategy(List<Producer> producers) {
        double min = 999;
        QuantityStrategy strategy = new QuantityStrategy();
        List<Producer> producersToQuantity = new ArrayList<>();

        for (Producer producer : producers) {
            if (producer.getPriceKW() <= min) {
                min = producer.getPriceKW();
            }
        }

        for (Producer producer : producers) {
            if(producer.getPriceKW() == min){
                producersToQuantity.add(producer);
            }
        }

        if(producersToQuantity.size() != 1) {
            return strategy.chooseStrategy(producersToQuantity);
        } else {
            return producersToQuantity.get(0);
        }
    }
}
