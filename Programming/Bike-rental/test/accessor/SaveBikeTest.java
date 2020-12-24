package accessor;

import datalayer.acessor.BikeAccessor;
import datalayer.model.Bike;
import datalayer.model.Category;
import datalayer.model.CategoryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveBikeTest {
    private BikeAccessor bikeAccessor;
    private Bike bike;

    @BeforeEach
    void setUp(){
        bikeAccessor = new BikeAccessor();
        CategoryFactory categoryFactory = CategoryFactory.getInstance();
        Category category = categoryFactory.getCategoryById(1);
        bike = new Bike(21, "test_update_bike", 1, 0, true, category);
    }

    @Test
    void updateBike(){
        bikeAccessor.save(bike);
        Bike bikeUpdate = bikeAccessor.get(bike.getBikeId());
        assertEquals(bikeUpdate.getBikeName(), bike.getBikeName());
        assertEquals(bikeUpdate.getCategory(), bike.getCategory());
        assertEquals(bikeUpdate.getPin(), bike.getPin());
        assertEquals(bikeUpdate.getStationId(), bike.getStationId());
    }
}
