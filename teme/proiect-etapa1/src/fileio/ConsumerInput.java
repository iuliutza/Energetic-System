package fileio;

public final class ConsumerInput extends ShowEntity{
    private final float monthlyIncome;

    public ConsumerInput(final int id, final float initialBudget, final float monthlyIncome) {
        super(id, initialBudget);
        this.monthlyIncome = monthlyIncome;
    }

    public float getMonthlyIncome() {
        return monthlyIncome;
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
