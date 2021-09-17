package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrincipalMenu extends Stage {
	
	
	//UI Components
	private Button ordersBtn;
	private Button inventoryBtn;
	private Button reportsBtn;
	private Button dishesBtn;
	private Button employeesBtn;
	
	public PrincipalMenu() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PrincipalMenu.fxml"));
			Parent root = loader.load();
			
			ordersBtn = (Button) loader.getNamespace().get("ordersBtn");
			inventoryBtn = (Button) loader.getNamespace().get("inventoryBtn");
			reportsBtn = (Button) loader.getNamespace().get("reportsBtn");
			dishesBtn = (Button) loader.getNamespace().get("dishesBtn");
			employeesBtn = (Button) loader.getNamespace().get("employeesBtn");
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void init() {
		ordersBtn.setOnAction(event-> {
			OrderHistory orderHistory = new OrderHistory();
			orderHistory.show();
			hide();
		});
		inventoryBtn.setOnAction(event-> {
			InventoryPage inventoryPage = new InventoryPage();
			inventoryPage.show();
			hide();
		});
		reportsBtn.setOnAction(event-> {
			Reports reports = new Reports();
			reports.show();
			hide();
		});
		dishesBtn.setOnAction(event-> {
			CartPage cart = new CartPage();
			cart.show();
			hide();
		});
		employeesBtn.setOnAction(event-> {
			EmployeeArea employeeArea = new EmployeeArea();
			employeeArea.show();
			hide();
		});
	}
	
}
