package working;

public class Contract {
    private int consumerId;
    private long price;
    private int remainedContractMonths;

    public Contract() {}

    public Contract(int id, long price, int remainedContractMonths) {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getRemainedContractMonths() {
        return remainedContractMonths;
    }

    public void setRemainedContractMonths(int remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }
}
