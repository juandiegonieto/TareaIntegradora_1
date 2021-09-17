package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderData {
	
	private ObservableList<Order> orders;
	
	
	public OrderData() {
		orders = FXCollections.observableArrayList();
	}
	
	
	
	public ObservableList<Order> getData(){
		return orders;
	}
	
}
