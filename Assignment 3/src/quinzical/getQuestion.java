package quinzical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class getQuestion {
	public static String displayQuestion(String category) {
		
		int categoryNum = 0;
		int lineNum = 0;
		
		if (category== "Places") {
			categoryNum = 1;
			lineNum = 13;
		}
		else if (category== "Symbols") {
			categoryNum = 2;
			lineNum = 8;
		}
		else if (category== "Geography") {
			categoryNum = 3;
			lineNum = 12;
		}
		else if (category== "History") {
			categoryNum = 4;
			lineNum = 9;
		}
		else if (category== "Famous People") {
			categoryNum = 5;
			lineNum = 9;
		}
		else if (category== "NZ Life") {
			categoryNum = 6;
			lineNum = 7;
		}
		else if (category== "Flora") {
			categoryNum = 7;
			lineNum = 10;
		}
		else if (category== "Fauna") {
			categoryNum = 8;
			lineNum = 18;
		}
		else if (category== "Oddities") {
			categoryNum = 9;
			lineNum = 8;
		}
		
		String global = "";
		
		int randNum = (int) (2 + (Math.random() * (lineNum - 2)));
		
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
			System.out.println("should be called");
			System.out.println(global);
			System.out.println("called");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return global;
		
		
	}
}
