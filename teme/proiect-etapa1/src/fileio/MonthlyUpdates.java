package fileio;

import java.util.List;

public class MonthlyUpdates {
    private List<ConsumerInput> newConsumers;
    private List<CostsChanges> costsChanges;

    public MonthlyUpdates() {
//        this.costChanges = null;
//        this.newConsumers = null;
    }

    public MonthlyUpdates(List<ConsumerInput> newConsumers, List<CostsChanges> costsChanges) {
        this.newConsumers = newConsumers;
        this.costsChanges = costsChanges;
    }

    public List<ConsumerInput> getNewConsumers() {
        return newConsumers;
    }

    public List<CostsChanges> getCostsChanges() {
        return costsChanges;
    }

    public void setNewConsumers(List<ConsumerInput> newConsumers) {
        this.newConsumers = newConsumers;
    }

    public void setCostsChanges(List<CostsChanges> costChanges) {
        this.costsChanges = costChanges;
    }

    @Override
    public String toString() {
        return "MonthlyUpdates{" +
                "newConsumers=" + newConsumers +
                ", costsChanges=" + costsChanges +
                '}';
    }
}
