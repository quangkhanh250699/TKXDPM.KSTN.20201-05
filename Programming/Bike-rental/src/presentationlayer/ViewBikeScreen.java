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
    ListView<Bike> list;

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
        int tmp = bike.getStationId();
        this.setStationId(tmp);
        /* ------- Code get data from controller ------
        Station station = StationController.getStation(stationID);
        List<Bike> bikes = station.getBikes();
        ObservableList<Bike> items = FXCollections.observableArrayList(bikes);

        */
        /* ------- Code fake data --------------------- */
//        Bike tmp1 = new Bike(stationID, "xe dap tinh yeu", null, 0);
//        Bike  tmp2 = new Bike(5, "xe dap may man",null, 0);
//        Bike  tmp3 = new Bike(5, "xe dap tinh yeu", null, 0);
//        Bike  tmp4 = new Bike(5, "xe dap tinh yeu", null, 0);
//
//        ObservableList<Bike> items = FXCollections.observableArrayList(tmp1, tmp2, tmp3, tmp4);

        /* --------------------------------------------------*/
//        list.setItems(items);
//        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
