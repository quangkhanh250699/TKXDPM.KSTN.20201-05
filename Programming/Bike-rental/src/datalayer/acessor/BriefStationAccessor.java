package datalayer.acessor;

import datalayer.model.BriefStation;
import datalayer.model.Station;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BriefStationAccessor extends DataAccessor<BriefStation>{
    @Override
    public BriefStation get(int id) {
        String q = "SELECT * FROM station WHERE stationId = " + id;
        BriefStation briefStation = null;
        try{
            ResultSet rs = query(q);
            if(rs.next() == false){
                return null;
            }
            briefStation = new BriefStation(id, rs.getString("station_name"),
                    rs.getString("image_path"));

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return briefStation;
    }

    @Override
    public List<BriefStation> getAll() {
        String q = "SELECT * FROM station" ;
        List<BriefStation> briefStations = new ArrayList<BriefStation>();
        try{
            ResultSet rs = query(q);
            while(rs.next()){
                briefStations.add(new BriefStation(rs.getInt("stationId"), rs.getString("station_name"),
                        rs.getString("image_path")));

            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return briefStations;
    }

    @Override
    public void update(BriefStation briefStation) {

    }

    @Override
    public void save(BriefStation briefStation) {

    }

    @Override
    public void delete(BriefStation briefStation) {

    }
}
