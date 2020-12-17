package applicationlayer;

import barcode.SimpleBarcodeProcessor;
import datalayer.model.Bike;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentBikeControllerTest {

    private RentBikeController rentBikeController;

    @BeforeEach
    void setUp() {
        rentBikeController = new RentBikeController();
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
}