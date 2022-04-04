package Main;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    //Test item
    static MenuItem item = new MenuItem("Lasagna", "Freshly baked lasagna with minced beef and Ricotta cheese. Finished with fresh basil.", "", 12, new Image("Assets/las.jpg"));
    static MenuItem item1 = new MenuItem("Risotto", "Piping hot risotto cooking with Parmesan cheese, white wine, butter, mushrooms, saffron, and onions.", "", 12, new Image("Assets/ris.jpg"));
    static MenuItem item2 = new MenuItem("Pizza", "Freshly baked pizza with home-made tomato sauce, basil, and mozzarella.", "", 12, new Image("Assets/piz.jpg"));
    static MenuItem item3 = new MenuItem("Spaghetti Bolognese", "Freshly made spaghetti with classic Bolognese sauce and topped with parsley.", "", 12, new Image("Assets/spa.jpg"));
    static MenuItem item4 = new MenuItem("Tiramisu", "Coffee flavored dessert with ladyfinger cookies, mascarpone cheese, topped with cocoa powder.", "", 12, new Image("Assets/tir.jpg"));
    static MenuItem item5 = new MenuItem("Chicken Alfredo", "Creamy Alfredo sauce and fresh sauted, slicred chicken breast served over a bed of tender fettuccine pasta.", "", 12, new Image("Assets/chicken.jpg"));
    static MenuItem item6 = new MenuItem("Ravioli", "Home-made ravioli stuffed with Rocotta cheese in pesto sauce.", "", 12, new Image("Assets/rav.jpg"));
    static MenuItem item7 = new MenuItem("Panna Cotta", "A creamy dessert with strawberry sauce, topped with fresh strawberries.", "", 12, new Image("Assets/panna.jpg"));
    static MenuItem item8 = new MenuItem("Chicken Parmesan", "Baked chicken with parmesan breading served on penne with tomato sauce.", "", 12, new Image("Assets/parme.jpg"));
    static MenuItem item9 = new MenuItem("Tortellini", "Tortellini stuffed with butternut squash and Rocotta cheese, topped with Burrata cheese and arugula.", "", 12, new Image("Assets/tort.jpg"));
    
    public static ArrayList<Customer> customers = new ArrayList<>();
    
    

    //Test Main.Menu
    public static Menu menu = new Menu(new ArrayList<>(Arrays.asList(item, item1, item2, item3, item4, item5, item6, item7, item8, item9)));

    public static Customer currCust = new Customer("og.trattoria@res.org", "John", "Smith", "oregano123", "refcode", "1234567890", "123 Sesame St", new ArrayList<Order>(), new Order(5, new ArrayList<>(Arrays.asList(item, item, item, item, item, item, item, item, item, item)), 0.0, "date") , new ArrayList<Coupon>(), new ArrayList<>());

}