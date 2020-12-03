package fileio;

public class ConsumerInput extends ShowEntity{
    private float monthlyIncome;

    public ConsumerInput(){super();}

    public ConsumerInput(int id, float initialBudget, float monthlyIncome) {
        super(id, initialBudget);
        this.monthlyIncome = monthlyIncome;
    }

    public float getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(float monthlyIncome) {
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
