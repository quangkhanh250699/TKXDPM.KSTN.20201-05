package applicationlayer;

import datalayer.model.Bike;
import datalayer.model.RentedBike;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class SimpleCostCalculator implements CostComputer {

    private final float COST_PER_24H = 200000;
    private final float EXTRA_COST_PER_15_MINUTE = 2000;
    private final float REFUND_PER_HOUR = 10000;

    @Override
    public float checkout(RentedBike rentedBike, Timestamp endTime) {
        long minutes = getMinutes(rentedBike.getStart_time(), endTime);
        long hours = TimeUnit.MINUTES.toHours(minutes);
        float cost = 200000;
        if (hours < 12) {
            int earlier = (int) Math.ceil(12 - hours);
            cost = COST_PER_24H - earlier * REFUND_PER_HOUR;
        } else if (hours >= 24) {
            int later = (int) Math.ceil((minutes - 24 * 60) / 15);
            cost = COST_PER_24H + later * EXTRA_COST_PER_15_MINUTE;
        }
        return cost;
    }

    protected long getMinutes(Timestamp start, Timestamp end) {
        long duration = (end.getTime() - start.getTime());
        return TimeUnit.MILLISECONDS.toMinutes(duration);
    }

    @Override
    public float getDebit(Bike bike)  {
        return (float) 0.4 * 400000;
    }
}
