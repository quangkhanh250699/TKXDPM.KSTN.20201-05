package applicationlayer;

import datalayer.model.RentedBike;

import java.sql.Timestamp;

public interface CostComputer {

    float checkout(RentedBike rentedBike, Timestamp endTime);

}
