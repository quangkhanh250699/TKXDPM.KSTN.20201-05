package presentationlayer;

import applicationlayer.RentBikeController;
import checkout.CreditCard;
import datalayer.model.Bike;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class RentBikeScreen {
    @FXML
    ListView<String> list;
    @FXML
    TextField cardCode;
    @FXML
    TextField Owner;
    @FXML
    TextField cvvCode;
    @FXML
    TextField dateExpired;

    private Bike bike;

    public Bike getBike() {
        return bike;
    }

    private void setBike(Bike bike) {
        this.bike = bike;
    }

    public void initData(Bike bike) {
        /**
         * Initialize the data of screen, detail information of bike user want to rent
         *
         * @param: Bike bike: bike user want to rent
         */
        // Set bike for rentBikeScreen
        this.setBike(bike);
        // rent data
        rentBikeData(bike, list);
    }

    static void rentBikeData(Bike bike, ListView<String> list) {
        /**
         * rent detail information of bike to list view string
         *
         * @param: Bike bike: bike to view detail information
         * @param: ListView<String> list: id of ListView in screen
         */
        String bikeid = "Bike id: " + bike.getBikeId();
        String bikename = "Bike name:  " + bike.getBikeName();
        String pin = "Pin: " + bike.getPin();
        String status =  bike.isStatus() ? "Trạng thái: Đang cho mượn" : "Trạng thái: Sẵn sàng";
        String bikecategory = "Caterory: " + bike.getCategory().getName();
        String description = "Description: " + bike.getCategory().getDescription();
        String costPerHour = "Cost per hour: " + bike.getCategory().getCost_per_hour();
        ObservableList<String> items = FXCollections.observableArrayList(bikeid, bikename, pin, status, bikecategory
                , description, costPerHour);

        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        /**
         * handle event when user click on back button, go back to home screen
         */
        App.getInstance().display_HomeScreen();
    }


    public void goNotificationScreen(ActionEvent actionEvent) throws IOException {
        /**
         * Handle event when user click on confirm rent bike event, go to the notification screen
         */
        // Get the data from user
        CreditCard creditCard = new CreditCard(cardCode.getText(), Owner.getText(),
        cvvCode.getText(), dateExpired.getText());

        // Get result of rent bike from api and go to notification screen
        RentBikeController rentBikeController = new RentBikeController();
        String result = rentBikeController.requestRentBike(App.userID, this.getBike(), creditCard);
        App.getInstance().display_NotificationScreen(result);

    }

    public void ResetDefaultValue(ActionEvent actionEvent) {
        /**
         * Handle event when user click on valid information button, fill in the default value of card
         */
        // Get the data from user(fix)
        cardCode.setText("118131_group5_2020");
        Owner.setText("Group 5");
        cvvCode.setText("296");
        dateExpired.setText("1125");
    }
}
