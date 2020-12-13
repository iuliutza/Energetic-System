package game;

public final class DistributorFactory extends AbstractFactory {

    @Override
    public Consumer createConsumer(final int id, final long budget, final long monthlyIncome) {
        return null;
    }

    @Override
    public Distributor createDistributor(final int id, final long budget, final int contractLength,
                                         final long pCost, final long iCost) {
        return new Distributor(id, budget, contractLength, pCost, iCost);
    }
}
