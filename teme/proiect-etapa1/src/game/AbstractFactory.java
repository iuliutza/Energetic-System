package game;

public abstract class AbstractFactory {
    /**
     *
     * @param id consumer's id
     * @param budget consumer's budget
     * @param monthlyIncome consumer's monthly income
     * @return returns new instance of consumer
     */
    public abstract Consumer createConsumer(int id, long budget, long monthlyIncome);

    /**
     *
     * @param id distributor's id
     * @param budget distributor's budget
     * @param contractLength distributor's length of contract
     * @param pCost distributor's production cost
     * @param iCost distributor's infrastructure cost
     * @return returns new instance of distributor
     */
    public abstract Distributor createDistributor(int id, long budget, int contractLength,
                                                  long pCost, long iCost);
}
