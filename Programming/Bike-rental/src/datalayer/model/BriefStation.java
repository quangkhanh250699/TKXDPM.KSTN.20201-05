package datalayer.model;

import datalayer.acessor.BikeAccessor;

import java.util.List;

public class BriefStation {

    private int stationId;
    private String stationName;
    private String imagePath;
    private List<Bike> bikes;

    public BriefStation(int stationId, String stationName, String imagePath) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.imagePath = imagePath;

        BikeAccessor bikeAccessor = new BikeAccessor();
        this.bikes = bikeAccessor.getByStationId(stationId);
    }

    public int getStationId() {
        return stationId;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public String getStationName() {
        return stationName;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "BriefStation{" +
                "stationId=" + this.stationId +
                ", stationName='" + this.stationName + '\'' +
                ", imagePath='" + this.imagePath + '\'' +
                '}';
    }
}
