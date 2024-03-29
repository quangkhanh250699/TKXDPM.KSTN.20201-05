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

/**
 * This class controls flow of system when user rents bike.
 */
public class RentBikeController {

    private final String SUCCESS_NOTIFICATION = "Your transaction is successful!";
    private final String BIKE_IS_RENTED = "This bike is rented, please choose others";

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

    /**
     * get bike for user
     * @param barcode barcode in the bike
     * @return bike matched with barcode
     */
    public Bike requestBike(String barcode) {
        int bikeId = this.barcodeProcessor.processBarcode(barcode);
        return bikeAccessor.get(bikeId);
    }

    /**
     * Request rent bike for user
     * @param userId id of user
     * @param bike the bike wanted to rent by user
     * @param creditCard credit card of user
     * @return notification string
     */
    public String requestRentBike(int userId, Bike bike, CreditCard creditCard) {
        if (bike.isStatus())
            return BIKE_IS_RENTED;
        int cost = (int) this.costComputer.getDebit(bike);
        try {
            PaymentTransaction paymentTransaction = this.interbank.payRental(creditCard, cost, bike.getBikeName());
            Date date  = new Date();
            Timestamp startTime = new Timestamp(date.getTime());
            int rentId = -1;
            bike.setStatus(true);
            RentedBike rentedBike = new RentedBike(
                    bike.getBikeId(),
                    bike.getBikeName(),
                    bike.getStationId(),
                    bike.getPin(),
                    true,
                    bike.getCategory(),
                    userId,
                    cost,
                    startTime
            );
            BikeRentedAccessor accessor = new BikeRentedAccessor();
            BikeAccessor bikeAccessor = new BikeAccessor();
            bikeAccessor.update(rentedBike);
            accessor.save(rentedBike);

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
