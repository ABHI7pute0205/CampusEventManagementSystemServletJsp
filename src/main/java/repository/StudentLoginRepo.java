package repository;

import Model.StudentModel;
import lombok.Data;
@Data
public interface StudentLoginRepo {
	public boolean isValidateStudent(StudentModel model);
	public int getStudentId(String name,String password);
}
