package datalayer.model;

public class Bike {

    private int bikeId;
    private String bikeName;
    private String info;
    private int stationId;

    public Bike(int bikeId, String bikeName) {
        this.bikeId = bikeId;
        this.bikeName = bikeName;
    }

    public int getBikeId() {
        return bikeId;
    }

    public String getBikeName() {
        return bikeName;
    }

    public String toString() {
        return this.bikeId + ": " +  this.bikeName;
    }


}
