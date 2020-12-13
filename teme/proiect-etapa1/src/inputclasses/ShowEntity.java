package inputclasses;

public abstract class ShowEntity {
    private int id;
    private long initialBudget;

    public ShowEntity() { }

    public ShowEntity(final int id, final long initialBudget) {
        this.id = id;
        this.initialBudget = initialBudget;
    }

    /**
     * Function returns the id of the entity
     * @return id of the entity
     */
    public int getId() {
        return id;
    }

    /**
     * Function returns the initial budget of the entity
     * @return
     */
    public long getInitialBudget() {
        return initialBudget;
    }

    /**
     * Sets aka assign a value to the id of the entity
     * @param id id of the entity
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Assign a value to the initial budget of the entity
     * @param initialBudget initial budget of the entity
     */
    public void setInitialBudget(final long initialBudget) {
        this.initialBudget = initialBudget;
    }
}
