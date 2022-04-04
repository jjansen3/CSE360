/*
Landing page controller
 */
package Main;

import GUI.Start;
import GUI.menuGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class AboutUs {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void homeButton(MouseEvent mouseEvent) throws IOException {
        if (Login.custLoggedIn == true){
            root = FXMLLoader.load(getClass().getResource("../Scenes/homePage.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("../Scenes/landingPage.fxml"));
        }

        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void aboutUsButton(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/aboutUs.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void menuButton(MouseEvent mouseEvent) throws IOException {
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        menuGUI menuScene = new menuGUI(stage);
        stage.setScene(menuScene.getScene());
        stage.show();
    }

    public void cartButton(MouseEvent mouseEvent) throws IOException {
        if (Login.custLoggedIn == true){
            //root = FXMLLoader.load(getClass().getResource("../Scenes/cart.fxml"));
            root = FXMLLoader.load(getClass().getResource("../Scenes/aboutUs.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("../Scenes/login.fxml"));
        }

        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void accountButton(MouseEvent mouseEvent) throws IOException {
        if (Login.custLoggedIn == true){
            root = FXMLLoader.load(getClass().getResource("../Scenes/profile.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("../Scenes/login.fxml"));
        }

        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
