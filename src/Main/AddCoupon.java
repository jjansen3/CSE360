
package Main;

import GUI.devMenuGUI;
import Main.Main;
import Main.Customer;
import Main.MenuItem;
import GUI.Start;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AddCoupon implements Initializable{
	
	@FXML
	private TreeView<String> treeView;
	
	@FXML
	private Button applyButton;
	
	@FXML
	private Button BackButton;
	
	@FXML
	private AnchorPane Anchor;
	
	@FXML
	private ComboBox<String> aCoup;
	
	public static int total = 0;
	
	private String[] coup = {"50% off one item", "20% off item" , "30% off"};
	
	public static Coupon c = new Coupon ("Buy one entree get one free", "BOGO", "Valid: 10/11/22");
	public static Coupon b = new Coupon ("Buy one entree get one 50% off", "BOGO50%", "Valid: 10/11/22");
	public static Coupon d = new Coupon ("20% entire purchase", "20%OFF", "Valid: 10/11/22");
	
	public Coupon[] list = {c, b, d};
	Stage stagee;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		aCoup.getItems().addAll(c.code,b.code,d.code);
		
		TreeItem<String> rootItem = new TreeItem<>("Customers");
		
		
	
		
		//TreeItem<String> Customer = new TreeItem<>("David Fitzer");
		//TreeItem<String> frequencyy = new TreeItem<>("Orders: 5");	
		//TreeItem<String> c = new TreeItem<>("Active Coupons: " + total);
		//TreeItem<String> leafItem4 = new TreeItem<>("Coupon2");	
		
		//Customer.getChildren().addAll(frequencyy, c);
		//rootItem.getChildren().add(Customer);
		
		for (int i=0; i < Main.customers.size(); i++)
		{
			TreeItem<String> branchItem = new TreeItem<>(Main.customers.get(i).fName + " " + Main.customers.get(i).lName);
			TreeItem<String> activeCoupons = new TreeItem<>("Active Coupons: " +Main.customers.get(i).coupons.size());
			TreeItem<String> frequency = new TreeItem<>("Orders: "+Main.customers.get(i).orders.size());
			//branchItem.getChildren().addAll(frequency, activeCoupons);
			rootItem.getChildren().add(branchItem);
			
		}
		
		
		//treeView.setShowRoot(false);
		treeView.setRoot(rootItem);
	}
	
	public boolean selectItem() {
	
		TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
		
		if(item != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void applyCoupon(ActionEvent event) {
		if (selectItem()==true)
		{
			Main.customers.get(treeView.getSelectionModel().getSelectedIndex() - 1).coupons.add(list[aCoup.getSelectionModel().getSelectedIndex()]);
			System.out.print(Main.customers.get(0).coupons.get(0).code);
			System.out.println("Coupon Applied");
			stagee = (Stage) Anchor.getScene().getWindow();
			devMenuGUI devMenu2 = new devMenuGUI(stagee);
			stagee.setScene(devMenu2.getScene());
;			
		
			
		}
		else {
			
		}
	}
	
	public void goBack(ActionEvent event) {
		
		stagee = (Stage) Anchor.getScene().getWindow();
		devMenuGUI devMenu2 = new devMenuGUI(stagee);
		stagee.setScene(devMenu2.getScene());
		
	}
}