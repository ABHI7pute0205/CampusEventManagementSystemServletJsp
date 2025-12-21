package service;

import java.util.List;

import Model.StudentModel;

public interface StudentService {
	
	public boolean isAddStudent(StudentModel model);
	public List<StudentModel> viewAllStudents();
	public boolean isDeleteStudentById(int eid);
	public StudentModel isUpdateStudent(StudentModel model);
	public List<StudentModel> isSearchStudentByDept(String dept);
	public List<StudentModel> isSearchStudentByEmail(String email);
}
