package game.producer;

import game.distributor.Distributor;
import inputclasses.ProducerChanges;

import java.util.List;

public interface ProducerInterface {
    /**
     * updates the quantity of the field energyPerDistributor at every update and sets the fiels
     * receivedUpdate on 1, this meaning that all the distributors must be notified
     * @param energyPerDistributor the energy given to one distributor
     */
    void updateQuantity(int energyPerDistributor);

    /**
     * notifies all the distributors that the given quantity has changed
     * @param producers holds all producers so the distributors can choose from this list.
     */
    void notifyAllDistributors(List<Producer> producers);

    /**
     * contains the ids of all the distributors to which the producer is giving energy
     * @return
     */
    List<Integer> takeDistributorsId();

    /**
     * receives the monthly updates regarding the quantities given to the distributors,
     * and notifies them all.
     * @param change contains the update itself
     * @param producers holds all producers so the distributors can choose from this list.
     */
    void receiveUpdates(ProducerChanges change, List<Producer> producers);

    /**
     * adds monthly statistic to the array of statistics
     * @param month the number that indicates to which month the statistics correspond.
     */
    void addStat(int month);

    /**
     * adds distributor to the list of current distributors if the max no has no been reached.
     * @param distributor the distributor that has to be added
     * @return true if the producer can still support the distributor, false if not.
     */
    boolean addDistributor(Distributor distributor);
}
