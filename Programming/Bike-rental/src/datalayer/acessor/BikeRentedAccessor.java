package datalayer.acessor;

import datalayer.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BikeRentedAccessor extends DataAccessor<RentedBike>{
    @Override
    public RentedBike get(int id) {
        String q = "SELECT * FROM rent WHERE rentId = " + id;
        RentedBike rentedBike = null;
        try{
            ResultSet rs = query(q);
            BikeFactory bikeFactory = BikeFactory.getInstance();
            rs.next();
            Bike bike = bikeFactory.getBikeById(rs.getInt("bikeId"));
            rentedBike = new RentedBike(bike.getBikeId(), bike.getBikeName(), bike.getStationId(),
                    bike.getPin(), bike.isStatus(), bike.getCategory(), rs.getInt("userId"),
                    rs.getInt("debit"), rs.getTimestamp("start_time"),
                    rs.getTimestamp("end_time"), rs.getInt("rentId"));
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return rentedBike;
    }

    @Override
    public List<RentedBike> getAll() {
        String q = "SELECT * FROM rent" ;
        List<RentedBike> rentedBikes = new ArrayList<RentedBike>();
        try{
            ResultSet rs = query(q);
            BikeFactory bikeFactory = BikeFactory.getInstance();
            while(rs.next()){
                Bike bike = bikeFactory.getBikeById(rs.getInt("bikeId"));
                RentedBike rentedBike = new RentedBike(bike.getBikeId(), bike.getBikeName(), bike.getStationId(),
                        bike.getPin(), bike.isStatus(), bike.getCategory(), rs.getInt("userId"),
                        rs.getInt("debit"), rs.getTimestamp("start_time"),
                        rs.getTimestamp("end_time"), rs.getInt("rentId"));
                rentedBikes.add(rentedBike);
            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return rentedBikes;
    }

    public List<RentedBike> getBikeRentByUserId(int userId) {
        String q = "SELECT * FROM rent WHERE userId = " + userId;
        List<RentedBike> rentedBikes = new ArrayList<RentedBike>();
        try{
            ResultSet rs = query(q);
            BikeFactory bikeFactory = BikeFactory.getInstance();
            while(rs.next()){
                Bike bike = bikeFactory.getBikeById(rs.getInt("bikeId"));
                RentedBike rentedBike = new RentedBike(bike.getBikeId(), bike.getBikeName(), bike.getStationId(),
                        bike.getPin(), bike.isStatus(), bike.getCategory(), rs.getInt("userId"),
                        rs.getInt("debit"), rs.getTimestamp("start_time"),
                        rs.getTimestamp("end_time"), rs.getInt("rentId"));
                rentedBikes.add(rentedBike);
            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return rentedBikes;
    }

    @Override
    public void update(RentedBike rentedBike) {

    }

    @Override
    public void save(RentedBike rentedBike) {

    }

    @Override
    public void delete(RentedBike rentedBike) {

    }
}
