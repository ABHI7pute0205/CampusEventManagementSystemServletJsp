package service;

import java.util.List;

import Model.EventModel;
import Model.EventRegisterModel;
import Model.StudentModel;

public interface EventRegisterService {

	public List<StudentModel> viewEventWiseStudentRegistrations(String eventName);
	
	public List<EventModel> viewStudentWiseEventRegistrations(int sid);
	
	public EventModel getEventCapacityDetails(int eventId);
	public EventRegisterModel isUpdateStuddentEvent(EventRegisterModel model);
	public boolean deleteRegistrationById(int rid);
}
