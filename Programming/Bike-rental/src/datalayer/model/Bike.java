package datalayer.model;

public class Bike {

    private int bikeId;
    private String bikeName;
    private String info;
    private int stationId;
    private Category category;

    public Bike(int bikeId, String bikeName, String info, int stationId) {
        this.bikeId = bikeId;
        this.bikeName = bikeName;
        this.stationId = stationId;
        this.info = info;
    }

    public Bike(int bikeId, String bikeName, String info, int stationId, Category category) {
        this.bikeId = bikeId;
        this.bikeName = bikeName;
        this.info = info;
        this.stationId = stationId;
        this.category = category;
    }

    public int getStationId() {
        return stationId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public String getBikeName() {
        return bikeName;
    }

    @Override
    public String toString() {
        return "Xe đạp số " + this.bikeId + ": " +  this.bikeName + ". Barcode: " + this.bikeId;
    }
}
