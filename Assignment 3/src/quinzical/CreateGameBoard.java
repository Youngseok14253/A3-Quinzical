package quinzical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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

		//creates a label asking the user to select a category
		Label label= new Label("Please select a category");
		GridPane.setConstraints(label, 1, 0);
		
		gameGrid.getChildren().add(label);
		
		ArrayList<Integer> randNumList= new ArrayList<>();
		for (int i=1; i<=9; i++) {
			randNumList.add(i);
		}
		Collections.shuffle(randNumList);
		
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
				
			Button Category = new Button(global);
			GridPane.setConstraints(Category, 1, i+1);
			Category.setPrefSize(200, 40);
			String catName = Category.getText();
			Category.setOnAction(e -> AnswerQuestion.displayQuestion(catName));

			gameGrid.getChildren().add(Category);
			
		}
		
		Stage window = new Stage();

		Scene scene= new Scene(gameGrid, 400,300);
		window.setScene(scene);
		window.setTitle("Game Mode");
		window.initModality(Modality.APPLICATION_MODAL);
		window.showAndWait();
		
	}
}
