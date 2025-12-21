package service;

import java.util.List;

import Model.EventModel;
import Model.EventRegisterModel;
import Model.StudentModel;
import repository.EventRegisterRepo;
import repository.EventRegisterRepoImpl;

public class EventRegisterServiceImpl implements EventRegisterService{

	EventRegisterRepo eventRegister = new EventRegisterRepoImpl();
	@Override
	public List<StudentModel> viewEventWiseStudentRegistrations(String eventName) {
		// TODO Auto-generated method stub
		return eventRegister.viewEventWiseStudentRegistrations(eventName);
	}
	@Override
	public List<EventModel> viewStudentWiseEventRegistrations(int sid) {
		// TODO Auto-generated method stub
		return eventRegister.viewStudentWiseEventRegistrations(sid);
//		List<EventModel> lst = eventRegister.viewStudentWiseEventRegistrations(studentNmae);

		
	}
	@Override
	public EventModel getEventCapacityDetails(int eventId) {
		// TODO Auto-generated method stub
		return eventRegister.getEventCapacityDetails(eventId);
	}
	@Override
	public EventRegisterModel isUpdateStuddentEvent(EventRegisterModel model) {
		// TODO Auto-generated method stub
		return eventRegister.isUpdateStuddentEvent(model);
	}
	@Override
	public boolean deleteRegistrationById(int rid) {
		// TODO Auto-generated method stub
		return eventRegister.deleteRegistrationById(rid);
	}


}
