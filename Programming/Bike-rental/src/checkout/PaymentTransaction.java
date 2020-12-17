package checkout;

import checkout.CreditCard;

public class PaymentTransaction {
    private int amount;
    private CreditCard card;
    private String transactionContent;
    private String createAt;

    public PaymentTransaction(int amount, CreditCard card, String transactionContent, String createAt) {
        this.amount = amount;
        this.card = card;
        this.transactionContent = transactionContent;
        this.createAt = createAt;
    }

    public int getAmount() {
        return amount;
    }

    public String getTransactionContent() {
        return transactionContent;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTransactionContent(String transactionContent) {
        this.transactionContent = transactionContent;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public PaymentTransaction(){};

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }
}
