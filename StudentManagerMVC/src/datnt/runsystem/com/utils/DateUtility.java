package datnt.runsystem.com.utils;

import java.util.Calendar;

public class DateUtility {
	
	public static String[] getYearSemester() {
		String[] string = new String[2];
		
		Calendar calendar = Calendar.getInstance();
		
		int month = calendar.get(Calendar.MONTH);
		int year  = calendar.get(Calendar.YEAR);
		
		string[0] = year + "-" + (year + 1);
		
		if (month >= 6 && month < 8) {
			string[1] = "3";
		} else if (month >= 8 && month < 12) {
			string[1] = "1";
		} else {
			string[1] = "2";
		}
		return string;
	}
	
	public static void main(String[] args) {
		
		String[] asd = getYearSemester();
		System.out.println(asd[0] + "  " + asd[1]);
	}

}
