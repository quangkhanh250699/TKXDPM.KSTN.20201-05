package datalayer.acessor;

import datalayer.model.Bike;
import datalayer.model.Category;
import datalayer.model.CategoryFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryAccessor extends DataAccessor<Category>{
    @Override
    public Category get(int id) {
        String q = "SELECT * FROM category WHERE categoryid = " + id;
        Category category = null;
        try{
            ResultSet rs = query(q);
            rs.next();
            category = new Category(id, rs.getString("name"), rs.getString("description"),
                    rs.getFloat("cost_per_hour"), rs.getInt("n_pedals"), rs.getInt("n_seats"));
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> getAll() {
        String q = "SELECT * FROM category" ;
        List<Category> categories = new ArrayList<Category>();
        try{
            ResultSet rs = query(q);
            while(rs.next()){
                categories.add(new Category(rs.getInt("categoryId"), rs.getString("name"), rs.getString("description"),
                        rs.getFloat("cost_per_hour"), rs.getInt("n_pedals"), rs.getInt("n_seats")));
            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(Category category) {

    }
}
