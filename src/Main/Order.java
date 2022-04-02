package Main;

import java.util.ArrayList;

public class Order {

    int orderNum;
    ArrayList<MenuItem> items;
    double total;
    String date;

    Order(int orderNum, ArrayList<MenuItem> items, double total, String date) {
        this.orderNum = orderNum;
        this.items = new ArrayList<>(items);
        this.total = total;
        this.date = date;
    }

    void addItem(MenuItem item) {
        items.add(item);
    }

    void remItem(MenuItem item) {
        items.remove(item);
    }

}