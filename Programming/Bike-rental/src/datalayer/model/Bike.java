package datalayer.model;

public class Bike {

    private String bikeId;
    private String bikeName;
    private String info;
    private int stationId;

    public Bike(String bikeId, String bikeName) {
        this.bikeId = bikeId;
        this.bikeName = bikeName;
    }

    public String getBikeId() {
        return bikeId;
    }

    public String getBikeName() {
        return bikeName;
    }

    public String toString() {
        return this.bikeId + ": " +  this.bikeName;
    }


}
