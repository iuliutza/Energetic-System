package fileio;

import java.util.List;

public final class InitialData {
    private final List<ConsumerInput> consumers;
    private final List<DistributorInput> distributors;

    public InitialData() {
        consumers = null;
        distributors = null;
    }

    public InitialData(List<ConsumerInput> consumers, List<DistributorInput> distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
    }

    public List<ConsumerInput> getConsumers() {
        return consumers;
    }

    public List<DistributorInput> getDistributors() {
        return distributors;
    }
}
