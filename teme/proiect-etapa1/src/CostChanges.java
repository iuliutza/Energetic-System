public class CostChanges {
    private int id;
    private float infrastructureCost;
    private float productionCost;

    public CostChanges() {
        id = 0;
        infrastructureCost = 0;
        productionCost = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getInfrastructureCost() {
        return infrastructureCost;
    }

    public void setInfrastructureCost(float infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    public float getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(float productionCost) {
        this.productionCost = productionCost;
    }
}
