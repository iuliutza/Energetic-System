package game.producer;

import entities.EnergyType;
import game.distributor.Distributor;
import inputclasses.ProducerChanges;

import java.util.ArrayList;
import java.util.List;

public final class Producer implements ProducerInterface {
    private int id;
    private EnergyType energyType;
    private int maxDistributors;
    private double priceKW;
    private int energyPerDistributor;
    private List<Distributor> currentDistributors;
    private List<MonthlyStats> monthlyStats;
    private int receivedUpdate;

    public Producer() { }

    public Producer(int id, String energyType, int maxDistributors,
                    double priceKW, int energyPerDistributor) {
        this.id = id;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyPerDistributor = energyPerDistributor;
        this.currentDistributors = new ArrayList<>();
        this.monthlyStats = new ArrayList<>();
        this.receivedUpdate = 0;

        switch (energyType) {
            case "WIND":
                this.energyType = EnergyType.WIND;
                break;
            case "SOLAR":
                this.energyType = EnergyType.SOLAR;
                break;
            case "HYDRO":
                this.energyType = EnergyType.HYDRO;
                break;
            case "NUCLEAR":
                this.energyType = EnergyType.NUCLEAR;
                break;
            case "COAL":
                this.energyType = EnergyType.COAL;
                break;
            default:
                break;
        }
    }

    public int getId() {
        return id;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    public int getMaxDistributors() {
        return maxDistributors;
    }

    public void setMaxDistributors(int maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    public double getPriceKW() {
        return priceKW;
    }

    public void setPriceKW(double priceKW) {
        this.priceKW = priceKW;
    }

    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    public void setEnergyPerDistributor(int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Distributor> getCurrentDistributors() {
        return currentDistributors;
    }

    public void setCurrentDistributors(List<Distributor> currentDistributors) {
        this.currentDistributors = currentDistributors;
    }

    public int getReceivedUpdate() {
        return receivedUpdate;
    }

    public void setReceivedUpdate(int receivedUpdate) {
        this.receivedUpdate = receivedUpdate;
    }

    public List<MonthlyStats> getMonthlyStats() {
        return monthlyStats;
    }

    public void setMonthlyStats(List<MonthlyStats> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }

    @Override
    public String toString() {
        return "Producer{"
                + "id=" + id
                + ", energyType=" + energyType
                + ", maxDistributors=" + maxDistributors
                + ", priceKW=" + priceKW
                + ", energyPerDistributor=" + energyPerDistributor
                + ", currentDistributors=" + currentDistributors
                + '}';
    }


    @Override
    public void updateQuantity(int energyPerDistributor) {
        this.setEnergyPerDistributor(energyPerDistributor);
        this.receivedUpdate = 1;
    }

    @Override
    public List<Integer> takeDistributorsId() {
        List<Integer> ids = new ArrayList<>();

        for (Distributor distributor : currentDistributors) {
            ids.add(distributor.getId());
        }
        return ids;
    }

    @Override
    public void receiveUpdates(ProducerChanges change, List<Producer> producers) {
        if (change.getId() == this.id) {
            this.updateQuantity(change.getEnergyPerDistributor());
            this.receivedUpdate = 1;
            notifyAllDistributors(producers);
        } else {
            this.receivedUpdate = 0;
        }
    }

    @Override
    public void addStat(int month) {
        MonthlyStats stat = new MonthlyStats(month, this.takeDistributorsId());
        this.monthlyStats.add(stat);
    }

    @Override
    public void notifyAllDistributors(List<Producer> producers) {
        if (receivedUpdate == 1) {
            for (Distributor distributor : currentDistributors) {
                distributor.update(producers);
            }
        }
    }

    @Override
    public boolean addDistributor(Distributor distributor) {
        if (currentDistributors.size() < maxDistributors) {
            currentDistributors.add(distributor);
            return true;
        } else {
            return false;
        }
    }
}
