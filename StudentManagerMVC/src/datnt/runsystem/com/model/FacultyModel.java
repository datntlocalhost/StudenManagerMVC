package datnt.runsystem.com.model;

public class FacultyModel {
	
	private String id;
	private String nameFaculty;
	
	public FacultyModel(String id, String nameFaculty) {
		this.id = id;
		this.nameFaculty = nameFaculty;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameFaculty() {
		return nameFaculty;
	}

	public void setNameFaculty(String nameFaculty) {
		this.nameFaculty = nameFaculty;
	}
}
