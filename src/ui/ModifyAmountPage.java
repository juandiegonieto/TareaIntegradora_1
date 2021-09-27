package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ModifyAmountPage extends Stage{
		
	//UI Components
	private TextField ingredientNameTF;
	private TextField newAmountTF;
	private Button saveBtn;
	private Button backBtn;
	
	public ModifyAmountPage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyAmountPage.fxml"));
			Parent root = loader.load();
			
			ingredientNameTF = (TextField) loader.getNamespace().get("ingredientNameTF");
			newAmountTF = (TextField) loader.getNamespace().get("newAmountTF");
			saveBtn = (Button) loader.getNamespace().get("saveBtn");
			backBtn = (Button) loader.getNamespace().get("backBtn");
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void init() {
		saveBtn.setOnAction(event-> {
			String ingredientName = "";
			if(ingredientNameTF.getText() != null) {
				ingredientName = ingredientNameTF.getText();
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Para continaur, escriba un ingrediente existente.");
				alert.showAndWait();
			}
			int newAmount = 0;
			if(newAmountTF.getText() != null) {
				newAmount = Integer.parseInt(newAmountTF.getText());
			}
			for(int i=0; i<InventoryPage.ingredients.getData().size(); i++) {	
				if(InventoryPage.ingredients.getData().get(i).getName() == ingredientName) {
					InventoryPage.ingredients.getData().get(i).setAmount(newAmount);
				} 
			}
		});
		backBtn.setOnAction(event-> {
			InventoryPage inventoryPage = new InventoryPage();
			inventoryPage.show();
			hide();
		});
	}
	
}
