package presentationlayer;

import applicationlayer.UserController;
import datalayer.model.RentedBike;
import datalayer.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class BikeRentedListScreen {
    @FXML
    ListView list;
    public void initData(int userId) {
        //Rent Listbikerented took from user
        UserController userController = new UserController();
        User user = userController.getUser(userId);
        ArrayList<RentedBike> rentedBikes = (ArrayList<RentedBike>) user.getRentBikes();
        ObservableList<RentedBike> items = FXCollections.observableArrayList(rentedBikes);
        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    public void goBack(ActionEvent actionEvent) {
        App.getInstance().display_HomeScreen();
    }

    public void goRentedBikeScreen(MouseEvent mouseEvent) throws IOException {
        RentedBike rentedBike = (RentedBike) list.getSelectionModel().getSelectedItem();
        App.getInstance().display_RentedBikeScreen(rentedBike);
    }
}
