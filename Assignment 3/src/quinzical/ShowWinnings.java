package quinzical;

public class ShowWinnings {
	
	public static int categoryOneCount;
	public static int categoryTwoCount;
	public static int categoryThreeCount;
	public static int categoryFourCount;
	public static int categoryFiveCount;
	
	
	public static void saveCategory(String catName) {
		
	}
	
	public static void setOneCount() {
		categoryOneCount = 1;
	}
	
	public static int getOneCount() {
		return categoryOneCount;
	}
	
	public static void incrementOneCount() {
		categoryOneCount++;
	}
	
	public static boolean isOneLimit() {
		if (categoryOneCount == 6) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void setTwoCount() {
		categoryTwoCount = 1;
	}
	
	public static int getTwoCount() {
		return categoryTwoCount;
	}
	
	public static void incrementTwoCount() {
		categoryTwoCount++;
	}
	public static boolean isTwoLimit() {
		if (categoryTwoCount == 6) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void setThreeCount() {
		categoryThreeCount = 1;
	}
	
	public static int getThreeCount() {
		return categoryThreeCount;
	}
	
	public static void incrementThreeCount() {
		categoryThreeCount++;
	}
	public static boolean isThreeLimit() {
		if (categoryThreeCount == 6) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void setFourCount() {
		categoryFourCount = 1;
	}
	
	public static int getFourCount() {
		return categoryFourCount;
	}
	
	public static void incrementFourCount() {
		categoryFourCount++;
	}
	public static boolean isFourLimit() {
		if (categoryFourCount == 6) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void setFiveCount() {
		categoryFiveCount = 1;
	}
	
	public static int getFiveCount() {
		return categoryFiveCount;
	}
	
	public static void incrementFiveCount() {
		categoryFiveCount++;
	}
	public static boolean isFiveLimit() {
		if (categoryFiveCount == 6) {
			return true;
		}
		else {
			return false;
		}
	}

}
