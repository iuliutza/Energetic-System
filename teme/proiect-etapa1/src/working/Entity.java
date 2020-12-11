package working;

public abstract class Entity {
    private int id;
    private float budget;
    private boolean isBankrupt;

    public Entity() { }

    public Entity(int id, float budget) {
        this.id = id;
        this.budget = budget;
        this.isBankrupt = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", budget=" + budget +
                ", isBankrupt=" + isBankrupt +
                '}';
    }
}
