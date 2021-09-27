package ui;

import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Dish;
import model.DishesData;
import model.Ingredient;
import model.IngredientsData;
import model.Stock;
import model.StockData;

public class CartPage extends Stage{
	
	//UI Components
	private TableView<Dish> dishesTV;
	private TextField nameTF;
	private TextField numberIngredientsTF;
	private Label ingredientNameLbl;
	private TextField ingredientNameTF;
	private Label ingrdientAmountLbl;
	private TextField ingredientAmountTF;
	private TextField priceTF;
	private Button nextIngredientBtn;
	private Button addDishBtn;
	private Button backBtn;
	
	//Data
	public static DishesData dishes = new DishesData();
	public static StockData stocks = new StockData();
	
	public CartPage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CartPage.fxml"));
			Parent root = loader.load();
			
			
			dishesTV = (TableView) loader.getNamespace().get("ingredientsTableTV");
			nameTF = (TextField) loader.getNamespace().get("nameTF");
			numberIngredientsTF = (TextField) loader.getNamespace().get("numberIngredientsTF");
			ingredientNameLbl = (Label) loader.getNamespace().get("ingredientNameLbl");
			ingredientNameTF = (TextField) loader.getNamespace().get("ingredientNameTF");
			ingrdientAmountLbl = (Label) loader.getNamespace().get("ingrdientAmountBtn");
			ingredientAmountTF = (TextField) loader.getNamespace().get("ingredientAmountTF");
			priceTF = (TextField) loader.getNamespace().get("priceTF");
			nextIngredientBtn = (Button) loader.getNamespace().get("nextIngredientBtn");
			addDishBtn = (Button) loader.getNamespace().get("addDishBtn");
			backBtn = (Button) loader.getNamespace().get("backBtn");
			
			dishes = new DishesData();
			stocks = new StockData();
			
			//Create table Colums
			TableColumn<Dish, String> nameCol = new TableColumn<>("Nombre");
			TableColumn<Dish, String> ingredientsCol = new TableColumn<>("Ingredientes");
			TableColumn<Dish, String> priceCol = new TableColumn<>("Precio");
			
			//Table elements
			nameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			ingredientsCol.setCellValueFactory(new PropertyValueFactory<>("ingredientes"));
			priceCol.setCellValueFactory(new PropertyValueFactory<>("precio"));
			
			dishesTV.getColumns().addAll(nameCol, ingredientsCol, priceCol);
			dishesTV.setItems(dishes.getData());
			
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			init();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void init() {
		nextIngredientBtn.setOnAction(event-> {
			if(nameTF.getText() != null) {
				String dish = nameTF.getText();
				if(numberIngredientsTF.getText() != null) {
					int numberOfIngredients = Integer.parseInt(numberIngredientsTF.getText());
					for(int i=0; i<numberOfIngredients; i++) {
						String name = ingredientNameTF.getText();
						int amount = Integer.parseInt(ingredientAmountTF.getText());
						Stock s = new Stock(dish, name, amount);
						stocks.getData().add(s);
					}
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Para continuar coloque la cantidad de ingredientes"
							+ "que desea agregar al platillo");
					alert.showAndWait();
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Para continuar coloque el nombre del plato");
				alert.showAndWait();
			}
			
			
		});
		addDishBtn.setOnAction(event-> {
			addDish();
		});
		backBtn.setOnAction(event-> {
			PrincipalMenu principalMenu = new PrincipalMenu();
			principalMenu.show();
		});
		
	}
	
	public void addDish() {
		if(ingredientNameTF.getText() != null) {
			String name = ingredientNameTF.getText();
			for(int i=0; i<stocks.getData().size(); i++) {
				ArrayList<Stock> stocks = new ArrayList();
				stocks.addAll(stocks);
			}
			double price = Double.parseDouble(priceTF.getText());
			Dish d = new Dish(name, null, price);
			dishes.getData().add(d); 
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("No se puede agregar el plato, para continuar"
					+ " agrege el nombre del plato");
			alert.showAndWait();
		}	
	}
	
	public void setData(DishesData data) {
		dishes = data;
	}
	
}
