package quinzical.question;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This Timer class provides the functionality of the Timer function and window.
 * This class includes methods that will time how long the question has been
 * displayed for and then close the window appropriately.
 *
 * @author Do Hyun Lee, Youngseok Chae
 *
 */
public class Timer {

	// Private class constant and some variables
	private static final Integer STARTTIME = 20;
	private Timeline timeline;
	private Label timerLabel = new Label();
	private Integer timeSeconds = STARTTIME;
	private static int isSubmitPressed = 0;

	/**
	 * This method opens a window that shows the remaining time for the user to
	 * answer the given question. This window will close once the timer reaches 0.
	 * 
	 * @param timerWindow    the Timer window
	 * @param questionWindow the Question/Answer window
	 * @param mode			 the type of mode: game or practice
	 */
	public void showTimer(Stage timerWindow, Stage questionWindow, String mode) {
		if (mode== "Game") {
			// Setup the Stage and the Scene (the scene graph)
			Group root = new Group();
			Scene scene = new Scene(root, 300, 250);

			// Configure the Label
			timerLabel.setText(timeSeconds.toString());
			timerLabel.setTextFill(Color.RED);
			timerLabel.setFont(new Font("Arial", 70));

			if (timeline != null) {
				timeline.stop();
			}
			timeSeconds = STARTTIME;

			// update timerLabel
			timerLabel.setText(timeSeconds.toString());
			timeline = new Timeline();
			timeline.setCycleCount(Timeline.INDEFINITE);
			timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
				// KeyFrame event handler
				public void handle(ActionEvent event) {
					timeSeconds--;
					// update timerLabel
					timerLabel.setText(timeSeconds.toString());
					if (timeSeconds <= 0) {
						timeline.stop();
						timerWindow.close();
						// checks if submit button is pressed, if not the "out of time" window is shown
						if (isSubmitPressed <= 0) {
							timeUp(questionWindow);
						}
						else {
							//do nothing, this prevents the time up window to appear from previous questions
						}
						System.out.println(isSubmitPressed);
						// reset count
						isSubmitPressed--;
					}
				}
			}));
			timeline.playFromStart();

			// Create and configure VBox
			// gap between components is 20
			VBox vb = new VBox(20);
			// center the components within VBox
			vb.setAlignment(Pos.CENTER);
			// Make it as wide as the application frame (scene)
			vb.setPrefWidth(scene.getWidth());
			// Move the VBox down a bit
			vb.setLayoutY(30);
			// Add the button and timerLabel to the VBox
			vb.getChildren().addAll(timerLabel);
			vb.setLayoutX(0);
			// Add the VBox to the root component
			root.getChildren().add(vb);

			timerWindow.setScene(scene);
			timerWindow.setX(850);
			timerWindow.setY(650);
			timerWindow.show();
		}
	}

	/**
	 * This method is called once the timer reaches 0. This method opens a new
	 * window that will display that the time is up. Once the user confirms that
	 * they have seen this message, this will close the question window as well,
	 * counting the answer to be incorrect and gaining no winnings.
	 * 
	 * @param questionWindow the Question/Answer window
	 */
	public void timeUp(Stage questionWindow) {
		Stage window = new Stage();
		Group root = new Group();
		Scene scene = new Scene(root, 300, 250);
		Label noTime = new Label("Time is up!");
		noTime.setFont(new Font("Arial", 35));
		Button confirm = new Button("Confirm");
		confirm.setFont(new Font("Arial", 35));
		// This button closes the window and calls a method to close the
		// question window as well.
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
				// closes the question/answer window
				questionWindow.close();
			}
		});

		// gap between components is 20
		VBox vb = new VBox(20);
		// center the components within VBox
		vb.setAlignment(Pos.CENTER);
		// Make it as wide as the application frame (scene)
		vb.setPrefWidth(scene.getWidth());
		// Move the VBox down a bit
		vb.setLayoutY(30);
		// Add the button and timerLabel to the VBox
		vb.getChildren().addAll(noTime, confirm);
		// Add the VBox to the root component
		root.getChildren().add(vb);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setScene(scene);
		window.show();

	}

	/**
	 * This method is called when the submit button is pressed by the user after
	 * typing their answer to the question. It closes the timer window, and
	 * increments the value of isSubmitPressed by 1 so that the "out of time" window
	 * is never shown.
	 * 
	 * @param timerWindow the Timer window
	 */
	public static void submitBeforeTime(Stage timerWindow) {
		timerWindow.close();

		// since submit is pressed, change value to 1
		isSubmitPressed++;
	}
}
