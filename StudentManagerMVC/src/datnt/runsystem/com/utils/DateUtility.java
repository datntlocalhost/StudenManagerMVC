package datnt.runsystem.com.utils;

import java.util.Calendar;

public class DateUtility {
	
	/*
	 * Lấy thời gian năm học và học kỳ
	 * 
	 * @return String[]
	 */
	public static String[] getYearSemester() {
		String[] string = new String[2];
		
		Calendar calendar = Calendar.getInstance();
		
		int month = calendar.get(Calendar.MONTH);
		int year  = calendar.get(Calendar.YEAR);
		
		//năm học vd 2017-2018
		string[0] = year + "-" + (year + 1);
		
		//trong tháng 6 - 8 là học kỳ 3
		if (month >= 6 && month < 8) {
			string[1] = "3";
		} else if (month >= 8 && month < 12) {
			string[1] = "1";
		} else {
			string[1] = "2";
		}
		return string;
	}
}
