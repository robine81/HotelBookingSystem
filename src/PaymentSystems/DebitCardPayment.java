package PaymentSystems;

public class DebitCardPayment extends Payment {
    public DebitCardPayment(double paidAmountInEUR) {
        super(Payment.Method.DebitCard, Payment.Status.Processed, paidAmountInEUR);
    }
}
