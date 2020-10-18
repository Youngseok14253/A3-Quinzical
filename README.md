# A3-Quinzical
Before running, please install VirtualBox image.\
Open Eclipse, and import the A3-Quinzical file to your Java projects. \
Make sure you have jdk-11 and JavaFX-11 installed in your IDE.\
Open the Main.java class and click Run as Java Application.\
\
IF YOU WANT TO ADD A CATEGORY TO THE GAME:\
Open the QuestionBank.txt text file.\
Copy this code under the + sign in line 128:\
-----------------------------------------------------------------------------------------------\
+\
NAME\
What is the year the Government pledged New Zealand would be predator free@what is@2050\
This is the name of New Zealand Male Rugby Team@what is@All Blacks\
What New Zealand song has made it into the New Zealand Top 40 in three separate decades@what is@Poi E\
This is the nationality of the inventors of the bobby pin, wide toothed shearing comb, and jet boat@what is@New Zealander\
In 1990 New Zealand became the first country in the modern world to make this appointment@what is@Official National Wizard/National Wizard\
With more that 400, New Zealand has more of these per capita than any other country in the world@what are@golf courses\
The first record wholly produced in New Zealand from composition to pressing@what is@Blue Smoke\
+\
-----------------------------------------------------------------------------------------------\
Where NAME is the category name, the general topic of the category you are adding.\
\
Except the questions would be different. The format of the question and answer must be EXACTLY in the following:\
question@what is@answer\
\
\
Open the CreatePracticeBoard.java class.\
Copy this code under Category 9 in line 138:\
------------------------------------------------------------------------------------------------\
Button CategoryX = new Button("NAME");\
	  GridPane.setConstraints(Category9, a, b);\
		Category9.setPrefSize(300, 80);\
		String catNameX = CategoryX.getText();\
\
		CategoryX.setOnAction(e -> {\
			AnswerQuestion.displayQuestion(catNameX, "Practice", 0);\
		});\
------------------------------------------------------------------------------------------------\
Where X is 10 if this is the first category that is being added. This number will increment depending on how many categories you add.\
Where NAME is the general topic of the category eg. Places, Symbols, Famous People etc.\
Where a is 1 and b is 5. If you are adding more than 1 category, each time you add a category, 'a' will alternate between 0 and 1, and 'b' will increment by 1 every time 'a' goes from 1 to 0. ie. Adding a 2nd category, 'a' would be 0 and 'b' would be 6.\
\
The existing code on line 141:\
gameGrid.getChildren().addAll(Category, Category1, Category2, Category3, Category4, Category5, Category6,
				Category7, Category8, Category9);\
\
Should be changed to:\
gameGrid.getChildren().addAll(Category, Category1, Category2, Category3, Category4, Category5, Category6,
				Category7, Category8, Category9, CategoryX);\
        \
\
Now open the GetQuestion.java class.\
Copy this code under line 64:\
------------------------------------------------------------------------------------------------\
else if (category.equals("NAME")) {\
			categoryNum = X+1;\
			lineNum = Y;\
		}\
------------------------------------------------------------------------------------------------\
Where X+1 is the same number used in the CreatePracticeBoard.java class plus 1.\
Where NAME is the same category name used in CreatePracticeBoard.java.\
Where Y is the number of lines the category takes up, including the line containing the category name.\
