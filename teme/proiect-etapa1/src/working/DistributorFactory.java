package working;

public class DistributorFactory extends AbstractFactory{

    @Override
    public Consumer createConsumer(int id, long budget, long monthlyIncome) {
        return null;
    }

    @Override
    public Distributor createDistributor(int id, long budget, int contractLength, long pCost, long iCost) {
        return new Distributor(id, budget, contractLength, pCost, iCost);
//        int id, long budget, int contractLength, long pCost, long iCost
    }




}
