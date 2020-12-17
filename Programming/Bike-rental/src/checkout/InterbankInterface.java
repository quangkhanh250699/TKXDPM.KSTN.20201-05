package checkout;

public interface InterbankInterface {
    void payRental(CreditCard creditCard);
    float getBalance(CreditCard creditCard);
    void refund(CreditCard creditCard, float amount);
}
