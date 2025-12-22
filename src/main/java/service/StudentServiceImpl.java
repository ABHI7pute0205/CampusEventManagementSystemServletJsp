package service;

import java.util.List;

import Model.StudentModel;
import repository.StudentRepo;
import repository.StudentRepoImpl;

public class StudentServiceImpl implements StudentService{

	StudentRepo studentRepo = new StudentRepoImpl();
	@Override
	public boolean isAddStudent(StudentModel model) {
		// TODO Auto-generated method stub
		return studentRepo.isAddStudent(model);
	}
	@Override
	public List<StudentModel> viewAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.viewAllStudents();
	}
	@Override
	public boolean isDeleteStudentById(int eid) {
		// TODO Auto-generated method stub
		return studentRepo.isDeleteStudentById(eid);
	}
	@Override
	public StudentModel isUpdateStudent(StudentModel model) {
		// TODO Auto-generated method stub
		return studentRepo.isUpdateStudent(model);
	}
	
	// me aata recently he method change kele
	@Override
	public List<StudentModel> isSearchStudentByDept(String dept , int limit , int offset) {
		// TODO Auto-generated method stub
		return studentRepo.isSearchStudentByDept(dept , limit , offset);
	}
	@Override
	public List<StudentModel> isSearchStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return studentRepo.isSearchStudentByEmail(email);
	}
	
	// this method is to apply pagination and getTotalstudentCount to prevent to stop at last page
	@Override
	public List<StudentModel> viewStudentsWithPagination(int limit, int offset) {
		// TODO Auto-generated method stub
		return studentRepo.viewStudentsWithPagination(limit, offset);
	}
	@Override
	public int getTotalStudentCount() {
		// TODO Auto-generated method stub
		return studentRepo.getTotalStudentCount();
	}
	@Override
	public int getStudentCountByDept(String dept) {
		return studentRepo.getStudentCountByDept(dept);
	}
}
