package datalayer.model;

import java.sql.Timestamp;

public class RentedBike extends Bike {
    private  int rentId;
    private int userId;
    private int debit;
    private Timestamp start_time;
    private Timestamp end_time;

    public RentedBike(int bikeId, String bikeName, int stationId, float pin, boolean status,
                      Category category, int userId, int debit, Timestamp start_time) {
        super(bikeId, bikeName, stationId, pin, status, category);
        this.userId = userId;
        this.debit = debit;
        this.start_time = start_time;
        this.end_time = null;
        this.rentId = -1;
    }

    public RentedBike(int bikeId, String bikeName, int stationId, float pin,
                      boolean status, Category category, int userId, int debit, Timestamp start_time,
                      Timestamp end_time, int rentId ) {
        super(bikeId, bikeName, stationId, pin, status, category);
        this.userId = userId;
        this.debit = debit;
        this.start_time = start_time;
        this.end_time = end_time;
        this.rentId = rentId;
    }

    public int getDebit() {
        return debit;
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

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Xe số: " + this.bikeId + " thuê ở bãi xe số " + this.stationId;
    }
}
