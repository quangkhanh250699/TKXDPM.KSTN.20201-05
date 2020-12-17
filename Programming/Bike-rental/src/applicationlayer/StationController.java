package applicationlayer;

import datalayer.acessor.StationAccessor;
import datalayer.model.Station;

public class StationController {
    public Station getStation(int stationId) {
        StationAccessor accessor = new StationAccessor();
        return accessor.get(stationId);
    }
}
