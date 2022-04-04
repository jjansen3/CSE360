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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import GUI.menuGUI;

public class Cart implements Initializable{
	
    private Stage stage;
    private Scene scene;
    public Parent root;
    /*
    @FXML
    private Label nameIngredient, descIngredient, price; 
    private TextField address;
    */
    @FXML
    private AnchorPane anchor1;
    
    
    
    
    public void initialize(URL url, ResourceBundle rb){
    	//set text inside scrollpane to proper text
    	/*
        nameIngredient.setText(Main.currCust.cart.items.get(0).name);
        descIngredient.setText(Main.currCust.cart.items.get(0).ingredients);
        price.setText("$" + Double.toString(Main.currCust.cart.items.get(0).price));
    	//set text of customer info
        address.setText(Main.currCust.address);
    	*/
    	
    	Color white = new Color(1,1,1,1);
    	Color black = new Color(0,0,0,1);
    	
    	for(int i = 0; i < Main.currCust.cart.items.size(); i++)
    	{
    		//rectangle for background of menu items
    		Rectangle rectangle = new Rectangle();
    		rectangle.setWidth(480);
    		rectangle.setHeight(150);
    		rectangle.setLayoutX(20);
    		rectangle.setLayoutY(20+(170*i));
    		rectangle.setStroke(black);
    		rectangle.setFill(white);
    		rectangle.toFront();
    		anchor1.getChildren().add(rectangle);
    			
    		Label ingredient2 = new Label("2nd Name"); //Main.currCust.cart.items.get(i).name);
    		ingredient2.setTranslateX(165);
    		ingredient2.setTranslateY(50+(170*i));
    		ingredient2.toFront();
    		anchor1.getChildren().add(ingredient2);
    			
    		Label price = new Label("$" + "2nd Price"); //Double.toString(Main.currCust.cart.items.get(i).price));
    		price.setTranslateX(415);
    		price.setTranslateY(50+(170*i));
    		price.toFront();
    		anchor1.getChildren().add(price);
    			
    		Label description = new Label("Description goes here"); //Main.currCust.cart.items.get(i).description);
    		description.setTranslateX(165);
    		description.setTranslateY(80+(170*i));
    		description.toFront();
    		anchor1.getChildren().add(description);
    			
    		SplitMenuButton sizes = new SplitMenuButton(); //size of order dropdown
    		sizes.setText("Sizes");
    		MenuItem choice1 = new MenuItem("Small");
    		MenuItem choice2 = new MenuItem("Medium");
    		MenuItem choice3 = new MenuItem("Large");
    		sizes.getItems().addAll(choice1, choice2, choice3);
    		sizes.setTranslateX(415);
    		sizes.setTranslateY(80+(170*i));
    		sizes.toFront();
    		anchor1.getChildren().add(sizes);
    			
    		ImageView imageV = new ImageView("Assets/las.jpg");
    		imageV.setFitHeight(108);
    		imageV.setFitWidth(108);
    		imageV.setLayoutX(41);
    		imageV.setLayoutY(41+170*i);
    		imageV.setPickOnBounds(true);
    		anchor1.getChildren().add(imageV);
    			

    		}
    		
    //	}

    	
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
        root = FXMLLoader.load(getClass().getResource("../Scenes/profile.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    

}
