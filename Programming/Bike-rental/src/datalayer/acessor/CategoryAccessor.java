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
            if(rs.next() == false){
                return null;
            }
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
        String q = "UPDATE category SET " +
                " name = " + "\"" +  category.getName() + "\"" +
                " , description = " + "\"" +  category.getDescription() + "\"" +
                " , cost_per_hour = " + category.getCost_per_hour() +
                " , n_pedals = " + category.getN_pedals() +
                " , n_seats = " + category.getN_seats() +
                " WHERE categoryId = " + category.getCategoryId();
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
    public void save(Category category) {
        String q = "insert into category(name, description, cost_per_hour, n_pedals, n_seats)\n" +
                "values( " +
                "\""+ category.getName() + "\", " + "\""+ category.getDescription() + "\", " +
                category.getCost_per_hour() + ", " +
                category.getN_pedals() + ", " + category.getN_seats()
                +")";
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
    public void delete(Category category) {
        String q = "DELETE FROM category WHERE categoryId = " + category.getCategoryId();
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
