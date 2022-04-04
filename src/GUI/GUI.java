package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

//This GUI class is the main class that runs the entire program.
//To test pages, first instantiate the GUI class and set the primary stage scene to the new GUI's scene
public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        addFoodGUI addFood = new addFoodGUI(primaryStage);
        devMenuGUI devMenu = new devMenuGUI(primaryStage);

        primaryStage.setTitle("Oregano's Trattoria");
        primaryStage.setScene(devMenu.getScene());
        primaryStage.show();
    }
}
