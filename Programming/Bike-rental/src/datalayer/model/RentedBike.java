package datalayer.model;

import java.sql.Timestamp;

public class RentedBike {
    private  int rentId;
    private int userId;
    private int bikeId;
    private Timestamp start_time;
    private Timestamp end_time;

    public RentedBike(int rentId, int userId, int bikeId, Timestamp start_time, Timestamp end_time) {
        this.rentId = rentId;
        this.userId = userId;
        this.bikeId = bikeId;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getRentId() {
        return rentId;
    }

    public int getUserId() {
        return userId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    @Override
    public String toString() {
        return "RentedBike{" +
                "rentId=" + this.rentId +
                ", userId=" + this.userId +
                ", bikeId=" + this.bikeId +
                ", start_time=" + this.start_time +
                ", end_time=" + this.end_time +
                '}';
    }
}
