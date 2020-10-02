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
				program.setScene(gameScene);
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
		GridPane gameGrid= new GridPane();
		gameGrid.setPadding(new Insets(10,10,10,10));
		gameGrid.setVgap(8);
		gameGrid.setHgap(10);

		Label nameLabel= new Label("Please enter a nickname:");
		GridPane.setConstraints(nameLabel,0,0);

		//Label passLabel= new Label("Password: ");
		//GridPane.setConstraints(passLabel,0,1);

		TextField nameInput= new TextField("Daniel Lee");
		GridPane.setConstraints(nameInput, 1, 0);

		//TextField passInput = new TextField();
		//passInput.setPromptText("password");
		//GridPane.setConstraints(passInput, 1,1);

		//Button loginButton= new Button("Log In");
		//GridPane.setConstraints(loginButton, 1, 2);
		
		Button Category1 = new Button("Category- 1");
		GridPane.setConstraints(Category1, 1, 1);
		Category1.setPrefSize(200, 40);
		String catName1 = Category1.getText();
		System.out.println(catName1);
		
		Category1.setOnAction(e -> System.out.println("selected category 1."));
		
		Button Category2 = new Button("Category- 2");
		GridPane.setConstraints(Category2, 1, 2);
		Category2.setPrefSize(200, 40);
		String catName2 = Category2.getText();
		System.out.println(catName2);
		
		Category2.setOnAction(e -> {
			System.out.println("selected category 2.");
			SelectCategory.displayQuestion(catName2);
		}
			);
		
		Button Category3 = new Button("Category- 3");
		GridPane.setConstraints(Category3, 1, 3);
		Category3.setPrefSize(200, 40);
		String catName3 = Category3.getText();
		System.out.println(catName3);
		
		Category3.setOnAction(e -> System.out.println("selected category 3."));
		
		Button Category4 = new Button("Category- 4");
		GridPane.setConstraints(Category4, 1, 4);
		Category4.setPrefSize(200, 40);
		String catName4 = Category4.getText();
		System.out.println(catName4);
		
		Category4.setOnAction(e -> System.out.println("selected category 4."));
		
		Button Category5 = new Button("Category- 5");
		GridPane.setConstraints(Category5, 1, 5);
		Category5.setPrefSize(200, 40);
		String catName5 = Category5.getText();
		System.out.println(catName5);
		
		Category5.setOnAction(e -> System.out.println("selected category 5."));

		gameGrid.getChildren().addAll(nameLabel, nameInput, Category1, Category2, Category3, Category4, Category5);
		gameScene= new Scene(gameGrid, 400,300);
		program.setScene(gameScene);
		
		
		
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