/*
 * Class AddStudentModel 
 * 
 * Chứa các phương thức thêm sinh viên vào database 
 */

package datnt.runsystem.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	/*
	 * Thêm thông tin sinh viên vào database SINHVIEN
	 * 
	 * @param idStudent   Mã số sinh viên
	 * @param idFaculty   Mã khoa
	 * @param studentName Họ tên sinh viên
	 * @return boolean    True nếu thêm thành công, false nếu thất bại
	 */
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
	
	/*
	 * Thêm thông tin tài khoản sinh viên vào database TAIKHOAN
	 * 
	 * @param idStudent  Mã số sinh viên (cũng chính là tài khoản) 
	 * @param password   Mật khẩu đã được hash MD5
	 * @return boolean   True nếu thêm thành công. false nếu thất bại 
	 */
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
	
	/*
	 * Thêm thông tin của sinh viên vào database LYLICH
	 * 
	 * @param idStudent  Mã số sinh viên 
	 * @param birthday   Ngày sinh 
	 * @return boolean   True nếu thêm thành công, false nếu thất bại
	 */
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
