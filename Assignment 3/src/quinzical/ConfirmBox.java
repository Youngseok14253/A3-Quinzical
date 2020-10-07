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

/**
 * This class provides the display method for the Main class when the user asks to exit the game.
 * It confirms that the user wants to exit and quits the game, and also makes sure that a misclick
 * by the user does not result in a shutdown.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 *
 */
public class ConfirmBox {
	
	private static boolean answer;

	/*
	 * This method returns a boolean value depending on the confirmation of the user when pressing
	 * the exit buttons provided in the Main class. A true is returned when the Yes button is pressed,
	 * or vice versa for the No button. 
	 * 
	 * @return A boolean value (true for Yes, false for No)
	 * 
	 */
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

		//return true if Yes is pressed
		btnYes.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				answer= true;
				window.close();
			}
		});
		
		//return false if No is pressed
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
