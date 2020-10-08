package quinzical;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayGameBoard {

	public static void displayGameBoard(ArrayList<String> categories) {
		
		Stage window = new Stage();
		
		//This method sets up a new window and gives access to all 9 categories to the user.
		GridPane gameGrid= new GridPane();
		gameGrid.setPadding(new Insets(10,10,10,10));
		gameGrid.setVgap(8);
		gameGrid.setHgap(10);

		Label Category= new Label("Please select a category");
		GridPane.setConstraints(Category,0,0);

		Button Category1 = new Button(categories.get(0));
		GridPane.setConstraints(Category1, 0, 1);
		Category1.setPrefSize(200, 40);
		String catName1 = Category1.getText();

		Category1.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion(catName1, "Game", 1);
			System.out.println(ShowWinnings.getOneCount());
			ShowWinnings.incrementOneCount();
			displayGameBoard(categories);
		}
				);

		Button Category2 = new Button(categories.get(1));
		GridPane.setConstraints(Category2, 0, 2);
		Category2.setPrefSize(200, 40);
		String catName2 = Category2.getText();

		Category2.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion(catName2, "Game", 2);
			ShowWinnings.incrementTwoCount();
		    displayGameBoard(categories);
		}
				);

		Button Category3 = new Button(categories.get(2));
		GridPane.setConstraints(Category3, 0, 3);
		Category3.setPrefSize(200, 40);
		String catName3 = Category3.getText();

		Category3.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion(catName3, "Game", 3);
			ShowWinnings.incrementThreeCount();
			displayGameBoard(categories);
		}
				);

		Button Category4 = new Button(categories.get(3));
		GridPane.setConstraints(Category4, 0, 4);
		Category4.setPrefSize(200, 40);
		String catName4 = Category4.getText();

		Category4.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion(catName4, "Game", 4);
			ShowWinnings.incrementFourCount();
			displayGameBoard(categories);
		}
				);

		Button Category5 = new Button(categories.get(4));
		GridPane.setConstraints(Category5, 0, 5);
		Category5.setPrefSize(200, 40);
		String catName5 = Category5.getText();

		Category5.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion(catName5, "Game", 5);
			ShowWinnings.incrementFiveCount();
			displayGameBoard(categories);
		}
				);
		
		Label catOneMoney = new Label();
		GridPane.setConstraints(catOneMoney,1,1);
		catOneMoney.setText("Question Worth $"+ShowWinnings.getOneCount()+"00");
		Label catTwoMoney = new Label();
		GridPane.setConstraints(catTwoMoney,1,2);
		catTwoMoney.setText("$"+ShowWinnings.getTwoCount()+"00");
		Label catThreeMoney = new Label();
		GridPane.setConstraints(catThreeMoney,1,3);
		catThreeMoney.setText("$"+ShowWinnings.getThreeCount()+"00");
		Label catFourMoney = new Label();
		GridPane.setConstraints(catFourMoney,1,4);
		catFourMoney.setText("$"+ShowWinnings.getFourCount()+"00");
		Label catFiveMoney = new Label();
		GridPane.setConstraints(catFiveMoney,1,5);
		catFiveMoney.setText("$"+ShowWinnings.getFiveCount()+"00");

		gameGrid.getChildren().addAll(Category, Category1, Category2, Category3, Category4, Category5);
		gameGrid.getChildren().addAll(catOneMoney, catTwoMoney, catThreeMoney, catFourMoney, catFiveMoney);
		Scene scene= new Scene(gameGrid, 400,300);
		window.setScene(scene);
		window.setTitle("Test Game Mode");
		window.initModality(Modality.APPLICATION_MODAL);
		window.show();
}
}
