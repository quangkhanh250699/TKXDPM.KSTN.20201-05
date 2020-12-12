package datalayer.model;

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
}
