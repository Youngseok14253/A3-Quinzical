package quinzical;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.ArrayList;

/**
 * This Main class provides the launch of the Quinzical GUI. It mainly implements CreateGameBoard 
 * and CreatePracticeBoard classes, and ConfirmBox if the user wishes to exit the game.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 *
 */
public class Main extends Application{

	Scene mainScene, gameScene, practiceScene;
	public Stage program;
	
	/*
	* This is the first GUI the user is greeted with - the main menu of Quinzical.
	* Here, the user can select 3 options - Game mode, Practice mode, or Quit.
	*
	* @param input primaryStage The stage called by the launch method
	* 
	*/
	@Override
	public void start(Stage primaryStage) {	
		
		MockGameBoard.displayGameBoard();
		
		program = primaryStage;
		
		Label label1= new Label("Welcome to Quinzical!");
		GridPane.setConstraints(label1, 1, 0);
		
		ShowWinnings.setOneCount();
		ShowWinnings.setTwoCount();
		ShowWinnings.setThreeCount();
		ShowWinnings.setFourCount();
		ShowWinnings.setFiveCount();
		
		final ArrayList<String> Categories = MockGameBoard.displayGameBoard();

		//Game button
		Button btnMainToGame= new Button("Game Mode");
		btnMainToGame.setPrefSize(335, 50);
		GridPane.setConstraints(btnMainToGame, 1, 1);
		
		btnMainToGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//CreateGameBoard.displayGameBoard();
				DisplayGameBoard.displayGameBoard(Categories);
			}
		});

		//Practice button 
		Button btnMainToPractice= new Button("Practice Mode");
		btnMainToPractice.setPrefSize(335, 50);
		GridPane.setConstraints(btnMainToPractice, 1, 2);
		
		btnMainToPractice.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CreatePracticeBoard.displayPracticeBoard();
			}
		});

		//Quit button 
		Button btnMainToExit= new Button("Quit");
		btnMainToExit.setPrefSize(335, 50);
		GridPane.setConstraints(btnMainToExit, 1, 3);
		
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
		
		label1.setFont(new Font("Cavolini", 30));
		btnMainToGame.setFont(new Font("Arial",20));
		btnMainToPractice.setFont(new Font("Arial",20));
		btnMainToExit.setFont(new Font("Arial",20));
		mainLayout.setAlignment(Pos.CENTER);
		mainScene= new Scene(mainLayout, 500,400);		
		
		
		program.setScene(mainScene);
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
			
			//The try and catch method removes created Category-* formats
			try {
				String command = "rm -f Category-*";
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