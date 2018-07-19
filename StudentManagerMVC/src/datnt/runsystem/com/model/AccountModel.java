package datnt.runsystem.com.model;

public class AccountModel {
	
	private String username;
	private String password;
	private int    permission;
	
	public AccountModel(String username, String password, int permission) {
		this.username   = username;
		this.password   = password;
		this.permission = permission;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getPermission() {
		return permission;
	}
}
