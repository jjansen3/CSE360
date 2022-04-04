package GUI;

import Main.Main.*;
import Main.*;
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
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


// ingredients for individual item
public class ingredientsGUI {
    Scene ingredientsScene;

    public ingredientsGUI(Stage primaryStage) {

        // Setting up the main grid for the menu
        GridPane menuGrid = new GridPane();
        menuGrid.setVgap(20);
        menuGrid.setHgap(20);
        menuGrid.setAlignment(Pos.CENTER);


        // title - custom font not working
        Text title = new Text();
        title.setText("Oregano's Trattoria");
        title.setX(100);
        title.setY(100);
        //Font customFont = Font.loadFont("../Assets/BonheurRoyale-Regular", 100);
        //title.setFont(customFont);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 35));

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

        //Blurs the background to focus on adding the item
        javafx.scene.effect.BoxBlur bb = new BoxBlur();
        bb.setWidth(10);
        bb.setHeight(10);
        bb.setIterations(3);
        menuGrid.setEffect(bb);

        // Ingredients panel
        Rectangle rect = new Rectangle();
        rect.setWidth(650);
        rect.setHeight(300);
        rect.setStroke(Color.GRAY);
        rect.setStrokeWidth(3.0);
        rect.setFill(Color.WHITE);
        StackPane ingredientsGUI = new StackPane();
        Text name = new Text(Main.menu.items.get(0).name.toString()); // have to refer to items in arrList (Main.menu.items)
        name.setFont(Font.font("Verdana", 18));
        Text ingredientsTitle = new Text("Ingredients");
        ingredientsTitle.setFont(Font.font("Verdana", 18));
        Text ingredientsText = new Text(Main.menu.items.get(0).ingredients.toString()); // MenuItem ingredients
        ingredientsText.setFont(Font.font("Verdana", 12));
        Text size = new Text(Main.menu.items.get(0).size.toString());
        size.setFont(Font.font("Verdana", 18));
        Text itemSize = new Text("Item size"); // MenuItem size
        itemSize.setFont(Font.font("Verdana", 18));
        ImageView image = new ImageView(Main.menu.items.get(0).image); // image
        image.setFitHeight(200);
        image.setFitWidth(200);
        Button menuImage = new Button();
        menuImage.setPrefSize(200,200);
        menuImage.setGraphic(image);
        Button addCheckoutButton = new Button();
        addCheckoutButton.setText("Add to checkout");
        Button backButton = new Button();
        backButton.setText("Back");
        ingredientsGUI.setMargin(name, new Insets(0, 100, 185, 125));
        ingredientsGUI.setMargin(ingredientsTitle, new Insets(0, 0, 35, 50));
        ingredientsGUI.setMargin(ingredientsText, new Insets(50, 0, 0, 250));
        ingredientsGUI.setMargin(addCheckoutButton, new Insets(185, 0, 0, 350));
        ingredientsGUI.setMargin(size,new Insets(200, 5, 385, 305)); // above checkout button
        ingredientsGUI.setMargin(itemSize,new Insets(0, 5, 185, 100)); // above checkout button
        ingredientsGUI.setMargin(menuImage, new Insets(0, 370, 0, 0));
        ingredientsGUI.setMargin(backButton, new Insets(180, 0, 0, 290));
        ingredientsGUI.setAlignment(backButton, Pos.TOP_LEFT);
        ingredientsText.setWrappingWidth(300);
        ingredientsGUI.getChildren().addAll(rect, name, ingredientsText, ingredientsTitle, addCheckoutButton, size, menuImage, backButton);


        // add to stack pane
        StackPane sp = new StackPane();
        sp.setMargin(ingredientsGUI, new Insets(20, 20, 20, 20));
        ObservableList list = sp.getChildren();
        list.addAll(menuGrid, ingredientsGUI);
        ingredientsScene = new Scene(sp);


        //Switches to the menu page when the backButton pressed
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuGUI menuPage = new menuGUI(primaryStage);
                primaryStage.setScene(menuPage.getScene());
            }
        });

        //Switches to the checkout page when the backButton pressed
        addCheckoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //switch to cart page
                //Main.currCust.cart.addItem(Main.menu.items.get(0));
                try {
                    goToCart(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //Returns this scene
    public Scene getScene() {
        return ingredientsScene;
    }

    public void goToCart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/cart.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}