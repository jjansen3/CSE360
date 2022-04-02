package Main;

import javafx.scene.image.Image;
import java.util.ArrayList;

public class Menu {

    public ArrayList<MenuItem> items;

    Menu(ArrayList<MenuItem> items) {
        this.items = new ArrayList<>(items);
    }

    public void addItem(String name, String ingredients, String size, double price, Image image) {
        MenuItem item = new MenuItem(name, ingredients, size, price, image);
        this.items.add(item);
    }

    public void remItem(MenuItem item) {
        this.items.remove(item);
    }

}