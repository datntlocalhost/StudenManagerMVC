package datnt.runsystem.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datnt.runsystem.com.dto.SubjectDTO;
import datnt.runsystem.com.dto.SubjectInfoDTO;
import datnt.runsystem.com.utils.ConnectionPool;
import datnt.runsystem.com.utils.DateUtility;

public class SubjectModel {
	
	private static SubjectModel instance;
	
	private SubjectModel() {}
	
	public static SubjectModel getInstance() {
		if (instance == null) {
			instance = new SubjectModel();
		}
		return instance;
	}
	
	public ArrayList<SubjectInfoDTO> getSubjectInfo(String id) {
		ArrayList<SubjectInfoDTO> subjects  = new ArrayList<SubjectInfoDTO>();
		Connection            conn      = null;
		ResultSet             result    = null;
		PreparedStatement     preState  = null;
		
		String sql = "SELECT MH.MAMH, MH.TENMH, CT.NAMHOC, CT.HOCKY, CT.DIEMQT, CT.DIEMTH, CT.DIEMGK, CT.DIEMCK "
				+ "FROM CHITIETMONHOC CT, MONHOC MH "
				+ "WHERE CT.MAMH=MH.MAMH AND CT.MSSV=?";
		try {
			conn = ConnectionPool.getInstance().getConnection();
			preState = conn.prepareStatement(sql);
			preState.setString(1, id);
			result = preState.executeQuery();
			
			while (result.next()) {
				String idSubject   = result.getString(1);
				String nameSubject = result.getString(2);
				String year        = result.getString(3);
				int semester       = result.getInt(4);
				float qtScores     = result.getFloat(5);
				float thScores     = result.getFloat(6);
				float gkScores     = result.getFloat(7);
				float ckScores     = result.getFloat(8);
				
				subjects.add(new SubjectInfoDTO(idSubject, nameSubject, year, semester, qtScores, thScores, gkScores, ckScores));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (preState != null) {
					preState.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return subjects;
	}
	
	public ArrayList<SubjectDTO> getSubjects() {
		ArrayList<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement preStatement = null;
		
		String sql = "SELECT * FROM MONHOC;";
		try {
			conn = ConnectionPool.getInstance().getConnection();
			preStatement = conn.prepareStatement(sql);
			
			result = preStatement.executeQuery();
			
			while (result.next()) {
				SubjectDTO subject = new SubjectDTO(result.getString("MAMH"), result.getString("TENMH"));
				subjects.add(subject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (preStatement != null) {
					preStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return subjects;
	}
	
	public ArrayList<String> registedSubject(String idStudent) {
		ArrayList<String>     subs      = new ArrayList<String>();
		Connection            conn      = null;
		ResultSet             result    = null;
		PreparedStatement     preState  = null;
		
		String sql = "SELECT MAMH FROM CHITIETMONHOC WHERE MSSV=?;";
		try {
			conn = ConnectionPool.getInstance().getConnection();
			preState = conn.prepareStatement(sql);
			preState.setString(1, idStudent);
			result = preState.executeQuery();
			
			while (result.next()) {
				String idSubject   = result.getString("MAMH");
				subs.add(idSubject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (preState != null) {
					preState.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return subs;
	}
	
	public void registerSubject(String idStudent, ArrayList<String> subjects) {
		Connection conn = null;
		Statement statement = null;
		
		try {
			conn = ConnectionPool.getInstance().getConnection();
			statement = conn.createStatement();
			String[] time = DateUtility.getYearSemester();
			for (int i = 0; i < subjects.size(); i++) {
				String sql = "INSERT INTO CHITIETMONHOC(MSSV, MAMH, NAMHOC, HOCKY) "
						+ "VALUES('" + idStudent + "','" + subjects.get(i) + "','" + time[0] + "','" + time[1] + "');"; 
				statement.addBatch(sql);
			}
			statement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
