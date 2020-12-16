package presentationlayer;

import datalayer.model.Bike;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.io.IOException;

public class StationDetailScreen {
    @FXML
    ListView<Bike> list;


    public int getStationID() {
        return stationID;
    }

    int stationID;
    public void setStationID(int stationID) {
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
        App.getInstance().display_HomeScreen();
    }

    public void initData(int stationID) {
        Bike  tmp1 = new Bike(stationID, "xe dap tinh yeu");
        Bike  tmp2 = new Bike(stationID, "xe dap may man");
        Bike  tmp3 = new Bike(stationID, "xe dap tinh yeu");
        Bike  tmp4 = new Bike(stationID, "xe dap tinh yeu");

//        this.setStationID(stationID);
        ObservableList<Bike> items = FXCollections.observableArrayList(tmp1, tmp2, tmp3, tmp4);
        list.setItems(items);

//        ArrayList<Bike> bikes = StationController.requestStationDetail(stationID);
//        ObservableList<Bike> items = FXCollections.observableArrayList(bikes);
//        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
