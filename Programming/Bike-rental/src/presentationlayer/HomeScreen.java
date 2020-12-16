package presentationlayer;

import applicationlayer.HomeController;
import applicationlayer.StationController;
import datalayer.model.Bike;
import datalayer.model.BriefStation;
import datalayer.model.Station;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeScreen {
    @FXML
    ListView<BriefStation> list;
    @FXML
    private void goDetailScreen(ActionEvent e) {
//        GUI.getInstance().display(GUI.STATION_DETAIL);
    }


    @FXML
    public void initialize() {
        /* Code when merge
        ArrayList<BriefStation> stations = (ArrayList<BriefStation>) HomeController.getBriefStations();
        ObservableList<BriefStation> items =  FXCollections.observableArrayList(stations);
        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        */
        /* Code when fake data */
        BriefStation briefStation1 = new BriefStation(1, "bai xe nuoc ngam", "So 3 phuong Ben Thuy");
        BriefStation briefStation2 = new BriefStation(2, "bai xe nuoc ngam", "So 3 phuong Ben Thuy");
        BriefStation briefStation3 = new BriefStation(3, "bai xe nuoc ngam", "So 3 phuong Ben Thuy");
        ObservableList<BriefStation> items = FXCollections.observableArrayList(briefStation1, briefStation2, briefStation3);
        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    @FXML
    public void handleMouseClick(MouseEvent e) throws IOException {
        BriefStation tmp = list.getSelectionModel().getSelectedItem();
        int stationId = tmp.getStationId();
        App.getInstance().display_StationDetail(stationId);
    }
}