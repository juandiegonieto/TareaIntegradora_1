package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PasswordChange extends Stage {
	
	//UI Components
	private TextField idTF;
	private Button acceptBtn;
	private PasswordField oldPassPF;
	private PasswordField newPassPF;
	
	public PasswordChange() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PasswordChange.fxml"));
			Parent root = loader.load();
			
			idTF = (TextField) loader.getNamespace().get("idTF");
			acceptBtn = (Button) loader.getNamespace().get("acceptBtn");
			oldPassPF = (PasswordField) loader.getNamespace().get("oldPassPF");
			newPassPF = (PasswordField) loader.getNamespace().get("newPassPF");
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void init() {
		acceptBtn.setOnAction(event-> {
			changeEmployeePassword();
		});
		
	}

	private void changeEmployeePassword() {
		for(int i=0; i<EmployeeArea.employees.getData().size(); i++) {
			if (Integer.parseInt(idTF.getText()) == EmployeeArea.employees.getData().get(i).getId()) {
				if(oldPassPF.getText().equals(EmployeeArea.employees.getData().get(i).getPassword())) {
					EmployeeArea.employees.getData().get(i).setPassword(newPassPF.getText());
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("La contraseña actual se incorrecta");
					alert.showAndWait();
				}
			}
		}
		
	}
	
}
