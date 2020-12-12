package datalayer.model;

import java.util.List;

public class Station extends BriefStation {

    private String address;
    private List<Bike> bikes;

    public Station(int stationId, String stationName, String imagePath, String address, List<Bike> bikes) {
        super(stationId, stationName, imagePath);
        this.address = address;
        this.bikes = bikes;
    }
}