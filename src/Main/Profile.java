package Main;

import GUI.Start;
import GUI.devMenuGUI;
import GUI.menuGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private SplitMenuButton accountMenu;
    @FXML
    public Label displayName, displayEmail, displayAddr, displayPhone;
    @FXML
    public Label cDesc, cCode, cExp;
    @FXML
    public Label orderNum, orderDate, orderPrice;


    // Display user info
    public void initialize(URL url, ResourceBundle rb){
        // Display user's name and email
        displayName.setText(Main.currCust.fName + " " + Main.currCust.lName);
        displayEmail.setText(Main.currCust.email);

        // Display user's phone number
        if (Main.currCust.phoneNum != null) {
            displayPhone.setText(Main.currCust.phoneNum);
        }


        // Display user's Coupon
        if (Main.currCust.coupons.size() > 0) {
            System.out.println(Main.currCust.coupons.get(0).code);
        }

        for (int i = 0; i < Main.currCust.coupons.size(); i++) {
            cDesc.setText(Main.currCust.coupons.get(i).desc);
            cCode.setText(Main.currCust.coupons.get(i).code);
            cExp.setText(Main.currCust.coupons.get(i).valid);
        }

        // Display user's order history
        for (int i = 0; i < Main.currCust.orders.size(); i++) {
            orderNum.setText(String.valueOf(Main.currCust.orders.get(i).orderNum));
            orderDate.setText(Main.currCust.orders.get(i).date);
            orderPrice.setText(String.valueOf(Main.currCust.orders.get(i).total));
        }


    }


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
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        menuGUI menuScene = new menuGUI(stage);
        stage.setScene(menuScene.getScene());
        stage.show();
    }

    public void goToAccount(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/profile.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


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
        root = FXMLLoader.load(getClass().getResource("../Scenes/exitPrompt.fxml"));
        stage = (Stage)accountMenu.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logoutQuit(ActionEvent event) throws IOException {
        Login.custLoggedIn = false;
        Login.devLogin = false;
        stage = (Stage)accountMenu.getScene().getWindow();
        stage.close();
    }

    public void logoutAccount(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/landingPage.fxml"));
        stage = (Stage)accountMenu.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        Login.custLoggedIn = false;
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
