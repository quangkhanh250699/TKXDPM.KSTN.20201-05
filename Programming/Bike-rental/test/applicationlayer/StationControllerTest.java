package applicationlayer;

import datalayer.model.Station;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationControllerTest {

    private StationController stationController;

    @BeforeEach
    void setUp() {
        stationController = new StationController();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStation() {
        int id = 1;
        Station station = this.stationController.getStation(id);
        assertEquals(id, station.getStationId());
    }
}