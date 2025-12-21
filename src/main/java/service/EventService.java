package service;

import java.util.List;

import Model.EventModel;

public interface EventService {

	public boolean isAddEvent(EventModel model);
	public List<EventModel> getAllEvents();
	public List<EventModel> getUpComingEvents();
	public boolean isDeleteEvent(int eid);
	public EventModel isUpdateEvent(EventModel model);

	boolean registerStudentForEvent(int studentId, int eventId);
	public boolean cancelEventRegistration(int studentId, int eventId);
}
