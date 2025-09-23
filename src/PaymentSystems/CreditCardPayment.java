package PaymentSystems;

public class CreditCardPayment extends Payment {
    public CreditCardPayment(double paidAmountInEUR) {
        super(Payment.Method.CreditCard, Payment.Status.Processing, paidAmountInEUR);
    }
    public void markAsProcessed() {
        this.setPaymentStatus(Payment.Status.Processed);
    }
}
