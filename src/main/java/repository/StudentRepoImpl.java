package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConfiguration.DBInitialize;
import Exceptions.DeleteEventIdNotFoundUserDefinedException;
import Model.StudentModel;

public class StudentRepoImpl extends DBInitialize implements StudentRepo {

	List<StudentModel> list;
	List<StudentModel> searchByDeptList;
	List<StudentModel> searchByEmailList;

	@Override
	public boolean isAddStudent(StudentModel model) {
		try {
			psmt = conn.prepareStatement(
					"insert into student (sname, email, contact, password, dept) values (?, ?, ?, ?, ?)");
			psmt.setString(1, model.getSname());
			psmt.setString(2, model.getEmail());
			psmt.setString(3, model.getContact());
			psmt.setString(4, model.getPassword());
			psmt.setString(5, model.getDept());

			int val = psmt.executeUpdate();
			if (val > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error is : " + e);
			return false;
		}
	}

	@Override
	public List<StudentModel> viewAllStudents() {
		try {
			list = new ArrayList<StudentModel>();
			psmt = conn.prepareStatement("Select * from Student");
			rs = psmt.executeQuery();
			while (rs.next()) {
				StudentModel model = new StudentModel();
				model.setSid(rs.getInt(1));
				model.setSname(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContact(rs.getString(4));
				model.setPassword(rs.getString(5));
				model.setDept(rs.getString(6));

				list.add(model);
			}
		} catch (Exception e) {
			System.out.println("Error is : " + e);
		}
		return list;
	}

	@Override
	public boolean isDeleteStudentById(int eid) {
		try {
			psmt = conn.prepareStatement("delete from student where sid=?");
			psmt.setInt(1, eid);

			int val = psmt.executeUpdate();
			if (val > 0) {
				return true;
			}
			throw new DeleteEventIdNotFoundUserDefinedException(val);
		} catch (DeleteEventIdNotFoundUserDefinedException ex) {
			System.out.println(ex.getErrorMsg());
		} catch (Exception e) {
			System.out.println("Error is : " + e);
		}
		return false;
	}

	@Override
	public StudentModel isUpdateStudent(StudentModel model) {
		try {
			psmt = conn.prepareStatement(
					"update student set sname=? , email=? , contact=? , password=? , dept=? where sid=?");
			psmt.setString(1, model.getSname());
			psmt.setString(2, model.getEmail());
			psmt.setString(3, model.getContact());
			psmt.setString(4, model.getPassword());
			psmt.setString(5, model.getDept());
			psmt.setInt(6, model.getSid());

			int val = psmt.executeUpdate();
			if (val > 0) {
				return model;
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("Error is : " + e);
			return null;
		}

	}

	@Override
	public List<StudentModel> isSearchStudentByDept(String dept, int limit, int offset) {
		try {
			searchByDeptList = new ArrayList<StudentModel>();
			psmt = conn.prepareStatement("select * from student where dept=? limit ? offset ?");

			psmt.setString(1, dept);
			psmt.setInt(2, limit);
			psmt.setInt(3, offset);

			rs = psmt.executeQuery();
			while (rs.next()) {
				StudentModel model = new StudentModel();
				model.setSid(rs.getInt(1));
				model.setSname(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContact(rs.getString(4));
				model.setPassword(rs.getString(5));
				model.setDept(rs.getString(6));

				searchByDeptList.add(model);
			}
		} catch (Exception e) {
			System.out.println("Error is : " + e);
		}
		return searchByDeptList;
	}

	@Override
	public List<StudentModel> isSearchStudentByEmail(String email) {
		try {
			searchByEmailList = new ArrayList<StudentModel>();
			psmt = conn.prepareStatement("select * from student where email=?");
			psmt.setString(1, email);

			rs = psmt.executeQuery();
			while (rs.next()) {
				StudentModel model = new StudentModel();
				model.setSid(rs.getInt(1));
				model.setSname(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContact(rs.getString(4));
				model.setPassword(rs.getString(5));
				model.setDept(rs.getString(6));

				searchByEmailList.add(model);
			}
		} catch (Exception e) {
			System.out.println("Error is : " + e);
		}
		return searchByEmailList;
	}

	// this method is for pagination
	@Override
	public List<StudentModel> viewStudentsWithPagination(int limit, int offset) {

		List<StudentModel> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement("select * from student limit ? offset ?");
			psmt.setInt(1, limit);
			psmt.setInt(2, offset);

			rs = psmt.executeQuery();

			while (rs.next()) {
				StudentModel model = new StudentModel();
				model.setSid(rs.getInt(1));
				model.setSname(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContact(rs.getString(4));
				model.setPassword(rs.getString(5));
				model.setDept(rs.getString(6));

				list.add(model);
			}
		} catch (Exception e) {
			System.out.println("Pagination Error : " + e);
		}

		return list;
	}

	@Override
	public int getTotalStudentCount() {
		int count = 0;
		try {
			psmt = conn.prepareStatement("select count(*) from student");
			rs = psmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Error is: " + e);
		}
		return count;
	}

	@Override
	public int getStudentCountByDept(String dept) {
		int count = 0;

	    try {
	        psmt = conn.prepareStatement("select count(*) from student where dept=?");

	        psmt.setString(1, dept);
	        rs = psmt.executeQuery();

	        if (rs.next()) {
	            count = rs.getInt(1);
	        }

	    } catch (Exception e) {
	        System.out.println("Dept Count Error: " + e);
	    }

	    return count;
	}

	@Override
	public StudentModel getStudentById(int sid) {

		try {
			psmt = conn.prepareStatement("select * from student where sid=?");
			psmt.setInt(1, sid);

			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				StudentModel s = new StudentModel();
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setEmail(rs.getString("email"));
				s.setContact(rs.getString("contact"));
				s.setPassword(rs.getString("password"));
				s.setDept(rs.getString("dept"));
				return s;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
