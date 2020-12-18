package datalayer.model;

public class Bike {

    private int bikeId;
    private String bikeName;
    private int stationId;
    private float pin;
    private boolean status;
    private Category category;

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

    @Override
    public String toString() {
        return "Xe đạp số " + this.bikeId + ".Tên xe: " +  this.bikeName + ". Barcode: " + this.bikeId;
    }
}
