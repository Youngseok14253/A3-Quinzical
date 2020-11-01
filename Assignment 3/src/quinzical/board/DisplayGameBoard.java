package quinzical.board;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import quinzical.question.AnswerQuestion;
import quinzical.question.CompareAnswer;
import quinzical.score.HighScore;
import quinzical.score.ShowWinnings;

/**
 * This class provides the display method for the Main class when the user
 * selects the Game Mode. It contains a single method, displayGameBoard which
 * creates a new window displaying five randomly selected categories, each with
 * a value. After answering all Categories, the final window is shown with the
 * user's total winnings and they are returned to the Main Menu.
 * 
 * @author Do Hyun Lee, Youngseok Chae
 *
 */
public class DisplayGameBoard {
	private static int count;
	private static boolean finished;
	private static ArrayList<String> chosenCategories= new ArrayList<String>();
	/*
	 * This method displays a new window with all categories in the Question Bank.
	 * Once 5 categories are selected by the user, the method displayGameBoard is called
	 * and the 5 selected categories are used as the parameter for the latter method, 
	 * in an ArrayList format.
	 * 
	 * 
	 */
	public static void displayGame() {
		// Resetting the count back to 1, so that 5 categories may be chosen again
		setCount();
		// New Stage
		Stage window = new Stage();

		// Set up GridPane
		GridPane gameGrid = new GridPane();
		gameGrid.setPadding(new Insets(10, 10, 10, 10));
		gameGrid.setVgap(8);
		gameGrid.setHgap(10);

		//ArrayList<String> chosenCategories= new ArrayList<String>();

		CompareAnswer.setCount();
		Label Category = new Label("Please select any 5 categories");
		GridPane.setConstraints(Category, 0, 0);

		// Each button is formatted the same way, so follow along the comments for
		// Button 1 (Category1)

		// Button for Places created, and placed in the (0,1) Pane
		Button Category1 = new Button("Places");
		GridPane.setConstraints(Category1, 1, 1);
		// Set a reasonable size
		Category1.setPrefSize(300, 80);
		// Return the name of the Category from the ArrayList and store it in a variable
		String catName1 = Category1.getText();
		Button catLabel1= new Button();
		catLabel1.setText("Places selected");

		// When the button is pressed, the category is marked as a selected category and changes into a 
		// unclickable button that shows the category is selected
		Category1.setOnAction(e -> {
			gameGrid.getChildren().remove(Category1);
			GridPane.setConstraints(catLabel1, 1, 1);
			catLabel1.setPrefSize(300, 80);
			gameGrid.getChildren().add(catLabel1);
			incrementCount();
			chosenCategories.add(catName1);
			boolean booleanType= isCategoriesSelected();
			//If 5 categories are selected, a new window will appear with the 5 chosen categories
			if (booleanType== true) {
				window.close();
				displayGameBoard(chosenCategories);
			}
		});

		Button Category2 = new Button("Symbols");
		GridPane.setConstraints(Category2, 1, 2);
		Category2.setPrefSize(300, 80);
		String catName2 = Category2.getText();
		Button catLabel2= new Button();
		catLabel2.setText("Symbols selected");

		Category2.setOnAction(e -> {
			gameGrid.getChildren().remove(Category2);
			GridPane.setConstraints(catLabel2, 1, 2);
			catLabel2.setPrefSize(300, 80);
			gameGrid.getChildren().add(catLabel2);
			incrementCount();
			chosenCategories.add(catName2);
			boolean booleanType= isCategoriesSelected();
			if (booleanType== true) {
				window.close();
				displayGameBoard(chosenCategories);
			}
		});

		Button Category3 = new Button("Geography");
		GridPane.setConstraints(Category3, 1, 3);
		Category3.setPrefSize(300, 80);
		String catName3 = Category3.getText();
		Button catLabel3= new Button();
		catLabel3.setText("Geography selected");

		Category3.setOnAction(e -> {
			gameGrid.getChildren().remove(Category3);
			GridPane.setConstraints(catLabel3, 1, 3);
			catLabel3.setPrefSize(300, 80);
			gameGrid.getChildren().add(catLabel3);
			incrementCount();
			chosenCategories.add(catName3);
			boolean booleanType= isCategoriesSelected();
			if (booleanType== true) {
				window.close();
				displayGameBoard(chosenCategories);
			}
		});

		Button Category4 = new Button("History");
		GridPane.setConstraints(Category4, 1, 4);
		Category4.setPrefSize(300, 80);
		String catName4 = Category4.getText();
		Button catLabel4= new Button();
		catLabel4.setText("History selected");

		Category4.setOnAction(e -> {
			gameGrid.getChildren().remove(Category4);
			GridPane.setConstraints(catLabel4, 1, 4);
			catLabel4.setPrefSize(300, 80);
			gameGrid.getChildren().add(catLabel4);
			incrementCount();
			chosenCategories.add(catName4);
			boolean booleanType= isCategoriesSelected();
			if (booleanType== true) {
				window.close();
				displayGameBoard(chosenCategories);
			}
		});

		Button Category5 = new Button("Famous People");
		GridPane.setConstraints(Category5, 0, 1);
		Category5.setPrefSize(300, 80);
		String catName5 = Category5.getText();
		Button catLabel5= new Button();
		catLabel5.setText("Famous People selected");

		Category5.setOnAction(e -> {
			gameGrid.getChildren().remove(Category5);
			GridPane.setConstraints(catLabel5, 0, 1);
			catLabel5.setPrefSize(300, 80);
			gameGrid.getChildren().add(catLabel5);
			incrementCount();
			chosenCategories.add(catName5);
			boolean booleanType= isCategoriesSelected();
			if (booleanType== true) {
				window.close();
				displayGameBoard(chosenCategories);
			}
		});

		Button Category6 = new Button("NZ Life");
		GridPane.setConstraints(Category6, 0, 2);
		Category6.setPrefSize(300, 80);
		String catName6 = Category6.getText();
		Button catLabel6= new Button();
		catLabel6.setText("NZ Life selected");

		Category6.setOnAction(e -> {
			gameGrid.getChildren().remove(Category6);
			GridPane.setConstraints(catLabel6, 0, 2);
			catLabel6.setPrefSize(300, 80);
			gameGrid.getChildren().add(catLabel6);
			incrementCount();
			chosenCategories.add(catName6);
			boolean booleanType= isCategoriesSelected();
			if (booleanType== true) {
				window.close();
				displayGameBoard(chosenCategories);
			}
		});

		Button Category7 = new Button("Flora");
		GridPane.setConstraints(Category7, 0, 3);
		Category7.setPrefSize(300, 80);
		String catName7 = Category7.getText();
		Button catLabel7= new Button();
		catLabel7.setText("Flora selected");

		Category7.setOnAction(e -> {
			gameGrid.getChildren().remove(Category7);
			GridPane.setConstraints(catLabel7, 0, 3);
			catLabel7.setPrefSize(300, 80);
			gameGrid.getChildren().add(catLabel7);
			incrementCount();
			chosenCategories.add(catName7);
			boolean booleanType= isCategoriesSelected();
			if (booleanType== true) {
				window.close();
				displayGameBoard(chosenCategories);
			}
		});

		Button Category8 = new Button("Fauna");
		GridPane.setConstraints(Category8, 0, 4);
		Category8.setPrefSize(300, 80);
		String catName8 = Category8.getText();
		Button catLabel8= new Button();
		catLabel8.setText("Fauna selected");

		Category8.setOnAction(e -> {
			gameGrid.getChildren().remove(Category8);
			GridPane.setConstraints(catLabel8, 0, 4);
			catLabel8.setPrefSize(300, 80);
			gameGrid.getChildren().add(catLabel8);
			incrementCount();
			chosenCategories.add(catName8);
			boolean booleanType= isCategoriesSelected();
			if (booleanType== true) {
				window.close();
				displayGameBoard(chosenCategories);
			}
		});
		Button Category9 = new Button("Oddities");
		GridPane.setConstraints(Category9, 0, 5);
		Category9.setPrefSize(300, 80);
		String catName9 = Category9.getText();
		Button catLabel9= new Button();
		catLabel9.setText("Oddities selected");

		Category9.setOnAction(e -> {
			gameGrid.getChildren().remove(Category9);
			GridPane.setConstraints(catLabel9, 0, 5);
			catLabel9.setPrefSize(300, 80);
			gameGrid.getChildren().add(catLabel9);
			incrementCount();
			chosenCategories.add(catName9);
			boolean booleanType= isCategoriesSelected();
			if (booleanType== true) {
				window.close();
				displayGameBoard(chosenCategories);
			}
		});

		// Adds the buttons and Labels to the Grid
		gameGrid.getChildren().addAll(Category, Category1, Category2, Category3, Category4, Category5, Category6,
				Category7, Category8, Category9);

		// Create layout and show scene
		Scene scene = new Scene(gameGrid, 600, 450);

		window.initModality(Modality.APPLICATION_MODAL);

		window.setScene(scene);
		window.setTitle("Game Mode");
		window.show();

	}
	/**
	 * This method determines through a count variable whether 5 categories have
	 * been selected yet or not. 
	 * @return boolean true
	 * @return boolean false
	 */
	public static boolean isCategoriesSelected() {
		if (getCount()==5) {
			return true;
		}
		else {
			return false;
		}
	}
	// Below are some getters and setters for the count variable
	public static void setCount() {
		count = 0;
	}

	public static int getCount() {
		return count;
	}

	public static void incrementCount() {
		count++;
	}
	/*
	 * This method displays a new window with the five selected categories.
	 * Once selected, it displays a question
	 * corresponding to the Category and depending on the user's answer, displays a
	 * "Correct" or "Incorrect" message. It also displays a question value next to
	 * each category which increases by 100 (starting from 100, up to 500) and adds
	 * the respective value to the user's winnings if they answer correctly. After
	 * answering 5 questions from each category, the category becomes unavailable.
	 * Once every category is answered, the user is taken to the final screen with
	 * the total earnings and asked to play again, or return to the Main Menu.
	 * 
	 * @param categories Five selected categories in a ArrayList format
	 * 
	 */
	public static void displayGameBoard(ArrayList<String> categories) {


		// This boolean checks whether all of the categories have been answered
		finished=false;
		// New Stage
		Stage window = new Stage();

		// Set up GridPane
		GridPane gameGrid = new GridPane();
		gameGrid.setPadding(new Insets(10, 10, 10, 10));
		gameGrid.setVgap(8);
		gameGrid.setHgap(10);

		Label Category = new Label("Please select a category");
		GridPane.setConstraints(Category, 0, 0);

		// Each button is formatted the same way, so follow along the comments for
		// Button 1 (Category1)

		// Category 1 is the first element in the categories ArrayList, and placed in
		// the (0,1) Pane
		Button Category1 = new Button(categories.get(0));
		GridPane.setConstraints(Category1, 0, 1);
		// Set a reasonable size
		Category1.setPrefSize(300, 80);
		// Return the name of the Category from the ArrayList and store it in a variable
		String catName1 = Category1.getText();

		// When the button is pressed, the Category window closes, and the
		// displayQuestion method is called
		// where the question is displayed.
		Category1.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion(catName1, "Game", 1);
			// The method incrementOneCount is called, where the count represents the number
			// of questions
			// which the user has selected from the first button (Category1)

			ShowWinnings.incrementOneCount();
			// The Cateogory board is displayed again
			displayGameBoard(categories);
		});

		Button Category2 = new Button(categories.get(1));
		GridPane.setConstraints(Category2, 0, 2);
		Category2.setPrefSize(300, 80);
		String catName2 = Category2.getText();

		Category2.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion(catName2, "Game", 2);
			ShowWinnings.incrementTwoCount();
			displayGameBoard(categories);
		});

		Button Category3 = new Button(categories.get(2));
		GridPane.setConstraints(Category3, 0, 3);
		Category3.setPrefSize(300, 80);
		String catName3 = Category3.getText();

		Category3.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion(catName3, "Game", 3);
			ShowWinnings.incrementThreeCount();
			displayGameBoard(categories);
		});

		Button Category4 = new Button(categories.get(3));
		GridPane.setConstraints(Category4, 0, 4);
		Category4.setPrefSize(300, 80);
		String catName4 = Category4.getText();

		Category4.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion(catName4, "Game", 4);
			ShowWinnings.incrementFourCount();
			displayGameBoard(categories);
		});

		Button Category5 = new Button(categories.get(4));
		GridPane.setConstraints(Category5, 0, 5);
		Category5.setPrefSize(300, 80);
		String catName5 = Category5.getText();

		Category5.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion(catName5, "Game", 5);
			ShowWinnings.incrementFiveCount();
			displayGameBoard(categories);
		});

		Button CategoryLocked = new Button("Locked");
		GridPane.setConstraints(CategoryLocked, 0, 6);
		CategoryLocked.setPrefSize(300, 80);


		Button CategoryInternational = new Button("International");
		GridPane.setConstraints(CategoryInternational, 0, 6);
		CategoryInternational.setPrefSize(300, 80);

		CategoryInternational.setOnAction(e -> {
			window.close();
			AnswerQuestion.displayQuestion("International", "Game", 6);
			ShowWinnings.incrementInternationalCount();
			displayGameBoard(categories);
		});

		// The Labels show the value of the question, taken from the count (number of
		// questions the user has
		// answered from each Category) and multiplying it by 100 (technically
		// concatenating, I know).
		// The Labels will update each time a Category is pressed.
		Label catOneMoney = new Label();
		GridPane.setConstraints(catOneMoney, 1, 1);
		catOneMoney.setText("\t\tQuestion Worth $" + ShowWinnings.getOneCount() + "00");
		Label catTwoMoney = new Label();
		GridPane.setConstraints(catTwoMoney, 1, 2);
		catTwoMoney.setText("\t\tQuestion Worth $" + ShowWinnings.getTwoCount() + "00");
		Label catThreeMoney = new Label();
		GridPane.setConstraints(catThreeMoney, 1, 3);
		catThreeMoney.setText("\t\tQuestion Worth $" + ShowWinnings.getThreeCount() + "00");
		Label catFourMoney = new Label();
		GridPane.setConstraints(catFourMoney, 1, 4);
		catFourMoney.setText("\t\tQuestion Worth $" + ShowWinnings.getFourCount() + "00");
		Label catFiveMoney = new Label();
		GridPane.setConstraints(catFiveMoney, 1, 5);
		catFiveMoney.setText("\t\tQuestion Worth $" + ShowWinnings.getFiveCount() + "00");
		Label catInternationalMoney = new Label();
		GridPane.setConstraints(catInternationalMoney, 1, 6);
		catInternationalMoney.setText("\t\tQuestion Worth $" + ShowWinnings.getInternationalCount() + "00");

		// Add the Labels and Buttons to the Grid
		gameGrid.getChildren().addAll(Category, Category1, Category2, Category3, Category4, Category5, CategoryLocked);
		gameGrid.getChildren().addAll(catOneMoney, catTwoMoney, catThreeMoney, catFourMoney, catFiveMoney);

		// Initialise "Unavailable Buttons" once the Category is completed (all five
		// questions have been
		// answered by the user)
		Button oneFinish = new Button("Unavailable");
		oneFinish.setPrefSize(300, 80);
		Button twoFinish = new Button("Unavailable");
		twoFinish.setPrefSize(300, 80);
		Button threeFinish = new Button("Unavailable");
		threeFinish.setPrefSize(300, 80);
		Button fourFinish = new Button("Unavailable");
		fourFinish.setPrefSize(300, 80);
		Button fiveFinish = new Button("Unavailable");
		fiveFinish.setPrefSize(300, 80);
		Button intFinish = new Button("Unavailable");
		intFinish.setPrefSize(300, 80);

		// If the limit (five) is reached, then the corresponding button and question
		// value labels are
		// removed, and replaced by a single Unavailable button which does not do
		// anything if pressed
		if (ShowWinnings.isOneLimit() == true) {
			gameGrid.getChildren().removeAll(Category1, catOneMoney);
			GridPane.setConstraints(oneFinish, 0, 1);
			gameGrid.getChildren().add(oneFinish);

		}
		if (ShowWinnings.isTwoLimit() == true) {
			gameGrid.getChildren().removeAll(Category2, catTwoMoney);
			GridPane.setConstraints(twoFinish, 0, 2);
			gameGrid.getChildren().add(twoFinish);
		}
		if (ShowWinnings.isThreeLimit() == true) {
			gameGrid.getChildren().removeAll(Category3, catThreeMoney);
			GridPane.setConstraints(threeFinish, 0, 3);
			gameGrid.getChildren().add(threeFinish);
		}
		if (ShowWinnings.isFourLimit() == true) {
			gameGrid.getChildren().removeAll(Category4, catFourMoney);
			GridPane.setConstraints(fourFinish, 0, 4);
			gameGrid.getChildren().add(fourFinish);
		}
		if (ShowWinnings.isFiveLimit() == true) {
			gameGrid.getChildren().removeAll(Category5, catFiveMoney);
			GridPane.setConstraints(fiveFinish, 0, 5);
			gameGrid.getChildren().add(fiveFinish);
		}

		//The following count is to keep track of how many categories have been completed.
		int count=0;
		if (ShowWinnings.isOneLimit()==true) {
			count++;
		}
		if (ShowWinnings.isTwoLimit()==true) {
			count++;
		}
		if (ShowWinnings.isThreeLimit()==true) {
			count++;
		}
		if (ShowWinnings.isFourLimit()==true) {
			count++;
		}
		if (ShowWinnings.isFiveLimit()==true) {
			count++;
		}

		//If two categories have been completed, the international category is unlocked
		//along with its current potential winning if the question is answered correctly.

		if (count >= 2) {
			gameGrid.getChildren().remove(CategoryLocked);
			gameGrid.getChildren().add(CategoryInternational);
			gameGrid.getChildren().add(catInternationalMoney);
		}

		if (ShowWinnings.isInternationalLimit() == true) {

			gameGrid.getChildren().removeAll(CategoryInternational, catInternationalMoney);
			GridPane.setConstraints(intFinish, 0, 6);
			gameGrid.getChildren().add(intFinish);
		}

		// If all buttons are Unavailable (i.e no more questions to ask), then the user
		// is greeted with
		// a final window displaying their total winnings
		if (ShowWinnings.isOneLimit() == true && ShowWinnings.isTwoLimit() == true
				&& ShowWinnings.isThreeLimit() == true && ShowWinnings.isFourLimit() == true
				&& ShowWinnings.isFiveLimit() == true && ShowWinnings.isInternationalLimit() == true) {
			String[] nameAndScore = ShowWinnings.rewardScreen();

			HighScore.updateScoreBoard(nameAndScore);

			window.close();
			// The boolean value is changed to true
			finished = true;
		}

		// Create layout and show scene
		Scene scene = new Scene(gameGrid, 600, 450);

		window.initModality(Modality.APPLICATION_MODAL);

		window.setScene(scene);
		window.setTitle("Game Mode");

		// As long as one Category is available, the Category window will always display
		// after the user answers a question
		if (finished == false) {
			window.show();
		}
		// If all Categories have been answered, the list with the 5 chosen categories will
		// remove the categories, so it can be reused if played again
		if(finished== true) {
			for(int i=0; i< chosenCategories.size(); i++) {
				chosenCategories.remove(i);
			}
		}
	}
	/** 
	 * This method determines if the game is considered to be finished or not
	 * @return boolean true
	 * @return boolean false
	 */
	public static boolean isFinished() {
		if (finished==true) {
			return true;
		}
		else {
			return false;
		}
	}
	/** 
	 * This method is mainly to have a method that the Main class can call to call the
	 * method displayGameBoard. This method will proceed to display a window with the 
	 * 5 chosen categories, as is what is shown in the displayGameBoard method above.
	 */
	public static void isNotFinished() {
		displayGameBoard(chosenCategories);
	}

}

