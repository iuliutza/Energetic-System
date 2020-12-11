package working;

import java.util.List;

public class Consumer extends Entity implements ConsumerInterface{
    private long monthlyIncome;
    private long penalty;
    private ClientContract contract = new ClientContract();

    public Consumer() { super(); }

    public Consumer(int id, long budget, long monthlyIncome) {
        super(id, budget);
        this.monthlyIncome = monthlyIncome;
        penalty = 0;
    }

    public long getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(long monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public long getPenalty() {
        return penalty;
    }

    public void setPenalty(long penalty) {
        this.penalty = penalty;
    }

    public ClientContract getContract() {
        return contract;
    }

    public void setContract(ClientContract contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                " id=" + super.getId()
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

    public void giveRate(Distributor distributor, long price){
                distributor.setBudget(distributor.getBudget() + price);
    }


    @Override
    public void payRate(List<Distributor> distributors) {

        long diff = this.getBudget() - this.contract.getPrice();
        int id = -1;
        //find the distributor
        for(Distributor distributor : distributors) {
            if(this.contract.getDistributorId() == distributor.getId()) {
                id = distributor.getId();
            }
        }

        if( diff <= 0 && this.penalty == 0) {
            this.penalty++;
            this.contract.setRemainedContractMonths(this.contract.getRemainedContractMonths()-1);
            //decrease number of months in the distributor contract as well
            for(int i = 0; i < distributors.get(id).getContracts().size(); i++) {
                if(distributors.get(id).getContracts().get(i).getConsumerId() == this.getId())
                    distributors.get(id).getContracts().get(i).setRemainedContractMonths(
                            this.contract.getRemainedContractMonths());
            }
            return;
        }

        if(penalty == 1) {
            long price = Math.round(Math.floor(this.contract.getPrice() * 1.2)
                    + this.contract.getPrice());

            if((this.getBudget() - price) <= 0) {
                this.setBankrupt(true);
                return;
            }

            this.setBudget(this.getBudget() - price);
            this.giveRate(distributors.get(id),price);
            this.penalty--;
        }

        if(diff > 0 && this.penalty == 0) {
            this.setBudget(this.getBudget() - this.contract.getPrice());
            this.giveRate(distributors.get(id), this.contract.getPrice());
        }

        this.contract.setRemainedContractMonths(this.contract.getRemainedContractMonths()-1);
        for(int i = 0; i < distributors.get(id).getContracts().size(); i++) {
            if(distributors.get(id).getContracts().get(i).getConsumerId() == this.getId())
                distributors.get(id).getContracts().get(i).setRemainedContractMonths(
                        this.contract.getRemainedContractMonths());
        }

    }



    @Override
    public int buildContract(List<Distributor> distributors) { //cauta distribuitorul cu cel mai mic pret la contract
        //si completeaza contractul din clasa ClientContract cu datele acestuia.
        long min = 1000;
        int id1 = -1;
        for(Distributor distributor : distributors) {
            //daca sunt doi dstributori cu acelasi pret min se ia primul
            if (distributor.isBankrupt() == false) {
                if (distributor.getPriceOfContract() <= min) {
                    min = distributor.getPriceOfContract();
                    id1 = distributor.getId();
                }
            }
        }

        this.contract.setRemainedContractMonths(distributors.get(id1).getContractLength());
        this.contract.setDistributorId(id1);
        this.contract.setPrice(distributors.get(id1).getPriceOfContract());

        return id1;
    }
}
