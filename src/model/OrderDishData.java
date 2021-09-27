package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderDishData {
	
	private ObservableList<OrderDish> orderDishes;
	
	
	public OrderDishData() {
		orderDishes = FXCollections.observableArrayList();
	}
	
	
	
	public ObservableList<OrderDish> getData(){
		return orderDishes;
	}
}
