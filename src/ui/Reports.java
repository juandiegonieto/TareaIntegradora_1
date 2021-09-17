package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Dish;
import model.Employee;

public class Reports extends Stage{
	//UI Components
	private TableView<Employee> employeesTableTV;
	private TableView<Dish> dishesTableTV;
	private Button generateReportBtn;
	private DatePicker initialDateDP;
	private DatePicker finalDateDP;
	
	
	public Reports() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Reports.fxml"));
			Parent root = loader.load();
			
			employeesTableTV = (TableView) loader.getNamespace().get("employeesTableTV");
			dishesTableTV = (TableView) loader.getNamespace().get("dishesTableTV");
			generateReportBtn = (Button) loader.getNamespace().get("generateReportBtn");
			initialDateDP = (DatePicker) loader.getNamespace().get("initialDateDP");
			finalDateDP = (DatePicker) loader.getNamespace().get("finalDateDP");
			
			
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void init() {
		
		
	}
}
