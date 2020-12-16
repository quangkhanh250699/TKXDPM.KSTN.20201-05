package datalayer.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Station {

    private String stationId;
    private String stationName;
    private String address;
    private List<Bike> bikes;
    private String imagePath;


    public String getStationId() {
        return stationId;
    }
    
    public List<Bike> getBikes() {
        return bikes;
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
}
