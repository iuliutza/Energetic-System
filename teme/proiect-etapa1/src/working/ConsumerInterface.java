package working;

import java.util.List;

public interface ConsumerInterface {
    void updateBudget();
    void payRate(List<Distributor> distributors);
    int buildContract(List<Distributor> distributors);
}
