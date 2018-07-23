package datnt.runsystem.com.utils;

public class StringValidator {
	
	public static boolean usernameValid(String username) {
		
		return true;
	}
	
	public static float scoresValid(String scores) {
		if (scores == null || scores.isEmpty()) {
			return 0;
		}
		return Float.parseFloat(scores);
	}

}
