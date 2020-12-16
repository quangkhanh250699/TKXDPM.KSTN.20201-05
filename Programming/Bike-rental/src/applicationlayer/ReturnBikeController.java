package applicationlayer;

import datalayer.model.RentedBike;

import java.sql.Timestamp;

public class ReturnBikeController {

    private CostComputer calculator;

    public ReturnBikeController() {
        this.calculator = new SimpleCostCalculator();
    }

    public void requestReturnBike(RentedBike bike) {
        return;
    }
}
