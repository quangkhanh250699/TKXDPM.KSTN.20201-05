package datalayer.model;

import datalayer.acessor.BikeAccessor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Station {

    private int stationId;
    private String stationName;
    private String imagePath;
    private String address;
    private List<Bike> bikes;

    public Station(int stationId, String stationName, String imagePath, String address, List<Bike> bikes) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.imagePath = imagePath;
        this.address = address;
        this.bikes = bikes;
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

    public String getAddress() {
        return address;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + this.stationId +
                ", stationName='" + this.stationName + '\'' +
                ", address='" + this.address + '\'' +
                ", imagePath='" + this.imagePath + '\'' +
                '}';
    }
}
