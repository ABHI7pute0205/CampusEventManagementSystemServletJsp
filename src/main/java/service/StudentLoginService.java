package service;

import Model.StudentModel;

public interface StudentLoginService {

	public boolean isValidateStudent(StudentModel model);
	public int getStudentId(String name,String password);
}
