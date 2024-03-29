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
            BikeRentedAccessor bikeRentedAccessor = new BikeRentedAccessor();
            if(rs.next() == false){
                return null;
            }
            List<RentedBike> rentedBikes = bikeRentedAccessor.getBikeRentByUserId(id);

            user = new User(id, rs.getString("name"), rentedBikes);

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
            BikeRentedAccessor bikeRentedAccessor = new BikeRentedAccessor();
            while(rs.next()){
                List<RentedBike> rentedBikes = bikeRentedAccessor.getBikeRentByUserId(rs.getInt("userId"));
                users.add(new User(rs.getInt("userId"), rs.getString("name"), rentedBikes));

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
        String q = "UPDATE user SET " +
                " name = " + "\"" +  user.getName() + "\"" +
                " WHERE userId = " + user.getUserId();
        System.out.println(q);
        try{
            executeUpdate(q);
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void save(User user) {
        String q = "insert into user(name)\n" +
                "values (" +
                "\""+ user.getName() + "\"" +
                ")";
        System.out.println(q);
        try{
            executeUpdate(q);
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void delete(User user) {
        String q = "DELETE FROM user WHERE userId = " + user.getUserId();
        System.out.println(q);
        try{
            execute(q);
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return;
    }
}
