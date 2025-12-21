package repository;

import DBConfiguration.DBInitialize;
import Model.StudentModel;

public class StudentLoginRepoImpl extends DBInitialize implements StudentLoginRepo{

	public boolean isValidateStudent(StudentModel model) {
		try {
			psmt=conn.prepareStatement("select * from student where email=? and password=?");
			psmt.setString(1, model.getEmail());
			psmt.setString(2, model.getPassword());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
			return false;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getStudentId(String name, String password) {
		try {
			psmt=conn.prepareStatement("select * from student where email=? and password=?");
			psmt.setString(1,name);
			psmt.setString(2,password);
			rs=psmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1); 
			}
			else {
				return 0;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
	}

}
