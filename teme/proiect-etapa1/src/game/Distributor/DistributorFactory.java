package game.Distributor;

import game.AbstractFactory;
import game.Consumer.Consumer;

public final class DistributorFactory extends AbstractFactory {

    @Override
    public Consumer createConsumer(final int id, final long budget, final long monthlyIncome) {
        return null;
    }

    @Override
    public Distributor createDistributor(final int id, final long budget, final int contractLength,
                                         final long iCost, final int energyNeededKW,
                                         final String strategy) {
        return new Distributor(id, budget, contractLength, iCost,energyNeededKW,strategy);
    }
}
