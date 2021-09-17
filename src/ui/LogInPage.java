package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
			
		});
	}
	
}
