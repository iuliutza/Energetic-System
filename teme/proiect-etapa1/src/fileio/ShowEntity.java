package fileio;

public abstract class ShowEntity {
    private int id;
    private float initialBudget;

    public ShowEntity(){}

    public ShowEntity(final int id, final float initialBudget) {
        this.id = id;
        this.initialBudget = initialBudget;
    }

    public int getId() {
        return id;
    }

    public float getInitialBudget() {
        return initialBudget;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInitialBudget(float initialBudget) {
        this.initialBudget = initialBudget;
    }
}
