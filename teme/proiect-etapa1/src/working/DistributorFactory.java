package working;

public class DistributorFactory extends AbstractFactory{

    @Override
    public Consumer createConsumer(int id, float budget, float monthlyIncome) {
        return null;
    }

    @Override
    public Distributor createDistributor(int id, float budget, int contractLength, float pCost, float iCost) {
        return new Distributor(id, budget, contractLength, pCost, iCost);
//        int id, float budget, int contractLength, float pCost, float iCost
    }




}
