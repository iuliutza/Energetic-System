package game;

import game.Consumer.Consumer;
import game.Distributor.Distributor;

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
     * @param iCost distributor's infrastructure cost
     * @return returns new instance of distributor
     */
    public abstract Distributor createDistributor(int id, long budget, int contractLength,
                                                  long iCost, int energyNeededKW, String strategy);
}
