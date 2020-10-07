package quinzical;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;

/**
 * This Main class provides the launch of the Quinzical GUI. It mainly implements CreateGameBoard 
 * and CreatePracticeBoard classes, and ConfirmBox if the user wishes to exit the game.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 *
 */
public class Main extends Application{

	Scene mainScene, gameScene, practiceScene;
	Stage program;
	
	/*
	* This is the first GUI the user is greeted with - the main menu of Quinzical.
	* Here, the user can select 3 options - Game mode, Practice mode, or Quit.
	*
	* @param input primaryStage The stage called by the launch method
	* 
	*/
	@Override
	public void start(Stage primaryStage) {	
		
		program = primaryStage;
		
		Label label1= new Label("Welcome to Quinzical!");
		GridPane.setConstraints(label1, 1, 0);

		//Game button
		Button btnMainToGame= new Button("Game Mode");
		GridPane.setConstraints(btnMainToGame, 1, 1);
		btnMainToGame.setMinSize(300,100);
		
		btnMainToGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CreateGameBoard.displayGameBoard();
			}
		});

		//Practice button 
		Button btnMainToPractice= new Button("Practice Mode");
		GridPane.setConstraints(btnMainToPractice, 1, 2);
		btnMainToPractice.setMinSize(300, 100);
		
		btnMainToPractice.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CreatePracticeBoard.displayPracticeBoard();
			}
		});

		//Quit button 
		Button btnMainToExit= new Button("Quit");
		GridPane.setConstraints(btnMainToExit, 1, 3);
		btnMainToExit.setMinSize(300, 100);
		
		btnMainToExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				closeProgram();
			}
		});


		//Closing when pressing the red X at top right corner
		//Asks the user to confirm, rather than exit immediately
		program.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				event.consume();
				closeProgram();

			}
		});


		//This is the main scene/window 
		//mainScene layout with GridPane
		GridPane mainLayout= new GridPane();
		mainLayout.setPadding(new Insets(10,10,10,10));
		mainLayout.setVgap(8);
		mainLayout.setHgap(10);
		mainLayout.getChildren().addAll(label1, btnMainToGame, btnMainToPractice, btnMainToExit);
		mainScene= new Scene(mainLayout, 500,400);		
		
		
		program.setScene(mainScene);
		mainScene.getStylesheets().add(getClass().getResource("mainMenu.css").toExternalForm());
		program.setTitle("Quinzical");
		program.show();
		
	}

	/*
	 * This method creates a confirmation window when the user tries to exit the game.
	 * Called by the Quit button and the red X.
	 * 
	 */
	private void closeProgram() {
		Boolean answer= ConfirmBox.display("Quit Program", "Are you sure you want to exit?");
		if(answer) {
			program.close();
		}
	}

	public static void main(String[] args) {
		
		//The try and catch method calls the CreateCategories bash function
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
		
		//Launches the game
	    launch(args);
	}
}