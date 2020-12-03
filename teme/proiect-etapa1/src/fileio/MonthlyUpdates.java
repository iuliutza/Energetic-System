package fileio;

import java.util.List;

public class MonthlyUpdates {
    private List<ConsumerInput> newConsumers;
    private List<CostChanges> costChanges;

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

    public void setNewConsumers(List<ConsumerInput> newConsumers) {
        this.newConsumers = newConsumers;
    }

    public void setCostChanges(List<CostChanges> costChanges) {
        this.costChanges = costChanges;
    }
}
