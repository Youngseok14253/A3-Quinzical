package quinzical;

import javafx.stage.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class AnswerQuestion {


	public static void displayQuestion(String categoryName, String mode, int categoryNumber) {

		Menu playbackMenu = new Menu("Playback Speed");
		ToggleGroup playbackSpeed = new ToggleGroup();

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

		playbackMenu.getItems().addAll(halfSpeed, slowSpeed, normalSpeed, quickSpeed, fastSpeed, doubleSpeed);
		
		Menu helpMenu = new Menu("Help");
		
		Menu answerHelp = new Menu("Answering Questions");
		answerHelp.setOnAction(e -> Help.displayHowToAnswer());
		
		helpMenu.getItems().add(answerHelp);
		

		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(categoryName);
		window.setMinWidth(600);
		window.setMinHeight(200);


		Label label = new Label();
		Label warning= new Label("\nSee help Menu for acceptable answer formats");
		String qAndA = new String();
		Label whatIsAre= new Label();


		qAndA= GetQuestion.returnQuestionFormat(categoryName, mode);

		String[] arrQAndA= qAndA.split("@",3);
		String question = arrQAndA[0];
		String answer= arrQAndA[2];
		String whatVal= arrQAndA[1];

		whatIsAre.setText("\n" + whatVal + ":");
		label.setText(question + "...");

		CompareAnswer.setCount();
		TextField answerField= new TextField();
		answerField.setMinWidth(100);
		Button submitButton = new Button("Submit");
		
		submitButton.setOnAction(e -> {
			boolean ans= CompareAnswer.compareAnswerToInput(answerField, answer);
			if (ans == true) {
				CompareAnswer.display("Correct!");
				if (mode.equals("Game")) {
					if (categoryNumber==1) {
						ShowWinnings.addToWinnings(ShowWinnings.getOneCount());
					}
					if (categoryNumber==2) {
						ShowWinnings.addToWinnings(ShowWinnings.getTwoCount());
					}

					if (categoryNumber==3) {
						ShowWinnings.addToWinnings(ShowWinnings.getThreeCount());
					}

					if (categoryNumber==4) {
						ShowWinnings.addToWinnings(ShowWinnings.getFourCount());
					}
					if (categoryNumber==5) {
						ShowWinnings.addToWinnings(ShowWinnings.getFiveCount());
					}

				}
				
				CompareAnswer.setCount();
				window.close();

			}

			else {
				CompareAnswer.display("Incorrect!");
				if (mode.equals("Game")) {
					ConfirmBox.showAnswer(answer);
					//updateValue(categoryNumber);
					window.close();
				}
			}

			int val = CompareAnswer.getCount();

			if (val == 2) {
				char hint= answer.charAt(0);
				ConfirmBox.displayHint(hint);
			} else if (val == 3) {
				ConfirmBox.showAnswer(answer);
				CompareAnswer.setCount();
				window.close();
			}
			CompareAnswer.incrementCount();

		});

		window.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				event.consume();
				Boolean answer= ConfirmBox.display("Give Up Question?", "\t\t  (In Game Mode)," +
				"\nThis will count as an incorrect answer," + 
				"\nand the answer will not be revealed.");
				if(answer) {
					window.close();
				}
			}
		});

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(playbackMenu, helpMenu);


		VBox layout = new VBox(menuBar);
		layout.setAlignment(Pos.TOP_CENTER);

		layout.getChildren().addAll(label,whatIsAre,answerField,submitButton, warning);
		

		Scene scene = new Scene(layout, 600, 200);
		window.setScene(scene);
		window.showAndWait();

	}
}