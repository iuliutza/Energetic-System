package working;

import java.util.List;

public interface ConsumerInterface {
    /**
     * Adds the monthly income to the consumer's budget.
     */
    void updateBudget();

    /**
     *"Pays" the rate to the distributor. Essentially subtracts the rate from the consumer's budget,
     * if he has the money to pay it or to pay the rate + penalty. If he doesn't have enough money,
     * declares the consumer bankrupt.
     * @param distributors list of all the distributors
     */
    void payRate(List<Distributor> distributors);

    /**
     * Iterates through the distributors list and chooses the one with the minimum price for the
     * contract. If two distributors share the same minimum price, the first one will be taken into
     * consideration. After choosing the distributor, the datas of the contract will be saved in the
     * consumer's contract.
     * @param distributors list of all the distributors
     * @return returns the id of the chosen distributor.
     */
    int buildContract(List<Distributor> distributors);

    /**
     * This functions basically adds the rate payed by the consumer to the distributor's budget.
     * @param distributor the distributor
     * @param price how much money the distributor has to receive from the consumer
     */
    void giveRate(Distributor distributor, long price);
}
