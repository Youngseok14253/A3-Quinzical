package quinzical;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Help {

	public static void displayHowToAnswer() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("How Quiznical Checks Answers");
		window.setMinWidth(400);
		
		Label text = new Label();
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
		
		VBox layout = new VBox(5);
		layout.getChildren().addAll(text, closeButton);
		layout.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		window.showAndWait();
		
	}

}
