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
				"Quinzical will ignore spaces between characters and words." +
		     "\n as well as uppercase/lowercase letters." +
		     "\n For example, for a question where the answer was teapot," +
			 "\n the words 'tea pot', 'TEAPOT', 'TE a PO t' would work" +
		     "\n but 'teapor' would not.");
		
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
