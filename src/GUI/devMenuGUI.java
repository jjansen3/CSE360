package GUI;

import Main.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import Main.*;

import java.io.IOException;


//This GUI class allows the dev to add a new item to the menu
public class devMenuGUI {

    Scene devMenuScene;

    public devMenuGUI(Stage primaryStage) {

        //Setting up the main grid for the menu
        GridPane menuGUI = new GridPane();
        menuGUI.setVgap(20);
        menuGUI.setHgap(20);
        menuGUI.setAlignment(Pos.CENTER);

        //Setting up the buttons for the dev navigation
        ImageView addMenuPic = new ImageView("Assets/addmenu.png");
        addMenuPic.setFitHeight(100);
        addMenuPic.setFitWidth(122);
        ImageView addCouponPic = new ImageView("Assets/coupon.png");
        addCouponPic.setFitHeight(100);
        addCouponPic.setFitWidth(136);
        Button addToMenu = new Button();
        addToMenu.setGraphic(addMenuPic);
        Button addCoupon = new Button();
        addCoupon.setGraphic(addCouponPic);
        Button exitDev = new Button();
        exitDev.setText("Exit Dev Mode");
        exitDev.setPrefSize(120, 50);

        //Adding all the items in the menu to the GUI
        int i = 0;
        int j = 0;
        for(MenuItem m : Main.menu.items) {
            StackPane itemGUI = new StackPane();
            Rectangle rect = new Rectangle();
            rect.setWidth(400);
            rect.setHeight(150);
            rect.setStroke(Color.LIGHTGRAY);
            rect.setStrokeWidth(3.0);
            rect.setFill(Color.WHITE);
            ImageView image = new ImageView(m.image);
            image.setFitHeight(100);
            image.setFitWidth(100);
            image.setX(10);
            Text itemName = new Text(m.name);
            itemName.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            Text itemIngredients = new Text(m.ingredients);
            Text price = new Text("$" + String.format("%.2f", m.price));
            price.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
            price.setFill(Color.GREEN);
            itemIngredients.setWrappingWidth(220);
            itemGUI.getChildren().addAll(rect, image, itemName, itemIngredients, price);
            itemGUI.setMargin(image, new Insets(0, 250, 0, 0));
            itemGUI.setAlignment(itemName, Pos.CENTER_LEFT);
            itemGUI.setMargin(itemName, new Insets(0, 0, 75, 157));
            itemGUI.setAlignment(itemIngredients, Pos.TOP_CENTER);
            itemGUI.setMargin(itemIngredients, new Insets(60, 0, 0, 132));
            itemGUI.setAlignment(price, Pos.CENTER_RIGHT);
            itemGUI.setMargin(price, new Insets(0, 25, 75, 0));
            menuGUI.add(itemGUI, i, j);
            i++;
            if (i > 2) {
                i = 0;
                j++;
            }
        }

        //A plus button to add a new food
        Button addFood = new Button();
        addFood.setPrefSize(400, 150);
        ImageView image = new ImageView("Assets/plus.png");
        image.setFitWidth(150);
        image.setFitHeight(87);
        addFood.setGraphic(image);
        menuGUI.add(addFood, i, j);

        //Switches the scene to addFoodGUI when the dev presses the add food button
        addFood.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addFoodGUI newFood = new addFoodGUI(primaryStage);
                primaryStage.setScene(newFood.getScene());
            }
        });

        //Switches to the add coupon page when the dev presses the add coupon button
        addCoupon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    goToAddCoupon(event);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Switches to the main page when the dev presses the exit dev button
        exitDev.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //switch to main page
                try {
                    goToHome(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        //Adding everything to the main stack pane
        StackPane sp = new StackPane();
        sp.setAlignment(menuGUI, Pos.BOTTOM_CENTER);
        sp.setMargin(menuGUI, new Insets(150, 20, 20, 20));
        sp.setAlignment(addToMenu, Pos.TOP_CENTER);
        sp.setMargin(addToMenu, new Insets(20, 850, 20, 0));
        sp.setAlignment(addCoupon, Pos.TOP_CENTER);
        sp.setMargin(addCoupon, new Insets(20, 0, 20, 0));
        sp.setAlignment(exitDev, Pos.TOP_CENTER);
        sp.setMargin(exitDev, new Insets(45, 0, 0, 850));
        sp.getChildren().addAll(menuGUI, addToMenu, addCoupon, exitDev);
        devMenuScene = new Scene(sp);

    }

    //Returns this scene
    public Scene getScene() {
        return devMenuScene;
    }

    public void goToHome(ActionEvent event) throws IOException {
        Login.custLoggedIn = false;
        Login.devLogin = false;
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/landingPage.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToAddCoupon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/addCoupon.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}