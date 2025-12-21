package repository;

import DBConfiguration.DBInitialize;
import Model.AdminLoginModel;

public class AdminLoginRepoImpl extends DBInitialize implements AdminLoginRepo{

	@Override
	public boolean validateAdminLogin(AdminLoginModel model) {

		try {
			psmt=conn.prepareStatement("select * from adminLogin where uname=? and password=?");

			psmt.setString(1,model.getUsername());
			psmt.setString(2, model.getPassword());
			
			rs=psmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Error is :"+e);
		}
		return false;
	}
}







