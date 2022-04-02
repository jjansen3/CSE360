package Main;

import GUI.Start;
import GUI.devMenuGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.IOException;

public class Profile {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private SplitMenuButton accountMenu;


    // App Navigation
    public void goToHome(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/homePage.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToAboutUs(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/aboutUs.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToMenu(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/placeholder.fxml"));
        // root = FXMLLoader.load(getClass().getResource("../Scenes/menu.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToAccount(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/profile.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    // Edit Profile
    public void editProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/editProfile.fxml"));
        stage = (Stage)accountMenu.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Dev Switch
    public void devSwitch(ActionEvent event) throws IOException {
        if (Login.devLogin == true) {
            stage = (Stage)accountMenu.getScene().getWindow();
            devMenuGUI devMenu = new devMenuGUI(stage);
            stage.setScene(devMenu.getScene());
            stage.show();
        }
    }


    // Exit options
    public void exitPrompt(ActionEvent event) throws IOException {
        Login.custLoggedIn = false;
        root = FXMLLoader.load(getClass().getResource("../Scenes/exitPrompt.fxml"));
        stage = (Stage)accountMenu.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logoutQuit(ActionEvent event) throws IOException {
        Login.custLoggedIn = false;
        stage = (Stage)accountMenu.getScene().getWindow();
        stage.close();
    }

    public void logoutAccount(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/landingPage.fxml"));
        stage = (Stage)accountMenu.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logoutCancel(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/profile.fxml"));
        stage = (Stage)accountMenu.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
