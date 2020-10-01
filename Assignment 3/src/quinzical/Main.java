package quinzical;

import javafx.application.Application;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Main extends Application{


	private Button btnPractice;
	private Button btnGame;

	@Override
	public void start(Stage primaryStage) {	
		primaryStage.setTitle("Quinzical");

		btnPractice = new Button();
		btnPractice.setText("               Practice");

		btnGame = new Button();
		btnGame.setText("Game");

		btnGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("testing for eventhandler");
			}
		});
		btnPractice.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("testing for eventhandler p[ractice");
			}
		});

		StackPane layout = new StackPane();
		layout.getChildren().add(btnPractice);
		layout.getChildren().add(btnGame);

		Scene scene = new Scene(layout,500,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}



	public static void main(String[] args) {
		launch(args);
	}
}