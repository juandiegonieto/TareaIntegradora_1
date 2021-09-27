package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StockData {
	
	private ObservableList<Stock> stocks;
	
	public StockData() {
		stocks = FXCollections.observableArrayList();
	}
	
	public ObservableList<Stock> getData(){
		return stocks;
	}
}
