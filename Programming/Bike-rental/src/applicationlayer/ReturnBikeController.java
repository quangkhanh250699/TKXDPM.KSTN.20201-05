package applicationlayer;

import datalayer.model.RentedBike;

import java.sql.Timestamp;

public class ReturnBikeController {

    private CostComputer calculator;

    public ReturnBikeController() {
        this.calculator = new SimpleCostCalculator();
    }

    public String requestReturnBike(RentedBike bike) {
        return null;
    }

    public float calculateCost(RentedBike rentedBike, Timestamp endTime) {
        return this.calculator.checkout(rentedBike, endTime);
    }
}
