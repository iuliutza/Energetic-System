package working;

public abstract class Entity {
    private int id;
    private long budget;
    private boolean isBankrupt;

    public Entity() { }

    public Entity(final int id, final long budget) {
        this.id = id;
        this.budget = budget;
        this.isBankrupt = false;
    }

    public final  int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final long getBudget() {
        return budget;
    }

    public final void setBudget(final long budget) {
        this.budget = budget;
    }

    public final boolean isBankrupt() {
        return isBankrupt;
    }

    public final void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /**
     * To string method in order to be able to see the values of the fields when printed out
     * @return String with the values of the fields
     */
    @Override
    public String toString() {
        return "Entity{"
                + "id=" + id
                + ", budget=" + budget
                + ", isBankrupt=" + isBankrupt
                + '}';
    }
}
