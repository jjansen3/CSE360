package Main;

public class Order {

    int orderNum;
    Cart cart;
    String date;
    

    Order(int orderNum, Cart cart, String date) {
        this.orderNum = orderNum;
        this.cart = cart;
        this.date = date;
    }
}
