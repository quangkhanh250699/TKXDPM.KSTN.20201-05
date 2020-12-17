package datalayer.acessor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datalayer.model.Bike;
import datalayer.model.BikeFactory;
import datalayer.model.Station;

public class StationAccessor extends DataAccessor<Station>{
    @Override
    public Station get(int id) {
        String q = "SELECT * FROM station WHERE stationId = " + id;
        Station station = null;
        try{
            ResultSet rs = query(q);
            BikeFactory bikeFactory = BikeFactory.getInstance();
            List<Bike> bikes = bikeFactory.getBikeByStationId(id);
            rs.next();
            station = new Station(id, rs.getString("station_name"), rs.getString("address"),
                    rs.getString("image_path"), bikes);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return station;
    }

    @Override
    public List<Station> getAll() {
        String q = "SELECT * FROM station" ;
        List<Station> stations = new ArrayList<Station>();
        try{
            ResultSet rs = query(q);
            BikeFactory bikeFactory = BikeFactory.getInstance();
            while(rs.next()){
                List<Bike> bikes = bikeFactory.getBikeByStationId(rs.getInt("stationId"));
                stations.add(new Station(rs.getInt("stationId"), rs.getString("station_name"), rs.getString("address"),
                        rs.getString("image_path"), bikes));

            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return stations;
    }

    @Override
    public void update(Station station) {

    }

    @Override
    public void save(Station station) {

    }

    @Override
    public void delete(Station station) {

    }
}
