package model;

public class Employee {
	
	private String name;
	private int id;
	private String birthday;
	private String password;
	
	public Employee(String name, int id, String birthday, String password) {
		super();
		this.name = name;
		this.id = id;
		this.birthday = birthday;
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
