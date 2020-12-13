package inputclasses;

import java.util.List;

public final class Input {
    private int numberOfTurns;
    private InitialData initialData;
    private List<MonthlyUpdates> monthlyUpdates;

    public Input(final int numberOfTurns, final InitialData initialData,
                 final List<MonthlyUpdates> monthlyUpdates) {
        this.numberOfTurns = numberOfTurns;
        this.initialData = initialData;
        this.monthlyUpdates = monthlyUpdates;
    }

    public Input() { }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public List<MonthlyUpdates> getMonthlyUpdates() {
        return monthlyUpdates;
    }

    public void setNumberOfTurns(final int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    public void setMonthlyUpdates(final List<MonthlyUpdates> monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }

    @Override
    public String toString() {
        return "Input{"
                + "numberOfTurns=" + numberOfTurns
                + ", initialData=" + initialData
                + ", monthlyUpdates=" + monthlyUpdates
                + '}';
    }
}
