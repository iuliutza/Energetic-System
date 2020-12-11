package working;

public abstract class AbstractFactory {
    public abstract Consumer createConsumer(int id, long budget, long monthlyIncome);
    public abstract Distributor createDistributor(int id, long budget, int contractLength, long pCost, long iCost);


}
