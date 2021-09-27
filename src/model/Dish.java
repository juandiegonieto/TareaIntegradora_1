package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Dish implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Stock> stocks;
	private double price;
	
	public Dish() {
		
	}
	
	public Dish(String name, ArrayList<Stock> stocks, double price) {
		this.name = name;
		this.stocks = stocks;
		this.price = price;
	}

	public ArrayList<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(ArrayList<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
