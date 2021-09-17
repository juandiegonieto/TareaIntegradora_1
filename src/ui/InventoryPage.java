package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Ingredient;
import model.IngredientsData;

public class InventoryPage extends Stage {
	
	//UI Components
	private TableView<Ingredient> ingredientsTableTV;
	private TextField ingredientNameTF;
	private TextField amountTF;
	private Button addIngredientBtn;
	private Button modifyIngredientBtn;
	private Button backBtn;
	
	//Datos
	public static IngredientsData ingredients = new IngredientsData();
	
	public InventoryPage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InventoryPage.fxml"));
			Parent root = loader.load();
			
			ingredientsTableTV = (TableView) loader.getNamespace().get("ingredientsTableTV");
			ingredientNameTF = (TextField) loader.getNamespace().get("ingredientNameTF");
			amountTF = (TextField) loader.getNamespace().get("amountTF");
			addIngredientBtn = (Button) loader.getNamespace().get("addIngredientBtn");
			modifyIngredientBtn = (Button) loader.getNamespace().get("modifyIngredientBtn");
			backBtn = (Button) loader.getNamespace().get("backBtn");
			
			ingredients = new IngredientsData();
			
			//Create table Colums
			TableColumn<Ingredient, String> nameCol = new TableColumn<>("Nombre");
			TableColumn<Ingredient, String> amountCol = new TableColumn<>("Unidades");
			
			//Table elements
			nameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			amountCol.setCellValueFactory(new PropertyValueFactory<>("unidades"));
			
			ingredientsTableTV.getColumns().addAll(nameCol, amountCol);
			ingredientsTableTV.setItems(ingredients.getData());
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void init() {
		addIngredientBtn.setOnAction(event-> {
			addIngredient();
		});
		modifyIngredientBtn.setOnAction(event-> {
			ModifyAmountPage modifyAmountPage = new ModifyAmountPage();
			modifyAmountPage.show();
			hide();
		});
		backBtn.setOnAction(event-> {
			PrincipalMenu principalMenu = new PrincipalMenu();
			principalMenu.show();
			hide();
		});
	}
	
	public void addIngredient() {
		String name = ingredientNameTF.getText();
		int amount = Integer.parseInt(amountTF.getText());
		Ingredient i = new Ingredient(name, amount);
		ingredients.getData().add(i);
	}
	
	public void setData(IngredientsData data) {
		ingredients = data;
	}
	
}
