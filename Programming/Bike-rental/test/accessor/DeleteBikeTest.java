package accessor;

import datalayer.acessor.BikeAccessor;
import datalayer.model.Bike;
import datalayer.model.Category;
import datalayer.model.CategoryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteBikeTest {

    private BikeAccessor bikeAccessor;
    private Bike bike;

    @BeforeEach
    void setUp(){
        bikeAccessor = new BikeAccessor();
        CategoryFactory categoryFactory = CategoryFactory.getInstance();
        Category category = categoryFactory.getCategoryById(1);
        bike = new Bike(10, "test_update_bike", 1, 0, true, category);
    }

    @Test
    void deleteBike(){
        bikeAccessor.delete(bike);
        Bike bikeUpdate = bikeAccessor.get(bike.getBikeId());
        assertNull(bikeUpdate);
    }
}
