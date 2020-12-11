package ouputClasses;

public class ConsumerOutput {
    private int id;
    private boolean isBankrupt;
    private float budget;

    public ConsumerOutput(int id, boolean isBankrupt, float budget) {
        this.id = id;
        this.isBankrupt = isBankrupt;
        this.budget =  budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    public void setIsBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "ConsumerOutput{" +
                "id=" + id +
                ", isBankrupt=" + isBankrupt +
                ", budget=" + budget +
                '}';
    }
}
