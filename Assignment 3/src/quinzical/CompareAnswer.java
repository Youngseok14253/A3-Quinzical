package quinzical;

import java.awt.Label;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;

public class CompareAnswer{
	
	public static void isAnswerPractice(TextField input, String answer, int tries) {
		
		//if (tries == 1) {
			//show hint
			//System.out.println("showing hint");
		//}
		String text= input.getText();
		text.toLowerCase();
		answer.toLowerCase();
		if (text.contains(answer)) {
			display("Correct!");
			System.out.println("correct");
		}
		else {
			display("Incorrect!");
			System.out.println("incorrect");
		}

	}
	
	public static void display(String title) {
		Stage window= new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMaxHeight(0);
		window.setMaxWidth(50);
		
		Label label= new Label();
		label.setText(title);
		
		Button btnCont= new Button("Continue");
		VBox layout= new VBox(10);
		//layout.getChildren().addAll(label, btnCont);
		layout.setAlignment(Pos.CENTER);
		Scene scene= new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

		btnCont.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
		});
		
		
	}
}

