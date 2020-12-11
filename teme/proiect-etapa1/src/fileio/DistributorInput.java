package fileio;

public class DistributorInput extends ShowEntity {
    private int contractLength;
    private long initialInfrastructureCost;
    private long initialProductionCost;

    public DistributorInput(){};

    public DistributorInput(int id, long initialBudget,
                            int contractLength,
                            long initialInfrastructureCost,
                            long initialProductionCost) {
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
        return "DistributorInput{" +
                "contractLength=" + contractLength +
                ", initialInfrastructureCost=" + initialInfrastructureCost +
                ", initialProductionCost=" + initialProductionCost +
                ", id=" + super.getId()+
                ", initialBudget=" + super.getInitialBudget() +
                '}';
    }
}
