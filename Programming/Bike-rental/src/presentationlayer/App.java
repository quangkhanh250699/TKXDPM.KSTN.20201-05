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
        /**
         * Main to start the bike rental management app
         */
        System.out.println(System.getProperty("user.dir"));
        launch(args);
    }

    public  void display_HomeScreen() throws IOException {
        /**
         *  Display Homescreen
         */
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("Homescreen.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        guiStage.setTitle("Home");
        guiStage.setScene(scene);
        guiStage.show();
    }


    public static void display_StationDetailScreen(int id) throws IOException {
        /**
         * Display station detail screen with a specific id
         *
         * @param: int id: id of the station
         */
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("StationDetailScreen.fxml"));
        root = loader.load();
        StationDetailScreen controller = loader.getController();
        controller.initData(id);
        Scene scene = new Scene(root);
        guiStage.setTitle("Station detail");
        guiStage.setScene(scene);
        guiStage.show();
    }

    public void display_ViewBikeScreen(int stationId, Bike bike) throws IOException {
        /**
         * Display the information detail of bike screen
         *
         * @param: Bike bike: the bike to display the information
         * @param: int stationid: id of the station contains that bike
         */
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("ViewBikeScreen.fxml"));
        root = loader.load();
        ViewBikeScreen controller = loader.getController();
        controller.initData(stationId, bike);
        Scene scene = new Scene(root);
        guiStage.setTitle("View bike detail");
        guiStage.setScene(scene);
        guiStage.show();
    }


    public void display_RentBikeScreen(Bike bike) throws IOException {
        /**
         * Display information of the bike user want to rent and fill in place for card information
         *
         * @param: Bike bike: the bike user rent
         */
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("RentBikeScreen.fxml"));
        root = loader.load();
        RentBikeScreen controller = loader.getController();
        controller.initData(bike);
        Scene scene = new Scene(root);
        guiStage.setTitle("Rent bike");
        guiStage.setScene(scene);
        guiStage.show();
    }


    public void display_NotificationScreen(String result) throws IOException {
        /**
         * Display notification screen, the result of rent or return bike
         *
         * @param: String result: result of the rent or return bike usecase
         */
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("NotificationScreen.fxml"));
        root = loader.load();
        NotificationScreen controller = loader.getController();
        controller.initData(result);
        Scene scene = new Scene(root);
        guiStage.setTitle("Notification");
        guiStage.setScene(scene);
        guiStage.show();
    }


    public void display_ReturnBikeScreen (RentedBike rentedBike) throws IOException {
        /**
         * Display return bike screen, where user fill in card information to return bike
         *
         * @param: Rented bike: rented bike: the rented bike of the previos sreen, this param is used for go back button
         */
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("ReturnBikeScreen.fxml"));
        root = loader.load();
        ReturnBikeScreen controller = loader.getController();
        controller.initData(rentedBike);
        Scene scene = new Scene(root);
        guiStage.setTitle("Return bike");
        guiStage.setScene(scene);
        guiStage.show();
    }



    public void display_RentedBikeScreen(RentedBike rentedBike) throws IOException {
        /**
         * Display detail information of rented bike, include information of bike, start time, end time, cost
         *
         * @param: RentedBike rentedBike: the rented bike to display information
         */
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("RentedBikeScreen.fxml"));
        root = loader.load();
        RentedBikeScreen controller = loader.getController();
        controller.initData(rentedBike);
        Scene scene = new Scene(root);
        guiStage.setTitle("Rented bike");
        guiStage.setScene(scene);
        guiStage.show();
    }

    public void display_BikeRentedListScreen(int userID) throws IOException {
        /**
         * Display rented list bike screen of the user
         *
         * @param: int userID: id of user
         */
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("BikeRentedListScreen.fxml"));
        root = loader.load();
        BikeRentedListScreen controller = loader.getController();
        controller.initData(userID);
        Scene scene = new Scene(root);
        guiStage.setTitle("Bike rented list");
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
