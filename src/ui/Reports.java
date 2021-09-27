package ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
			
			
			//Create table Colums
			TableColumn<Employee, String> employeeCol = new TableColumn<>("Empleado");
			TableColumn<Employee, String> ordersCol = new TableColumn<>("Pedidos");
			TableColumn<Employee, String> totalMoneyOrdersCol = new TableColumn<>("Monto total pedidos ($)");
			
			TableColumn<Dish, String> dishCol = new TableColumn<>("Platillo");
			TableColumn<Dish, String> totalAmountCol = new TableColumn<>("Cantidad total");
			TableColumn<Dish, String> totalMoneyDishesCol = new TableColumn<>("Monto total pedidos ($)");
			
			//Table elements
			employeeCol.setCellValueFactory(new PropertyValueFactory<>("empleado"));
			ordersCol.setCellValueFactory(new PropertyValueFactory<>("pedidos"));
			totalMoneyOrdersCol.setCellValueFactory(new PropertyValueFactory<>("monto total pedidos ($)"));
			
			dishCol.setCellValueFactory(new PropertyValueFactory<>("empleado"));
			totalAmountCol.setCellValueFactory(new PropertyValueFactory<>("cantidad total"));
			totalMoneyDishesCol.setCellValueFactory(new PropertyValueFactory<>("monto total pedidos ($)"));
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void init() {
		generateReportBtn.setOnAction(event-> {
			genereateReports();
		});
	}
	
	public void genereateReports() {

	}
}
