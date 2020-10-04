package quinzical;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class createGameBoard{

	public static void displayGameBoard() {
		GridPane gameGrid= new GridPane();
		gameGrid.setPadding(new Insets(10,10,10,10));
		gameGrid.setVgap(8);
		gameGrid.setHgap(10);

		Label nameLabel= new Label("Please enter a nickname:");
		GridPane.setConstraints(nameLabel,0,0);


		TextField nameInput= new TextField();
		nameInput.setPromptText("Nickname");
		GridPane.setConstraints(nameInput, 1, 0);


		Button Category1 = new Button("Category- 1");
		GridPane.setConstraints(Category1, 1, 1);
		Category1.setPrefSize(200, 40);
		String catName1 = Category1.getText();
		System.out.println(catName1);

		Category1.setOnAction(e -> System.out.println("selected category 1."));

		Button Category2 = new Button("Category- 2");
		GridPane.setConstraints(Category2, 1, 2);
		Category2.setPrefSize(200, 40);
		String catName2 = Category2.getText();
		System.out.println(catName2);

		Category2.setOnAction(e -> {
			System.out.println("selected category 2.");
			SelectCategory.displayQuestion(catName2);
		}
				);

		Button Category3 = new Button("Category- 3");
		GridPane.setConstraints(Category3, 1, 3);
		Category3.setPrefSize(200, 40);
		String catName3 = Category3.getText();
		System.out.println(catName3);

		Category3.setOnAction(e -> System.out.println("selected category 3."));

		Button Category4 = new Button("Category- 4");
		GridPane.setConstraints(Category4, 1, 4);
		Category4.setPrefSize(200, 40);
		String catName4 = Category4.getText();
		System.out.println(catName4);

		Category4.setOnAction(e -> System.out.println("selected category 4."));

		Button Category5 = new Button("Category- 5");
		GridPane.setConstraints(Category5, 1, 5);
		Category5.setPrefSize(200, 40);
		String catName5 = Category5.getText();
		System.out.println(catName5);

		Category5.setOnAction(e -> System.out.println("selected category 5."));
		
		Stage window = new Stage();

		gameGrid.getChildren().addAll(nameLabel, nameInput, Category1, Category2, Category3, Category4, Category5);
		Scene scene= new Scene(gameGrid, 400,300);
		window.setScene(scene);
		window.setTitle("Game Mode");
		window.initModality(Modality.APPLICATION_MODAL);
		window.showAndWait();
	}
}
