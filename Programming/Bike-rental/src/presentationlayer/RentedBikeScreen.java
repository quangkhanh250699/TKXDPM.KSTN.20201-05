package presentationlayer;

import applicationlayer.RentBikeController;
import applicationlayer.ReturnBikeController;
import applicationlayer.StationController;
import applicationlayer.UserController;
import datalayer.model.Bike;
import datalayer.model.RentedBike;
import datalayer.model.Station;
import datalayer.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class RentedBikeScreen {
    public void setRentedBike(RentedBike rentedBike) {
        this.rentedBike = rentedBike;
    }

    public RentedBike getRentedBike() {
        return rentedBike;
    }

    private  RentedBike rentedBike;
    @FXML
    ListView list;
    public void initData(RentedBike rentedBike) {
        /**
         * Initialize data of the screen: detail information of rented bike, include start time, end time and cost
         *
         * @param: RentedBike rentedBike: rented bike to display information
         */
        // Set rented bike
        this.setRentedBike(rentedBike);

        // Bike information
        String bikeid = "Bike id: " + rentedBike.getBikeId();
        String bikename = "Bike name:  " + rentedBike.getBikeName();
        String pin = "Pin: " + rentedBike.getPin();
        String bikecategory = "Caterory: " + rentedBike.getCategory().getName();
        String description = "Description: " + rentedBike.getCategory().getDescription();
        String costPerHour = "Cost per hour: " + rentedBike.getCategory().getCost_per_hour();
        String startTime = "Start time: " + rentedBike.getStart_time();

        // get end time
        Date date = new Date();
        java.sql.Timestamp end = new Timestamp(date.getTime());
        String endTime = "End time: " + end;

        String debit = "Debit: " + rentedBike.getDebit();
        // Calculate rented cost
        ReturnBikeController returnBikeController = new ReturnBikeController();
        String Cost = "Rented cost up to now: " + returnBikeController.calculateCost(rentedBike, end);

        ObservableList<String> items = FXCollections.observableArrayList(bikeid, bikename, pin, bikecategory
                , description, costPerHour, startTime, endTime, debit, Cost);

        list.setItems(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    public void goBack(ActionEvent actionEvent) throws IOException {
        /**
         * Handle event when user click on back button, go to bike rented list screen
         */
        App.getInstance().display_BikeRentedListScreen(App.userID);
    }

    public void goReturnBikeScreen(ActionEvent e) throws IOException {
        /**
         * Handle event when user click on return bike button, go to return bike screen
         */
        App.getInstance().display_ReturnBikeScreen(this.getRentedBike());
    }
}
