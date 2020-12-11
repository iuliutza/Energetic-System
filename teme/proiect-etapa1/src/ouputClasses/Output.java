package ouputClasses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
@JsonPropertyOrder({
        "consumers",
        "distributors"
})
public class Output {
    private List<ConsumerOutput> consumers;
    private List<DistributorOutput> distributors;

    public Output(List<ConsumerOutput> consumers, List<DistributorOutput> distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
    }

    public List<ConsumerOutput> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<ConsumerOutput> consumers) {
        this.consumers = consumers;
    }

    public List<DistributorOutput> getDistributors() {
        return distributors;
    }

    public void setDistributors(List<DistributorOutput> distributors) {
        this.distributors = distributors;
    }

    @Override
    public String toString() {
        return "Output{" +
                "consumers=" + consumers +
                ", distributors=" + distributors +
                '}';
    }
}
