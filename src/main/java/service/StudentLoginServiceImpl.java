package service;

import Model.StudentModel;
import repository.StudentLoginRepo;
import repository.StudentLoginRepoImpl;

public class StudentLoginServiceImpl implements StudentLoginService{

	StudentLoginRepo studentRepo = new StudentLoginRepoImpl();
	@Override
	public boolean isValidateStudent(StudentModel model) {
		// TODO Auto-generated method stub
		return studentRepo.isValidateStudent(model);
	}
	@Override
	public int getStudentId(String name, String password) {
		// TODO Auto-generated method stub
		return studentRepo.getStudentId(name, password);
	}

}
