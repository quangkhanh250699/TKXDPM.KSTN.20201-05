package datalayer.model;

public class BriefStation {
    private int stationId;
    private String stationName;
    private String imagePath;
    private String address;

    public BriefStation(int stationId, String stationName, String address) {
        this.stationId = stationId;
        this.stationName = stationName;
//        this.imagePath = imagePath;
        this.address = address;
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

    public String toString() {
        return this.stationName + " ở " +  this.address;
    }
}
