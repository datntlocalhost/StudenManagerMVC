package datnt.runsystem.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datnt.runsystem.com.model.FacultyModel;
import datnt.runsystem.com.model.InfoModel;
import datnt.runsystem.com.model.StudentModel;
import datnt.runsystem.com.model.SubjectModel;

public class FullInfoDAO {
	
	private static FullInfoDAO instance;
	
	private FullInfoDAO() {}
	
	public static FullInfoDAO getInstance() {
		if (instance == null) {
			instance = new FullInfoDAO();
		}
		return instance;
	}
	
	public StudentModel getFullInfo(String mssv) {
		StudentModel      studentModel = null;
		Connection        connection   = null;
		ResultSet         resultSet    = null;
		PreparedStatement preStatement = null;
		
		String sql = "SELECT SV.MSSV,SV.HOTEN,K.TENKHOA,LL.NGAYSINH,LL.DIACHI,LL.SDT,LL.EMAIL,K.MAKHOA "
				+ "FROM SINHVIEN AS SV, LYLICH AS LL, KHOA AS K "
				+ "WHERE SV.ID=LL.ID AND SV.MAKHOA=K.MAKHOA AND SV.MSSV=?";
		try {
			connection = ConnectionPool.getInstance().getDataSource().getConnection();
			preStatement = connection.prepareStatement(sql);
			preStatement.setString(1, mssv);
			resultSet    = preStatement.executeQuery();
			
			if (resultSet.next()) {
				String ms       = resultSet.getString(1);
				String name     = resultSet.getString(2);
				String faculty  = resultSet.getString(3);
				String birthday = resultSet.getString(4);
				String address  = resultSet.getString(5);
				String phone    = resultSet.getString(6);
				String email    = resultSet.getString(7);
				String facID    = resultSet.getString(8);
				
				InfoModel info = new InfoModel(birthday, address, phone, email);
				FacultyModel facultyModel = new FacultyModel(facID, faculty);
				
				studentModel = new StudentModel(ms, name, info, facultyModel, new SubjectModel());
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preStatement != null) {
					preStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return studentModel;
	}

}
