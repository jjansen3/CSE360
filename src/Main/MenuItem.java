package Main;

import javafx.scene.image.Image;

public class MenuItem {

    public String name;
    public String ingredients;
    public String size;
    public double price;
    public Image image;

    MenuItem(String name, String ingredients, String size, double price, Image image) {
        this.name = name;
        this.ingredients = ingredients;
        this.size = size;
        this.price = price;
        this.image = image;
    }

}