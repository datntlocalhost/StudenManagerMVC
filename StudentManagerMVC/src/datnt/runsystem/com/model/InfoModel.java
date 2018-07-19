package datnt.runsystem.com.model;

public class InfoModel {
	
	private String birthDay;
	private String address;
	private String phone;
	private String email;
	
	public InfoModel(String birthday, String address, String phone, String email) {
		this.birthDay = birthday;
		this.address  = address;
		this.phone    = phone;
		this.email    = email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
