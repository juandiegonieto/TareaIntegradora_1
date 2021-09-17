package model;

public class Order {
	
		private int code;
		private String state;
		private String orderDate;
		
		public Order(int code, String state, String orderDate) {
			super();
			this.code = code;
			this.state = state;
			this.orderDate = orderDate;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
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
		
		
		
}
