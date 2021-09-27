package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LogInPage extends Stage {
	
	//UI Components
	private ImageView imageIV;
	private PasswordField passwordPF;
	private TextField idTF;
	private Button logInBtn;
	
	

	public LogInPage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInPage.fxml"));
			Parent root = loader.load();
			
			imageIV = (ImageView) loader.getNamespace().get("imageIV");
			passwordPF = (PasswordField) loader.getNamespace().get("passwordPF");
			idTF = (TextField) loader.getNamespace().get("idTF");
			logInBtn = (Button) loader.getNamespace().get("logInBtn");	
			
			
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void init() {
		logInBtn.setOnAction(event-> {
			for(int i=0; i<EmployeeArea.employees.getData().size();i++) {
				if(idTF.getText() != null && passwordPF.getText() != null) {
					if(passwordPF.getText().equals(EmployeeArea.employees.getData().get(i).getPassword())
							&& idTF.getText().equals(EmployeeArea.employees.getData().get(i).getId())) {
						PrincipalMenu principalMenu = new PrincipalMenu();
						principalMenu.show();
						hide();
					}
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Usuario y/o contraseña incorrectos.");
					alert.showAndWait();
				}
			}
		});
	}
	
}
