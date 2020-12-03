package fileio;

import java.util.List;

public class Input {
    private int numberOfTurns;
    private InitialData initialData;
    private List<MonthlyUpdates> monthlyUpdates;

    public Input(int numberOfTurns, InitialData initialData,
                 List<MonthlyUpdates> monthlyUpdates) {
        this.numberOfTurns = numberOfTurns;
        this.initialData = initialData;
        this.monthlyUpdates = monthlyUpdates;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public List<MonthlyUpdates> getMonthlyUpdates() {
        return monthlyUpdates;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public void setInitialData(InitialData initialData) {
        this.initialData = initialData;
    }

    public void setMonthlyUpdates(List<MonthlyUpdates> monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }
}
