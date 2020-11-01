package quinzical.question;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This CompareAnswer class provides methods to compare the user input with the
 * answer, and return the respective message window depending on the result.
 * This class is mainly called by the SelectCategory class, when the user input
 * is submitted. It also contains a method to count the user attempts during
 * Practice Mode.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 * 
 */
public class CompareAnswer {

	public static int count;

	/*
	 * This method converts the answer and input into lower case, and checks whether
	 * or not they match. If they have answered correctly, then a display pops up
	 * with a "Correct!". Else, "Incorrect!" pops up.
	 * 
	 * @param input The input of the user
	 * 
	 * @param answer The answer on QuestionBank.txt
	 *
	 */
	public static boolean compareAnswerToInput(TextField input, String answer) {

		// Converts the TextField into String, then makes it all Lowercase
		String text = input.getText();
		String lowerText = text.toLowerCase();

		// removes any spaces
		lowerText = lowerText.replace(" ", "");

		// Makes the answer all Lowercase, then removes spaces
		String lowerAnswer = answer.toLowerCase();
		lowerAnswer = lowerAnswer.replace(" ", "");

		// Checks how many alternate answers there are by counting the number of "/"
		// in the answer (i.e Mt Cook/Mount Cook has two alternate answers)
		int ansNum = 1;
		for (char c : lowerAnswer.toCharArray()) {
			if (c == '/') {
				ansNum++;
			}
		}

		// By splitting the answer by "/" and adding it the String Array, the input is
		// compared with each element in the Array (all alternate answers)
		String[] answerArr = new String[ansNum];
		answerArr = lowerAnswer.split("/");

		for (int i = 0; i < ansNum; i++) {
			// If a match is found, then true is returned
			if (lowerText.length() == answerArr[i].length()) {
				if (lowerAnswer.contains(lowerText)) {
					return true;
				}
			}
		}

		// If no matches are found, then return false
		return false;

	}

	/*
	 * This method is called by isAnswerPractice and creates a window showing
	 * whether the user's answer was correct or not.
	 * 
	 * @param message A message "Correct!" or "Incorrect!" depending on user input
	 */
	public static void display(String message) {

		// New Stage
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);

		window.setMinWidth(300);
		window.setMinHeight(20);

		window.setTitle("Result");

		Label label = new Label();
		label.setText(message);
		label.setFont(new Font("Arial", 35));

		Button btnCont = new Button("Continue");
		btnCont.setFont(new Font("Arial", 35));

		// Pressing confirm will close the window
		btnCont.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}

		});

		// Create layout and show the scene
		VBox layout = new VBox(10);

		layout.getChildren().addAll(label, btnCont);
		layout.setAlignment(Pos.CENTER);
		window.setX(780);
		window.setY(250);

		Scene scene = new Scene(layout,450,300);
		window.setScene(scene);
		window.showAndWait();

	}

	// Some Getters and Setters to count the number of user attempts

	public static void setCount() {
		count = 1;
	}

	public static int getCount() {
		return count;
	}

	public static void incrementCount() {
		count++;
	}

}