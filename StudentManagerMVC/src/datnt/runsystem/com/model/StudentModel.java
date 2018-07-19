package datnt.runsystem.com.model;

public class StudentModel {
	
	private String id;
	private String name;
	private InfoModel info;
	private FacultyModel faculty;
	private SubjectModel subject;
	
	public StudentModel(String id, String name, InfoModel info, FacultyModel faculty, SubjectModel sub) {
		this.id   = id;
		this.name = name;
		this.info = info;
		this.faculty = faculty;
		this.subject = sub;
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

	public InfoModel getInfo() {
		return info;
	}

	public void setInfo(InfoModel info) {
		this.info = info;
	}

	public FacultyModel getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyModel faculty) {
		this.faculty = faculty;
	}

	public SubjectModel getSubject() {
		return subject;
	}

	public void setSubject(SubjectModel subject) {
		this.subject = subject;
	}
}
