package fileio;

public abstract class ShowEntity {
    private int id;
    private long initialBudget;

    public ShowEntity(){}

    public ShowEntity(final int id, final long initialBudget) {
        this.id = id;
        this.initialBudget = initialBudget;
    }

    public int getId() {
        return id;
    }

    public long getInitialBudget() {
        return initialBudget;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInitialBudget(long initialBudget) {
        this.initialBudget = initialBudget;
    }
}
