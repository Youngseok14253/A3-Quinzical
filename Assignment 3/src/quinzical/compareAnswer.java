package quinzical;

import java.awt.Label;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class compareAnswer{
	public static boolean isAnswerPractice(TextField input, String answer) {
		String text= input.getText();
		text.toLowerCase();
		answer.toLowerCase();
		int count=0;
		while (count<3) {
			if (text.equals(answer)) {
				System.out.println("corect");
				return true;
			}
			else if (count==2) {
				showHint(answer);
			}
			else {
				System.out.println("iuncrect");
			}
			count++;
		}
	return false;
	}
	private static void showHint(String answer) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Hint");
		window.setMinWidth(200);
		
		Label hint= new Label();
		hint.setText("The first letter is "+ answer.charAt(0));
		Button confirm= new Button("Continue");
		
		VBox layout= new VBox(10);
		//layout.getChildren().addAll(hint, confirm);
		layout.setAlignment(Pos.CENTER);
		Scene scene= new Scene(layout);
		answer.toUpperCase();
		window.setScene(scene);
		window.showAndWait();		
		confirm.setOnAction(e -> window.close());
	}
}
