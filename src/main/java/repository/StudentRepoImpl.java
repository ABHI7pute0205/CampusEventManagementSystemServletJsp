package repository;

import java.util.ArrayList;
import java.util.List;

import DBConfiguration.DBInitialize;
import Exceptions.DeleteEventIdNotFoundUserDefinedException;
import Model.StudentModel;

public class StudentRepoImpl extends DBInitialize implements StudentRepo{

	List<StudentModel> list;
	List<StudentModel> searchByDeptList;
	List<StudentModel> searchByEmailList;
	
	@Override
	public boolean isAddStudent(StudentModel model) {
		try {
			psmt=conn.prepareStatement("insert into student (sname, email, contact, password, dept) values (?, ?, ?, ?, ?)");
			psmt.setString(1, model.getSname());
			psmt.setString(2, model.getEmail());
			psmt.setString(3, model.getContact());
			psmt.setString(4, model.getPassword());
			psmt.setString(5, model.getDept());
			
			int val = psmt.executeUpdate();
			if(val>0) {
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
	}

	@Override
	public List<StudentModel> viewAllStudents() {
		try {
			list=new ArrayList<StudentModel>();
			psmt=conn.prepareStatement("Select * from Student");
			rs=psmt.executeQuery();
			while(rs.next()) {
				StudentModel model = new StudentModel();
				model.setSid(rs.getInt(1));
				model.setSname(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContact(rs.getString(4));
				model.setPassword(rs.getString(5));
				model.setDept(rs.getString(6));
				
				list.add(model);
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return list;
	}

	@Override
	public boolean isDeleteStudentById(int eid) {
		try {
			psmt=conn.prepareStatement("delete from student where sid=?");
			psmt.setInt(1, eid);
			
			int val = psmt.executeUpdate();
			if(val > 0) {
				return true;
			}
			throw new DeleteEventIdNotFoundUserDefinedException(val);
		}
		catch(DeleteEventIdNotFoundUserDefinedException ex) {
			System.out.println(ex.getErrorMsg());
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return false;
	}

	@Override
	public StudentModel isUpdateStudent(StudentModel model) {
		try {
			psmt=conn.prepareStatement("update student set sname=? , email=? , contact=? , password=? , dept=? where sid=?");
			psmt.setString(1, model.getSname());
			psmt.setString(2, model.getEmail());
			psmt.setString(3, model.getContact());
			psmt.setString(4, model.getPassword());
			psmt.setString(5, model.getDept());
			psmt.setInt(6, model.getSid());
			
			int val = psmt.executeUpdate();
			if(val>0) {
				return model;
			}
			else {
				return null;
			}
			
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
			return null;
		}
		
	}

	@Override
	public List<StudentModel> isSearchStudentByDept(String dept) {
		try {
			searchByDeptList = new ArrayList<StudentModel>();
			psmt=conn.prepareStatement("select * from student where dept=?");
			psmt.setString(1, dept);
			
			rs=psmt.executeQuery();
			while(rs.next()) {
				StudentModel model = new StudentModel();
				model.setSid(rs.getInt(1));
				model.setSname(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContact(rs.getString(4));
				model.setPassword(rs.getString(5));
				model.setDept(rs.getString(6));
				
				searchByDeptList.add(model);
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return searchByDeptList;
	}

	@Override
	public List<StudentModel> isSearchStudentByEmail(String email) {
		try {
			searchByEmailList = new ArrayList<StudentModel>();
			psmt=conn.prepareStatement("select * from student where email=?");
			psmt.setString(1, email);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				StudentModel model = new StudentModel();
				model.setSid(rs.getInt(1));
				model.setSname(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContact(rs.getString(4));
				model.setPassword(rs.getString(5));
				model.setDept(rs.getString(6));
				
				searchByEmailList.add(model);
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return searchByEmailList;
	}


}
