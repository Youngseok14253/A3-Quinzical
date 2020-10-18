package board;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import quinzical.AnswerQuestion;

/**
 * This class provides the display method for the Main class when the user
 * selects the Game Mode. It contains a single method, createPracticeBoard which
 * creates a new window displaying all categories. The method is almost exactly
 * the same as displayGameBoard, except (mentioned above) all Categories are
 * available for selection, and upon the third attempt at asnwering a question,
 * gives the user a hint which displays the first letter of the answer.
 * Cateogories also do disappear after a select number of presses, and can
 * always be selected no matter the attempt.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 *
 */
public class CreatePracticeBoard {

	/*
	 * This method displays a new window with all categories in the Question Bank.
	 * Once a category is selected, it displays a question corresponding to the
	 * Category and depending on the user's answer, displays a "Correct" or
	 * "Incorrect" message. Unlike displayGameBoard, the user is allowed three
	 * attempts to answer correctly. On the third and last attempt, a window with a
	 * hint (first character of the answer) is displayed to the user. If the user
	 * answers correctly on any attempt, or incorrectly on the final, they are
	 * returned to the Category window where they can continue practicing.
	 * 
	 */
	public static void displayPracticeBoard() {

		// New Stage
		Stage window = new Stage();

		// Set up GridPane
		GridPane gameGrid = new GridPane();
		gameGrid.setPadding(new Insets(10, 10, 10, 10));
		gameGrid.setVgap(8);
		gameGrid.setHgap(10);

		Label Category = new Label("Please select a category");
		GridPane.setConstraints(Category, 0, 0);

		// Each button is formatted the same way, so follow along the comments for
		// Button 1 (Category1)

		// Button for Places created, and placed in the (0,1) Pane
		Button Category1 = new Button("Places");
		GridPane.setConstraints(Category1, 1, 1);
		// Set a reasonable size
		Category1.setPrefSize(300, 80);
		// Return the name of the Category from the ArrayList and store it in a variable
		String catName1 = Category1.getText();

		// When the button is pressed, the displayQuestion method is called where the
		// question is displayed.
		Category1.setOnAction(e -> {
			AnswerQuestion.displayQuestion(catName1, "Practice", 0);
		});

		Button Category2 = new Button("Symbols");
		GridPane.setConstraints(Category2, 1, 2);
		Category2.setPrefSize(300, 80);
		String catName2 = Category2.getText();

		Category2.setOnAction(e -> {
			AnswerQuestion.displayQuestion(catName2, "Practice", 0);
		});

		Button Category3 = new Button("Geography");
		GridPane.setConstraints(Category3, 1, 3);
		Category3.setPrefSize(300, 80);
		String catName3 = Category3.getText();

		Category3.setOnAction(e -> {
			AnswerQuestion.displayQuestion(catName3, "Practice", 0);
		});

		Button Category4 = new Button("History");
		GridPane.setConstraints(Category4, 1, 4);
		Category4.setPrefSize(300, 80);
		String catName4 = Category4.getText();

		Category4.setOnAction(e -> {
			AnswerQuestion.displayQuestion(catName4, "Practice", 0);
		});

		Button Category5 = new Button("Famous People");
		GridPane.setConstraints(Category5, 0, 1);
		Category5.setPrefSize(300, 80);
		String catName5 = Category5.getText();

		Category5.setOnAction(e -> {
			AnswerQuestion.displayQuestion(catName5, "Practice", 0);
		});

		Button Category6 = new Button("NZ Life");
		GridPane.setConstraints(Category6, 0, 2);
		Category6.setPrefSize(300, 80);
		String catName6 = Category6.getText();

		Category6.setOnAction(e -> {
			AnswerQuestion.displayQuestion(catName6, "Practice", 0);
		});

		Button Category7 = new Button("Flora");
		GridPane.setConstraints(Category7, 0, 3);
		Category7.setPrefSize(300, 80);
		String catName7 = Category7.getText();

		Category7.setOnAction(e -> {
			AnswerQuestion.displayQuestion(catName7, "Practice", 0);
		});

		Button Category8 = new Button("Fauna");
		GridPane.setConstraints(Category8, 0, 4);
		Category8.setPrefSize(300, 80);
		String catName8 = Category8.getText();

		Category8.setOnAction(e -> {
			AnswerQuestion.displayQuestion(catName8, "Practice", 0);
		});

		Button Category9 = new Button("Oddities");
		GridPane.setConstraints(Category9, 0, 5);
		Category9.setPrefSize(300, 80);
		String catName9 = Category9.getText();

		Category9.setOnAction(e -> {
			AnswerQuestion.displayQuestion(catName9, "Practice", 0);
		});

		// Adds the buttons and Labels to the Grid
		gameGrid.getChildren().addAll(Category, Category1, Category2, Category3, Category4, Category5, Category6,
				Category7, Category8, Category9);

		// Create layout and show scene
		Scene scene = new Scene(gameGrid, 600, 450);

		window.initModality(Modality.APPLICATION_MODAL);

		window.setScene(scene);
		window.setTitle("Practice Mode");
		window.showAndWait();
	}
}