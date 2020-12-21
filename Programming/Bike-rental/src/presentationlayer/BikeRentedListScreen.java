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
    ListView<RentedBike> list;
    public void initData(int userId) {
        /**
         * Initialize data for bike rented list screen, all bike rented by user have userId
         *
         * @param: int userId: id of the user
         */
        //Rent Listbikerented took from user
        UserController userController = new UserController();
        User user = userController.getUser(userId);
        ArrayList<RentedBike> rentedBikes = (ArrayList<RentedBike>) user.getRentBikes();
        ObservableList<RentedBike> items = FXCollections.observableArrayList(rentedBikes);
        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    public void goBack(ActionEvent actionEvent) {
        /**
         * Handle event when user click on back button, go back to home screen
         */
        App.getInstance().display_HomeScreen();
    }

    public void goRentedBikeScreen(MouseEvent mouseEvent) throws IOException {
        /**
         *  Handle event when user click on the a bike in list rented bike, go to rented bike
         *  screen (this screen have detail information of chosen rented bike)
         */
        RentedBike rentedBike =  list.getSelectionModel().getSelectedItem();
        App.getInstance().display_RentedBikeScreen(rentedBike);
    }
}
