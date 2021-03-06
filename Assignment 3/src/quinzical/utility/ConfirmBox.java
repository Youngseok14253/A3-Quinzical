package quinzical.utility;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class provides the display method for the Main class when the user asks
 * to exit the game. It confirms that the user wants to exit and quits the game,
 * and also makes sure that a misclick by the user does not result in a
 * shutdown.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 *
 */
public class ConfirmBox {

	private static boolean answer;

	/*
	 * This method returns a boolean value depending on the confirmation of the user
	 * when pressing the exit buttons provided in the Main class. A true is returned
	 * when the Yes button is pressed, or vice versa for the No button.
	 * 
	 * @param title The title of the window
	 * 
	 * @param message The message to display through the window
	 * 
	 * @return A boolean value (true for Yes, false for No)
	 * 
	 */
	public static boolean display(String title, String message) {

		// New Stage
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(700);
		Label label = new Label();
		label.setText(message);
		label.setFont(new Font("Arial", 35));

		// Creating two buttons
		Button btnYes = new Button("Yes");
		btnYes.setPrefSize(535, 50);
		btnYes.setFont(new Font("Arial", 35));
		Button btnNo = new Button("No");
		btnNo.setPrefSize(535, 50);
		btnNo.setFont(new Font("Arial", 35));

		// return true if Yes is pressed, and close the window
		btnYes.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				answer = true;
				window.close();
			}
		});

		// return false if No is pressed, and close the window
		btnNo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				answer = false;
				window.close();
			}
		});

		// Create layout and show scene
		VBox layout = new VBox(10);

		layout.getChildren().addAll(label, btnYes, btnNo);
		layout.setAlignment(Pos.CENTER);
		window.setX(400);
		window.setY(200);
		Scene scene = new Scene(layout, 1200,350);
		window.setScene(scene);
		window.showAndWait();

		return answer;

	}

	/*
	 * This method creates a new window, where it displays a hint (first character
	 * of the Answer) to the user after their second attempt. The window closes
	 * after the user confirms to exit/continue.
	 * 
	 * @param hint The first character of the Answer to its corresponding Question
	 * 
	 */
	public static void displayHint(char hint) {

		// New Stage
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);

		window.setTitle("Hint");
		window.setMinWidth(700);

		Label label = new Label();
		label.setText("The first character of the answer is:");
		label.setFont(new Font("Arial", 35));

		// Converts char to String, and sets the Label to display
		String hintString = Character.toString(hint);
		Label hintLabel = new Label();
		hintLabel.setText(hintString.toUpperCase());
		hintLabel.setFont(new Font("Arial", 35));

		Label goodLuck = new Label();
		goodLuck.setText("This is your last attempt - make it count!");
		goodLuck.setFont(new Font("Arial", 35));

		Button button = new Button("Confirm");
		button.setFont(new Font("Arial", 35));

		// Pressing confirm will close the window
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
		});

		// Create layout and show the scene
		VBox layout = new VBox(10);

		layout.getChildren().addAll(label, hintLabel, goodLuck, button);

		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout,800,250);
		window.setScene(scene);
		window.showAndWait();

	}

	/*
	 * This method creates a new window, where it displays the correct Answer to the
	 * user either submitting and incorrect in Game Mode, or after a third incorrect
	 * attempt in Practice Mode. The window closes after the user confirms to
	 * exit/continue.
	 * 
	 * @param answer The Answer to the Question
	 * 
	 */
	public static void showAnswer(String answer) {

		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(700);
		window.setTitle("Answer");

		Label label = new Label();
		label.setText("The correct answer was:");
		label.setFont(new Font("Arial", 35));

		// Sets the label to display the Answer
		Label ansLabel = new Label();
		ansLabel.setText(answer);
		ansLabel.setFont(new Font("Arial", 35));

		Button button = new Button("Confirm");
		button.setFont(new Font("Arial", 35));

		// Pressing confirm will close the window
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
		});

		// Create layout and show the scene
		VBox layout = new VBox(10);

		layout.getChildren().addAll(label, ansLabel, button);

		layout.setAlignment(Pos.CENTER);
		window.setX(650);
		window.setY(250);

		Scene scene = new Scene(layout,600,250);
		window.setScene(scene);
		window.showAndWait();

	}
}