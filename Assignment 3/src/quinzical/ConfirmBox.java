package quinzical;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	static boolean answer;

	public static boolean display(String title, String message) {
		Stage window= new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		Label label= new Label();
		label.setText(message);

		//Creating two buttons
		Button btnYes= new Button("Yes");
		Button btnNo= new Button("No");

		btnYes.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				answer= true;
				window.close();
			}
		});
		btnNo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				answer=false;
				window.close();
			}
		});
		
		VBox layout= new VBox(10);
		layout.getChildren().addAll(label, btnYes, btnNo);
		layout.setAlignment(Pos.CENTER);
		Scene scene= new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
}
