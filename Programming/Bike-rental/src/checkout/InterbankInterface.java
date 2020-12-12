package checkout;

public interface InterbankInterface {
    void payRental(CreditCard creditCard);
    int getBalance(CreditCard creditCard);
    void refund(CreditCard creditCard, int amount);
}
