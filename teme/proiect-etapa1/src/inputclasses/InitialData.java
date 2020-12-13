package inputclasses;

import java.util.List;

public final class InitialData {
    private List<ConsumerInput> consumers;
    private List<DistributorInput> distributors;

    public InitialData() { }

    public InitialData(final List<ConsumerInput> consumers,
                       final List<DistributorInput> distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
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

    @Override
    public String toString() {
        return "InitialData{"
                + "consumers=" + consumers
                + ", distributors=" + distributors
                + '}';
    }
}
