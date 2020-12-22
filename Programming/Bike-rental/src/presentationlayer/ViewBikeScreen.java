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
    TextField textField;
    public void goBack(ActionEvent actionEvent) throws IOException {
        /**
         * Handle event when user click on back button, go back to station detail screen
         */
        App.getInstance().display_StationDetailScreen(this.getStationId());
    }

    public void initData(int stationId, Bike bike) {
        /**
         * Initialize data of screen: detail information of the bike
         *
         * @param: Bike bike: bike to display detail screen
         * @param: int stationId: id of the station of that bike, this param used for going back to station
         * detail screen
         */
        // Set stationId to goback
        this.setStationId(stationId);

        // Rent bike information
        RentBikeScreen.rentBikeData(bike, list);
    }



}
