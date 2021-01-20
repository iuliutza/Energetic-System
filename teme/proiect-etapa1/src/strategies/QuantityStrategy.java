package strategies;

import game.producer.Producer;

import java.util.List;

public class QuantityStrategy implements Strategy{

    @Override
    public Producer chooseStrategy(List<Producer> producers) {
        int min = 999999;
        Producer finalProducer = new Producer();

        for (Producer producer : producers) {
            if(producer.getEnergyPerDistributor() <= min) {
                min = producer.getEnergyPerDistributor();
            }
        }
        for (Producer producer : producers) {
            if(producer.getEnergyPerDistributor() == min){
                finalProducer = producer;
                break;
            }
        }

        return finalProducer;
    }
}
