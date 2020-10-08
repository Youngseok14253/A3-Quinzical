package quinzical;

import javafx.stage.*;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class AnswerQuestion {



	public static void displayQuestion(String categoryName, String mode) {

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

		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(categoryName);
		window.setMinWidth(400);


		Label label = new Label();
		Label warning= new Label("Do not include prefixes in your answer");
		String qAndA = new String();
		Label whatIsAre= new Label();
		Label blank= new Label(" ");
		
		qAndA= GetQuestion.returnQuestionFormat(categoryName);

		String[] arrQAndA= qAndA.split("@",3);
		String question = arrQAndA[0];
		String answer= arrQAndA[2];
		String whatVal= arrQAndA[1];
		
		whatIsAre.setText(whatVal);
		label.setText(question);

		CompareAnswer.setCount();
		
		TextField answerField= new TextField();
		Button submitButton = new Button("Submit");
		submitButton.setOnAction(e -> {
				boolean ans= CompareAnswer.compareAnswerToInput(answerField, answer);
				if (ans == true) {
					CompareAnswer.display("Correct!");
					//if (mode.equals("Game")) {
					//	ConfirmBox.showAnswer(answer);
					//	window.close();
						//Show current winnings
					//}
					CompareAnswer.setCount();
					window.close();
					
				}
				
				else {
					CompareAnswer.display("Incorrect!");
					if (mode.equals("Game")) {
						ConfirmBox.showAnswer(answer);
						window.close();
						//Show current winnings
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
				Boolean answer= ConfirmBox.display("Give Up Question?", "This will count as an incorrect answer if you are in Game Mode");
				if(answer) {
				window.close();
				}
			}
		});
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(playbackMenu);


		VBox layout = new VBox(menuBar);

		layout.getChildren().addAll(label,warning,blank,whatIsAre,answerField,submitButton);

		Scene scene = new Scene(layout, 600, 400);
		window.setScene(scene);
		window.showAndWait();

	}
}
