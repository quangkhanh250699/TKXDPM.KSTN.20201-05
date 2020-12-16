package datalayer.model;

import java.sql.*;
import java.util.ArrayList;

public class Station {

    private String stationId;
    private String stationName;
    private String address;
    private String imagePath;

    public String getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public String getAddress() {
        return address;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationID='" + stationId + '\'' +
                ", stationName='" + stationName + '\'' +
                ", address='" + address + '\'' +
                ", imageUrl='" + imagePath + '\'' +
                '}';
    }
}
