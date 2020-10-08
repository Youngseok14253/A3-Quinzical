package quinzical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * 
 * 
 * @author Do Hyun Lee, Youngseok Chae
 *
 */
public class CreateGameBoard{
	static boolean truth= true;
	/*
	 * This method sets up a new window and selects five categories to choose at random.
	 * It allows for the user to choose one of the five categories,
	 * where a question under that category will be shown.
	 * 
	 */
	public static void displayGameBoard() { 

		GridPane gameGrid= new GridPane();
		gameGrid.setPadding(new Insets(10,10,10,10));
		gameGrid.setVgap(8);
		gameGrid.setHgap(10);
		
		Stage window = new Stage();

		Scene scene= new Scene(gameGrid, 400,300);
		window.setScene(scene);
		window.setTitle("Game Mode");
		window.initModality(Modality.APPLICATION_MODAL);
		//creates a label asking the user to select a category
		Label label= new Label("Please select a category");
		GridPane.setConstraints(label, 1, 0);

		gameGrid.getChildren().add(label); 

		ArrayList<Integer> randNumList= new ArrayList<>();
		for (int i=1; i<=9; i++) {
			randNumList.add(i);
		}
		Collections.shuffle(randNumList);
		if(truth== true) {
			CompareAnswer.setCount();
		}
		//selects 5 categories to display at random
		for (int i = 0; i < 5; i++) {


			String global = "";


			try {
				//bash command returns the first line of formatted Category files, where it will return the name of the category
				String command = ("sed -n '1p' < Category-" + randNumList.get(i));
				ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);

				Process process = pb.start();

				BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
				BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream()));

				int exitStatus = process.waitFor();

				if (exitStatus == 0) {

					String line;
					while ((line = stdout.readLine()) != null) {
						global = line;
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

			Button category = new Button(global);
			GridPane.setConstraints(category, 1, i+1);
			category.setPrefSize(200, 40);
			String catName = category.getText();


			category.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					window.close();
					AnswerQuestion.displayQuestion(catName, "Game");
					CompareAnswer.incrementCount();
					truth=false;
					displayGameBoard();
				}
			});

			gameGrid.getChildren().add(category);


			Label categoryWinnings = new Label();
			int count= CompareAnswer.getCount();
			categoryWinnings.setText("$"+count+"00");
			GridPane.setConstraints(categoryWinnings, 2, i+1); //Move out of for loop but keep ith position
			category.setPrefSize(200, 40);
			gameGrid.getChildren().add(categoryWinnings);
			window.show();
		}

	}

}
