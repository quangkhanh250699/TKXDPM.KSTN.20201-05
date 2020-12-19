package presentationlayer;

import datalayer.model.Bike;
import datalayer.model.RentedBike;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static int userID = 1;
    private static Parent root;
    private static App instance;
    private static Stage guiStage;


    public void start(Stage stage) throws IOException {
        instance = this;
        guiStage = stage;
        display_HomeScreen();
//        display("ReturnBikeScreen.fxml");
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


    public void display_RentBikeScreen(Bike bike) throws IOException {
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("RentBikeScreen.fxml"));
        root = loader.load();
        RentBikeScreen controller = loader.getController();
        controller.initData(bike);
        Scene scene = new Scene(root);
        guiStage.setScene(scene);
        guiStage.show();
    }


    public void display_NotificationScreen(String result) throws IOException {
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("NotificationScreen.fxml"));
        root = loader.load();
        NotificationScreen controller = loader.getController();
        controller.initData(result);
        Scene scene = new Scene(root);
        guiStage.setScene(scene);
        guiStage.show();
    }


    public void display_ReturnBikeScreen (RentedBike rentedBike) throws IOException {
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("ReturnBikeScreen.fxml"));
        root = loader.load();
        ReturnBikeScreen controller = loader.getController();
        controller.initData(rentedBike);
        Scene scene = new Scene(root);
        guiStage.setScene(scene);
        guiStage.show();
    }



    public void display_RentedBikeScreen(RentedBike rentedBike) throws IOException {
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("RentedBikeScreen.fxml"));
        root = loader.load();
        RentedBikeScreen controller = loader.getController();
        controller.initData(rentedBike);
        Scene scene = new Scene(root);
        guiStage.setScene(scene);
        guiStage.show();
    }

    public void display_BikeRentedListScreen(int userID) throws IOException {
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("BikeRentedListScreen.fxml"));
        root = loader.load();
        BikeRentedListScreen controller = loader.getController();
        controller.initData(userID);
        Scene scene = new Scene(root);
        guiStage.setScene(scene);
        guiStage.show();
    }

    public static App getInstance() {
        return instance;
    }

    public static Parent getParent() {
        return root;
    }
}
