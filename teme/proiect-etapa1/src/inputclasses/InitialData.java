package inputclasses;

import java.util.List;

public final class InitialData {
    private List<ConsumerInput> consumers;
    private List<DistributorInput> distributors;
    private List<ProducerInput> producers;

    public InitialData() { }

    public InitialData(final List<ConsumerInput> consumers,
                       final List<DistributorInput> distributors,
                       final List<ProducerInput> producers) {
        this.consumers = consumers;
        this.distributors = distributors;
        this.producers = producers;
    }

    public List<ConsumerInput> getConsumers() {
        return consumers;
    }

    public List<DistributorInput> getDistributors() {
        return distributors;
    }

    public void setConsumers(final List<ConsumerInput> consumers) {
        this.consumers = consumers;
    }

    public void setDistributors(final List<DistributorInput> distributors) {
        this.distributors = distributors;
    }

    public List<ProducerInput> getProducers() {
        return producers;
    }

    public void setProducers(List<ProducerInput> producers) {
        this.producers = producers;
    }

    @Override
    public String toString() {
        return "InitialData{" +
                "consumers=" + consumers +
                ", distributors=" + distributors +
                ", producers=" + producers +
                '}';
    }
}
