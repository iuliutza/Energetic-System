package game.producer;

import java.util.ArrayList;
import java.util.List;

public class MonthlyStats {
    private int month;
    private List<Integer> distributorsIds;

    public MonthlyStats() {
        month = 0;
        distributorsIds = new ArrayList<>();
    }

    public MonthlyStats(int month, List<Integer> distributorsIds) {
        this.month = month;
        this.distributorsIds = distributorsIds;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public List<Integer> getDistributorsIds() {
        return distributorsIds;
    }

    public void setDistributorsIds(List<Integer> distributorsIds) {
        this.distributorsIds = distributorsIds;
    }

    @Override
    public String toString() {
        return "MonthlyStats{" +
                "month=" + month +
                ", distributorsIds=" + distributorsIds +
                '}';
    }
}
