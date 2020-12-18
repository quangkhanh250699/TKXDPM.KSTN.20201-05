package presentationlayer;

import applicationlayer.HomeController;
import datalayer.model.BriefStation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeScreen {
    @FXML
    ListView<BriefStation> list;

    @FXML
    TextField textField;

    @FXML
    public void initialize() {
        HomeController homeController = new HomeController();
        ArrayList<BriefStation> stations = (ArrayList<BriefStation>) homeController.getBriefStations();
        ObservableList<BriefStation> items =  FXCollections.observableArrayList(stations);
        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }


    public void goStationDetail(MouseEvent e) throws IOException {
        BriefStation briefStation = list.getSelectionModel().getSelectedItem();
        int stationId = briefStation.getStationId();
        App.getInstance().display_StationDetailScreen(stationId);
    }

    @FXML
    public void goRentBikeScreen(ActionEvent e) {
        String tmp = textField.getText();
        System.out.println("Hello " + tmp);
    }


    public void goRentedBikeScreen(ActionEvent actionEvent) {
        //
    }
}
