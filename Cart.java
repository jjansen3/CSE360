package Main;

import java.util.ArrayList;

public class Cart {

	public ArrayList<MenuItem> cart;
	public double totalPrice;
	
	Cart() //constructor for empty cart
	{
		this.cart = null;
		this.totalPrice = 0.0;
	}
	
	void addItem(MenuItem addedItem) //add item to cart; also update price
	{
		this.cart.add(addedItem);
		this.totalPrice = this.totalPrice + addedItem.price;
	}
	
	void removeItem(MenuItem removedItem) //remove item from cart; update price
	{
		this.cart.remove(removedItem);
		this.totalPrice = this.totalPrice - removedItem.price;
	}
	

	
}
