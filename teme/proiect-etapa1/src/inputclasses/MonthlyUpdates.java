package inputclasses;

import java.util.List;

public final class MonthlyUpdates {
    private List<ConsumerInput> newConsumers;
    private List<CostsChanges> costsChanges;

    public MonthlyUpdates() { }

    public MonthlyUpdates(final List<ConsumerInput> newConsumers,
                          final List<CostsChanges> costsChanges) {
        this.newConsumers = newConsumers;
        this.costsChanges = costsChanges;
    }

    public List<ConsumerInput> getNewConsumers() {
        return newConsumers;
    }

    public List<CostsChanges> getCostsChanges() {
        return costsChanges;
    }

    public void setNewConsumers(final List<ConsumerInput> newConsumers) {
        this.newConsumers = newConsumers;
    }

    public void setCostsChanges(final List<CostsChanges> costChanges) {
        this.costsChanges = costChanges;
    }

    @Override
    public String toString() {
        return "MonthlyUpdates{"
                + "newConsumers=" + newConsumers
                + ", costsChanges=" + costsChanges
                + '}';
    }
}
