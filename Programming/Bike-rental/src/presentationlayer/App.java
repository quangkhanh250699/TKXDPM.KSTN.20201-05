package presentationlayer;

import datalayer.model.Bike;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {


    private static Parent root;
    private static App instance;
    private static Stage guiStage;


    public void start(Stage stage) {
        instance = this;
        guiStage = stage;
        display_HomeScreen();
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        launch(args);
    }
    private void display(String Filepath) throws IOException {
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource(Filepath));
        root = loader.load();
        Scene scene = new Scene(root);
        guiStage.setScene(scene);
        guiStage.show();
    }

    public  void display_HomeScreen() {
        try {
            display("HomeScreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void display_StationDetailScreen(int id) throws IOException {
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("StationDetailScreen.fxml"));
        root = loader.load();
        StationDetailScreen controller = loader.getController();
        controller.initData(id);
        Scene scene = new Scene(root);
        guiStage.setScene(scene);
        guiStage.show();
    }

    public void display_ViewBikeScreen(int stationId, Bike bike) throws IOException {
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("ViewBikeScreen.fxml"));
        root = loader.load();
        ViewBikeScreen controller = loader.getController();
        controller.initData(stationId, bike);
        Scene scene = new Scene(root);
        guiStage.setScene(scene);
        guiStage.show();
    }


    public void display_RentBikeScreen() {

    }


    public void display_NotificationScreen() {

    }


    public void display_ReturnBikeScreen () {

    }


    public void display_RentedBikeScreen () {

    }


    public void display_BikeRentedList () {

    }
    public static App getInstance() {
        return instance;
    }

    public static Parent getParent() {
        return root;
    }
}
