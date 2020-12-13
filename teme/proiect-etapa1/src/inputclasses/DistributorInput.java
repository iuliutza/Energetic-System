package inputclasses;

public final class DistributorInput extends ShowEntity {
    private int contractLength;
    private long initialInfrastructureCost;
    private long initialProductionCost;

    public DistributorInput() { }

    public DistributorInput(final int id, final long initialBudget,
                            final int contractLength,
                            final long initialInfrastructureCost,
                            final long initialProductionCost) {
        super(id, initialBudget);
        this.contractLength = contractLength;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.initialProductionCost = initialProductionCost;
    }

    public int getContractLength() {
        return contractLength;
    }

    public long getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    public long getInitialProductionCost() {
        return initialProductionCost;
    }

    @Override
    public String toString() {
        return "DistributorInput{"
                + "contractLength=" + contractLength
                + ", initialInfrastructureCost=" + initialInfrastructureCost
                + ", initialProductionCost=" + initialProductionCost
                + ", id=" + super.getId()
                + ", initialBudget=" + super.getInitialBudget()
                + '}';
    }
}
