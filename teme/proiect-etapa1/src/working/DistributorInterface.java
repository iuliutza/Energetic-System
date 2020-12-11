package working;

import java.util.List;

public interface DistributorInterface {
    void updateCosts( long iCost, long pCost);
    void updateCostContract(long iCost, long pCost, long profit, int noOfClients);
    void payExpenses(long iCost, long pCost, int noOfClients);
    void calculateProfit(long productionCost);
    void updateContracts(int consumerId, long price, int remainedContractMonths);
    void deleteUselessContracts();
    void deleteContract(int id);
}
