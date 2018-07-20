package datnt.runsystem.com.utils;

import java.util.ResourceBundle;

public class PropertyReader {
	
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
	
	public static String getValue(String key) {
		return resourceBundle.getString(key);
	}
	
}
