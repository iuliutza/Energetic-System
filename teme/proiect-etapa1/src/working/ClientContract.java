package working;

public class ClientContract {
    private int distributorId;
    private float price;
    private int remainedContractMonths;

    public ClientContract() { }

    public ClientContract(int distributorId, float price, int remainedContractMonths) {
        this.distributorId = distributorId;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRemainedContractMonths() {
        return remainedContractMonths;
    }

    public void setRemainedContractMonths(int remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }

    @Override
    public String toString() {
        return "ClientContract{" +
                "distributorId=" + distributorId
                + ", price=" + price
                + ", remainedContractMonths=" + remainedContractMonths
                + '}';
    }
}
