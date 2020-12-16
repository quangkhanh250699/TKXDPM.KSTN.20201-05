package datalayer.model;

import java.sql.Timestamp;

public class RentedBike extends Bike {

    private Timestamp startTime;
    private int userId;

    public RentedBike(int bikeId, String bikeName) {
        super(bikeId, bikeName);
    }
}
