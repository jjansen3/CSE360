package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import GUI.menuGUI;

public class Cart implements Initializable{
	
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label nameIngredient, descIngredient, price; 
    private TextField address;
    
    public void initialize(URL url, ResourceBundle rb){
    	//set text inside scrollpane to proper text
        /*
    	if(Main.currCust != null)
    	{
        	nameIngredient.setText(Main.currCust.cart.items.get(0).name);
        	descIngredient.setText(Main.currCust.cart.items.get(0).ingredients);
        	price.setText("$" + Double.toString(Main.currCust.cart.items.get(0).price));
    	}

    	//set text of customer info
    	if(Main.currCust != null)
    	{
        	address.setText(Main.currCust.address);
    	}
        */
    	
    }
    
    
    
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
        root = FXMLLoader.load(getClass().getResource("../Scenes/cart.fxml"));
        // root = FXMLLoader.load(getClass().getResource("../Scenes/cart.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToAccount(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Scenes/login.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

}
