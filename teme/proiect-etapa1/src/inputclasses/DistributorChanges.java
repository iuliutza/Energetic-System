package inputclasses;

public final class DistributorChanges {
    private int id;
    private long infrastructureCost;

    public DistributorChanges() { }

    public DistributorChanges(final int id, final long infrastructureCost) {
        this.id = id;
        this.infrastructureCost = infrastructureCost;
    }

    public int getId() {
        return id;
    }

    public long getInfrastructureCost() {
        return infrastructureCost;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setInfrastructureCost(final long infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    @Override
    public String toString() {
        return "CostChanges{"
                + "id=" + id
                + ", infrastructureCost=" + infrastructureCost
                + '}';
    }
}
