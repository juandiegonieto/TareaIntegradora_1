package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeData {
private ObservableList<Employee> employees;
	
	
	public EmployeeData() {
		employees = FXCollections.observableArrayList();
	}
	
	
	
	public ObservableList<Employee> getData(){
		return employees;
	}
	
}
