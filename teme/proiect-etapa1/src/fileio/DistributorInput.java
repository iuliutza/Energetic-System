package fileio;

public final class DistributorInput extends ShowEntity {
    private final int contractLength;
    private final int initialInfrastructureCost;
    private final int initialProductionCost;

    public DistributorInput(final int id, final float initialBudget,
                            final int contractLength,
                            final int initialInfrastructureCost,
                            final int initialProductionCost) {
        super(id, initialBudget);
        this.contractLength = contractLength;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.initialProductionCost = initialProductionCost;
    }

    public int getContractLength() {
        return contractLength;
    }

    public int getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    public int getInitialProductionCost() {
        return initialProductionCost;
    }

    @Override
    public String toString() {
        return "DistributorInput{" +
                "contractLength=" + contractLength +
                ", initialInfrastructureCost=" + initialInfrastructureCost +
                ", initialProductionCost=" + initialProductionCost +
                ", id=" + super.getId()+
                ", initialBudget=" + super.getInitialBudget() +
                '}';
    }
}
