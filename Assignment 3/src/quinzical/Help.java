package quinzical;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class provides the implementation of the help module in the application.  This class and
 * implementation will help reduce the possible confusion the user might have and also reduce 
 * ambiguity when answering the questions.
 *
 * @author Do Hyun Lee, Youngseok Chae
 */
public class Help {
	/*
	 * This method implements the module in which when prompted by the user, the user is given
	 * tips and guidance on how to format the answer. The message in this method is to help the 
	 * user on how they can answer the question.
	 */
	public static void displayHowToAnswer() {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("How Quinzical Checks Answers");
		window.setMinWidth(400);

		Label text = new Label();
		//This label displays to the user what types of formatting is allowed when
		//answering the questions.
		text.setText(
				"Quinzical will ignore spaces between characters and wordsn" +
						"\nas well as uppercase/lowercase letters." +
						"\nFor example, for a question where the answer was teapot," +
						"\nthe words 'tea pot', 'TEAPOT', 'TE a PO t' would be accepted" +
						"\nbut 'teapor' would not.\n\n" +
						"Numbers (excluding years) can also be written in word format." +
						"\nFor example, for a question where the answer was 4," +
						"\nboth '4' and 'four' would be accepted."
				);

		Button closeButton = new Button("I Understand");
		closeButton.setOnAction(e -> window.close());

		//Help module layout as a VBox layout
		VBox layout = new VBox(5);
		layout.getChildren().addAll(text, closeButton);
		layout.setAlignment(Pos.TOP_CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);

		window.showAndWait();

	}

}