package working;

import java.util.ArrayList;
import java.util.List;

public class Distributor extends Entity implements DistributorInterface {
    private int contractLength;
    private long infrastructureCost;
    private long productionCost;
    private int noOfClients;
    private long priceOfContract;
    private long profit;
    private List<Contract> contracts;

    public Distributor() { super(); }

    public Distributor(int id, long budget, int contractLength, long pCost, long iCost) {
        super(id, budget);
        this.contractLength = contractLength;
        this.productionCost = pCost;
        this.infrastructureCost = iCost;
        this.noOfClients = 0;
        this.priceOfContract = 0;
        this.profit = 0;
        contracts = new ArrayList<>();
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    public long getInfrastructureCost() {
        return infrastructureCost;
    }

    public void setInfrastructureCost(long infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    public long getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(long productionCost) {
        this.productionCost = productionCost;
    }

    public int getNoOfClients() {
        return noOfClients;
    }

    public void setNoOfClients(int noOfClients) {
        this.noOfClients = noOfClients;
    }

    public long getPriceOfContract() {
        return priceOfContract;
    }

    public void setPriceOfContract(long priceOfContract) {
        this.priceOfContract = priceOfContract;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "Distributor{"
                + "id=" + super.getId()
                + " budget=" + super.getBudget()
                + " isBankrupt=" + super.isBankrupt()
                + " contractLength=" + contractLength
                + ", infrastructureCost=" + infrastructureCost
                + ", productionCost=" + productionCost
                + ", noOfClients=" + noOfClients
                + ", priceOfContract=" + priceOfContract
                + ", profit=" + profit
                + ", contracts= " + contracts
                + '}';
    }

    @Override
    public void updateCosts(long iCost, long pCost) {
        this.infrastructureCost = iCost;
        this.productionCost = pCost;
    }

    @Override
    public void updateCostContract(long iCost, long pCost, long profit, int noOfClients) {
        if (noOfClients == 0)
            this.priceOfContract = iCost + pCost + profit;
        else
            this.priceOfContract = Math.round(Math.floor(iCost / noOfClients) + pCost + profit);
    }

    @Override
    public void payExpenses(long iCost, long pCost, int noOfClients) {
        long price = iCost + (pCost * noOfClients);
        this.setBudget(this.getBudget() - price);
        if (this.getBudget() < 0) {
            this.setBankrupt(true);
        }
    }

    @Override
    public void calculateProfit(long productionCost) {
        this.profit = Math.round(Math.floor(0.2 * productionCost));
    }

    @Override
    public void updateContracts(int consumerId, long price, int remainedContractMonths) {
        Contract contract = new Contract(consumerId, price, remainedContractMonths);
        this.contracts.add(contract);

    }

    @Override
    public void deleteUselessContracts() {
        for (int i = 0; i < this.contracts.size(); i++) {
            if (this.contracts.get(i).getRemainedContractMonths() == 0) {
                this.contracts.remove(i);
                i--;
                this.setNoOfClients(this.getNoOfClients() - 1);
            }
        }
    }

    @Override
    public void deleteContract(int id) {
        for (int i = 0; i < this.contracts.size(); i++) {
            if (this.contracts.get(i).getConsumerId() == id) {
                this.contracts.remove(i);
                i--;
                this.setNoOfClients(this.getNoOfClients() - 1);
            }
        }
    }
}
