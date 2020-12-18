package applicationlayer;

import barcode.BarcodeProcessor;
import barcode.BarcodeProcessorFactory;
import checkout.CreditCard;
import checkout.InterbankInterface;
import checkout.InterbankSubsystem;
import checkout.PaymentTransaction;
import checkout.exception.PaymentException;
import datalayer.acessor.BikeAccessor;
import datalayer.acessor.BikeRentedAccessor;
import datalayer.model.Bike;
import datalayer.model.RentedBike;
import datalayer.model.TransactionHistory;

import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;

public class RentBikeController {

    private final String SUCCESS_NOTIFICATION = "You transaction is successful!";

    private BarcodeProcessor barcodeProcessor;
    private BikeAccessor bikeAccessor;
    private InterbankInterface interbank;
    private CostComputer costComputer;

    public RentBikeController() {
        this.barcodeProcessor = BarcodeProcessorFactory.getBarcodeProcessor();
        this.bikeAccessor = new BikeAccessor();
        this.interbank = new InterbankSubsystem();
        this.costComputer = new SimpleCostCalculator();
    }

    public Bike requestBike(String barcode) {
        int bikeId = this.barcodeProcessor.processBarcode(barcode);
        return bikeAccessor.get(bikeId);
    }

    public String requestRentBike(int userId, Bike bike, CreditCard creditCard) {
        int cost = (int) this.costComputer.getDebit(bike);
        try {
            PaymentTransaction paymentTransaction = this.interbank.payRental(creditCard, cost, bike.getBikeName());
            Date date  = new Date();
            Timestamp startTime = new Timestamp(date.getTime());
            int rentId = -1;
            RentedBike rentedBike = new RentedBike(
                    bike.getBikeId(),
                    bike.getBikeName(),
                    bike.getStationId(),
                    bike.getPin(),
                    bike.isStatus(),
                    bike.getCategory(),
                    userId,
                    cost,
                    startTime
            );
            BikeRentedAccessor accessor = new BikeRentedAccessor();
            accessor.update(rentedBike);

            return SUCCESS_NOTIFICATION;

        } catch (PaymentException e) {
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Cannot process transaction";
    }
}
