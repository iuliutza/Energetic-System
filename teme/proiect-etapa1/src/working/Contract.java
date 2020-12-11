package working;

public class Contract {
    private int consumerId;
    private float price;
    private int remainedContractMonths;

    public Contract() {}

    public Contract(int id, float price, int remainedContractMonths) {
        this.consumerId = id;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "consumerId=" + consumerId +
                ", price=" + price +
                ", remainedContractMonths=" + remainedContractMonths +
                '}';
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
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
}
