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

    /**
     * We use Singleton to create only one object of BikeFactory,
     * cause BikeFactory has "bikes" map the id of Category object to Bike object
     * @return
     */
    public static BikeFactory getInstance(){
        if(instance == null){
            instance = new BikeFactory();
        }
        return instance;
    }

    /**
     * Use this function instead of BikeFactory.get()
     * Select the table "bike" in database
     * Get Bike by id, and save it to "bikes"
     * @param bikeId
     * @return object of Bike
     */
    public Bike getBikeById(int bikeId){
        if(!bikes.containsKey(bikeId)){
            Bike bike = bikeAccessor.get(bikeId);
            bikes.put(bikeId, bike);
        }
        return bikes.get(bikeId);
    }

    /**
     * Use this function instead of BikeFactory.getAll()
     * Select the table "bike" in database
     * Get all Bikes, and save them to "bikes"
     * @return object of Bike
     */
    public List<Bike> getAllBike(){
        List<Bike> bikes = bikeAccessor.getAll();
        for(Bike bike: bikes){
            if(!this.bikes.containsKey(bike.getBikeId())){
                this.bikes.put(bike.getBikeId(), bike);
            }
        }
        return new ArrayList<Bike>(this.bikes.values());
    }

    /**
     * Select the table "bike" in database
     * Get Bikes which has bike.stationId = stationId
     * @param stationId
     * @return list bikes has bike.stationId = stationId
     */
    public List<Bike> getBikeByStationId(int stationId){
        List<Bike> bikes = bikeAccessor.getBikeByStationId(stationId);
        return bikes;
    }
}
