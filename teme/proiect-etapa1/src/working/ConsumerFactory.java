package working;

public class ConsumerFactory extends AbstractFactory{

    @Override
    public Consumer createConsumer(int id, long budget, long monthlyIncome) {
        return new Consumer(id,budget,monthlyIncome);
//        int id, long budget, long monthlyIncome);
    }

    @Override
    public Distributor createDistributor(int id, long budget, int contractLength, long pCost, long iCost) {
        return null;
    }


}
