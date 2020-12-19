package applicationlayer;

import checkout.CreditCard;
import datalayer.acessor.BikeRentedAccessor;
import datalayer.model.RentedBike;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class ReturnBikeControllerTest {

    private ReturnBikeController returnBikeController;

    @BeforeEach
    void setUp() {
        returnBikeController = new ReturnBikeController();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void requestReturnBike() {
        int userId = 1;
        CreditCard creditCard = new CreditCard("118131_group5_2020", "Group 5", "296", "1125");
        RentedBike rentedBike = (new BikeRentedAccessor()).get(30);
        rentedBike.setStatus(false);

        assertEquals("You returned bike successfully!",
                this.returnBikeController.requestReturnBike(
                        userId,
                        rentedBike,
                        creditCard,
                        rentedBike.getEnd_time()
                ));
    }

    @Test
    void calculateCost() {
        RentedBike bike = new RentedBike(1, "1", 1, 1, true, null, 1, 0,
                                            new Timestamp(2020, 12, 12, 12, 0, 0, 0),
                                            new Timestamp(2020, 12, 12, 13, 0, 0, 0),4);
        float cost = this.returnBikeController.calculateCost(bike, bike.getEnd_time());
        assertEquals(90000, cost);
    }
}