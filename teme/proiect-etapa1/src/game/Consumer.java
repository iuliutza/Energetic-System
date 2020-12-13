package game;

import java.util.List;

public final class Consumer extends Entity implements ConsumerInterface {
    private long monthlyIncome;
    private long penalty;
    private long remainingPayment;
    private ClientContract contract = new ClientContract();

    public Consumer() {
        super();
    }

    public Consumer(final int id, final long budget, final long monthlyIncome) {
        super(id, budget);
        this.monthlyIncome = monthlyIncome;
        penalty = 0;
        remainingPayment = 0;
    }

    public long getRemainingPayment() {
        return remainingPayment;
    }

    public void setRemainingPayment(final long remainingPayment) {
        this.remainingPayment = remainingPayment;
    }

    public long getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(final long monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public long getPenalty() {
        return penalty;
    }

    public void setPenalty(final long penalty) {
        this.penalty = penalty;
    }

    public ClientContract getContract() {
        return contract;
    }

    public void setContract(final ClientContract contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "Consumer{"
                + " id=" + super.getId()
                + " budget=" + super.getBudget()
                + " isBankrupt=" + super.isBankrupt()
                + " monthlyIncome=" + monthlyIncome
                + ", penalty=" + penalty
                + ", contract=" + contract
                + '}';
    }

    @Override
    public void updateBudget() {
        this.setBudget(this.getBudget() + monthlyIncome);
    }

    @Override
    public void giveRate(final Distributor distributor, final long price) {
                distributor.setBudget(distributor.getBudget() + price);
    }

    @Override
    public void payRate(final List<Distributor> distributors) {

        long diff = this.getBudget() - this.contract.getPrice();
        int id = Constants.BEGINNING_ID;
        //find the distributor
        for (Distributor distributor : distributors) {
            if (this.contract.getDistributorId() == distributor.getId()) {
                id = distributor.getId();
            }
        }

        //case: it's the first month when the consumer can't pay the rate
        if (diff < 0 && this.penalty == 0) {
            this.penalty++;
            this.remainingPayment = this.contract.getPrice();
            decreaseNoOfMonths(distributors, id);
            return;
        }

        //case: consumer has already one month in which he couldn't pay the rate
        if (penalty == 1) {
            long price = Math.round(Math.floor(this.remainingPayment * Constants.PENALTY_PERCENTAGE)
                    + this.contract.getPrice());
            if ((this.getBudget() - price) < 0) {
                this.setBankrupt(true);
                return;
            }
            this.setBudget(this.getBudget() - price);
            this.giveRate(distributors.get(id), price);
            System.out.println(distributors.get(id).getBudget());
            this.penalty--;
        }
        //case: consumer normally pays the rate
        if (diff >= 0 && this.penalty == 0) {
            this.setBudget(this.getBudget() - this.contract.getPrice());
            this.giveRate(distributors.get(id), this.contract.getPrice());
        }
        decreaseNoOfMonths(distributors, id);
    }

    private void decreaseNoOfMonths(final List<Distributor> distributors, final int id) {
        this.contract.setRemainedContractMonths(this.contract.getRemainedContractMonths() - 1);
        for (int i = 0; i < distributors.get(id).getContracts().size(); i++) {
            if (distributors.get(id).getContracts().get(i).getConsumerId() == this.getId()) {
                distributors.get(id).getContracts().get(i).setRemainedContractMonths(
                        this.contract.getRemainedContractMonths());
            }
        }
    }


    @Override
    public int buildContract(final List<Distributor> distributors) {
        long min = Constants.MIN;
        int id = Constants.BEGINNING_ID;
        for (Distributor distributor : distributors) {
            if (!distributor.isBankrupt()) {
                if (distributor.getPriceOfContract() <= min) {
                    min = distributor.getPriceOfContract();
                }
            }
        }
        for (Distributor distributor : distributors) {

            if (!distributor.isBankrupt() && distributor.getPriceOfContract() == min) {
                id = distributor.getId();
                break;
            }
        }
        if (id != Constants.BEGINNING_ID) {
            this.contract.setRemainedContractMonths(distributors.get(id).getContractLength());
            this.contract.setDistributorId(id);
            this.contract.setPrice(distributors.get(id).getPriceOfContract());
        }
        return id;
    }
}
