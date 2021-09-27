package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrderState extends Stage {
	
	//UI Components
	private TextField OderCodeTF;
	private Button acceptBtn;
	private TextField OderStateTF;
	
	public OrderState() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderState.fxml"));
			Parent root = loader.load();
			
			OderCodeTF = (TextField) loader.getNamespace().get("OderCodeTF");
			acceptBtn = (Button) loader.getNamespace().get("acceptBtn");
			OderStateTF = (TextField) loader.getNamespace().get("OderStateTF");
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void init() {
		acceptBtn.setOnAction(event-> {
			changeOrderState();
		});
	}
	
	public void changeOrderState() {
		String orderCode = "";
		if(OderCodeTF.getText() != null) {
			orderCode = OderCodeTF.getText();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Para continuar, escriba el codigo del pedido.");
			alert.showAndWait();
		}
		String orderState = "";
		if(OderStateTF.getText() != null) {
			orderState = OderStateTF.getText();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Para continuar, escriba el estado del pedido.");
			alert.showAndWait();
		}
		for(int i=0;i<OrderHistory.orders.getData().size();i++) {
			if(orderCode == OrderHistory.orders.getData().get(i).getCode()) {
				OrderHistory.orders.getData().get(i).setState(orderState);
			}
		}
	}
}
