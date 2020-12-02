package fileio;

public final class CostChanges {
    private final int id;
    private final float infrastructureCost;
    private final float productionCost;

    public CostChanges(final int id, final float infrastructureCost, final float productionCost) {
        this.id = id;
        this.infrastructureCost = infrastructureCost;
        this.productionCost = productionCost;
    }

    public int getId() {
        return id;
    }

    public float getInfrastructureCost() {
        return infrastructureCost;
    }

    public float getProductionCost() {
        return productionCost;
    }

    @Override
    public String toString() {
        return "CostChanges{" +
                "id=" + id +
                ", infrastructureCost=" + infrastructureCost +
                ", productionCost=" + productionCost +
                '}';
    }
}
