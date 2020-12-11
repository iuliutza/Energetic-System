package working;

import java.util.List;

public class Consumer extends Entity implements ConsumerInterface{
    private float monthlyIncome;
    private float penalty;
    private ClientContract contract = new ClientContract();

    public Consumer() { super(); }

    public Consumer(int id, float budget, float monthlyIncome) {
        super(id, budget);
        this.monthlyIncome = monthlyIncome;
        penalty = 0;
    }

    public float getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(float monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public float getPenalty() {
        return penalty;
    }

    public void setPenalty(float penalty) {
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

    public void giveRate(List<Distributor> distributors, float price){
        for(Distributor distributor : distributors) {
            if(this.contract.getDistributorId() == distributor.getId()) {
                distributor.setBudget(distributor.getBudget() + price);
            }
        }
    }


    @Override
    public void payRate(List<Distributor> distributors) {

        float diff = this.getBudget() - this.contract.getPrice();

        if( diff <= 0 && this.penalty == 0) {
            this.penalty++;
            this.contract.setRemainedContractMonths(this.contract.getRemainedContractMonths()-1);
            return;
        }

        if(penalty == 1) {
            float price = Math.round(Math.floor(this.contract.getPrice() * 1.2)
                    + this.contract.getPrice());

            if((this.getBudget() - price) <= 0) {
                this.setBankrupt(true);
                return;
            }

            this.setBudget(this.getBudget() - price);
            this.giveRate(distributors,price);
            this.penalty--;
        }

        if(diff > 0 && this.penalty == 0) {
            this.setBudget(this.getBudget() - this.contract.getPrice());
            this.giveRate(distributors, this.contract.getPrice());
        }

        this.contract.setRemainedContractMonths(this.contract.getRemainedContractMonths()-1);

    }



    @Override
    public int buildContract(List<Distributor> distributors) { //cauta distribuitorul cu cel mai mic pret la contract
        //si completeaza contractul din clasa ClientContract cu datele acestuia.
        float min = 1000;
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
