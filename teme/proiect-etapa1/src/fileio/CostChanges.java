package fileio;

public class CostChanges {
    private int id;
    private float infrastructureCost;
    private float productionCost;

    public CostChanges(int id, float infrastructureCost, float productionCost) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setInfrastructureCost(float infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    public void setProductionCost(float productionCost) {
        this.productionCost = productionCost;
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
