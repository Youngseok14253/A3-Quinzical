package quinzical;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;

public class CompareAnswer{
	
	public static void isAnswerPractice(TextField input, String answer, int tries) {
		String title= "Confirmation";
		String text= input.getText();
		text.toLowerCase();
		System.out.println(text);
		answer.toLowerCase();
		System.out.println(answer);
		if (text.equals(answer)) {
			display(title, "Correct!");
		}
		else {
			display(title, "Incorrect!");
		}

	}
	
	public static void display(String title,String message) {
		Stage window= new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(200);
		
		Label label= new Label();
		label.setText(message);
		
		Button btnCont= new Button("Continue");
		

		btnCont.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
		});
		VBox layout= new VBox(10);
		layout.getChildren().addAll(label, btnCont);
		layout.setAlignment(Pos.CENTER);
		Scene scene= new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		
	}
}

