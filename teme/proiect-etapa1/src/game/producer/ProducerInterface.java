package game.producer;

import game.Distributor.Distributor;
import inputclasses.ProducerChanges;

import java.util.List;

public interface ProducerInterface {
    void updateQuantity(int energyPerDistributor);
    void notifyAllDistributors(List<Producer> producers);
    List<Integer> takeDistributorsId ();
    void receiveUpdates(ProducerChanges change, List<Producer> producers);
    void addStat(int month);
    boolean addDistributor(Distributor distributor);
}
