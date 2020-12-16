package datalayer.model;

public class Bike {

    private int BikeId;
    private String bikeName;
    private int stationId;
    private float pin;
    private boolean status;
    private Category category;

    public Bike(int bikeId, String bikeName, int stationId, float pin, boolean status, int categoryId) {
        BikeId = bikeId;
        this.bikeName = bikeName;
        this.stationId = stationId;
        this.pin = pin;
        this.status = status;
        CategoryFactory categoryFactory = CategoryFactory.getInstance();
        this.category = categoryFactory.getCategory(categoryId);

    }

    public int getBikeId() {
        return BikeId;
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
        return "Bike{" +
                "BikeId='" + BikeId + '\'' +
                ", bikeName='" + bikeName + '\'' +
                ", stationId=" + stationId +
                ", pin=" + pin +
                ", status=" + status +
                ", category=" + category +
                '}';
    }
}
