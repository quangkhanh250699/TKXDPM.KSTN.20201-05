package sample;

import datalayer.acessor.BikeAccessor;
import datalayer.acessor.CategoryAccessor;
import datalayer.acessor.StationAccessor;
import datalayer.acessor.UserAccessor;
import datalayer.model.*;

import java.util.List;

public class test {
    public static void main(String[] args) {

//        CategoryFactory categoryFactory = CategoryFactory.getInstance();
//        Category category1 = categoryFactory.getCategoryById(1);
//        System.out.println(category1.toString());
//        Category category2 = categoryFactory.getCategoryById(2);
//        System.out.println(category2.toString());
//
//        List<Category> categories = categoryFactory.getAllCategory();
//        for(Category category : categories){
//            System.out.println(category.toString());
//        }
//
//
//        BikeFactory bikeFactory = BikeFactory.getInstance();
//        List<Bike> bikes1 = bikeFactory.getAllBike();
//        List<Bike> bikes = bikeFactory.getBikeByStationId(1);
//        for(Bike bike: bikes){
//            System.out.println(bike.toString());
//        }


//        StationAccessor stationAccessor = new StationAccessor();
//        List<Station> stations = stationAccessor.getAll();
//        System.out.println(stations.get(0).toString());
//        System.out.println(stations.get(1).toString());\

        UserAccessor userAccessor = new UserAccessor();
        User user = userAccessor.get(1);
        System.out.println(user.toString());
        for(Bike bike: user.getRentBikes()){
            System.out.println(bike.toString());
        }

    }
}
