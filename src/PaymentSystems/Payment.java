package PaymentSystems;

abstract public class Payment {
    public enum Method {
        DebitCard,
        CreditCard
    }

    public enum Status {
        Processing,
        Processed
    }

    private Method paymentMethod;
    private Status paymentStatus;
    private double paidAmountInEUR;

    protected Payment(Method paymentMethod, Status paymentStatus, double paidAmountInEUR) {
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.paidAmountInEUR = paidAmountInEUR;
    }

    public Method getPaymentMethod() {
        return this.paymentMethod;
    }

    public Status getPaymentStatus() {
        return this.paymentStatus;
    }

    protected void setPaymentStatus(Status paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // abstract void pay();
}
