package quinzical.question;

import javafx.stage.*;
import quinzical.score.ShowWinnings;
import quinzical.utility.ConfirmBox;
import quinzical.utility.Help;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

/**
 * This AnswerQuestion Class provides a display method for the user to read,
 * listen and answer the question. The window, depending on the mode the user
 * has selected, displays the question (either in text and/or via audio), allows
 * the user to adjust the speed to of the audio, and submit an answer in the
 * text-field given. This class is called by the Display classes when the user
 * selects a category on the Board.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 * 
 */
public class AnswerQuestion {
	/*
	 * This method creates a new window, where it displays a question (either
	 * text/audio) from the Question Bank corresponding to the selected category and
	 * waits for the user to submit an answer.
	 * 
	 * @param categoryName The name of the Category in th Question Bank
	 * 
	 * @param mode The mode (Game or Practice)
	 * 
	 * @param categoryNumber The integer assigned to the Category when it is
	 * formatted
	 *
	 */
	public static void displayQuestion(String categoryName, String mode, int categoryNumber) {
		
		//Stage for the timer
		Stage timerWindow = new Stage();

		// This menu item adjusts the speed of TTS
		Menu playbackMenu = new Menu("Playback Speed");
		ToggleGroup playbackSpeed = new ToggleGroup();

		// Six different speeds which the user can adjust
		RadioMenuItem halfSpeed = new RadioMenuItem("x0.50");
		RadioMenuItem slowSpeed = new RadioMenuItem("x0.75");
		RadioMenuItem normalSpeed = new RadioMenuItem("x1.00");
		RadioMenuItem quickSpeed = new RadioMenuItem("x1.50");
		RadioMenuItem fastSpeed = new RadioMenuItem("x1.75");
		RadioMenuItem doubleSpeed = new RadioMenuItem("x2.00");

		halfSpeed.setToggleGroup(playbackSpeed);
		slowSpeed.setToggleGroup(playbackSpeed);
		normalSpeed.setToggleGroup(playbackSpeed);
		quickSpeed.setToggleGroup(playbackSpeed);
		fastSpeed.setToggleGroup(playbackSpeed);
		doubleSpeed.setToggleGroup(playbackSpeed);

		// Adds the items to the PlayBack menu
		playbackMenu.getItems().addAll(halfSpeed, slowSpeed, normalSpeed, quickSpeed, fastSpeed, doubleSpeed);

		// This menu item shows the Help window
		Menu helpMenu = new Menu("Help");

		// Pressing the "Answering Questions" button under the help menu will call
		// displayHowToAnswer method,
		// which displays a window with a help 'manual'
		Menu answerHelp = new Menu("Answering Questions");
		answerHelp.setOnAction(e -> Help.displayHowToAnswer());

		// Adds the item to the Help menu
		helpMenu.getItems().add(answerHelp);

		// New Stage, set limits
		Stage window = new Stage();

		//window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(categoryName);
		window.setMinWidth(600);
		window.setMinHeight(200);

		// Initialise labels
		Label label = new Label();
		Label warning = new Label();
		Label whatIsAre = new Label();
		String qAndA = new String();

		// Initialise answering field and submit button
		TextField answerField = new TextField();
		answerField.setMinWidth(100);
		Button submitButton = new Button("Submit");

		// Calls the returnQuestionFormat method, which will return a line from the
		// corresponding Category
		// from the formatted QuestionBannk (Category-*) in Question/What/Answer form
		qAndA = GetQuestion.returnQuestionFormat(categoryName, mode);

		// Splits the String (Q/W/A) into a String Array, then back into its
		// respectively named Strings
		String[] arrQAndA = qAndA.split("@", 3);
		String question = arrQAndA[0];
		String answer = arrQAndA[2];
		String whatVal = arrQAndA[1];

		// Set text to labels after getting the Question/What/Answer
		warning.setText("\nSee help Menu for acceptable answer formats");
		whatIsAre.setText("\n" + whatVal + ":");
		label.setText(question + "...");
		
		// Calls the setCount method, where the count becomes 1
		// This count is used to check the number of user attempts when answering a
		// Question
		// If in Practice Mode, and the count becomes 2, then the hint is shown
		CompareAnswer.setCount();

		// If the submit button is pressed, then it passes the user input and answer
		// into the compareAnswerToInput
		// method, and stores the boolean value output
		submitButton.setOnAction(e -> {
			
			//Method closes timer window, and makes sure "out of time" window does not appear
			Timer.submitBeforeTime(timerWindow);
			
			boolean ans = CompareAnswer.compareAnswerToInput(answerField, answer);
			
			// If the answer is true, and in Game Mode, then it displays "Correct", and
			// increments
			// the count of the selected category (from 1 to 5) by 1
			if (ans == true) {
				CompareAnswer.display("Correct, Ka pai!");
				if (mode.equals("Game")) {
					if (categoryNumber == 1) {
						ShowWinnings.addToWinnings(ShowWinnings.getOneCount());
					}
					if (categoryNumber == 2) {
						ShowWinnings.addToWinnings(ShowWinnings.getTwoCount());
					}

					if (categoryNumber == 3) {
						ShowWinnings.addToWinnings(ShowWinnings.getThreeCount());
					}

					if (categoryNumber == 4) {
						ShowWinnings.addToWinnings(ShowWinnings.getFourCount());
					}
					if (categoryNumber == 5) {
						ShowWinnings.addToWinnings(ShowWinnings.getFiveCount());
					}
					if (categoryNumber == 6) {
						ShowWinnings.addToWinnings(ShowWinnings.getInternationalCount());
					}
				}

				// The count for the attempts resets, and the window closes
				CompareAnswer.setCount();
				window.close();

			}

			else {
				// If the answer is false, and in Game Mode, then it displays "Incorrect", and
				// exits
				CompareAnswer.display("Incorrect!");
				if (mode.equals("Game")) {
					ConfirmBox.showAnswer(answer);
					// updateValue(categoryNumber);
					window.close();
				}
			}

			// Otherwise, in Practice Mode, a hint is given if the attempts equals to 2
			// and exits after the user submits incorrectly for the third and final time
			int val = CompareAnswer.getCount();

			if (val == 2) {
				char hint = answer.charAt(0);
				ConfirmBox.displayHint(hint);
			} else if (val == 3) {
				ConfirmBox.showAnswer(answer);
				CompareAnswer.setCount();
				window.close();
			}

			CompareAnswer.incrementCount();

		});

		// If the user tries to close the window, a warning message will appear asking
		// them if they are sure
		// they want to exit - since the exit will count as a loss
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				event.consume();
				Boolean answer = ConfirmBox.display("Give Up Question?", "\t\t  (In Game Mode),"
						+ "\nThis will count as an incorrect answer," + "\nand the answer will not be revealed.");
				if (answer) {
					window.close();
				}
			}
		});

		// Add PlayBack and Help to the Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(playbackMenu, helpMenu);

		// Create the layout and show the scene
		VBox layout = new VBox(menuBar);
		layout.setAlignment(Pos.TOP_CENTER);

		layout.getChildren().addAll(label, whatIsAre, answerField, submitButton, warning);

		Scene scene = new Scene(layout, 600, 200);
		window.setScene(scene);
		
		// Creating the timer for the question
		Timer time= new Timer();
		time.showTimer(timerWindow, window);		
		
		window.showAndWait();

	}

}