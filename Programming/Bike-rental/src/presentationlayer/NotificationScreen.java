package presentationlayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class NotificationScreen {
    @FXML
    Text result;

    public void initData(String result) {
        this.result.setText(result);
    }
    public void goBack(ActionEvent actionEvent) {
        App.getInstance().display_HomeScreen();
    }
}
