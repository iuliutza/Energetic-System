package strategies;

import game.producer.Producer;

import java.util.List;

public final class QuantityStrategy implements Strategy {

    @Override
    public Producer chooseProducer(List<Producer> producers) {
        int max = 0;
        Producer finalProducer = new Producer();

        for (Producer producer : producers) {
            if (producer.getEnergyPerDistributor() > max) {
                max = producer.getEnergyPerDistributor();
            }
        }
        for (Producer producer : producers) {
            if (producer.getEnergyPerDistributor() == max) {
                finalProducer = producer;
                break;
            }
        }

        return finalProducer;
    }
}
