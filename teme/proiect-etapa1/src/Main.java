import com.fasterxml.jackson.databind.ObjectMapper;
import game.AbstractFactory;
import game.FactoryCreator;
import game.consumer.Consumer;
import game.distributor.Distributor;
import game.producer.Producer;
import inputclasses.DistributorChanges;
import inputclasses.Input;
import inputclasses.InputLoader;
import inputclasses.ProducerChanges;
import ouputclasses.ConsumerOutput;
import ouputclasses.DistributorOutput;
import ouputclasses.Output;
import ouputclasses.ProducerOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class  Main {
    /**
     * The main function contains the whole game. The args parameters store the names of the input
     * and output files. First the input is read and assigned to the specific classes. Then the
     * game starts.
     * <p>
     *  The game has the next flow:
     *  1. Do the cost updates.
     *  2. Create the new consumers.
     *  3. Calculate prices of contracts for all the distributors and their profit.
     *  4. Delete the consumers that have 0 moths remaining in their contracts.
     *  5. All the consumers will receive their monthly income.
     *  6. The consumers that do not have a contract will search for the one with the minimum price.
     *  7. After choosing one, the consumer, as well as the distributor will save this contract.
     *  8. Consumers will pay their rate, depending on their budget and penalties.
     *  9. Distributors will receive their rates and then pay their own expenses.
     *  10. Check if there are any bankrupt consumers. If there are, delete their contracts from the
     *  distributor's list.
     *  11. Check if there are any bankrupt distributors. If there are, delete all the contracts
     *  with their clients.
     * </p>
     * <p>
     *     After the game is finished, the results are loaded in the output classes, and printed in
     *     the output files
     * </p>
     * @param args names of the input and output files
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {
        String pathIn = "./../checker/resources/in/" + args[0];
        InputLoader inputLoader = new InputLoader(pathIn);
        Input input = inputLoader.readData(args[0]);
        List<Consumer> consumers = new ArrayList<>();
        List<Distributor> distributors = new ArrayList<>();
        List<Producer> producers = new ArrayList<>();
        FactoryCreator creator = FactoryCreator.getInstance();
        AbstractFactory consumerFactory =  creator.getFactory("consumer");
        AbstractFactory distributorFactory = creator.getFactory("distributor");
        int i;
        //load consumers
        if (input.getInitialData().getDistributors() != null) {
            for (i = 0; i < input.getInitialData().getConsumers().size(); i++) {
                Consumer consumer = consumerFactory.createConsumer(
                                input.getInitialData().getConsumers().get(i).getId(),
                                input.getInitialData().getConsumers().get(i).getInitialBudget(),
                                input.getInitialData().getConsumers().get(i).getMonthlyIncome());
                consumers.add(consumer);
            }
        }
        //load distributors
        if (input.getInitialData().getDistributors() != null) {
            for (i = 0; i < input.getInitialData().getDistributors().size(); i++) {
                Distributor distributor = distributorFactory.createDistributor(
                                input.getInitialData().getDistributors().get(i).getId(),
                                input.getInitialData().getDistributors().get(i).getInitialBudget(),
                                input.getInitialData().getDistributors().get(i).getContractLength(),
                                input.getInitialData().getDistributors().get(i).
                                        getInitialInfrastructureCost(),
                        input.getInitialData().getDistributors().get(i).getEnergyNeededKW(),
                        input.getInitialData().getDistributors().get(i).getProducerStrategy());
                distributors.add(distributor);
            }
        }
        //load producers
        if (input.getInitialData().getProducers() != null) {
            for (i = 0; i < input.getInitialData().getProducers().size(); i++) {
                Producer producer = new Producer(
                        input.getInitialData().getProducers().get(i).getId(),
                        input.getInitialData().getProducers().get(i).getEnergyType(),
                        input.getInitialData().getProducers().get(i).getMaxDistributors(),
                        input.getInitialData().getProducers().get(i).getPriceKW(),
                        input.getInitialData().getProducers().get(i).getEnergyPerDistributor());
                producers.add(producer);
            }

        }
        for (int k = 0; k <= input.getNumberOfTurns(); k++) {
            if (k == 0) {
                //first round, distributors select a producer or more
                for (Distributor distributor : distributors) {
                    distributor.chooseProducers(producers);
                }
            }
            if (k > 0) {
                //update infrastructure cost, new customers and energetic changes
                int sizeCosts = input.getMonthlyUpdates().get(k - 1).getDistributorChanges().size();
                if (sizeCosts > 0) {
                    for (int j = 0; j < sizeCosts; j++) {
                        DistributorChanges change = new DistributorChanges(
                                input.getMonthlyUpdates().get(k - 1).getDistributorChanges().get(j).
                                        getId(),
                                input.getMonthlyUpdates().get(k - 1).getDistributorChanges().get(j).
                                        getInfrastructureCost());
                        for (int l = 0; l < distributors.size(); l++) {
                            if (distributors.get(l).getId() == change.getId()) {
                                distributors.get(l).updateCosts(change.getInfrastructureCost());
                            }
                        }
                    }
                }
                int size = input.getMonthlyUpdates().get(k - 1).getNewConsumers().size();
                if ((input.getMonthlyUpdates().get(k - 1).getNewConsumers().size()) > 0) {
                    for (int j = 0; j < size; j++) {
                       if (consumerFactory != null) {
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

                int sizeProducer = input.getMonthlyUpdates().get(k - 1).getProducerChanges().size();
                if ((input.getMonthlyUpdates().get(k - 1).getNewConsumers().size()) > 0) {
                    for (int j = 0; j < sizeProducer; j++) {
                        ProducerChanges change = new ProducerChanges(
                                input.getMonthlyUpdates().get(k - 1).getProducerChanges().get(j).
                                        getId(),
                                input.getMonthlyUpdates().get(k - 1).getProducerChanges().get(j).
                                        getEnergyPerDistributor());
                        for (int l = 0; l < producers.size(); l++) {
                            producers.get(l).receiveUpdates(change, producers);
                        }
                    }
                }
            }
            //calculate prices of contracts and profit
            for (Distributor distributor : distributors) {
                    distributor.updateCostContract();
            }
            //delete consumers with 0 months remained
            for (Distributor distributor : distributors) {
                distributor.deleteUselessContracts();
            }
            //consumers receive monthly income and choose a contract
            //distributors register that contract, and increase the number of clients
            for (Consumer  consumer : consumers) {
                if (!consumer.isBankrupt()) {
                    consumer.updateBudget();
                    if (consumer.getContract().getRemainedContractMonths() == 0) {
                        int id = consumer.buildContract(distributors);
                        distributors.get(id).updateContracts(consumer.getId());
                    }
                    consumer.payRate(distributors);
                }
            }
            //distributors pay their expenses
            for (Distributor distributor : distributors) {
                if (!distributor.isBankrupt()) {
                    distributor.payExpenses();
                }
            }
            //consumer is bankrupt
            for (Consumer consumer : consumers) {
                if (consumer.isBankrupt()) {
                    for (Distributor distributor : distributors) {
                        if (consumer.getContract().getDistributorId() == distributor.getId()) {
                            distributor.deleteContract(consumer.getId());
                        }
                    }
                }
            }
            //distributor is bankrupt
            for (Distributor distributor : distributors) {
                if (distributor.isBankrupt()) {
                    distributor.getContracts().clear();
                    distributor.setNoOfClients(0);
                    for (Consumer consumer : consumers) {
                        if (consumer.getContract().getDistributorId() == distributor.getId()) {
                            consumer.getContract().setRemainedContractMonths(0);
                        }
                    }
                }
            }
            //monthly stats producer
            for (Producer producer : producers) {
                if (k != 0) {
                   producer.addStat(k);
                }
            }
        }
        //load results in output and print them in the output files
        List<DistributorOutput> outputDistributors = new ArrayList<>();
        List<ConsumerOutput> outputConsumers = new ArrayList<>();
        List<ProducerOutput> outputProducers = new ArrayList<>();
        for (Consumer consumer : consumers) {
            ConsumerOutput out =
                    new ConsumerOutput(consumer.getId(), consumer.isBankrupt(),
                            consumer.getBudget());
            outputConsumers.add(out);
        }
        for (Distributor distributor : distributors) {
            DistributorOutput out =
                    new DistributorOutput(distributor.getId(), distributor.getEnergyNeededKW(),
                            distributor.getPriceOfContract(), distributor.getBudget(),
                    distributor.getProducerStrategy(), distributor.isBankrupt(),
                            distributor.getContracts());
            outputDistributors.add(out);
        }
        for (Producer producer : producers) {
            ProducerOutput out =
                    new ProducerOutput(producer.getId(), producer.getMaxDistributors(),
                            producer.getPriceKW(), producer.getEnergyType().getLabel(),
                            producer.getEnergyPerDistributor(), producer.getMonthlyStats());
            outputProducers.add(out);
        }
        Output output = new Output(outputConsumers, outputDistributors, outputProducers);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(args[1]), output);
    }
}
