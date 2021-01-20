package inputclasses;

public final class DistributorInput extends ShowEntity {
    private int contractLength;
    private long initialInfrastructureCost;
    private int energyNeededKW;
    private String producerStrategy;

    public DistributorInput() { super(); }

    public DistributorInput(final int id, final long initialBudget, int contractLength,
                            long initialInfrastructureCost, int energyNeededKW,
                            String producerStrategy) {
        super(id, initialBudget);
        this.contractLength = contractLength;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.energyNeededKW = energyNeededKW;
        this.producerStrategy = producerStrategy;
    }

    public int getContractLength() {
        return contractLength;
    }

    public long getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    public int getEnergyNeededKW() {
        return energyNeededKW;
    }

    public String getProducerStrategy() {
        return producerStrategy;
    }


    @Override
    public String toString() {
        return "DistributorInput{" +
                "contractLength=" + contractLength +
                ", initialInfrastructureCost=" + initialInfrastructureCost +
                ", energyNeededKW=" + energyNeededKW +
                ", producerStrategy='" + producerStrategy + '\'' +
                '}';
    }
}
