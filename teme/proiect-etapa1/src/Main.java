import com.fasterxml.jackson.databind.ObjectMapper;
import inputclasses.CostsChanges;
import inputclasses.Input;
import inputclasses.InputLoader;
import ouputclasses.ConsumerOutput;
import ouputclasses.DistributorOutput;
import ouputclasses.Output;
import working.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class  Main {

    public static void main(String[] args) throws Exception {
        String pathIn = "./../checker/resources/in/"
                + args[0];
        InputLoader inputLoader = new InputLoader(pathIn);
        Input input = inputLoader.readData(args[0]);

        List<Consumer> consumers = new ArrayList<>();
        List<Distributor> distributors = new ArrayList<>();

        FactoryCreator creator = FactoryCreator.getInstance();

        AbstractFactory consumerFactory =  creator.getFactory("consumer");
        AbstractFactory distributorFactory = creator.getFactory("distributor");

        int i;
        //load consumers
        if (input.getInitialData().getDistributors() != null) {
            for (i = 0; i < input.getInitialData().getConsumers().size(); i++) {
                Consumer consumer = consumerFactory.createConsumer
                                    (input.getInitialData().getConsumers().get(i).getId(),
                                input.getInitialData().getConsumers().get(i).getInitialBudget(),
                                input.getInitialData().getConsumers().get(i).getMonthlyIncome());
                consumers.add(consumer);
            }
        }

        //load distributors
        if (input.getInitialData().getDistributors() != null) {

            for (i = 0; i < input.getInitialData().getDistributors().size(); i++) {
                Distributor distributor = distributorFactory.createDistributor
                        (input.getInitialData().getDistributors().get(i).getId(),
                                input.getInitialData().getDistributors().get(i).getInitialBudget(),
                                input.getInitialData().getDistributors().get(i).getContractLength(),
                                input.getInitialData().getDistributors().get(i).
                                        getInitialProductionCost(),
                                input.getInitialData().getDistributors().get(i).
                                        getInitialInfrastructureCost());
                distributors.add(distributor);
            }
        }

        for (int k = 0; k <= input.getNumberOfTurns(); k++) {

            //doing updates
            if (k > 0) {
                //update costs
                int sizeCosts = input.getMonthlyUpdates().get(k - 1).getCostsChanges().size();
                if (sizeCosts > 0) {
                    for (int j = 0; j < sizeCosts; j++) {
                        CostsChanges change = new CostsChanges(
                                input.getMonthlyUpdates().get(k - 1).getCostsChanges().get(j).
                                        getId(),
                                input.getMonthlyUpdates().get(k - 1).getCostsChanges().get(j).
                                        getInfrastructureCost(),
                                input.getMonthlyUpdates().get(k - 1).getCostsChanges().get(j).
                                        getProductionCost());
                        for (int l = 0; l < distributors.size(); l++) {
                            if (distributors.get(l).getId() == change.getId()) {
                                distributors.get(l).updateCosts(change.getInfrastructureCost(),
                                        change.getProductionCost());
                            }
                        }
                    }
                }

                //update new consumers
                int size = input.getMonthlyUpdates().get(k - 1).getNewConsumers().size();
                if (size > 0) {
                    for (int j = 0; j < size; j++) {
                        Consumer consumer = consumerFactory.createConsumer(
                                input.getMonthlyUpdates().get(k - 1).getNewConsumers().get(j).
                                        getId(),
                                input.getMonthlyUpdates().get(k - 1).getNewConsumers().
                                        get(j).getInitialBudget(),
                                input.getMonthlyUpdates().get(k - 1).getNewConsumers().get(j).
                                        getMonthlyIncome());
                        consumers.add(consumer);
                    }
                }
            }

            //calculate prices of contracts and profit
            for (Distributor distributor : distributors) {
                    //compute profit
                    distributor.calculateProfit(distributor.getProductionCost());
                    //calculate price of contract and update
                    distributor.updateCostContract(distributor.getInfrastructureCost(),
                            distributor.getProductionCost(), distributor.getProfit(),
                            distributor.getNoOfClients());
            }

            //delete consumers with 0 months remained
            for(Distributor distributor : distributors){
                distributor.deleteUselessContracts();
            }

            int id;
            //consumers receive monthly income
            //and choose a contract
            //distributors register that contract, and increase the number of clients
            for (Consumer  consumer : consumers) {
                if (consumer.isBankrupt() == false) {
                    //receives monthly income
                    consumer.updateBudget();
                    //chooses contract and saves it
                    if(consumer.getContract().getRemainedContractMonths() == 0) {
                        id = consumer.buildContract(distributors);

                        //the contract then it s saved by the distributor as well
                        distributors.get(id).updateContracts(consumer.getId(),
                                distributors.get(id).getPriceOfContract(),
                                distributors.get(id).getContractLength());
                        //distributor adds client
                        distributors.get(id).setNoOfClients(distributors.get(id).
                                getNoOfClients() + 1);
                    }
                    //consumer pays rate
                    consumer.payRate(distributors);
                }
            }

            //distributors pay their expenses
            for (Distributor distributor : distributors) {
                if(distributor.isBankrupt() == false) {
                    distributor.payExpenses(distributor.getInfrastructureCost(),
                            distributor.getProductionCost(), distributor.getNoOfClients());
                }
            }

            //consumer is bankrupt
            for(Consumer consumer : consumers) {
                if (consumer.isBankrupt() == true) {
                    for (Distributor distributor : distributors) {
                        if (consumer.getContract().getDistributorId() == distributor.getId()) {
                            distributor.deleteContract(consumer.getId());
                        }
                    }
                }
            }

            //distributor is bankrupt
            for (Distributor distributor : distributors) {
                if (distributor.isBankrupt() == true) {
                    distributor.getContracts().clear();
                    distributor.setNoOfClients(0);
                    for (Consumer consumer : consumers) {
                        if (consumer.getContract().getDistributorId() == distributor.getId()) {
                            consumer.getContract().setRemainedContractMonths(0);
                        }
                    }
                }
            }
        }

        List<DistributorOutput> outputDistributors = new ArrayList<>();
        List<ConsumerOutput> outputConsumers = new ArrayList<>();

        for (Consumer consumer : consumers) {
            ConsumerOutput out =
                    new ConsumerOutput(consumer.getId(), consumer.isBankrupt(),
                            consumer.getBudget());
            outputConsumers.add(out);
        }

        for (Distributor distributor : distributors) {
            DistributorOutput out =
                    new DistributorOutput(distributor.getId(), distributor.getBudget(),
                    distributor.isBankrupt(), distributor.getContracts());
            outputDistributors.add(out);
        }

        Output output = new Output(outputConsumers, outputDistributors);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(args[1]), output);

    }
}
