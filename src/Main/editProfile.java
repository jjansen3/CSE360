package Main;

import GUI.Start;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class editProfile {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView profilePic;
    @FXML
    private Label picIndicator;
    @FXML
    private TextField changefName, changelName, changeEmail, changePhone,changePass;
    @FXML
    private TextField changeCard, changeExp, changeCVV, changeAddr, changeCountry, changeZip;



    public void uploadProfilePic(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Upload your profile picture");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.svg", "*.tiff"));
        File file = fc.showOpenDialog(null);

        if (file != null) {
            profilePic.setImage(new Image(file.toURI().toString()));
        }
        else {
            picIndicator.setText("Invalid image");
        }

    }

    public void updateProfile(ActionEvent event) throws IOException {
        //


        // Update profile information
        //Main.customers.add(new Customer(changeEmail.getText(), changefName.getText(), changelName.getText(), changePass.getText(), "", changePhone.getText(), changeAddr.getText(), new ArrayList<>(), null, new ArrayList<>(), new ArrayList<>()));

        root = FXMLLoader.load(getClass().getResource("../Scenes/profile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void goToAccount(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/profile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
