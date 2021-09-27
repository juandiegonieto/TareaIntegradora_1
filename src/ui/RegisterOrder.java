package ui;

import java.util.UUID;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.OrderData;

public class RegisterOrder extends Stage {
	
	//UI Components
	private Button addOrderBtn;
	private ChoiceBox<String> dishCB;
	private TextField amountTF;
	private TextField clientNameTF;

	
	public RegisterOrder() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterOrder.fxml"));
			Parent root = loader.load();
			
			addOrderBtn = (Button) loader.getNamespace().get("addOrderBtn");
			dishCB = (ChoiceBox) loader.getNamespace().get("dishCB");
			amountTF = (TextField) loader.getNamespace().get("amountTF");
			clientNameTF = (TextField) loader.getNamespace().get("clientNameTF");
			
			for(int i=0; i<CartPage.dishes.getData().size(); i++) {
				String dishToAdd = CartPage.dishes.getData().get(i).getName();
				dishCB.getItems().add(i, dishToAdd);
			}
 			
			
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void init() {
		addOrderBtn.setOnAction(event-> {
			addOrder();
		});
	}
	
	public void addOrder() {
		String code = UUID.randomUUID().toString();
		String state = "Pendiente";
	}	
	
}
