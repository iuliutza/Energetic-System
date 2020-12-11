package working;

public abstract class AbstractFactory {
    public abstract Consumer createConsumer(int id, float budget, float monthlyIncome);
    public abstract Distributor createDistributor(int id, float budget, int contractLength, float pCost, float iCost);


}
