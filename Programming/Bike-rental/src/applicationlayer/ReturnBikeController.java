package applicationlayer;

import checkout.CreditCard;
import checkout.InterbankInterface;
import checkout.InterbankSubsystem;
import checkout.PaymentTransaction;
import checkout.exception.PaymentException;
import datalayer.acessor.BikeAccessor;
import datalayer.acessor.BikeRentedAccessor;
import datalayer.acessor.TransactionHistoryAccessor;
import datalayer.model.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * This class controls flow of system when user returns bike.
 */
public class ReturnBikeController {

    /**
     * String returned when user rent bike successfully.
     */
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

    /**
     * return return bike rented by user
     * @param userId id of user
     * @param bike user's rented bike
     * @param creditCard credit card info
     * @param endTime time that user returns bike
     * @return
     */
    public String requestReturnBike(int userId, RentedBike bike, CreditCard creditCard, Timestamp endTime) {
        if (endTime == null) {
            endTime = new Timestamp((new Date()).getTime());
        }
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
                    newRentBike,
                    paymentTransaction
            );
            transactionHistoryAccessor.save(transactionHistory);
            Bike freeBike = BikeFactory.getInstance().getBikeById(bike.getBikeId());
            freeBike.setStatus(false);
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

    /**
     * calculate cost of bike rented to specific time
     * @param rentedBike bike rented by user
     * @param endTime the time that user rent bike to
     * @return
     */
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
