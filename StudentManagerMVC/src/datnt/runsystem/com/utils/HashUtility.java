package datnt.runsystem.com.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtility {
	
	/*
	 * Hàm hash một chuỗi String đầu vào sau đó trả về chuỗi String hash
	 * 
	 * @param s        Chuỗi input
	 * @return String  Chuỗi hash
	 */
	public static String hash(String s) {
		/*MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(StandardCharsets.UTF_8.encode(s));
			return String.format("%032x", new BigInteger(1, md5.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
		return s;
	}
}
