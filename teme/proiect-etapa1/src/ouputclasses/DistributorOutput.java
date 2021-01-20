package ouputclasses;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import game.Distributor.Contract;

import java.util.List;

@JsonPropertyOrder({
        "id", "energyNeededKW", "contractCost",
        "budget", "producerStrategy", "isBankrupt",
        "contracts"

})
public final class DistributorOutput {
    private int id;
    private long energyNeededKW;
    private long contractCost;
    private long budget;
    private String producerStrategy;
    private boolean isBankrupt;
    private List<Contract> contracts;

    public DistributorOutput(int id, long energyNeededKW, long contractCost,
                             long budget, String producerStrategy, boolean isBankrupt,
                             List<Contract> contracts) {
        this.id = id;
        this.energyNeededKW = energyNeededKW;
        this.contractCost = contractCost;
        this.budget = budget;
        this.producerStrategy = producerStrategy;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getEnergyNeededKW() {
        return energyNeededKW;
    }

    public void setEnergyNeededKW(long energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    public long getContractCost() {
        return contractCost;
    }

    public void setContractCost(long contractCost) {
        this.contractCost = contractCost;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getProducerStrategy() {
        return producerStrategy;
    }

    public void setProducerStrategy(String producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
