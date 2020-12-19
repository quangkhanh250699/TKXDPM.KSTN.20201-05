package applicationlayer;

import datalayer.model.RentedBike;

import java.sql.Timestamp;

public class BasicCostCalculator extends SimpleCostCalculator{

    private final int BASE_FIRST_30M = 10000;
    private final int EXTRA_PER_INTERVAL = 3000;
    private final int INTERVAL = 15;

    @Override
    public float checkout(RentedBike rentedBike, Timestamp endTime) {
        long minutes = getMinutes(rentedBike.getStart_time(), endTime);
        long extra = minutes - 30;
        float cost = BASE_FIRST_30M;
        int intervals = (int) Math.ceil(extra / INTERVAL);
        if (extra > 0)
            cost += intervals * EXTRA_PER_INTERVAL;
        return cost;
    }
}
