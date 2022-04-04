package GUI;

import Main.Main;
import Main.MenuItem;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


import java.io.IOException;

// main menu GUI
public class menuGUI {

    Scene menuScene;

    public menuGUI(Stage primaryStage) {

        // Setting up the main grid for the menu
        GridPane menuGrid = new GridPane();
        menuGrid.setVgap(20);
        menuGrid.setHgap(20);
        menuGrid.setAlignment(Pos.CENTER);

        // Setting buttons for top banner / search bar navigation
        Button homeButton = new Button();
        Button aboutButton = new Button();
        Button cartButton = new Button();
        Button loginButton = new Button();
        ImageView homePic = new ImageView("Assets/Home_icon.png");
        ImageView aboutPic = new ImageView("Assets/Contact_icon.png");
        ImageView cartPic = new ImageView("Assets/Cart_icon.png");
        ImageView loginPic = new ImageView("Assets/Account_icon.png");
        // picture size
        homePic.setFitHeight(100);
        homePic.setFitWidth(120);
        aboutPic.setFitHeight(100);
        aboutPic.setFitWidth(120);
        cartPic.setFitHeight(100);
        cartPic.setFitWidth(120);
        loginPic.setFitHeight(100);
        loginPic.setFitWidth(120);
        // set button graphics
        homeButton.setGraphic(homePic);
        aboutButton.setGraphic(aboutPic);
        cartButton.setGraphic(cartPic);
        loginButton.setGraphic(loginPic);


        // title - custom font not working
        Text title = new Text();
        title.setText("Oregano's Trattoria");
        //Font customFont = Font.loadFont("../Assets/BonheurRoyale-Regular", 100);
        //title.setFont(customFont);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 35));

        // Button text

        Text homeText = new Text();
        homeText.setText("Home");
        homeText.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Text aboutText = new Text();
        homeText.setText("About Us");
        /*
        Text cartText = new Text();
        homeText.setText("Cart");
        Text loginText = new Text();
        homeText.setText("Sign In");
         */


        // adding menu items to GUI
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
            // ingredients page when clicked
            rect.setOnMouseClicked(mouseEvent -> {
                ingredientsGUI ingredientsPage = new ingredientsGUI(primaryStage);
                primaryStage.setScene(ingredientsPage.getScene());
            });
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
            menuGrid.add(itemGUI, i, j);
            i++;

            // new row
            if (i > 2) {
                i = 0;
                j++;
            }
        }

        //Switches to the home page when the homeButton pressed
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
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


        //Switches the scene to about page when the aboutButton pressed
        aboutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //switch to about page
                try {
                    goToAbout(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Switches to cart page when the cartButton pressed
        cartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //switch to about page
                try {
                    goToCart(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Switches to sign in page when the loginButton pressed
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //switch to main page
                try {
                    goToLogin(event);
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        //Adding GridPane / buttons to the main stack pane
        StackPane sp = new StackPane();
        sp.setAlignment(menuGrid, Pos.BOTTOM_CENTER);
        sp.setMargin(menuGrid, new Insets(150, 20, 20, 20));
        sp.setAlignment(homeButton, Pos.TOP_LEFT);
        sp.setMargin(homeButton, new Insets(20, 0, 0, 0));
        sp.setAlignment(aboutButton, Pos.TOP_LEFT);
        sp.setMargin(aboutButton, new Insets(20, 0, 0, 275));
        sp.setAlignment(cartButton, Pos.TOP_RIGHT);
        sp.setMargin(cartButton, new Insets(20, 275, 0, 0));
        sp.setAlignment(loginButton, Pos.TOP_RIGHT);
        sp.setMargin(loginButton, new Insets(20, 0, 0, 0));
        sp.setAlignment(title, Pos.TOP_CENTER);
        sp.setMargin(title, new Insets(50,0,0,0));
        //sp.setMargin(homeText, new Insets(100,1150,675,0));
        //sp.setMargin(aboutText, new Insets(100,850,675,0));

        /*
        sp.setAlignment(aboutText, Pos.TOP_LEFT);
        sp.setMargin(aboutText, new Insets(150,50,0,0));
        sp.setAlignment(cartText, Pos.TOP_LEFT);
        sp.setMargin(cartText, new Insets(150,80,0,0));
        sp.setAlignment(loginText, Pos.TOP_LEFT);
        sp.setMargin(loginText, new Insets(150,100,0,0));
         */
        sp.getChildren().addAll(menuGrid, homeButton, aboutButton, cartButton, loginButton, title);
        menuScene = new Scene(sp);

    }

    //Returns this scene
    public Scene getScene() {
        return menuScene;
    }


    public void goToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/homePage.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToAbout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/aboutUs.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/profile.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public void goToCart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/cart.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
