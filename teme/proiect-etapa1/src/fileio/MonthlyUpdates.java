package fileio;

import java.util.List;

public class MonthlyUpdates {
    private final List<ConsumerInput> newConsumers;
    private final List<CostChanges> costChanges;

    public MonthlyUpdates() {
        this.costChanges = null;
        this.newConsumers = null;
    }

    public MonthlyUpdates(List<ConsumerInput> newConsumers, List<CostChanges> costChanges) {
        this.newConsumers = newConsumers;
        this.costChanges = costChanges;
    }

    public List<ConsumerInput> getNewConsumers() {
        return newConsumers;
    }

    public List<CostChanges> getCostChanges() {
        return costChanges;
    }
}
