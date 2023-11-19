package HostelAllotmentSystem;

public class Fee {
    private double amount;
    private Date paymentDate;

    public Fee( double amount) {
        this.amount = amount;

    }


    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
