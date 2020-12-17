package presentationlayer;

import datalayer.model.Bike;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

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
        /* ------- Code get data from controller ------
        Station station = StationController.getStation(stationID);
        List<Bike> bikes = station.getBikes();
        ObservableList<Bike> items = FXCollections.observableArrayList(bikes);
        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        */
        /* ------- Code fake data --------------------- */
//        Bike  tmp1 = new Bike(stationID, "xe dap tinh yeu", null, 0);
//        Bike  tmp2 = new Bike(5, "xe dap may man",null, 0);
//        Bike  tmp3 = new Bike(5, "xe dap tinh yeu", null, 0);
//        Bike  tmp4 = new Bike(5, "xe dap tinh yeu", null, 0);
//
//        ObservableList<Bike> items = FXCollections.observableArrayList(tmp1, tmp2, tmp3, tmp4);
//        list.setItems(items);
//        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void handleClickOnListBike(MouseEvent mouseEvent) throws IOException {
        /* -------- Code get data from controller --- */
        Bike bike = list.getSelectionModel().getSelectedItem();
        App.getInstance().display_ViewBikeScreen(stationID, bike);
        /* -------- Code fake data ------------------ */
    }
}
