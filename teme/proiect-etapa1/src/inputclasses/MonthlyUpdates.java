package inputclasses;

import java.util.List;

public final class MonthlyUpdates {
    private List<ConsumerInput> newConsumers;
    private List<DistributorChanges> distributorChanges;
    private List<ProducerChanges> producerChanges;

    public MonthlyUpdates() { }

    public MonthlyUpdates(List<ConsumerInput> newConsumers,
                          List<DistributorChanges> distributorChanges,
                          List<ProducerChanges> producerChanges) {
        this.newConsumers = newConsumers;
        this.distributorChanges = distributorChanges;
        this.producerChanges = producerChanges;
    }

    public List<ConsumerInput> getNewConsumers() {
        return newConsumers;
    }

    public void setNewConsumers(final List<ConsumerInput> newConsumers) {
        this.newConsumers = newConsumers;
    }

    public List<DistributorChanges> getDistributorChanges() {
        return distributorChanges;
    }

    public void setDistributorChanges(List<DistributorChanges> distributorChanges) {
        this.distributorChanges = distributorChanges;
    }

    public List<ProducerChanges> getProducerChanges() {
        return producerChanges;
    }

    public void setProducerChanges(List<ProducerChanges> producerChanges) {
        this.producerChanges = producerChanges;
    }

    @Override
    public String toString() {
        return "MonthlyUpdates{"
                + "newConsumers=" + newConsumers
                + ", costsChanges=" + distributorChanges
                + '}';
    }
}
