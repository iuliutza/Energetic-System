package game.Consumer;

import game.AbstractFactory;
import game.Consumer.Consumer;
import game.Distributor.Distributor;

public final class ConsumerFactory extends AbstractFactory {
    @Override
    public Consumer createConsumer(final int id, final long budget, final long monthlyIncome) {
        return new Consumer(id, budget, monthlyIncome);
    }

    @Override
    public Distributor createDistributor(final int id, final long budget, final int contractLength,
                                         final long iCost, final int energyNeededKW, final String strategy) {
        return null;
    }
}
