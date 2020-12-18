package presentationlayer;

import datalayer.model.Bike;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ViewBikeScreen {
    @FXML
    ListView<String> list;

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getStationId() {
        return stationId;
    }

    int stationId;

    @FXML
    public void initialize() {
        //
    }

    @FXML
    TextField textField;
    public void goBack(ActionEvent actionEvent) throws IOException {
        App.getInstance().display_StationDetailScreen(this.getStationId());
    }

    public void initData(int stationId, Bike bike) {
        // Set stationId to goback
        this.setStationId(stationId);

        // Rent bike information
        RentBikeScreen.rentBikeData(bike, list);
    }



}
