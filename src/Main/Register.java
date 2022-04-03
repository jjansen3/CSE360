package Main;

import Main.Main;
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

public class Register {
    private Stage stage;
    private Scene scene;
    private Parent root;


    private boolean allowEmail = false;
    private boolean noNull = false;
    private boolean password_match = false;
    private boolean regDone = false;


    @FXML
    private Label accIndicator, regIndicator;
    @FXML
    private TextField firstName, lastName, referralCode, email;
    @FXML
    private PasswordField password, rePassword;



    public void userRegister(ActionEvent event) throws IOException {
        verifyRegistration();
        storeUserInfo();

        if (regDone == true) {
            //Profile.displayInfo();
            goToHome(event);
        }
    }

    public void verifyRegistration() throws IOException {
        // Check email in database
        // if email has existed, cannot create account (no duplicate email)
        if (!firstName.getText().matches("^[a-zA-Z]*$") || !lastName.getText().matches("^[a-zA-Z]*$")) {
            accIndicator.setText("Name can only contain alphabets");
        } else {
            accIndicator.setText("");
        }

        if (email.getText().equals("123@gmail.com")) {
            accIndicator.setText("Account has existed under this email");
        }
        else {
            accIndicator.setText("");
            allowEmail = true;
        }

        // Check for empty field, except Referral Code field
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty() || rePassword.getText().isEmpty()) {
            regIndicator.setText("Enter your data");
        }
        // Check is password match
        else if (!password.getText().equals(rePassword.getText())) {
            regIndicator.setText("Password do not match");
        }
        else {
            regIndicator.setText("");
            noNull = true;
            password_match = true;
        }

    }

    // Store in database
    public void storeUserInfo() throws NullPointerException {

        if (allowEmail == true && noNull == true && password_match == true) {
            Main.customers.add(new Customer(email.getText(), firstName.getText(), lastName.getText(), password.getText(), referralCode.getText(), "", "", new ArrayList<>(), null, new ArrayList<>(), new ArrayList<>()));
            regDone = true;
            Login.custLoggedIn = true;
        }

    }

    public void goToLandingPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/landingPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/login.fxml"));
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



}
