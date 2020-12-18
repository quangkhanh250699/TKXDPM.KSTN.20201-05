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
        String bikeid = "Bike id: " + bike.getBikeId();
        String bikename = "Bike name:  " + bike.getBikeName();
        String pin = "Pin: " + bike.getPin();
        String status =  bike.isStatus() ? "Trạng thái: Sẵn sàng" : "Trạng thái: Đang cho mượn";
        String bikecategory = "Caterory: " + bike.getCategory().getName();
        String description = "Description: " + bike.getCategory().getDescription();
        String costPerHour = "Cost per hour: " + bike.getCategory().getCost_per_hour();
        ObservableList<String> items = FXCollections.observableArrayList(bikeid, bikename, pin, status, bikecategory
        , description, costPerHour);

        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
