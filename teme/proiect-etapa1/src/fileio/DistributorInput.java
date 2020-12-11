package fileio;

public class DistributorInput extends ShowEntity {
    private int contractLength;
    private float initialInfrastructureCost;
    private float initialProductionCost;

    public DistributorInput(){};

    public DistributorInput(int id, float initialBudget,
                            int contractLength,
                            float initialInfrastructureCost,
                            float initialProductionCost) {
        super(id, initialBudget);
        this.contractLength = contractLength;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.initialProductionCost = initialProductionCost;
    }

    public int getContractLength() {
        return contractLength;
    }

    public float getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    public float getInitialProductionCost() {
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
