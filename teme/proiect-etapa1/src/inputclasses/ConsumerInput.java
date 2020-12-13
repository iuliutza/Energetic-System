package inputclasses;

public final class ConsumerInput extends ShowEntity {
    private long monthlyIncome;

    public ConsumerInput() {
        super();
    }

    public ConsumerInput(final int id, final long initialBudget, final long monthlyIncome) {
        super(id, initialBudget);
        this.monthlyIncome = monthlyIncome;
    }

    public long getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(final long monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    @Override
    public String toString() {
        return "ConsumerInput{"
                + "monthlyIncome=" + monthlyIncome
                + "\nid=" + super.getId()
                + "\ninitialBudget=" + super.getInitialBudget()
                + '}';
    }
}
