package presentationlayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class NotificationScreen {
    @FXML
    Text result;

    public void initData(String result) {
        /**
         * Initialize data for the notification screen, the result of rent or return bike usecase
         *
         * @param: String result: result of rent or return bike usecase
         */
        this.result.setText(result);
    }
    public void goBack(ActionEvent actionEvent) {
        /**
         * Handle event when user click on go home button, go to home screen
         */
        App.getInstance().display_HomeScreen();
    }
}
