package quinzical;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This CompareAnswer class provides methods to compare the user input with the answer, and return
 * the respective message window depending on the result. This class is mainly called by the 
 * SelectCategory class, when the user input is submitted.
 * 
 *  @author Do Hyun Lee, Youngseok Chae
 * 
 */
public class CompareAnswer{
	
	public static int count;

	/*
	 * This method converts the answer and input into lower case, and checks whether 
	 * or not they match. If they have answered correctly, then a display pops up
	 * with a "Correct!". Else, "Incorrect!" pops up.
	 * 
	 * @param input The input of the user 
	 * @param answer The answer on QuestionBank.txt
	 *
	 */
	public static boolean compareAnswerToInput(TextField input, String answer) {
		String text= input.getText();
		String lowerText= text.toLowerCase();
		lowerText = lowerText.replace(" ", "");
		String lowerAnswer=  answer.toLowerCase();
		lowerAnswer = lowerAnswer.replace(" ", "");

		int ansNum= 1;
		for(char c: lowerAnswer.toCharArray()) {
			if (c== '/') {
				ansNum++;
			}
		}

		String[] answerArr= new String[ansNum];
		answerArr= lowerAnswer.split("/");
		for(int i=0; i< ansNum;i++) {
			if(lowerText.length()== answerArr[i].length()) {
				if (lowerAnswer.contains(lowerText)) {
					return true;
				} 
			}
		}
		return false;

	}

	/*
	 * This method is called by isAnswerPractice and creates a window showing whether 
	 * the user's answer was correct or not.
	 * 
	 * @param message A message "Correct!" or "Incorrect!" depending on user input
	 */
	public static void display(String message) {

		String title= "Confirmation";

		Stage window= new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(200);

		Label label= new Label();
		label.setText(message);

		Button btnCont= new Button("Continue");

		btnCont.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}

		});

		VBox layout= new VBox(10);
		layout.getChildren().addAll(label, btnCont);
		layout.setAlignment(Pos.CENTER);
		Scene scene= new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

	}
	
	public static void setCount() {
		count = 1;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void incrementCount() {
		count++;
	}
	
	public static void resetCount() {
		count = 1;
	}
	
	//isPractice .equalsString, display incorrect
	//if true
	public static void isPractice(String mode) {
	}
}

