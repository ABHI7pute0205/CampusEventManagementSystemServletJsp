package service;

import java.util.List;

import Model.StudentModel;

public interface StudentService {
	
	public boolean isAddStudent(StudentModel model);
	public List<StudentModel> viewAllStudents();
	public boolean isDeleteStudentById(int eid);
	public StudentModel isUpdateStudent(StudentModel model);
	
	public List<StudentModel> isSearchStudentByDept(String dept , int limit , int offset);
	public int getStudentCountByDept(String dept);
	
	public List<StudentModel> isSearchStudentByEmail(String email);
	
	// new method to apply pagination:
	
	public List<StudentModel> viewStudentsWithPagination(int limit, int offset);
	public int getTotalStudentCount();
}
