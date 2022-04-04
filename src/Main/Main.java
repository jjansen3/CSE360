package Main;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    //Test item
    static MenuItem item = new MenuItem("Lasagna", "Freshly baked lasagna with minced beef and Ricotta cheese. Finished with fresh basil.", "", 12, new Image("Assets/las.jpg"));

    public static ArrayList<Customer> customers = new ArrayList<>();

    //Test Main.Menu
    public static Menu menu = new Menu(new ArrayList<>(Arrays.asList(item, item, item, item, item, item, item, item, item, item)));

    static Customer currCust = new Customer("og.trattoria@res.org", "John", "Smith", "oregano123", "refcode", "1234567890", "123 Sesame St", new ArrayList<Order>(), new Order(5, new ArrayList<>(Arrays.asList(item, item, item, item, item, item, item, item, item, item)), 0.0, "date") , new ArrayList<Coupon>(), new ArrayList<>());

}
