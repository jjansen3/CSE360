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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class Login {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private boolean match = false;
    public static boolean custLoggedIn;
    public static boolean devLogin = false;

    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    // Retrieve Info
    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return password.getText();
    }


    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();

        if (devLogin == true) {
            wrongLogin.setText("Dev Login");
            custLoggedIn = true;
            //Profile.displayInfo();
            promptDevMode(event);
        }

        else if (match == true) {
            custLoggedIn = true;
            //Profile.displayInfo();
            goToHome(event);
        }
    }

    public void guestLogin(ActionEvent event) throws IOException {
        Login.custLoggedIn = true;
        Main.currCust = new Customer("guest@og.res", "Guest", "Guest", "", "Guest0", "", "", new ArrayList<Order>(), null, new ArrayList<Coupon>(), new ArrayList<>());
        goToHome(event);
    }

    // Connect to database
    private void checkLogin() throws IOException {
        // Dev/owner logging in
        //if (username.getText().equals("og.trattoria@res.org") && password.getText().equals("oregano123")) {
        if (username.getText().equals("og.trattoria@res.org") && password.getText().equals("oregano123")) {
            devLogin = true;
        }
        else {
            for (int i = 0; i < Main.customers.size(); i++) {
                if (username.getText().equals(Main.customers.get(i).email) && password.getText().equals(Main.customers.get(i).pass)) {
                    match = true;
                }
            }

            // if username and password have empty field
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                wrongLogin.setText("Enter your data");
            }
            // else display login error
            else {
                wrongLogin.setText("Invalid username and password");
            }
        }
    }



    public void goToLandingPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/landingPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/homePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void promptDevMode(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/enterDevPrompt.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Connect with devMenuGUI
    public void goToDevMenu(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        devMenuGUI devMenu = new devMenuGUI(stage);
        stage.setScene(devMenu.getScene());
        stage.show();
    }

}
