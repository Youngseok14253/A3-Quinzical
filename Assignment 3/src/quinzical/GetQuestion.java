package quinzical;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This GetQuestion class provides the methods to retrieve the question from the
 * Question Bank. This class uses ProcessBuilder to take advantage of the use of
 * bash scripts to format and retrieve the question.
 *
 *
 * @author Do Hyun Lee, Youngseok Chae
 */
public class GetQuestion {
	/*
	 * This method opens a certain category file that has been separated from the
	 * original Question Bank. Each category has a certain number of questions and a
	 * category number so that they are easier to access and tell apart from each
	 * other. The ProcessBuilder accesses a bash script that returns a question from
	 * the selected category.
	 *
	 * @param category The category name that is selected mode The mode that the
	 * module is in, game or practice
	 * 
	 * @return global A string consisting of a random question from the selected
	 * category
	 */
	public static String returnQuestionFormat(String category, String mode) {

		int categoryNum = 0;
		int lineNum = 0;

		// Depending on the category name, a certain file is opened
		if (category.equals("Places")) {
			categoryNum = 2;
			lineNum = 13;
		} else if (category.equals("Symbols")) {
			categoryNum = 3;
			lineNum = 8;
		} else if (category.equals("Geography")) {
			categoryNum = 4;
			lineNum = 12;
		} else if (category.equals("History")) {
			categoryNum = 5;
			lineNum = 9;
		} else if (category.equals("Famous People")) {
			categoryNum = 6;
			lineNum = 9;
		} else if (category.equals("NZ Life")) {
			categoryNum = 7;
			lineNum = 7;
		} else if (category.equals("Flora")) {
			categoryNum = 8;
			lineNum = 10;
		} else if (category.equals("Fauna")) {
			categoryNum = 9;
			lineNum = 18;
		} else if (category.equals("Oddities")) {
			categoryNum = 10;
			lineNum = 8;
		} else if (category.equals("International")) {
			categoryNum = 1;
			lineNum = 13;
		}

		String global = "";

		// Picking a random question by choosing a line number between 2 and max line
		// number.
		// This is the because line 1 is the category name.
		int randNum = (int) (2 + (Math.random() * (lineNum - 2)));

		// Using ProcessBuilder to access the files and get a question line
		try {
			String command = ("bash readQuestion Category-" + categoryNum + " " + randNum);
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

		if (mode.equals("Game")) {

		}

		return global;

	}
}