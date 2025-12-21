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
	@Override
	public List<StudentModel> isSearchStudentByDept(String dept) {
		// TODO Auto-generated method stub
		return studentRepo.isSearchStudentByDept(dept);
	}
	@Override
	public List<StudentModel> isSearchStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return studentRepo.isSearchStudentByEmail(email);
	}
}
