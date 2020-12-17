package datalayer.acessor;

import datalayer.model.Category;
import datalayer.model.Station;
import datalayer.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAccessor extends DataAccessor<User>{
    @Override
    public User get(int id) {
        String q = "SELECT * FROM station WHERE stationId = " + id;
        User user = null;
        try{
            ResultSet rs = query(q);
            rs.next();
            user = new User(id, rs.getString("name"));

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
        String q = "SELECT * FROM category" ;
        List<User> users = new ArrayList<User>();
        try{
            ResultSet rs = query(q);
            while(rs.next()){
                users.add(new User(rs.getInt("userId"), rs.getString("name")));

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
