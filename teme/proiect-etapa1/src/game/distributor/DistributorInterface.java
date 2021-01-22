package game.distributor;

import game.producer.Producer;

import java.util.List;

public interface DistributorInterface {
    /**
     * Updates the infrastructure and production costs with the monthly updates.
     * @param iCost the infrastructure cost
     */
    void updateCosts(long iCost);

    /**
     * Calculates the cost of the contract. There are two situations: when there are no clients,
     * and where there are.
     */
    void updateCostContract();

    /**
     * Calculates the monthly expenses of the distributor, subtracts them from the budget of the
     * distributor and checks is the distributor is bankrupt.
     */
    void payExpenses();

    /**
     * Calculates the profit every month, and stores it in the "profit" field of the Distributor
     * class.
     *
     */
    void calculateProfit();

    /**
     * Every time a consumer picks this distributor, the distributor saves its contract in an
     * array list. This function creates the contract and adds it to the array.
     * @param consumerId the consumer's id
     */
    void updateContracts(int consumerId);

    /**
     * Deletes the contracts that have 0 remaining months/
     */
    void deleteUselessContracts();

    /**
     * Deletes a certain contract from the array of contracts.
     * @param id the id of the customer
     */
    void deleteContract(int id);

    /**
     * Calculates the production cost
     */
    void calculateProductionCost();

    /**
     * Chooses the producers according to the distributor's strategy
     * @param producers the list of all producers
     */
    void chooseProducers(List<Producer> producers);
}
