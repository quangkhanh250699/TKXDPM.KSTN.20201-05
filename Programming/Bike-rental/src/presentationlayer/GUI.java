package presentationlayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;
public class GUI extends Application {


    private static Parent root;
    private static String[] resourceStrings;
    private static GUI instance;
    private static Stage guiStage;


    //resources constant indices

    public static final int HOME = 0;
    public static final int STATION_DETAIL = 1;
    public static final int BIKE_DETAIL= 2;


    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        loadResourcesFrom("src/presentationlayer/");
        launch(args);
    }

    private static void loadResourcesFrom(String pathname) {
        File currentDirectory = new File(pathname);
        File[] resources = currentDirectory.listFiles((name) -> {
//            System.out.println(name);
            return name.getName().contains(".fxml"); // get all fxml file in boundary folder
        });
        resourceStrings = new String[resources.length];
        for (int i = 0; i < resourceStrings.length; i++) {

            resourceStrings[i] = resources[i].getName();
            System.out.println(resourceStrings[i]);
        } //
    }

    public void start(Stage stage) {
        instance = this;
        guiStage = stage;
        display(HOME);
//        display(STATION_DETAIL);

    }

    public static void display(int option) {
        if (isInvalid(option))
            return;
        try {
            System.out.println(instance.getClass().getResource(resourceStrings[option]));
            root = FXMLLoader.load(instance.getClass().getResource(resourceStrings[option]));
            Scene scene = new Scene(root);
            guiStage.setScene(scene);
            guiStage.show();
        } catch (Exception e) {
            System.out.println("The error message is:");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    public static void display_stationDetail(String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(instance.getClass().getResource("StationDetail.fxml"));
        root = loader.load();
        StationDetailBoundary controller = loader.getController();
        controller.initData(id);
        Scene scene = new Scene(root);
        guiStage.setScene(scene);
        guiStage.show();
    }
    private static boolean isInvalid(int option) {
        return option < 0 || option > 7;
    }

    /**
     * @return the GUI Instance
     */
    public static GUI getInstance() {
        return instance;
    }

    /**
     * @return the root
     */
    public static Parent getParent() {
        return root;
    }
}
