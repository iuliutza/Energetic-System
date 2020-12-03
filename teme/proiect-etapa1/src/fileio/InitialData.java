package fileio;

import java.util.List;

public class InitialData {
    private List<ConsumerInput> consumers;
    private List<DistributorInput> distributors;

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

    public void setConsumers(List<ConsumerInput> consumers) {
        this.consumers = consumers;
    }

    public void setDistributors(List<DistributorInput> distributors) {
        this.distributors = distributors;
    }

    @Override
    public String toString() {
        return "InitialData{" +
                "consumers=" + consumers +
                ", distributors=" + distributors +
                '}';
    }
}
