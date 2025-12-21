package service;

import java.util.List;

import Model.EventModel;
import repository.EventRepo;
import repository.EventRepoImpl;

public class EventServiceImpl implements EventService{

	EventRepo eventRepo = new EventRepoImpl();
	
	@Override
	public boolean isAddEvent(EventModel model) {
		// TODO Auto-generated method stub
		return eventRepo.isAddEvent(model);
	}

	@Override
	public List<EventModel> getAllEvents() {
		// TODO Auto-generated method stub
		return eventRepo.getAllEvents();
	}

	@Override
	public List<EventModel> getUpComingEvents() {
		// TODO Auto-generated method stub
		return eventRepo.getUpComingEvents();
	}

	@Override
	public boolean isDeleteEvent(int eid) {
		// TODO Auto-generated method stub
		return eventRepo.isDeleteEvent(eid);
	}

	@Override
	public EventModel isUpdateEvent(EventModel model) {
		// TODO Auto-generated method stub
		return eventRepo.isUpdateEvent(model);
	}

	@Override
	public boolean registerStudentForEvent(int studentId, int eventId) {
		// TODO Auto-generated method stub
		return eventRepo.registerStudentForEvent(studentId, eventId);
	}

	@Override
	public boolean cancelEventRegistration(int studentId, int eventId) {
		return eventRepo.cancelEventRegistration(studentId, eventId);
	}

}
