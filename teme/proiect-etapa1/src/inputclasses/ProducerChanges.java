package inputclasses;

public class ProducerChanges {
    private int id;
    private int energyPerDistributor;

    public ProducerChanges() { }

    public ProducerChanges(int id, int energyPerDistributor) {
        this.id = id;
        this.energyPerDistributor = energyPerDistributor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    public void setEnergyPerDistributor(int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    @Override
    public String toString() {
        return "ProducerChanges{" +
                "id=" + id +
                ", energyPerDistributor=" + energyPerDistributor +
                '}';
    }
}
