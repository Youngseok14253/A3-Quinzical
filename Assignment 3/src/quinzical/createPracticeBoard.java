package quinzical;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class createPracticeBoard {

	public static void displayPracticeBoard() {
		GridPane gameGrid= new GridPane();
		gameGrid.setPadding(new Insets(10,10,10,10));
		gameGrid.setVgap(8);
		gameGrid.setHgap(10);

		Label Category= new Label("Please select a category");
		GridPane.setConstraints(Category,0,0);


		Button Category1 = new Button("Places");
		GridPane.setConstraints(Category1, 1, 1);
		Category1.setPrefSize(200, 40);
		String catName1 = Category1.getText();
		System.out.println(catName1);

		Category1.setOnAction(e -> {
			SelectCategory.displayQuestion(catName1);
		}
				);

		Button Category2 = new Button("Symbols");
		GridPane.setConstraints(Category2, 1, 2);
		Category2.setPrefSize(200, 40);
		String catName2 = Category2.getText();
		System.out.println(catName2);

		Category2.setOnAction(e -> {
			SelectCategory.displayQuestion(catName2);
		}
				);

		Button Category3 = new Button("Geography");
		GridPane.setConstraints(Category3, 1, 3);
		Category3.setPrefSize(200, 40);
		String catName3 = Category3.getText();
		System.out.println(catName3);

		Category3.setOnAction(e -> {
			SelectCategory.displayQuestion(catName3);
		}
				);

		Button Category4 = new Button("History");
		GridPane.setConstraints(Category4, 1, 4);
		Category4.setPrefSize(200, 40);
		String catName4 = Category4.getText();
		System.out.println(catName4);

		Category4.setOnAction(e -> {
			SelectCategory.displayQuestion(catName4);
		}
				);

		Button Category5 = new Button("Famous People");
		GridPane.setConstraints(Category5, 0, 1);
		Category5.setPrefSize(200, 40);
		String catName5 = Category5.getText();
		System.out.println(catName5);

		Category5.setOnAction(e -> {
			SelectCategory.displayQuestion(catName5);
		}
				);

		Button Category6 = new Button("NZ Life");
		GridPane.setConstraints(Category6, 0, 2);
		Category6.setPrefSize(200, 40);
		String catName6 = Category6.getText();
		System.out.println(catName6);

		Category6.setOnAction(e -> {
			SelectCategory.displayQuestion(catName6);
		}
				);

		Button Category7 = new Button("Flora");
		GridPane.setConstraints(Category7, 0, 3);
		Category7.setPrefSize(200, 40);
		String catName7 = Category7.getText();
		System.out.println(catName7);

		
		Category7.setOnAction(e -> {
			SelectCategory.displayQuestion(catName7);
		}
				);

		Button Category8 = new Button("Fauna");
		GridPane.setConstraints(Category8, 0, 4);
		Category8.setPrefSize(200, 40);
		String catName8 = Category8.getText();
		System.out.println(catName8);

		Category8.setOnAction(e -> {
			SelectCategory.displayQuestion(catName8);
		}
				);

		Button Category9 = new Button("Oddities");
		GridPane.setConstraints(Category9, 0, 5);
		Category9.setPrefSize(200, 40);
		String catName9 = Category9.getText();
		System.out.println(catName9);

		Category9.setOnAction(e -> {
			SelectCategory.displayQuestion(catName9);
		}
				);

		Stage window = new Stage();

		gameGrid.getChildren().addAll(Category, Category1, Category2, Category3, Category4, Category5, Category6, Category7, Category8, Category9);
		Scene scene= new Scene(gameGrid, 400,300);
		window.setScene(scene);
		window.setTitle("Practice Mode");
		window.initModality(Modality.APPLICATION_MODAL);
		window.showAndWait();
}
}
