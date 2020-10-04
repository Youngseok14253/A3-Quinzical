package quinzical;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
		Label label1= new Label("Welcome to Quinzical!");
		GridPane.setConstraints(label1, 1, 0);

		//Play button on main menu
		Button btnMainToGame= new Button("Play");
		GridPane.setConstraints(btnMainToGame, 1, 1);
		btnMainToGame.setMinSize(300,100);
		btnMainToGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				createGameBoard.displayGameBoard();
			}
		});

		//Practice button on main menu
		Button btnMainToPractice= new Button("Practice Mode");
		GridPane.setConstraints(btnMainToPractice, 1, 2);
		btnMainToPractice.setMinSize(300, 100);
		btnMainToPractice.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				createPracticeBoard.displayPracticeBoard();
			}
		});

		//Exit button on main menu
		Button btnMainToExit= new Button("Quit");
		GridPane.setConstraints(btnMainToExit, 1, 3);
		btnMainToExit.setMinSize(300, 100);
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


		//mainScene layout with GridPane
		//VBox mainLayout= new VBox(20);
		GridPane mainLayout= new GridPane();
		mainLayout.setPadding(new Insets(10,10,10,10));
		mainLayout.setVgap(8);
		mainLayout.setHgap(10);
		mainLayout.getChildren().addAll(label1, btnMainToGame, btnMainToPractice, btnMainToExit);
		mainScene= new Scene(mainLayout, 500,400);		
		
		
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

		program.setScene(mainScene);
		mainScene.getStylesheets().add(getClass().getResource("mainMenu.css").toExternalForm());
		program.setTitle("Quinzical");
		program.show();
	}

	private void closeProgram() {
		Boolean answer= ConfirmBox.display("Quit", "Are you sure you want to exit?");
		if(answer) {
			program.close();
		}
	}

	public static void main(String[] args) {

		System.out.println(System.getProperty("user.dir"));
        
		try {
			String command = "bash CreateCategories";
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
		
		try {
			String command = "ls";
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