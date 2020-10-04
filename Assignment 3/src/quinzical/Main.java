package quinzical;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.*;
import java.lang.reflect.Field;

import javafx.scene.*;

public class Main extends Application{

	Scene mainScene, gameScene, practiceScene;
	Stage program;

	@Override
	public void start(Stage primaryStage) {	
		program= primaryStage;
		Label label1= new Label("Welcome to Quinzical! Please select one of the three options to continue.");

		//Play button on main menu
		Button btnMainToGame= new Button("Play");
		btnMainToGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				createGameBoard.displayGameBoard();
			}
		});

		//Practice button on main menu
		Button btnMainToPractice= new Button("Practice Mode");
		btnMainToPractice.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				program.setScene(practiceScene);
			}
		});

		//Exit button on main menu
		Button btnMainToExit= new Button("Quit");
		btnMainToExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				closeProgram();
			}
		});


		//Closing when pressing the red X
		program.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				event.consume();
				closeProgram();

			}
		});


		//mainScene layout with VBox
		VBox mainLayout= new VBox(20);
		mainLayout.getChildren().addAll(label1, btnMainToGame, btnMainToPractice, btnMainToExit);
		mainScene= new Scene(mainLayout, 500,400);



		//gameScene layout with GridPane WE NEED TO CHANGE THIS TO FORMAT THE QUESTION BANK AND MONEY 
		
		
		
		
		//Adjusting speed of Text-to-Speech
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

		//practiceScene layout with GridPane
		GridPane practiceGrid= new GridPane();
		practiceGrid.setPadding(new Insets(10,10,10,10));
		practiceGrid.setVgap(8);
		practiceGrid.setHgap(10);
		Label answerLabel= new Label("Answer:");
		GridPane.setConstraints(answerLabel,0,0);

		TextField answerField= new TextField();
		answerField.setPromptText("answer here");

		Button submitButton= new Button("Submit");
		GridPane.setConstraints(submitButton, 1, 1);

		submitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				isInt(answerField, answerField.getText());
			}
		});

		GridPane.setConstraints(answerField,1,0);
		practiceGrid.getChildren().addAll(answerLabel, answerField, submitButton);
		practiceScene= new Scene(practiceGrid, 300,200);
		program.setScene(practiceScene);

		program.setScene(mainScene);
		program.setTitle("Quinzical");
		program.show();
	}

	private void closeProgram() {
		Boolean answer= ConfirmBox.display("Quit", "Are you sure you want to exit?");
		if(answer) {
			program.close();
		}
	}

	private boolean isInt(TextField input, String message) { //WE NEED TO CHANGE THIS TO MAKE IT VALIDATE THE INPUT AND THE CORRECT ANSWER
		try {
			int age = Integer.parseInt(input.getText());
			System.out.println("User is " +age);
			return true;
		}catch (NumberFormatException e) {
			System.out.println(message+ "is not a number");
			return false;
		}
	}


	public static void main(String[] args) {

		System.out.println(System.getProperty("user.dir"));
        
		try {
			String command = "bash createQuestionBoard";
			ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);

			Process process = pb.start();

			BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			int exitStatus = process.waitFor();
			
			if (exitStatus == 0) {
				String line;
				while ((line = stdout.readLine()) != null) {
					System.out.println(line);
				}
			} else {
				String line;
				while ((line = stderr.readLine()) != null) {
					System.err.println(line);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        


	    launch(args);
	}
}