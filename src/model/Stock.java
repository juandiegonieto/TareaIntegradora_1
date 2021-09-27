package model;

import java.io.Serializable;

public class Stock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String dish;
	private String name;
	private int amount;
	
	public Stock() {
		
	}
	
	public Stock(String dish, String name, int amount) {
		super();
		this.dish = dish;
		this.name = name;
		this.amount = amount;
	}
	
	public String getDish() {
		return dish;
	}
	public void setDish(String dish) {
		this.dish = dish;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}