package working;

public class FactoryCreator {
    private static FactoryCreator instance;


    private FactoryCreator() { }

    public static FactoryCreator getInstance() {
        if (instance == null) {
            instance = new FactoryCreator();
        }
        return instance;
    }

    public AbstractFactory getFactory(String choice) {
        if (choice.equals("consumer")) {
            return new ConsumerFactory();
        }
        else if (choice.equals("distributor")) {
            return new DistributorFactory();
        }
        return null;
    }
}
