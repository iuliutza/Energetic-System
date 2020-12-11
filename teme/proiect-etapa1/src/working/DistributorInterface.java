package working;

import java.util.List;

public interface DistributorInterface {
    void updateCosts( float iCost, float pCost);
    void updateCostContract(float iCost, float pCost, float profit, int noOfClients);
    void payExpenses(float iCost, float pCost, int noOfClients);
    void calculateProfit(float productionCost);
    void updateContracts(int consumerId, float price, int remainedContractMonths);
    void deleteUselessContracts();
    void deleteContract(int id);
}
