package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
		private String code;
		private String state;
		private String orderDate;
		private ArrayList<OrderDish> orderDishes;
		
		public Order() {
			
		}
		
		public Order(String code, String state, String orderDate, ArrayList<OrderDish> orderDishes) {
			super();
			this.code = code;
			this.state = state;
			this.orderDate = orderDate;
			this.orderDishes = orderDishes;
		}

		public Order(String code, String state, String orderDate) {
			super();
			this.code = code;
			this.state = state;
			this.orderDate = orderDate;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(String orderDate) {
			this.orderDate = orderDate;
		}
		
		public ArrayList<OrderDish> getDishes() {
			return orderDishes;
		}

		public void setDishes(ArrayList<OrderDish> orderDishes) {
			this.orderDishes = orderDishes;
		}
		
}
