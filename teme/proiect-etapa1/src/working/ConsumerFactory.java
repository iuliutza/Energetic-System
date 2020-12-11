package working;

public class ConsumerFactory extends AbstractFactory{

    @Override
    public Consumer createConsumer(int id, float budget, float monthlyIncome) {
        return new Consumer(id,budget,monthlyIncome);
//        int id, float budget, float monthlyIncome);
    }

    @Override
    public Distributor createDistributor(int id, float budget, int contractLength, float pCost, float iCost) {
        return null;
    }


}
