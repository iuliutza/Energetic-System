package fileio;

public abstract class ShowEntity {
    private final int id;

    private final float initialBudget;

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
}
