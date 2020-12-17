package applicationlayer;

import datalayer.model.RentedBike;

import java.sql.Timestamp;

public class SimpleCostCalculator implements CostComputer {

    @Override
    public float checkout(RentedBike rentedBike, Timestamp endTime) {
        return 1000;
    }
}
