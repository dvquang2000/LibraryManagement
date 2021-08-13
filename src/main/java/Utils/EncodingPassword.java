/*package Utils;

import org.mindrot.jbcrypt.BCrypt;

public class EncodingPassword {
	public static void main(String[] args) {
		String passwordString = "hello";
		String passwordString1 = "11";
		String hash = BCrypt.hashpw(passwordString, BCrypt.gensalt(12));
		System.out.println("BCrypt hash: " + hash);
		boolean value = BCrypt.checkpw(passwordString, "$2a$12$TjEsbDOV.IbekkLHTRh.I.A1H4oDJLedirZSn94AAvr/hV3UYqN2W");
		System.out.println(value);
	}
	public String hashString(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
}*/
