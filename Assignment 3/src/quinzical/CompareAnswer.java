package quinzical;

import java.awt.Label;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CompareAnswer{
	
	public static boolean isAnswerPractice(TextField input, String answer, int tries) {
		
		if (tries == 1) {
			//show hint
			System.out.println("showing hint");
		}
		

		System.out.println(answer);
		String inputText = input.getText();
		System.out.println(inputText);
		
		if (inputText.equals(answer)) {
			return true;
		}	
		
		return false;

	}

}

