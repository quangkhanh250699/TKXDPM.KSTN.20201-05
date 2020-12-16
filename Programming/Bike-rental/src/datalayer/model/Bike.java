package datalayer.model;

public class Bike {

    private String BikeId;
    private String bikeName;

    public Bike(String bikeId, String bikeName) {
        BikeId = bikeId;
        this.bikeName = bikeName;
    }

    public String getBikeId() {
        return BikeId;
    }

    public String getBikeName() {
        return bikeName;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "BikeId='" + BikeId + '\'' +
                ", bikeName='" + bikeName + '\'' +
                '}';
    }
}
