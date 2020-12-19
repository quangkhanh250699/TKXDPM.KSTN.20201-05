package presentationlayer;

import applicationlayer.RentBikeController;
import applicationlayer.ReturnBikeController;
import checkout.CreditCard;
import datalayer.model.RentedBike;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class ReturnBikeScreen {
    @FXML
    TextField cardCode;
    @FXML
    TextField Owner;
    @FXML
    TextField cvvCode;
    @FXML
    TextField dateExpired;

    private RentedBike rentedBike;
    public RentedBike getRentedBike() {
        return rentedBike;
    }

    public void setRentedBike(RentedBike rentedBike) {
        this.rentedBike = rentedBike;
    }

    public void initData(RentedBike rentedBike) {
        this.setRentedBike(rentedBike);
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        App.getInstance().display_RentedBikeScreen(this.getRentedBike());
    }

    public void goNotificationScreen(ActionEvent actionEvent) throws IOException {
        // Get the data from user
        CreditCard creditCard = new CreditCard(cardCode.getText(), Owner.getText(),
                cvvCode.getText(), dateExpired.getText());
        Date date = new Date();
        java.sql.Timestamp end = new Timestamp(date.getTime());

        // Get result of rent bike from api and go to notification screen
        ReturnBikeController returnBikeController = new ReturnBikeController();
        String result = returnBikeController.requestReturnBike(App.userID, this.getRentedBike(), creditCard, end);
        App.getInstance().display_NotificationScreen(result);
    }

    public void ResetDefaultValue(ActionEvent actionEvent) {
        // Get the data from user(fix)
        cardCode.setText("118131_group5_2020");
        Owner.setText("Group 5");
        cvvCode.setText("296");
        dateExpired.setText("1125");
    }
}
