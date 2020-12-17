package applicationlayer;

import datalayer.acessor.BriefStationAccessor;
import datalayer.model.BriefStation;

import java.util.List;

public class HomeController {
    public List<BriefStation> getBriefStations() {
        BriefStationAccessor accessor = new BriefStationAccessor();
        return accessor.getAll();
    }
}
