package presentationlayer;

import applicationlayer.StationController;
import datalayer.model.Bike;
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

public class StationDetailScreen {
    @FXML
    ListView<Bike> list;

    int stationID;

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }


    public void goBack(ActionEvent actionEvent) {
        App.getInstance().display_HomeScreen();
    }

    public void initData(int stationID) {
        // set stationid of stationdetail screen
        this.setStationID(stationID);

        //Rent Listbike took from controller
        StationController stationController = new StationController();
        Station station = stationController.getStation(stationID);
        ArrayList<Bike> bikes = (ArrayList<Bike>) station.getBikes();
        ObservableList<Bike> items = FXCollections.observableArrayList(bikes);
        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }



    public void goViewBikeScreen(MouseEvent mouseEvent) throws IOException {
        Bike bike = list.getSelectionModel().getSelectedItem();
        App.getInstance().display_ViewBikeScreen(this.getStationID(), bike);
    }
}
