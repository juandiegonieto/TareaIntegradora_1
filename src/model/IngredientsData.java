package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IngredientsData {
	
	private ObservableList<Ingredient> ingredients;
	
	
	public IngredientsData() {
		ingredients = FXCollections.observableArrayList();
	}
	
	
	
	public ObservableList<Ingredient> getData(){
		return ingredients;
	}
	
}
