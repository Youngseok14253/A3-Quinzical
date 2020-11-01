package quinzical.score;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class provides the implementation of displaying the winnings after the
 * user plays the game on Game mode. This class consists of multiple getters and
 * setters to keep track of which questions were answered correctly and
 * accurately declare a total amount of winnings after the game is finished.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 *
 */

public class ShowWinnings {

	public static int categoryOneCount;
	public static int categoryTwoCount;
	public static int categoryThreeCount;
	public static int categoryFourCount;
	public static int categoryFiveCount;
	public static int categoryInternationalCount;
	public static int totalWinnings;

	public static void saveCategory(String catName) {

	}

	// Below are the getters and setters for the random Category 1.

	public static void setOneCount() {
		categoryOneCount = 1;
	}

	public static int getOneCount() {
		return categoryOneCount;
	}

	public static void incrementOneCount() {
		categoryOneCount++;
	}

	public static boolean isOneLimit() {
		if (categoryOneCount == 6) {
			return true;
		} else {
			return false;
		}
	}

	// Below are the getters and setters for the random Category 2.

	public static void setTwoCount() {
		categoryTwoCount = 1;
	}

	public static int getTwoCount() {
		return categoryTwoCount;
	}

	public static void incrementTwoCount() {
		categoryTwoCount++;
	}

	public static boolean isTwoLimit() {
		if (categoryTwoCount == 6) {
			return true;
		} else {
			return false;
		}
	}

	// Below are the getters and setters for the random Category 3.

	public static void setThreeCount() {
		categoryThreeCount = 1;
	}

	public static int getThreeCount() {
		return categoryThreeCount;
	}

	public static void incrementThreeCount() {
		categoryThreeCount++;
	}

	public static boolean isThreeLimit() {
		if (categoryThreeCount == 6) {
			return true;
		} else {
			return false;
		}
	}

	// Below are the getters and setters for the random Category 4.

	public static void setFourCount() {
		categoryFourCount = 1;
	}

	public static int getFourCount() {
		return categoryFourCount;
	}

	public static void incrementFourCount() {
		categoryFourCount++;
	}

	public static boolean isFourLimit() {
		if (categoryFourCount == 6) {
			return true;
		} else {
			return false;
		}
	}

	// Below are the getters and setters for the random Category 5.

	public static void setFiveCount() {
		categoryFiveCount = 1;
	}

	public static int getFiveCount() {
		return categoryFiveCount;
	}

	public static void incrementFiveCount() {
		categoryFiveCount++;
	}

	public static boolean isFiveLimit() {
		if (categoryFiveCount == 6) {
			return true;
		} else {
			return false;
		}
	}
	
	// Below are the getters and setters for the International Category.
	
	public static void setInternationalCount() {
		categoryInternationalCount = 1;
	}

	public static int getInternationalCount() {
		return categoryInternationalCount;
	}

	public static void incrementInternationalCount() {
		categoryInternationalCount++;
	}

	public static boolean isInternationalLimit() {
		if (categoryInternationalCount == 6) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * This method adds all the winnings to find out the total amount of winnings.
	 *
	 * @param val The question number from that certain category.
	 *
	 */
	public static void addToWinnings(int val) {
		totalWinnings = totalWinnings + (val * 100);
	}

	/*
	 * This method returns the total winnings that was added up from the above
	 * method
	 * 
	 * @return totalWinnings The total winnings of one game on Game mode.
	 *
	 */
	public static int returnTotalWinnings() {
		return totalWinnings;
	}

	/*
	 * This method implements the launch of the winnings window.
	 *
	 */

	public static String[] rewardScreen() {
		
		//stores the name and total winnings in a string array
		String[] nameAndScore = new String[2];
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Rewards");
		window.setMinWidth(250);

		Label label = new Label();
		label.setText("Congratulations, you earned:");
		Label winnings = new Label();
		winnings.setText("$" + totalWinnings);
		
		Label enterName= new Label();
		enterName.setText("Please enter a nickname:");
		TextField nickname= new TextField();
		nickname.setPromptText("John");

		// Creating two buttons
		Button submit = new Button("Submit");

		// Back to main menu if this button is pressed
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String name= nickname.getText();
			
				// Resetting the count of the category questions so that
				// the implementation of winnings is reset.
				ShowWinnings.setOneCount();
				ShowWinnings.setTwoCount();
				ShowWinnings.setThreeCount();
				ShowWinnings.setFourCount();
				ShowWinnings.setFiveCount();
				ShowWinnings.setInternationalCount();
				
				//stores name
				nameAndScore[0] = name;

				window.close();
				
				ArrayList<String> score= HighScore.returnScores();
				HighScore.displayScores(score,name,totalWinnings);

			}
			
		});


		// The ShowWinnings layout is a VBox layout
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, winnings,enterName,nickname,submit);

		// Setting up general interface visuals.
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #AAAAAA;");

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		//stores total winnings
		nameAndScore[1] = Integer.toString(totalWinnings);
		
		return nameAndScore;
	}
	
	

}