package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
			
		});
	}
}
