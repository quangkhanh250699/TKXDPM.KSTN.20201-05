package datalayer.model;

import datalayer.acessor.CategoryAccessor;
import datalayer.acessor.connection.MySQLConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryFactory {

    private static CategoryFactory instance;
    private Map<Integer, Category> categories = new HashMap<Integer, Category>();
    private CategoryAccessor categoryAccessor = new CategoryAccessor();

    private CategoryFactory(){}

    public static CategoryFactory getInstance(){
        if(instance == null){
            instance = new CategoryFactory();
        }
        return instance;
    }

    public Category getCategoryById(int categoryId){
        if(!categories.containsKey(categoryId)){

            Category category = categoryAccessor.get(categoryId);
            categories.put(categoryId, category);
        }
        return categories.get(categoryId);
    }

//    public List<Category> getAllCategory(){
//        List<Category> categories = categoryAccessor.getAll();
//        for(Category category: categories){
//            if(!this.categories.containsKey(category.getCategoryId())){
//                this.categories.put(category.getCategoryId(), category);
//            }
//        }
//        return new ArrayList<Category>(this.categories.values());
//    }

}
