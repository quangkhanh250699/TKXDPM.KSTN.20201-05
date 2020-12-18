package applicationlayer;

import datalayer.model.RentedBike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCostCalculatorTest {
    private SimpleCostCalculator simpleCostCalculator;

    @BeforeEach
    void setUp() {
        simpleCostCalculator = new SimpleCostCalculator();
    }

    @ParameterizedTest
    @CsvSource({
            "2012-07-10 14:58:00,30,80000",
            "2012-07-10 14:58:00,630,180000",
            "2012-07-10 14:58:00,720,200000",
            "2012-07-10 14:58:00,1000,200000",
            "2012-07-10 14:58:00,1455,202000",
            "2012-07-10 14:58:00,1500,208000"
    })
    void checkout(String start, long minute, float expected) throws ParseException {
        Date temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
        long duration = TimeUnit.MINUTES.toMillis(minute);
        Timestamp startTime = new Timestamp(temp.getTime());
        Timestamp endTime = new Timestamp(temp.getTime() + duration);
        RentedBike rentedBike = new RentedBike(1, 1, 1, startTime, null);
        float cost = simpleCostCalculator.checkout(rentedBike, endTime);
        assertEquals(expected, cost);
    }
}