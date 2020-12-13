package working;

public interface DistributorInterface {
    /**
     * Updates the infrastructure and production costs with the monthly updates.
     * @param iCost the infrastructure cost
     * @param pCost the production cost
     */
    void updateCosts(long iCost, long pCost);

    /**
     * Calculates the cost of the contract. There are two situations: when there are no clients,
     * and where there are.
     * @param iCost the infrastructure cost
     * @param pCost the production cost
     * @param profit the profit
     * @param noOfClients the number of clients
     */
    void updateCostContract(long iCost, long pCost, long profit, int noOfClients);

    /**
     * Calculates the monthly expenses of the distributor, subtracts them from the budget of the
     * distributor and checks is the distributor is bankrupt.
     * @param iCost the infrastructure cost
     * @param pCost the production cost
     * @param noOfClients the number of clients
     */
    void payExpenses(long iCost, long pCost, int noOfClients);

    /**
     * Calculates the profit every month, and stores it in the "profit" field of the Distributor
     * class.
     * @param productionCost the production cost
     */
    void calculateProfit(long productionCost);

    /**
     * Every time a consumer picks this distributor, the distributor saves its contract in an
     * array list. This function creates the contract and adds it to the array.
     * @param consumerId the consumer's id
     * @param price the price of the contract
     * @param remainedContractMonths the number of months remaining in the contract
     */
    void updateContracts(int consumerId, long price, int remainedContractMonths);

    /**
     * Deletes the contracts that have 0 remaining months/
     */
    void deleteUselessContracts();

    /**
     * Deletes a certain contract from the array of contracts.
     * @param id the id of the customer
     */
    void deleteContract(int id);
}
