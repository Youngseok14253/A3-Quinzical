package quinzical;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetQuestion {
	public static String returnQuestionFormat(String category) {
		
		int categoryNum = 0;
		int lineNum = 0;
		
		//Depending on the category name, a certain file is opened
		if (category.equals("Places")) {
			categoryNum = 1;
			lineNum = 13;
		}
		else if (category.equals("Symbols")) {
			categoryNum = 2;
			lineNum = 8;
		}
		else if (category.equals("Geography")) {
			categoryNum = 3;
			lineNum = 12;
		}
		else if (category.equals("History")) {
			categoryNum = 4;
			lineNum = 9;
		}
		else if (category.equals("Famous People")) {
			categoryNum = 5;
			lineNum = 9;
		}
		else if (category.equals("NZ Life")) {
			categoryNum = 6;
			lineNum = 7;
		}
		else if (category.equals("Flora")) {
			categoryNum = 7;
			lineNum = 10;
		}
		else if (category.equals("Fauna")) {
			categoryNum = 8;
			lineNum = 18;
		}
		else if (category.equals("Oddities")) {
			categoryNum = 9;
			lineNum = 8;
		}
		
		String global = "";
		
		//Picking a random question by choosing a line number between 2 and max line number
		int randNum = (int) (2 + (Math.random() * (lineNum - 2)));
		
		//Using ProcessBuilder to access the files and get a question line
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
		
		return global;
		
		
	}
}
