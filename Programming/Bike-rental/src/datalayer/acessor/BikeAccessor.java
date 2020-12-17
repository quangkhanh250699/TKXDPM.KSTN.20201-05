package datalayer.acessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import datalayer.model.Bike;
import datalayer.model.Category;
import datalayer.model.CategoryFactory;

public class BikeAccessor extends DataAccessor<Bike>{


    @Override
    public Bike get(int id) {
        String q = "SELECT * FROM bike WHERE bikeId = " + id;
        Bike bike = null;
        try{
            ResultSet rs = query(q);
            rs.next();
            CategoryFactory categoryFactory = CategoryFactory.getInstance();
            Category category = categoryFactory.getCategoryById(rs.getInt("categoryId"));
            bike = new Bike(id, rs.getString("bike_name"), rs.getInt("stationId"),
                    rs.getFloat("pin"), rs.getBoolean("status"), category);
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return bike;
    }

    @Override
    public List<Bike> getAll() {
        String q = "SELECT * FROM bike" ;
        List<Bike> bikes = new ArrayList<Bike>();
        try{
            ResultSet rs = query(q);
            CategoryFactory categoryFactory = CategoryFactory.getInstance();
            while(rs.next()){
                Category category = categoryFactory.getCategoryById(rs.getInt("categoryId"));
                bikes.add(new Bike(rs.getInt("bikeId"), rs.getString("bike_name"), rs.getInt("stationId"),
                        rs.getFloat("pin"), rs.getBoolean("status"), category));

            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return bikes;
    }

    public List<Bike> getBikeByStationId(int stationId) {
        String q = "SELECT * FROM bike where stationId = " + stationId;
        List<Bike> bikes = new ArrayList<Bike>();
        try{
            ResultSet rs = query(q);
            CategoryFactory categoryFactory = CategoryFactory.getInstance();
            while(rs.next()){
                Category category = categoryFactory.getCategoryById(rs.getInt("categoryId"));
                bikes.add(new Bike(rs.getInt("bikeId"), rs.getString("bike_name"), rs.getInt("stationId"),
                        rs.getFloat("pin"), rs.getBoolean("status"), category));

            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return bikes;
    }

    @Override
    public void update(Bike bike) {

    }

    @Override
    public void save(Bike bike) {

    }

    @Override
    public void delete(Bike bike) {

    }
}
