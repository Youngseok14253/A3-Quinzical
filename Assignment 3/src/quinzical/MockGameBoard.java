package quinzical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class provides methods to implement the display when Game mode is
 * selected from the main menu. This class uses ProcessBuilder to access the use
 * of bash scripts to receive and format the 5 selected categories.
 *
 * @author Do Hyun Lee, Youngseok Chae
 *
 */
public class MockGameBoard {

	/*
	 * This method sets up a new window and selects five categories to choose at
	 * random. It allows for the user to choose one of the five categories, where a
	 * question under that category will be shown.
	 *
	 * @return test A list of the 5 categories that has been selected at random
	 */
	public static ArrayList<String> displayGameBoard() {

		// Initialising an ArrayList with numbers from 1 to 9.
		ArrayList<Integer> randNumList = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			randNumList.add(i);
		}
		// Randomises the ordering of the numbers in the Array List.
		Collections.shuffle(randNumList);

		ArrayList<String> test = new ArrayList<>();

		// Selects 5 categories to display at random
		for (int i = 0; i < 5; i++) {

			String global = "";

			try {
				// bash command returns the first line of formatted Category files, where it
				// will return the name of the category
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

			test.add(global);

		}

		return test;

	}

}