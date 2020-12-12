package presentationlayer;

import datalayer.model.Bike;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.io.IOException;

public class StationDetailBoundary {
    @FXML
    ListView<Bike> list;


    public String getStationID() {
        return stationID;
    }

    String stationID;
    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public void goBikeInformationScreen(ActionEvent actionEvent) {
    }

    public void goViewRentedBikeScreen(ActionEvent actionEvent) {
    }

    public void goReturnBikeScreen(ActionEvent actionEvent) {
    }

    public void goRentBikeScreen(ActionEvent actionEvent) {
    }

    @FXML
    public void initialize() throws IOException {

    }

    public void goBack(ActionEvent actionEvent) {
        GUI.getInstance().display(GUI.HOME);
    }

    public void initData(String stationID) {
        Bike  tmp1 = new Bike("bike001", "xe dap tinh yeu");
        Bike  tmp2 = new Bike("bike002", "xe dap may man");
        Bike  tmp3 = new Bike("bike003", "xe dap tinh yeu");
        Bike  tmp4 = new Bike("bike004", "xe dap tinh yeu");

        this.setStationID(stationID);
        ObservableList<Bike> items = FXCollections.observableArrayList(tmp1, tmp3, tmp2, tmp4);
        list.setItems(items);

//        ArrayList<Bike> bikes = StationController.requestStationDetail(stationID);
//        ObservableList<Bike> items = FXCollections.observableArrayList(bikes);
//        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
