package quinzical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class getQuestion {
	public static String displayQuestion(String category) {
		if (category== "Places") {
			
			return "testing palces";
		}
		else if (category== "Symbols") {
			return "testing symbols";
		}
		else if (category== "Geography") {
			return "testing geograhy";
		}
		else if (category== "History") {
			return "testing history";
		}
		else if (category== "Famous People") {
			return "testing famous peopel";
		}
		else if (category== "NZ Life") {
			return "testing nzlife";
		}
		else if (category== "Flora") {
			return "testing flroa";
		}
		else if (category== "Fauna") {
			return "testing Fauna";
		}
		else if (category== "Oddities") {
			return "testing idditoes";
		}
		return "testing end return";
	}
}
