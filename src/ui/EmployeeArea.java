package ui;

import java.time.Month;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Employee;
import model.EmployeeData;
import model.Ingredient;

public class EmployeeArea extends Stage {
	
	//UI Components
	 private Button addEmployeeBtn;
	 private TableView<Employee> employeeListTV;
	 private DatePicker birthdayBP;
	 private TextField nameTF;
	 private TextField idTF;
	 private PasswordField passPF;
	 private Button changePassBtn;
	 private Button backBTn;
	 
	//Data
	public static EmployeeData employees = new EmployeeData();
	 
	public EmployeeArea() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PasswordChange.fxml"));
			Parent root = loader.load();
			
			addEmployeeBtn = (Button) loader.getNamespace().get("addEmployeeBtn");
			employeeListTV = (TableView) loader.getNamespace().get("employeeListTV");
			birthdayBP = (DatePicker) loader.getNamespace().get("birthdayBP");
			nameTF = (TextField) loader.getNamespace().get("nameTF");
			idTF = (TextField) loader.getNamespace().get("idTF");
			passPF = (PasswordField) loader.getNamespace().get("passPF");
			changePassBtn = (Button) loader.getNamespace().get("changePassBtn");
			backBTn = (Button) loader.getNamespace().get("backBTn");
			
			employees = new EmployeeData();
			
			//Create table Colums
			TableColumn<Employee, String> nameCol = new TableColumn<>("Nombre");
			TableColumn<Employee, String> idCol = new TableColumn<>("cedula");
			TableColumn<Employee, String> birthdayCol = new TableColumn<>("Fecha de nacimiento");
			TableColumn<Employee, String> passwordCol = new TableColumn<>("Contraseña");
			
			//Table elements
			nameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
			birthdayCol.setCellValueFactory(new PropertyValueFactory<>("fecha de nacimiento"));
			passwordCol.setCellValueFactory(new PropertyValueFactory<>("contraseña"));
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void init() {
		addEmployeeBtn.setOnAction(event-> {
			addEmployee();
		});
		changePassBtn.setOnAction(event-> {
			PasswordChange passwordChange = new PasswordChange();
			passwordChange.show();
			hide();	
		});
		backBTn.setOnAction(event-> {
			PrincipalMenu principalMenu = new PrincipalMenu();
			principalMenu.show();
			hide();
		});
	}

	public void addEmployee() {
		String name = nameTF.getText();
		int id = Integer.parseInt(idTF.getText());
		int month = birthdayBP.getValue().getMonthValue();
		int day = birthdayBP.getValue().getDayOfMonth();
		int year = birthdayBP.getValue().getYear();
		String birthday = day+"/"+month+"/"+year;
		String password = passPF.getText();
		Employee e = new Employee(name, id, birthday, password);
		employees.getData().add(e);
	}
	
}
