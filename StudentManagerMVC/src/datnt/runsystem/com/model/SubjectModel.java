package datnt.runsystem.com.model;

public class SubjectModel {
	
	private String id;
	private String nameSubject;
	private String year;
	private String semester;
	private float  qtScores;
	private float  thScores;
	private float  gkScores;
	private float  ckScores;
	
	public SubjectModel() {
		
	}

	public SubjectModel(String id, String nameSubject, String year, String semester, float qtScores, float thScores,
			float gkScores, float ckScores) {
		super();
		this.id = id;
		this.nameSubject = nameSubject;
		this.year = year;
		this.semester = semester;
		this.qtScores = qtScores;
		this.thScores = thScores;
		this.gkScores = gkScores;
		this.ckScores = ckScores;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameSubject() {
		return nameSubject;
	}

	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public float getQtScores() {
		return qtScores;
	}

	public void setQtScores(float qtScores) {
		this.qtScores = qtScores;
	}

	public float getThScores() {
		return thScores;
	}

	public void setThScores(float thScores) {
		this.thScores = thScores;
	}

	public float getGkScores() {
		return gkScores;
	}

	public void setGkScores(float gkScores) {
		this.gkScores = gkScores;
	}

	public float getCkScores() {
		return ckScores;
	}

	public void setCkScores(float ckScores) {
		this.ckScores = ckScores;
	}
}
