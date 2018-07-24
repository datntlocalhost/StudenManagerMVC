/*
 * Class StudentModel 
 * 
 * Chứa các phương thức lấy thông tin đầy đủ của sinh viên 
 * và cập nhật thông tin lý lích cho sinh viên
 */

package datnt.runsystem.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import datnt.runsystem.com.dto.StudentDTO;
import datnt.runsystem.com.utils.ConnectionPool;

public class StudentModel {
	
	private static StudentModel instance;
	
	private StudentModel() {}
	
	public static StudentModel getInstance() {
		if (instance == null) {
			instance = new StudentModel();
		}
		return instance;
	}
	
	/*
	 * Lấy thông tin đầy đủ của sinh viên dựa vào mã số sinh viên
	 * 
	 * @param id           Mã số sinh viên  
 	 * @return StudentDTO  Đối tượng StudentDTO
 	 */
	public StudentDTO getStudentInfo(String id) {
		StudentDTO student = null;
		Connection conn = null;
		ResultSet  result = null;
		PreparedStatement preStatement = null;
		
		String sql = "SELECT SV.MSSV, K.TENKHOA, SV.HOTEN, LL.NGAYSINH, LL.DIACHI, LL.SDT, LL.EMAIL "
				+ "FROM SINHVIEN SV, LYLICH LL, KHOA K "
				+ "WHERE SV.MSSV=LL.MSSV AND SV.MAKHOA=K.MAKHOA AND SV.MSSV=?;";
		try {
			conn = ConnectionPool.getInstance().getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, id);
			result = preStatement.executeQuery();
			
			if (result.next()) {
				String mssv     = result.getString(1);
				String faculty  = result.getString(2);
				String name     = result.getString(3);
				String birthday = result.getString(4);
				String address  = result.getString(5);
				String phone    = result.getString(6);
				String email    = result.getString(7);
				
				student = new StudentDTO(id, name, faculty, birthday, address, phone, email);
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
		return student;
	}
	
	/*
	 * Cập nhật thông tin lí lịch cho sinh viên
	 * 
	 * @param idStudent   Mã số sinh viên
	 * @param address	  Địa chỉ
	 * @param phone       Số điện thoại
	 * @param email       Email 
	 * @return boolean    True nếu update thành công, false nếu thất bại
	 */
	public boolean updateInfo(String idStudent, String address, String phone, String email) {
		boolean isUpdate = false;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement preState = null;
		
		String sql ="UPDATE LYLICH SET DIACHI=?, SDT=?, EMAIL=? "
				+ "WHERE MSSV=?;";
		try {
			conn = ConnectionPool.getInstance().getConnection();
			preState = conn.prepareStatement(sql);
			preState.setString(1, address);
			preState.setString(2, phone);
			preState.setString(3, email);
			preState.setString(4, idStudent);
			
			isUpdate = preState.executeUpdate() > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (result != null) {
					result.close();
				}
				if (result != null) {
					result.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return isUpdate;
	}

}
