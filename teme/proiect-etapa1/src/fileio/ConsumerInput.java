package fileio;

public class ConsumerInput extends ShowEntity{
    private long monthlyIncome;

    public ConsumerInput(){super();}

    public ConsumerInput(int id, long initialBudget, long monthlyIncome) {
        super(id, initialBudget);
        this.monthlyIncome = monthlyIncome;
    }

    public long getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(long monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    @Override
    public String toString() {
        return "ConsumerInput{" +
                "monthlyIncome=" + monthlyIncome +
                "\nid=" + super.getId() +
                "\ninitialBudget=" + super.getInitialBudget() +
                '}';
    }
}
