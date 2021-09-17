package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DishesData {
	
private ObservableList<Dish> dishes;
		
	public DishesData() {
		dishes = FXCollections.observableArrayList();
	}
	
	
	
	public ObservableList<Dish> getData(){
		return dishes;
	}
}
