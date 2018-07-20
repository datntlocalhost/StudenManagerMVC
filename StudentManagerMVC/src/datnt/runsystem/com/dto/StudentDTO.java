package datnt.runsystem.com.dto;

public class StudentDTO {
	
	private String id;
	private String name;
	private String faculty;
	private String birthday;
	private String address;
	private String phone;
	private String email;
	
	public StudentDTO(String id, String name, String factural) {
		super();
		this.id = id;
		this.name = name;
		this.faculty = factural;
	}

	public StudentDTO(String id, String name, String factural, String birthday, String address, String phone,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.faculty = factural;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String factural) {
		this.faculty = factural;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
