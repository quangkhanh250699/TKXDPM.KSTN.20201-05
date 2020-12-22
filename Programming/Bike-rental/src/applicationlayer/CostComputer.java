package applicationlayer;

import datalayer.model.Bike;
import datalayer.model.RentedBike;

import java.sql.Timestamp;

/**
 * Interface provides methods related cost computation.
 */
public interface CostComputer {

    /**
     *
     * @param rentedBike bike that was rented by user
     * @param endTime the time user checking out
     * @return amount of money
     */
    float checkout(RentedBike rentedBike, Timestamp endTime);

    /**
     *
     * @param bike
     * @return
     */
    float getDebit(Bike bike);

}
