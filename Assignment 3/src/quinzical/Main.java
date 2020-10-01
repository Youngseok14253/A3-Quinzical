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

public class Main extends Application implements EventHandler<ActionEvent>{


	private Button btnPractice;
	private Button btnGame;
	
	@Override
	public void start(Stage primaryStage) {	
		primaryStage.setTitle("Quinzical");
		        
        //btnPractice = new Button();
        //btnPractice.setText("               Practice");
        
        //btnGame = new Button();
        //btnGame.setText("Game");
        
        //btnGame.setOnAction(this);
        //btnPractice.setOnAction(this);
            HBox hbox = new HBox();
            hbox.setPadding(new Insets(15, 12, 15, 12));
            hbox.setSpacing(10);
            hbox.setStyle("-fx-background-color: #336699;");

            Button btnGame = new Button("Game");
            btnGame.setPrefSize(100, 20);

            Button btnPractice = new Button("Practice");
            btnPractice.setPrefSize(100, 20);
            hbox.getChildren().addAll(btnGame, btnPractice);
            btnGame.setOnAction(this);
            btnPractice.setOnAction(this);

        
        //StackPane layout = new StackPane();
        //layout.getChildren().add(btnPractice);
        //layout.getChildren().add(btnGame);
        
		Scene scene = new Scene(hbox,500,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void handle(ActionEvent Event) {
		if (Event.getSource() == btnGame) {
			System.out.println("game started.");
		}
		else if (Event.getSource() == btnPractice) {
			System.out.println("practice started.");
		}
	}


	
	public static void main(String[] args) {
		launch(args);
	}
}