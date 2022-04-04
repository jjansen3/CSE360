/*
Landing page controller
 */
package Main;

import GUI.menuGUI;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HomePage {

    private Stage stage;
    private Scene scene;
    private Parent root;

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

        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        menuGUI menuScene = new menuGUI(stage);
        stage.setScene(menuScene.getScene());
        stage.show();
    }

    public void goToCart(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/placeholder.fxml"));
        // root = FXMLLoader.load(getClass().getResource("../Scenes/cart.fxml"));
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
}
