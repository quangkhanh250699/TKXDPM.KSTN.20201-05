package presentationlayer;

import datalayer.model.Bike;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class StationDetail implements Initializable {
    @FXML
    ListView<Bike> list;
    public void goBikeInformationScreen(ActionEvent actionEvent) {
    }

    public void goViewRentedBikeScreen(ActionEvent actionEvent) {
    }

    public void goReturnBikeScreen(ActionEvent actionEvent) {
    }

    public void goRentBikeScreen(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ArrayList<Station> stations = StationController.requestStationBoundary();
//        ObservableList<Bike> items = FXCollections.observableArrayList(stations);
//        list.setItems(items);
//        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
