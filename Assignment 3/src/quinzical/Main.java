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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Main extends Application{

	Scene mainScene, gameScene, practiceScene;

	@Override
	public void start(Stage primaryStage) {	
		
		Label label1= new Label("Welcome to Quinzical! Please select one of the three options to continue.");

		Button btnMainToGame= new Button("main menu button to game scene");
		btnMainToGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(gameScene);
			}
		});
		Button btnMainToPractice= new Button("main menu button to practice scene");
		btnMainToPractice.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(practiceScene);
			}
		});
		Button btnMainToExit= new Button("main menu button to exit scene");
		btnMainToExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		//mainScene layout with VBox
		VBox mainLayout= new VBox(20);
		mainLayout.getChildren().addAll(label1, btnMainToPractice, btnMainToGame, btnMainToExit);
		mainScene= new Scene(mainLayout, 500,400);
		
		//Making btnGame
		Button btnGame= new Button("game button to main scene");
		btnGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(mainScene);
			}
		});
		//gameScene layout with StackPane
		StackPane layout2= new StackPane();
		layout2.getChildren().add(btnGame);
		gameScene= new Scene(layout2, 600, 300);
		
		//Making btnPractice
		Button btnPractice= new Button("practice button to main scene");
		btnPractice.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(mainScene);
			}
		});
		//practiceScene layout with StackPane
		StackPane layout3= new StackPane();
		layout3.getChildren().add(btnPractice);
		practiceScene= new Scene(layout3, 600,300);

		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Quinzical");
		primaryStage.show();
	}



	public static void main(String[] args) {
		launch(args);
	}
}