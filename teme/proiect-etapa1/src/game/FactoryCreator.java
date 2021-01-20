package game;

import game.Consumer.ConsumerFactory;
import game.Distributor.DistributorFactory;

public final class FactoryCreator {
    private static FactoryCreator instance;

    private FactoryCreator() { }

    /**
     * As this factory is a singleton, this function creates an instance if there's none,
     * or returns the aforecreated instance.
     * @return returns instance of the FactoryCreator class
     */
    public static FactoryCreator getInstance() {
        if (instance == null) {
            instance = new FactoryCreator();
        }
        return instance;
    }

    /**
     * The functions returns instances of one of the two types of factories, Distributor or
     * Consumer, depending on the "choice" parameter.
     * @param choice string that indicates the type of factory that will be created
     * @return instance of one of the factories, or null if there is no case for the "choice"
     * parameter
     */
    public AbstractFactory getFactory(final String choice) {
        if (choice.equals("consumer")) {
            return new ConsumerFactory();
        } else if (choice.equals("distributor")) {
            return new DistributorFactory();
        }
        return null;
    }
}
