/*
 * Class FacultyModel 
 * 
 * Chứa các phương thức lấy và cập nhật dữ liệu cho đối tượng 
 * Khoa từ database KHOA 
 */

package datnt.runsystem.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import datnt.runsystem.com.dto.FacultyDTO;
import datnt.runsystem.com.utils.ConnectionPool;

public class FacultyModel {
	
	private static FacultyModel instance;
	
	private FacultyModel() {}
	
	public static FacultyModel getInstance() {
		if (instance == null) {
			instance = new FacultyModel();
		}
		return instance;
	}
	
	/*
	 * Lấy danh sách thông tin các khoa đang có trong database 
	 * 
	 * @return ArrayList<FacultyDTO>
	 */
	public ArrayList<FacultyDTO> getFaculties() {
		ArrayList<FacultyDTO> faculties = new ArrayList<FacultyDTO>();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement preStatement = null;
		
		String sql = "SELECT * FROM KHOA;";
		try {
			conn = ConnectionPool.getInstance().getConnection();
			preStatement = conn.prepareStatement(sql);
			
			result = preStatement.executeQuery();
			
			while (result.next()) {
				FacultyDTO fac = new FacultyDTO(result.getString("MAKHOA"), result.getString("TENKHOA"));
				faculties.add(fac);
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
		
		return faculties;
	}
}
