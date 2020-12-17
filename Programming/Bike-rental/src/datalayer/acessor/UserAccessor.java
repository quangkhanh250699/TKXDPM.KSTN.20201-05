package datalayer.acessor;

import datalayer.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAccessor extends DataAccessor<User>{
    @Override
    public User get(int id) {
        String q = "SELECT * FROM user WHERE userId = " + id;
        User user = null;
        try{
            ResultSet rs = query(q);
            BikeFactory bikeFactory = BikeFactory.getInstance();
            rs.next();
            List<Bike> bikesRent = bikeFactory.getBikeRentByUserId(id);
            user = new User(id, rs.getString("name"), bikesRent);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        String q = "SELECT * FROM user" ;
        List<User> users = new ArrayList<User>();
        try{
            ResultSet rs = query(q);
            BikeFactory bikeFactory = BikeFactory.getInstance();
            while(rs.next()){
                List<Bike> bikesRent = bikeFactory.getBikeRentByUserId(rs.getInt("userId"));
                users.add(new User(rs.getInt("userId"), rs.getString("name"), bikesRent));

            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
