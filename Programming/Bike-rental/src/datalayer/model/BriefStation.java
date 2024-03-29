package datalayer.model;

import datalayer.acessor.BikeAccessor;

import java.util.List;

public class BriefStation {

    private int stationId;
    private String stationName;
    private String imagePath;

    public BriefStation(int stationId, String stationName, String imagePath) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.imagePath = imagePath;
    }

    public int getStationId() {
        return stationId;
    }


    public String getStationName() {
        return stationName;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "Bãi xe số: " + this.stationId + ". Tên bãi xe: " + this.stationName;
    }
}
