package datalayer.model;

import datalayer.acessor.BikeAccessor;
import datalayer.acessor.CategoryAccessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BikeFactory {
    private static BikeFactory instance;
    private Map<Integer, Bike> bikes = new HashMap<Integer, Bike>();
    private BikeAccessor bikeAccessor = new BikeAccessor();

    private BikeFactory(){}

    public static BikeFactory getInstance(){
        if(instance == null){
            instance = new BikeFactory();
        }
        return instance;
    }

    public Bike getBikeById(int bikeId){
        if(!bikes.containsKey(bikeId)){
            Bike bike = bikeAccessor.get(bikeId);
            bikes.put(bikeId, bike);
        }
        return bikes.get(bikeId);
    }

    public List<Bike> getAllBike(){
        List<Bike> bikes = bikeAccessor.getAll();
        for(Bike bike: bikes){
            if(!this.bikes.containsKey(bike.getBikeId())){
                this.bikes.put(bike.getBikeId(), bike);
            }
        }
        return new ArrayList<Bike>(this.bikes.values());
    }

    public List<Bike> getBikeByStationId(int stationId){
        List<Bike> bikes = bikeAccessor.getBikeByStationId(stationId);
        return bikes;
    }
}
