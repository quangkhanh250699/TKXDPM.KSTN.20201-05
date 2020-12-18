package applicationlayer;

import barcode.SimpleBarcodeProcessor;
import checkout.CreditCard;
import datalayer.acessor.BikeAccessor;
import datalayer.model.Bike;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentBikeControllerTest {

    private RentBikeController rentBikeController;
    private CreditCard card;

    @BeforeEach
    void setUp() {
        rentBikeController = new RentBikeController();
        card = new CreditCard("118131_group5_2020", "Group 5", "296", "1125");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void requestBike() {
        String barcode = "1";
        SimpleBarcodeProcessor processor = new SimpleBarcodeProcessor();
        Bike bike = rentBikeController.requestBike(barcode);
        int bikeId = processor.processBarcode(barcode);
        assertEquals(bikeId, bike.getBikeId());
    }

    @Test
    void requestRentBike() {
        Bike bike = (new BikeAccessor()).get(1);
        String notification = rentBikeController.requestRentBike(1, bike, card);

        assertEquals("You transaction is successful!", notification);
    }
}