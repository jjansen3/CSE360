package Main;

import java.util.ArrayList;

public class Customer {

    String fName;
    String lName;
    String email;
    String pass;
    String refCode;
    String phoneNum;
    String address;
    ArrayList<Order> orders;
    Order cart;
    ArrayList<Coupon> coupons;
    ArrayList<Card> cards;


    Customer(String fName, String lName, String email, String pass, String refCode, String phoneNum, String address, ArrayList<Order> orders, Order cart, ArrayList<Coupon> coupons, ArrayList<Card> cards) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.pass = pass;
        this.refCode = refCode;
        this.phoneNum = phoneNum;
        this.address = address;
        this.orders = new ArrayList<>(orders);
        this.cart = cart;
        this.coupons = coupons;
        this.cards = new ArrayList<>(cards);
    }

    void addCoupon(String desc, String code, String valid) {
        Coupon coupon = new Coupon(desc, code, valid);
        coupons.add(coupon);
    }

    void remCoupon(Coupon coupon) {
        coupons.remove(coupon);
    }

    void addOrder(int orderNum, ArrayList<MenuItem> items, int total, String date) {
        Order order = new Order(orderNum, items, total, date);
        orders.add(order);
    }

    void addCart(int orderNum, ArrayList<MenuItem> items, int total, String date) {
        Order order = new Order(orderNum, items, total, date);
        cart = order;
    }

    void addCard(int num, String exp, int sec, String country, int zip) {
        Card card = new Card(num, exp, sec, country, zip);
        cards.add(card);
    }

}
