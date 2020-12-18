package applicationlayer;

import checkout.CreditCard;
import checkout.InterbankInterface;
import checkout.InterbankSubsystem;
import checkout.PaymentTransaction;
import checkout.exception.PaymentException;
import datalayer.acessor.BikeRentedAccessor;
import datalayer.acessor.TransactionHistoryAccessor;
import datalayer.model.RentedBike;
import datalayer.model.Station;
import datalayer.model.TransactionHistory;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class ReturnBikeController {

    private String SUCCESS_REFUND = "You returned bike successfully!";

    private CostComputer calculator;
    private BikeRentedAccessor bikeRentedAccessor;
    private InterbankInterface interbank;
    private TransactionHistoryAccessor transactionHistoryAccessor;

    public ReturnBikeController() {
        this.calculator = new SimpleCostCalculator();
        this.bikeRentedAccessor = new BikeRentedAccessor();
        this.interbank = new InterbankSubsystem();
        this.transactionHistoryAccessor = new TransactionHistoryAccessor();
    }

    public String requestReturnBike(int userId, RentedBike bike, CreditCard creditCard, Timestamp endTime) {
        int debit = (int) this.calculator.getDebit(bike);
        int cost = (int) calculateCost(bike, endTime);
        int returnMoney = debit - cost;
        int stationId = bike.getStationId();
        try {
            PaymentTransaction paymentTransaction = this.interbank.refund(creditCard, returnMoney, "return");
            RentedBike newRentBike = new RentedBike(
                    bike.getBikeId(),
                    bike.getBikeName(),
                    stationId,
                    bike.getPin(),
                    false,
                    bike.getCategory(),
                    bike.getUserId(),
                    cost,
                    bike.getStart_time(),
                    endTime,
                    bike.getRentId()
            );
            this.bikeRentedAccessor.update(newRentBike);
            TransactionHistory transactionHistory = makeTransactionHistory(
                    userId,
                    bike,
                    paymentTransaction
            );
            transactionHistoryAccessor.save(transactionHistory);
            return SUCCESS_REFUND;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (PaymentException e) {
            return e.getMessage();
        }
        return "";
    }

    public float calculateCost(RentedBike rentedBike, Timestamp endTime) {
        return this.calculator.checkout(rentedBike, endTime);
    }

    private TransactionHistory makeTransactionHistory(int userId, RentedBike bike, PaymentTransaction paymentTransaction) {
        int transactionId = -1;
        float totalPayment = (float) paymentTransaction.getAmount();
        Timestamp time = new Timestamp(paymentTransaction.getCreateAt().getTime());
        String bikeName = bike.getBikeName();
        long duration = bike.getEnd_time().getTime() - bike.getStart_time().getTime();
        long rentMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        return new TransactionHistory(
                transactionId,
                userId,
                totalPayment,
                time,
                bikeName,
                (float) (rentMinutes / 60.0)
        );
    }
}
