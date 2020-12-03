package fileio;

public class DistributorInput extends ShowEntity {
    private int contractLength;
    private int initialInfrastructureCost;
    private int initialProductionCost;

    public DistributorInput(){};

    public DistributorInput(int id, float initialBudget,
                            int contractLength,
                            int initialInfrastructureCost,
                            int initialProductionCost) {
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
