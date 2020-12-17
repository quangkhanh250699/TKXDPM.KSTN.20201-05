package datalayer.model;

import java.sql.Timestamp;

public class TransactionHistory {
    private int transactionId;
    private int userId;
    private float total_payment;
    private Timestamp time;
    private String bike_name;
    private float rented_duration;

    public TransactionHistory(int transactionId, int userId, float total_payment, Timestamp time, String bike_name, float rented_duration) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.total_payment = total_payment;
        this.time = time;
        this.bike_name = bike_name;
        this.rented_duration = rented_duration;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public float getTotal_payment() {
        return total_payment;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getBike_name() {
        return bike_name;
    }

    public float getRented_duration() {
        return rented_duration;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "transactionId=" + this.transactionId +
                ", userId=" + this.userId +
                ", total_payment=" + this.total_payment +
                ", time=" + this.time +
                ", bike_name='" + this.bike_name + '\'' +
                ", rented_duration=" + this.rented_duration +
                '}';
    }
}
