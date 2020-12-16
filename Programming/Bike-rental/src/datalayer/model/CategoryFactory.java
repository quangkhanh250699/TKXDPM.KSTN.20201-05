package datalayer.model;

import datalayer.acessor.CategoryAccessor;
import datalayer.acessor.connection.MySQLConnection;

import java.util.Map;

public class CategoryFactory {

    private static CategoryFactory instance;
    private Map<Integer, Category> categories;

    private CategoryFactory(){}

    public static CategoryFactory getInstance(){
        if(instance == null){
            instance = new CategoryFactory();
        }
        return instance;
    }

    public Category getCategory(int categoryId){
        if(!categories.containsKey(categoryId)){
            CategoryAccessor categoryAccessor = new CategoryAccessor();
            Category category = categoryAccessor.get(categoryId);
            categories.put(categoryId, category);
        }
        return categories.get(categoryId);
    }
}
