package datalayer.model;

public class Bike {

    protected int bikeId;
    protected String bikeName;
    protected int stationId;
    protected float pin;

    protected boolean status;
    protected Category category;

    public Bike(int bikeId, String bikeName, int stationId, float pin, boolean status, Category category) {
        this.bikeId = bikeId;
        this.bikeName = bikeName;
        this.stationId = stationId;
        this.pin = pin;
        this.status = status;
        this.category = category;
    }

    public int getBikeId() {
        return bikeId;
    }

    public String getBikeName() {
        return bikeName;
    }

    public int getStationId() {
        return stationId;
    }

    public float getPin() {
        return pin;
    }

    public boolean isStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }


    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public void setPin(float pin) {
        this.pin = pin;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Xe đạp số " + this.bikeId + ".Tên xe: " +  this.bikeName + ". Barcode: " + this.bikeId;
    }
}
