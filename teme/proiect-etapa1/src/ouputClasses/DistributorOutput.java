package ouputClasses;
import working.Contract;

import java.util.List;

public class DistributorOutput {
    private int id;
    private float budget;
    private boolean isBankrupt;
    private List<Contract> contracts;

    public DistributorOutput(int id, float budget, boolean isBankrupt, List<Contract> contracts) {
        this.id = id;
        this.budget = budget;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    public void setIsBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "DistributorOutput{" +
                "id=" + id +
                ", budget=" + budget +
                ", isBankrupt=" + isBankrupt +
                ", contracts=" + contracts +
                '}';
    }
}
