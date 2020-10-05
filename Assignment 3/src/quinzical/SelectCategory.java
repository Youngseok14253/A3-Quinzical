package quinzical;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javafx.geometry.*;

public class SelectCategory {



	public static void displayQuestion(String categoryName) {

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
		qAndA= getQuestion.displayQuestion(categoryName);

		String[] arrQAndA= qAndA.split("@",3);
		String question = arrQAndA[0];
		String answer= arrQAndA[2];
		//String what= arrQAndA[1];
		label.setText(question);

		TextField answerField= new TextField();
		Button submitButton = new Button("Submit");
		
		submitButton.setOnAction(e -> {
				CompareAnswer.isAnswerPractice(answerField, answer, 0);
				window.close();
		});
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(playbackMenu);

		Button closeButton = new Button("Return");
		closeButton.setOnAction(e -> window.close());

		VBox layout = new VBox(menuBar);

		layout.getChildren().addAll(label,warning,answerField,submitButton, closeButton);


		//need to position individual nodes in VBox
		//setting up a new repository due to network changes




		Scene scene = new Scene(layout, 400, 400);
		window.setScene(scene);
		window.showAndWait();

	}
}
