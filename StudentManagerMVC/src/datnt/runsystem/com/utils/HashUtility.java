package datnt.runsystem.com.utils;


public class HashUtility {
	
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
