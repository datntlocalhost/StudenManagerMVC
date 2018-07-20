package datnt.runsystem.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datnt.runsystem.com.dto.SubjectDTO;
import datnt.runsystem.com.utils.ConnectionPool;

public class SubjectModel {
	
	private static SubjectModel instance;
	
	private SubjectModel() {}
	
	public static SubjectModel getInstance() {
		if (instance == null) {
			instance = new SubjectModel();
		}
		return instance;
	}
	
	public ArrayList<SubjectDTO> getSubject(String id) {
		ArrayList<SubjectDTO> subjects  = new ArrayList<SubjectDTO>();
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
				
				subjects.add(new SubjectDTO(idSubject, nameSubject, year, semester, qtScores, thScores, gkScores, ckScores));
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

}
