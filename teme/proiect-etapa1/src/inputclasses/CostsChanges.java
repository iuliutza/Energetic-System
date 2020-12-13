package inputclasses;

public final class CostsChanges {
    private int id;
    private long infrastructureCost;
    private long productionCost;

    public CostsChanges() { }

    public CostsChanges(final int id, final long infrastructureCost, final long productionCost) {
        this.id = id;
        this.infrastructureCost = infrastructureCost;
        this.productionCost = productionCost;
    }

    public int getId() {
        return id;
    }

    public long getInfrastructureCost() {
        return infrastructureCost;
    }

    public long getProductionCost() {
        return productionCost;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setInfrastructureCost(final long infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    public void setProductionCost(final long productionCost) {
        this.productionCost = productionCost;
    }

    @Override
    public String toString() {
        return "CostChanges{"
                + "id=" + id
                + ", infrastructureCost=" + infrastructureCost
                + ", productionCost=" + productionCost
                + '}';
    }
}
