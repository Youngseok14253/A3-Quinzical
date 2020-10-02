package quinzical;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		
		
		//Making btnGame
		Button btnGame= new Button("game button to main scene");
		btnGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				program.setScene(mainScene);
			}
		});
		
		
		//gameScene layout with GridPane
		GridPane grid= new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		Label nameLabel= new Label("Username:");
		GridPane.setConstraints(nameLabel,0,0);
		
		Label passLabel= new Label("Password: ");
		GridPane.setConstraints(passLabel,0,1);
		
		TextField nameInput= new TextField("dlee432");
		GridPane.setConstraints(nameInput, 1, 0);
		
		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1,1);
		
		Button loginButton= new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2);
		
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
		gameScene= new Scene(grid, 300,200);
		program.setScene(gameScene);
		
		
		//Making btnPractice
		Button btnPractice= new Button("practice button to main scene");
		btnPractice.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				program.setScene(mainScene);
			}
		});
		
		
		//practiceScene layout with StackPane
		StackPane layout3= new StackPane();
		layout3.getChildren().add(btnPractice);
		practiceScene= new Scene(layout3, 600,300);
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


	public static void main(String[] args) {
		launch(args);
	}
}