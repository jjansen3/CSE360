package GUI;

import Main.Main;
import Main.MenuItem;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

//This GUI class allows the dev to add a picture, name, ingredients, and price to a menu item.
public class addFoodGUI {

    Scene addFoodScene;
    Image selectedFood;

    public addFoodGUI(Stage primaryStage) {

        //Setting up the main grid for the menu
        GridPane menuGUI = new GridPane();
        menuGUI.setVgap(20);
        menuGUI.setHgap(20);
        menuGUI.setAlignment(Pos.CENTER);

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
            itemIngredients.setWrappingWidth(220);
            Text price = new Text("$" + m.price);
            price.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
            price.setFill(Color.GREEN);
            itemGUI.getChildren().addAll(rect, image, itemName, itemIngredients, price);
            itemGUI.setMargin(image, new Insets(0, 250, 0, 0));
            itemGUI.setMargin(itemName, new Insets(0, 0, 75, 5));
            itemGUI.setMargin(itemIngredients, new Insets(10, 0, 0, 132));
            itemGUI.setMargin(price, new Insets(0, 0, 80, 300));
            menuGUI.add(itemGUI, i, j);
            i++;
            if (i > 2) {
                i = 0;
                j++;
            }
        }
        //Blurs the background to focus on adding the item
        BoxBlur bb = new BoxBlur();
        bb.setWidth(10);
        bb.setHeight(10);
        bb.setIterations(3);
        menuGUI.setEffect(bb);

        //The main panel to add the food item
        Rectangle rect = new Rectangle();
        rect.setWidth(650);
        rect.setHeight(300);
        rect.setStroke(Color.GRAY);
        rect.setStrokeWidth(3.0);
        rect.setFill(Color.WHITE);
        StackPane addItemGUI = new StackPane();
        Text name = new Text("Food Name");
        name.setFont(Font.font("Verdana", 18));
        Text ingredients = new Text("Ingredients");
        ingredients.setFont(Font.font("Verdana", 18));
        Text price = new Text("Price");
        price.setFont(Font.font("Verdana", 18));
        TextField nameTBox = new TextField();
        nameTBox.setPromptText("Enter the name of the food you want to add");
        nameTBox.setMaxSize(250, 30);
        TextField ingTBox = new TextField();
        ingTBox.setPromptText("Enter the ingredients of the food");
        ingTBox.setMaxSize(250, 30);
        TextField priceTBox = new TextField();
        priceTBox.setPromptText("Set the price");
        priceTBox.setMaxSize(100, 30);
        ImageView image = new ImageView("Assets/addpic.png");
        image.setFitHeight(200);
        image.setFitWidth(200);
        Button button = new Button();
        button.setPrefSize(200,200);
        button.setGraphic(image);
        Button addFood = new Button();
        Button back = new Button();
        back.setText("Back");
        //addFood.setPrefSize(100, 50);
        addFood.setText("Add New Food Item");
        addItemGUI.setMargin(ingTBox, new Insets(30, 0, 0, 150));
        addItemGUI.setMargin(nameTBox, new Insets(0, 0, 120, 150));
        addItemGUI.setMargin(priceTBox, new Insets(180, 0, 0, 0));
        addItemGUI.setMargin(name, new Insets(0, 0, 185, 5));
        addItemGUI.setMargin(ingredients, new Insets(0, 0, 35, 5));
        addItemGUI.setMargin(price, new Insets(120, 53, 0, 0));
        addItemGUI.setMargin(button, new Insets(0, 370, 0, 0));
        addItemGUI.setMargin(addFood, new Insets(185, 0, 0, 350));
        addItemGUI.setMargin(back, new Insets(185, 0, 0, 550));
        addItemGUI.getChildren().addAll(rect, name, ingredients, nameTBox, ingTBox, button, addFood, price, priceTBox, back);

        //Getting the picture from your computer
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));

        //Adding restraints for each text field
        Text mustSelect = new Text("You must select a picture to add");
        mustSelect.setFill(Color.RED);
        Text mustName = new Text("You must input a name");
        mustName.setFill(Color.RED);
        Text mustIng = new Text("You must input the ingredients");
        mustIng.setFill(Color.RED);
        Text mustPrice = new Text("You must input a price");
        mustPrice.setFill(Color.RED);
        Text mustPriceNum = new Text("You must input a number");
        mustPriceNum.setFill(Color.RED);

        //This button is the add picture button, tt gets the picture from you select from your computer
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File selectedImage = fc.showOpenDialog(primaryStage);
                if (selectedImage != null) {
                    if (addItemGUI.getChildren().contains(mustSelect)) {
                        addItemGUI.getChildren().remove(mustSelect);
                    }
                    addItemGUI.getChildren().remove(button);
                    selectedFood = new Image(selectedImage.toURI().toString());
                    ImageView sf = new ImageView(selectedFood);
                    sf.setFitHeight(200);
                    sf.setFitWidth(200);
                    addItemGUI.setMargin(sf, new Insets(0, 370, 0, 0));
                    addItemGUI.getChildren().add(sf);
                }
            }
        });

        //Back button to go back to the main add screen
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                devMenuGUI menuGUI = new devMenuGUI(primaryStage);
                primaryStage.setScene(menuGUI.getScene());
            }
        });

        //Add food button checks for all the restraints and adds the food to the menu if they're all met
        addFood.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!addItemGUI.getChildren().stream().anyMatch(i -> i instanceof ImageView) && !addItemGUI.getChildren().contains(mustSelect)) {
                    addItemGUI.setMargin(mustSelect, new Insets(0, 370, 250, 0));
                    addItemGUI.getChildren().add(mustSelect);
                }
                if (nameTBox.getText().isEmpty() && !addItemGUI.getChildren().contains(mustName)) {
                    addItemGUI.setMargin(mustName, new Insets(0, 0, 180, 260));
                    addItemGUI.getChildren().add(mustName);
                }
                else if (addItemGUI.getChildren().contains(mustName) && !nameTBox.getText().isEmpty()) {
                    addItemGUI.getChildren().remove(mustName);
                }
                if (ingTBox.getText().isEmpty() && !addItemGUI.getChildren().contains(mustIng)) {
                    addItemGUI.setMargin(mustIng, new Insets(0, 0, 30, 300));
                    addItemGUI.getChildren().add(mustIng);
                }
                else if (addItemGUI.getChildren().contains(mustIng) && !ingTBox.getText().isEmpty()) {
                    addItemGUI.getChildren().remove(mustIng);
                }
                if (priceTBox.getText().isEmpty()) {
                    if (addItemGUI.getChildren().contains(mustPriceNum)) {
                        addItemGUI.getChildren().remove(mustPriceNum);
                    }
                    if (!addItemGUI.getChildren().contains(mustPrice)) {
                        addItemGUI.setMargin(mustPrice, new Insets(122, 170, 0, 300));
                        addItemGUI.getChildren().add(mustPrice);
                    }
                    else if (addItemGUI.getChildren().contains(mustPrice) && !priceTBox.getText().isEmpty()) {
                        addItemGUI.getChildren().remove(mustPrice);
                    }
                }
                else {
                    if (addItemGUI.getChildren().contains(mustPrice)) {
                        addItemGUI.getChildren().remove(mustPrice);
                    }
                    if (addItemGUI.getChildren().contains(mustPriceNum)) {
                        if (priceTBox.getText().matches("[0-9]*")) {
                            addItemGUI.getChildren().remove(mustPriceNum);
                        }
                    }
                    else {
                        if (!priceTBox.getText().matches("[0-9]*")) {
                            addItemGUI.setMargin(mustPriceNum, new Insets(122, 160, 0, 300));
                            addItemGUI.getChildren().add(mustPriceNum);
                        }
                    }
                }
                if (!nameTBox.getText().isEmpty() && !ingTBox.getText().isEmpty() && !priceTBox.getText().isEmpty() && priceTBox.getText().matches("[0-9]*") && addItemGUI.getChildren().stream().anyMatch(i -> i instanceof ImageView)) {
                    Main.menu.addItem(nameTBox.getText(), ingTBox.getText(), "", Double.parseDouble(priceTBox.getText()), selectedFood);
                    devMenuGUI menuGUI = new devMenuGUI(primaryStage);
                    primaryStage.setScene(menuGUI.getScene());
                }
            }
        });

        //Add everything to the main stack pane
        StackPane sp = new StackPane();
        sp.setMargin(menuGUI, new Insets(20, 20, 20, 20));
        ObservableList list = sp.getChildren();
        list.addAll(menuGUI, addItemGUI);
        addFoodScene = new Scene(sp);
    }

    //Returns this scene
    public Scene getScene() {
        return addFoodScene;
    }

}