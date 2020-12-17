package datalayer.acessor;

import datalayer.model.Bike;
import datalayer.model.Category;
import datalayer.model.CategoryFactory;
import datalayer.model.RentedBike;

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
            rs.next();
            rentedBike = new RentedBike(id, rs.getInt("userId"), rs.getInt("bikeId"),
                    rs.getTimestamp("start_time"), rs.getTimestamp("end_time"));
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
            while(rs.next()){
                rentedBikes.add(new RentedBike(rs.getInt("rentId"), rs.getInt("userId"), rs.getInt("bikeId"),
                        rs.getTimestamp("start_time"), rs.getTimestamp("end_time")));
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
            while(rs.next()){
                rentedBikes.add(new RentedBike(rs.getInt("rentId"), rs.getInt("userId"), rs.getInt("bikeId"),
                        rs.getTimestamp("start_time"), rs.getTimestamp("end_time")));
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
