/*
 * Class StringValidator 
 * 
 * Chứa các phương thức kiểm tra và xử lý chuỗi input nhận từ request
 */

package datnt.runsystem.com.utils;

public class StringValidator {
	
	/*
	 * Kiểm tra input username có hợp lệ
	 * 
	 * @param s   
	 * @return boolean
	 */
	public static boolean isUsername(String s) {
		String regex = "^[a-zA-Z0-9]{0,26}";
		
		if (s.matches(regex) && !isNull(s)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Kiểm tra password có hợp lệ 
	 * 
	 * @param s   
	 * @return boolean
	 */
	public static boolean isPassword(String s) {
		String regex = "^[a-zA-Z0-9!@#$%^&*()]{0,26}";
		
		if (s.matches(regex) && !isNull(s)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Chuyển string sang float
	 * 
	 * @param scores
	 * @return float 
	 */
	public static float scoresValid(String scores) {
		if (!isFloat(scores)){
			return 0;
		}
		return Float.parseFloat(scores);
	}
	
	/*
	 * Kiểm tra chuỗi input có phải là dang float
	 * 
	 * @param  s       input
	 * @return boolean true nếu là dạng float, false nếu không
	 */
	public static boolean isFloat(String s) {
		String regex = "^[0-9.]{0,5}$";
		
		if (s.matches(regex) && !isNull(s)) {
			return true;
		}
		return false;
	}
	/*
	 * Kiểm tra chuỗi null
	 * 
	 * @param s         Input
	 * @return boolean  True nếu chuỗi null, false nếu != null 
	 */
	public static boolean isNull(String s) {
		if (s == null || s.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * Kiểm tra input có phải là dang Họ tên
	 * 
	 * @param s   
	 * @return boolean
	 */
	public static boolean isName(String s) {
		String regex = "^[a-zA-Z ]*$";
		
		if (s.matches(regex) && !isNull(s)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Kiểm tra input có phải là dang Email
	 * 
	 * @param s   
	 * @return boolean
	 */
	public static boolean isEmail(String s) {
		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		
		if (s.matches(regex)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Kiểm tra input có phải là dang SĐT
	 * 
	 * @param s   
	 * @return boolean
	 */
	public static boolean isPhone(String s) {
		String regex = "^[0-9]{5-15}$";
		
		if (s.matches(regex)) {
			return true;
		}
		return false;
	}
}
