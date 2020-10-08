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

public class ShowWinnings {
	
	public static int categoryOneCount;
	public static int categoryTwoCount;
	public static int categoryThreeCount;
	public static int categoryFourCount;
	public static int categoryFiveCount;
	
	
	public static void saveCategory(String catName) {
		
	}
	
	public static void setOneCount() {
		categoryOneCount = 6;
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
		}
		else {
			return false;
		}
	}
	
	public static void setTwoCount() {
		categoryTwoCount = 6;
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
		}
		else {
			return false;
		}
	}
	public static void setThreeCount() {
		categoryThreeCount = 6;
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
		}
		else {
			return false;
		}
	}
	public static void setFourCount() {
		categoryFourCount = 6;
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
		}
		else {
			return false;
		}
	}
	public static void setFiveCount() {
		categoryFiveCount = 5;
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
		}
		else {
			return false;
		}
	}
	public static void rewardScreen() {
		Stage window= new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Rewards");
		window.setMinWidth(250);
		Label label= new Label();
		int totalWinnings= 0; //need to find way to find total winnings
		label.setText("Congratulations, you earned "+ totalWinnings+"!");

		//Creating two buttons
		Button btnMainMenu= new Button("Return to Main Menu");
		Button btnPlayAgain= new Button("Play Again");
		
		//Back to main menu if this button is pressed
		btnMainMenu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ShowWinnings.setOneCount();
				ShowWinnings.setTwoCount();
				ShowWinnings.setThreeCount();
				ShowWinnings.setFourCount();
				ShowWinnings.setFiveCount();
				ShowWinnings.categoryOneCount=1;
				ShowWinnings.categoryTwoCount=1;
				ShowWinnings.categoryThreeCount=1;
				ShowWinnings.categoryFourCount=1;
				ShowWinnings.categoryFiveCount=1;
				window.close();
			}
		});
		
		//Play again if this button is pressed
		btnPlayAgain.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
		});
		
		VBox layout= new VBox(10);
		layout.getChildren().addAll(label, btnPlayAgain, btnMainMenu);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #AAAAAA;");
		Scene scene= new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

}
