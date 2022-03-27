package Main;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    //Test item
    static MenuItem item = new MenuItem("Lasagna", "Freshly baked lasagna with minced beef and Ricotta cheese. Finished with fresh basil.", "", 12, new Image("Resources/las.jpg"));

    ArrayList<Customer> customers = new ArrayList<>();

    //Test Main.Menu
    public static Menu menu = new Menu(new ArrayList<>(Arrays.asList(item, item, item, item, item, item, item, item, item, item)));

    Customer currCust;

}
