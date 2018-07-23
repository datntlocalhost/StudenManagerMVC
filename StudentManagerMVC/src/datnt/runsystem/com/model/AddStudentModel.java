package datnt.runsystem.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datnt.runsystem.com.utils.ConnectionPool;

public class AddStudentModel {
	
	private static AddStudentModel instance;
	
	private AddStudentModel() {}
	
	public static AddStudentModel getInstance() {
		if (instance == null) {
			instance = new AddStudentModel();
		}
		return instance;
	}
	
	public boolean addStudent(String idStudent, String idFaculty, String studentName) {
		boolean isSuccess = false;
		Connection conn = null;
		PreparedStatement preStatement = null;
		
		String sql = "INSERT INTO SINHVIEN(MSSV, MAKHOA, HOTEN) VALUES(?,?,?);";
		try {
			conn = ConnectionPool.getInstance().getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, idStudent);
			preStatement.setString(2, idFaculty);
			preStatement.setString(3, studentName);
			isSuccess = preStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
		return isSuccess;
	}
	
	public boolean addAccount(String idStudent, String password) {
		boolean           isSuccess = false;
		Connection        conn = null;
		PreparedStatement preStatement = null;
		
		String sql = "INSERT INTO TAIKHOAN(TAIKHOAN, MSSV, MATKHAU, PERMISSION) "
				+ "VALUES(?,?,?,0);";
		try {
			conn = ConnectionPool.getInstance().getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, idStudent);
			preStatement.setString(2, idStudent);
			preStatement.setString(3, password);
			
			isSuccess = preStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
		return isSuccess;
	}
	
	public boolean addInfo(String idStudent, String birthday) {
		boolean isSuccess = false;
		Connection conn = null;
		PreparedStatement preStatement = null;
		
		String sql = "INSERT INTO LYLICH(MSSV, NGAYSINH) "
				+ "VALUES(?,?);";
		try {
			conn = ConnectionPool.getInstance().getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, idStudent);
			preStatement.setString(2, birthday);
			
			isSuccess = preStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
		return isSuccess;
	}

}
