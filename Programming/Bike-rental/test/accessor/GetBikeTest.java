package accessor;

import datalayer.acessor.BikeAccessor;
import datalayer.model.Bike;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetBikeTest {

    private BikeAccessor bikeAccessor;

    @BeforeEach
    void setUp(){bikeAccessor = new BikeAccessor();}

    @ParameterizedTest
    @CsvSource({
            "1, 1"
    })

    void validateBike(int id, int bikeId){
        Bike bike = bikeAccessor.get(id);

        assertEquals(bike.getBikeId(), bikeId);
    }
}
