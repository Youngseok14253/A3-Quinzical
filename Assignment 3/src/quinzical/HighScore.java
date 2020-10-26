package quinzical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

/**
 * This HighScore Class provides implementations for reading and editing the
 * High-Scores file, then displaying the names and scores to the user. This is
 * mainly called by the Main Class, but is also used by DisplayGameBoard to
 * update a user's attempt after completing Game Mode.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 * 
 */
public class HighScore {

	/*
	 * This method uses a bash line to read the High-Scores text file and each line
	 * to an ArrayList. It reads from the second line onwards, and after completion
	 * returns the ArrayList to the Classes that called it.
	 * 
	 * @return ArrayList<String> with each element a line in the High-Scores file
	 * (line 2 onwards)
	 *
	 */
	public static ArrayList<String> returnScores() {

		ArrayList<String> scoreArray = new ArrayList<>();

		// The try and catch method reads the High-Scores file from line 2 onwards
		try {
			String command = "tail -n +2 Scores/High-Scores";
			ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);

			int count = 1;

			Process process = pb.start();

			BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			int exitStatus = process.waitFor();

			if (exitStatus == 0) {
				String line;
				while ((line = stdout.readLine()) != null) {
					// Formats it in "Count. Name - Score" and adds it to the array
					String scores = count + ". " + line;
					scoreArray.add(scores);
					count++;
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

		return scoreArray;
	}

	/*
	 * This method creates a new window, where it displays the high scores of all
	 * users who have completed Game Mode in decreasing score order.
	 * 
	 * @param scores The list of Names and final Winnings
	 *
	 */
	public static void displayScores(ArrayList<String> scores, String name, int winnings) {

		// New Stage with GridPane
		Stage window = new Stage();
		GridPane mainLayout = new GridPane();

		mainLayout.setPadding(new Insets(10, 10, 10, 10));
		mainLayout.setVgap(8);
		mainLayout.setHgap(10);

		Label label = new Label("Hall of Fame");
		GridPane.setConstraints(label, 1, 0);

		mainLayout.getChildren().add(label);
		label.setFont(new Font("Cavolini", 30));

		int count = scores.size();

		// for Loop which goes through the ArrayList and creates a label for
		// each element inside it. Then adds it to the Main Layout
		for (int i = 0; i < count; i++) {

			Label scoreLabel = new Label();
			GridPane.setConstraints(scoreLabel, 1, i + 1);
			scoreLabel.setText(scores.get(i));
			scoreLabel.setFont(new Font("Arial", 20));

			mainLayout.getChildren().add(scoreLabel);
		}

		if (winnings <= 9000) {
			// Label for the nickname they entered from the Game Mode
			Label nickname = new Label(name + ": " + winnings);
			GridPane.setConstraints(nickname, 1, scores.size() + 1);
			nickname.setFont(new Font("Arial", 20));
			mainLayout.getChildren().add(nickname);
		}

		// Return button to Main Menu
		Button button = new Button("Return");
		button.setPrefSize(335, 50);
		GridPane.setConstraints(button, 1, scores.size() + 2);
		button.setFont(new Font("Arial", 20));

		// Pressing confirm will close the window
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
		});

		mainLayout.getChildren().add(button);

		// Sizing and Alignment, then show scene
		mainLayout.setAlignment(Pos.CENTER);
		Scene mainScene = new Scene(mainLayout, 500, 400);

		window.setScene(mainScene);
		window.setTitle("High Scores");
		window.show();

	}

	public static void updateScoreBoard(String[] nameAndScore) {

		String name = nameAndScore[0];
		String winnings = nameAndScore[1];

		// The try and catch method calls the CreateCategories bash function
		try {
			String command = "bash Scores/CompareScore " + winnings + " " + name;
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
