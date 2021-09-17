package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Dish;
import model.Ingredient;
import model.IngredientsData;
import model.Order;
import model.OrderData;

public class OrderHistory extends Stage{
	
	//UI Components
	private TableView<Order> orderListTV;
	private Button backBtn;
	private Button addOrder;
		
	//Datos
	public static OrderData orders = new OrderData();
	
	public OrderHistory() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderHistory.fxml"));
			Parent root = loader.load();
			
			orderListTV = (TableView) loader.getNamespace().get("ingredientsTableTV");
			backBtn = (Button) loader.getNamespace().get("backBtn");
			addOrder = (Button) loader.getNamespace().get("addOrder");
			
			orders = new OrderData();
			
			//Create table Colums
			TableColumn<Order, String> codeCol = new TableColumn<>("Código");
			TableColumn<Order, String> dishesListCol = new TableColumn<>("Lista de Platillos");
			TableColumn<Order, String> orderStateCol = new TableColumn<>("Estado de pedido");
			TableColumn<Order, String> orderDateCol = new TableColumn<>("Fecha");
			
			//Table elements
			codeCol.setCellValueFactory(new PropertyValueFactory<>("codigo"));
			dishesListCol.setCellValueFactory(new PropertyValueFactory<>("lista de platillos"));
			orderStateCol.setCellValueFactory(new PropertyValueFactory<>("estado de pedido"));
			orderDateCol.setCellValueFactory(new PropertyValueFactory<>("fecha de pedido"));
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void init() {
		addOrder.setOnAction(event-> {
			RegisterOrder registerOrder = new RegisterOrder();
			registerOrder.show();
		});
		backBtn.setOnAction(event-> {
			PrincipalMenu principalMenu = new PrincipalMenu();
			principalMenu.show();
			hide();
		});
	}
	
	public void setData(OrderData data) {
		orders = data;
	}
	
}
