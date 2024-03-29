package presentationlayer;

import applicationlayer.BarcodeController;
import applicationlayer.HomeController;
import applicationlayer.RentBikeController;
import datalayer.model.Bike;
import datalayer.model.BriefStation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeScreen {
    @FXML
    ListView<BriefStation> list;

    @FXML
    TextField textField;

    @FXML
    Text invalidBarcode;

    public int getUserId() {
        return userId;
    }

    int userId = 1;


    @FXML
    public void initialize() {
        /**
         * Initialize data of home screen: list of station
         */
        HomeController homeController = new HomeController();
        ArrayList<BriefStation> stations = (ArrayList<BriefStation>) homeController.getBriefStations();
        ObservableList<BriefStation> items =  FXCollections.observableArrayList(stations);
        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }


    public void goStationDetail(MouseEvent e) throws IOException {
        /**
         * Handle event when user click on station, go to the station detail screen of choosen station
         */
        BriefStation briefStation = list.getSelectionModel().getSelectedItem();
        int stationId = briefStation.getStationId();
        App.getInstance().display_StationDetailScreen(stationId);
    }

    @FXML
    public void goRentBikeScreen(ActionEvent e) throws IOException {
        /**
         * Handle event when user click on rent bike button, process the bar code
         * and return the bike information user want to rent
         */
        String barCode = textField.getText();
        BarcodeController barcodeController = new BarcodeController();
        boolean check = barcodeController.validateBarcode(barCode);
        if(check == false) {
            invalidBarcode.setText("Invalid Barcode");
        }
        else {
            RentBikeController rentBikeController = new RentBikeController();
            Bike bike = rentBikeController.requestBike(barCode);
            if (bike == null) {
                invalidBarcode.setText("Invalid Barcode");
            }
            else {
                App.getInstance().display_RentBikeScreen(bike);
            }

        }

    }


    public void goBikeRentedListScreen(ActionEvent actionEvent) throws IOException {
        /**
         * Handle event when user click on view rented bike button, go to the bike rented list screen
         */
        App.getInstance().display_BikeRentedListScreen(App.userID);
    }
}
