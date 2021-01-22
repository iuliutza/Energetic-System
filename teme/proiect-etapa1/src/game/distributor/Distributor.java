package game.distributor;

import game.Constants;
import game.Entity;
import game.producer.Producer;
import strategies.GreenStrategy;
import strategies.PriceStrategy;
import strategies.QuantityStrategy;
import strategies.StrategyContext;


import java.util.ArrayList;
import java.util.List;


public final class Distributor extends Entity implements DistributorInterface, Observer {
    private int contractLength;
    private long infrastructureCost;
    private long productionCost;
    private int noOfClients;
    private long priceOfContract;
    private long profit;
    private List<Contract> contracts;
    private long energyNeededKW;
    private String producerStrategy;
    private StrategyContext strategy;
    private List<Producer> chosenProducers;
    private long addedEnergy;



    public Distributor(final int id, final long budget, final int contractLength,
                        final long iCost, final int energyNeededKW, final String strategy) {
        super(id, budget);
        this.contractLength = contractLength;
        this.infrastructureCost = iCost;
        this.energyNeededKW = energyNeededKW;
        this.producerStrategy = strategy;
        this.noOfClients = 0;
        this.priceOfContract = 0;
        this.profit = 0;
        this.productionCost = 0;
        this.contracts = new ArrayList<>();
        this.chosenProducers = new ArrayList<>();
        this.addedEnergy = 0;

        switch (this.producerStrategy) {
            case "GREEN":
                this.strategy = new StrategyContext(new GreenStrategy());
                break;
            case "PRICE":
                this.strategy = new StrategyContext(new PriceStrategy());
                break;
            case "QUANTITY":
                this.strategy = new StrategyContext(new QuantityStrategy());
                break;
            default:
                break;
        }
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

    public long getEnergyNeededKW() {
        return energyNeededKW;
    }

    public void setEnergyNeededKW(long energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    public String getProducerStrategy() {
        return producerStrategy;
    }

    public void setProducerStrategy(String producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    public StrategyContext getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyContext strategy) {
        this.strategy = strategy;
    }

    public List<Producer> getChosenProducers() {
        return chosenProducers;
    }

    public void setChosenProducers(List<Producer> chosenProducers) {
        this.chosenProducers = chosenProducers;
    }

    public long getAddedEnergy() {
        return addedEnergy;
    }

    public void setAddedEnergy(long addedEnergy) {
        this.addedEnergy = addedEnergy;
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
    public void updateCosts(final long iCost) {
        this.infrastructureCost = iCost;
    }

    @Override
    public void updateCostContract() {
        calculateProductionCost();
        calculateProfit();
        if (noOfClients == 0) {
            this.priceOfContract = this.infrastructureCost + this.productionCost + profit;
        } else {
            this.priceOfContract = Math.round(Math.floor(this.infrastructureCost / noOfClients)
                    + this.productionCost + profit);
        }
    }

    @Override
    public void payExpenses() {
        long price = infrastructureCost + (productionCost * noOfClients);
        this.setBudget(this.getBudget() - price);
        if (this.getBudget() < 0) {
            this.setBankrupt(true);
        }
    }

    @Override
    public void calculateProductionCost() {
        long cost = 0;
        for (Producer producer : this.chosenProducers) {
            cost += producer.getEnergyPerDistributor() * producer.getPriceKW();
        }
        this.productionCost = Math.round(Math.floor(cost / Constants.PERCENTAGE));
    }

    @Override
    public void calculateProfit() {
        this.profit = Math.round(Math.floor(Constants.PROFIT_PERCENTAGE * productionCost));
    }

    @Override
    public void updateContracts(final int consumerId) {
        Contract contract = new Contract(consumerId, priceOfContract, contractLength);
        this.noOfClients++;
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
    public void deleteContract(final int id) {
        for (int i = 0; i < this.contracts.size(); i++) {
            if (this.contracts.get(i).getConsumerId() == id) {
                this.contracts.remove(i);
                i--;
                this.setNoOfClients(this.getNoOfClients() - 1);
            }
        }
    }

    @Override
    public void chooseProducers(List<Producer> producers) {
        List<Producer> copy = new ArrayList<>();
        List<Producer> toRemove = new ArrayList<>();
        Producer producerBuff;
        copy.addAll(producers);

        while (this.addedEnergy < this.energyNeededKW) {
            producerBuff = strategy.executeStrategy(copy);
            for (Producer producer : copy) {
                if (producer.getId() == producerBuff.getId()) {
                    if (producer.addDistributor(this)) {
                        toRemove.add(producerBuff);
                        this.chosenProducers.add(producerBuff);
                        this.addedEnergy += producerBuff.getEnergyPerDistributor();
                    } else {
                        toRemove.add(producerBuff);
                    }
                }
            }
            copy.removeAll(toRemove);
        }
        copy.clear();
    }

    @Override
    public void update(List<Producer> producers) {

        this.chosenProducers.clear();
        chooseProducers(producers);
    }
}
