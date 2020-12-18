package applicationlayer;

import datalayer.model.Bike;
import datalayer.model.RentedBike;

import java.sql.Timestamp;

public interface CostComputer {

    float checkout(RentedBike rentedBike, Timestamp endTime);

    float getDebit(Bike bike);

}
