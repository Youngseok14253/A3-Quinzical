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

import java.awt.Desktop;
import java.io.*;
import java.util.ArrayList;

/**
 * This Main class provides the launch of the Quinzical GUI. It mainly
 * implements CreateGameBoard and CreatePracticeBoard classes, and ConfirmBox if
 * the user wishes to exit the game.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 *
 */
public class Main extends Application {

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

		program = primaryStage;

		Label label1 = new Label("Welcome to Quinzical!");
		GridPane.setConstraints(label1, 1, 0);

		// Setting/Resetting the count of the questions so that the implementation of
		// winnings is reset.
		ShowWinnings.setOneCount();
		ShowWinnings.setTwoCount();
		ShowWinnings.setThreeCount();
		ShowWinnings.setFourCount();
		ShowWinnings.setFiveCount();
		ShowWinnings.setInternationalCount();

		final ArrayList<String> Categories = MockGameBoard.CreateGameBoardArray();

		// Game button
		Button btnMainToGame = new Button("Game Mode");
		btnMainToGame.setPrefSize(335, 50);
		GridPane.setConstraints(btnMainToGame, 1, 1);

		// When pressed, a new window displaying the Game board will show.
		btnMainToGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DisplayGameBoard.displayGameBoard(Categories);
			}
		});

		// Practice button
		Button btnMainToPractice = new Button("Practice Mode");
		btnMainToPractice.setPrefSize(335, 50);
		GridPane.setConstraints(btnMainToPractice, 1, 2);

		// When pressed, a new window displaying the Practice board will show.
		btnMainToPractice.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CreatePracticeBoard.displayPracticeBoard();
			}
		});

		// Help button
		Button btnMainToHelp = new Button("Help");
		btnMainToHelp.setPrefSize(335, 50);
		GridPane.setConstraints(btnMainToHelp, 1, 3);

		// When pressed, a pdf file with the manual is shown
		btnMainToHelp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("this is supposed to open Help.pdf");
			}

		});

		// High Score button
		Button btnMainToHighScore = new Button("High Scores");
		btnMainToHighScore.setPrefSize(335, 50);
		GridPane.setConstraints(btnMainToHighScore, 1, 4);

		// When pressed, a new window showing the name and score is shown
		btnMainToHighScore.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("High Scores");
			}
		});

		// Reset button
		Button btnMainToReset = new Button("Reset");
		btnMainToReset.setPrefSize(335, 50);
		GridPane.setConstraints(btnMainToReset, 1, 5);

		// When pressed, the game resets, and international becomes hidden
		btnMainToReset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				resetProgram();
			}
		});

		// Quit button
		Button btnMainToExit = new Button("Quit");
		btnMainToExit.setPrefSize(335, 50);
		GridPane.setConstraints(btnMainToExit, 1, 6);

		// When pressed, a new window confirming the closure of the program will show.
		btnMainToExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				closeProgram();
			}
		});

		// Closing when pressing the red X at top right corner
		// Asks the user to confirm, rather than exit immediately
		program.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				event.consume();
				closeProgram();

			}
		});

		// This is the main scene/window
		// mainScene layout with GridPane
		GridPane mainLayout = new GridPane();
		mainLayout.setPadding(new Insets(10, 10, 10, 10));
		mainLayout.setVgap(8);
		mainLayout.setHgap(10);
		mainLayout.getChildren().addAll(label1, btnMainToGame, btnMainToPractice, btnMainToHelp, btnMainToHighScore,
				btnMainToReset, btnMainToExit);

		// Setting up font and general interface visuals.
		label1.setFont(new Font("Cavolini", 30));
		btnMainToGame.setFont(new Font("Arial", 20));
		btnMainToPractice.setFont(new Font("Arial", 20));
		btnMainToExit.setFont(new Font("Arial", 20));
		btnMainToHelp.setFont(new Font("Arial", 20));
		btnMainToHighScore.setFont(new Font("Arial", 20));
		btnMainToReset.setFont(new Font("Arial", 20));
		mainLayout.setAlignment(Pos.CENTER);
		mainScene = new Scene(mainLayout, 500, 400);

		program.setScene(mainScene);
		program.setTitle("Quinzical");
		program.show();

	}

	/*
	 * This method creates a confirmation window when the user tries to exit the
	 * game. Called by the Quit button and the red X.
	 * 
	 */
	private void closeProgram() {
		Boolean answer = ConfirmBox.display("Quit Program", "Are you sure you want to exit?");
		if (answer) {

			// The try and catch method removes created Category-* formats
			try {
				String command = "bash DeleteCategories";
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

	/*
	 * This method creates a confirmation window when the user tries to reset the
	 * game. When the user confirms, it resets high scores and locks the
	 * international button.
	 * 
	 */
	private void resetProgram() {
		Boolean answer = ConfirmBox.display("Reset Scores and lock International", "Are you sure you want to reset?");
		if (answer) {

			// The try and catch method removes created Category-* formats
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

		}
	}

	public static void main(String[] args) {

		// The try and catch method calls the CreateCategories bash function
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

		launch(args);

	}
}