package repository;

import java.util.ArrayList;
import java.util.List;

import DBConfiguration.DBInitialize;
import Model.EventModel;
import Model.EventRegisterModel;
import Model.StudentModel;

public class EventRegisterRepoImpl extends DBInitialize implements EventRegisterRepo{

	List<StudentModel> list;
	List<EventModel> eventList;
	@Override
	public List<StudentModel> viewEventWiseStudentRegistrations(String eventName) {
		try {
			list = new ArrayList<StudentModel>();
			
			psmt=conn.prepareStatement("select s.sid , s.sname , s.email, s.contact, s.dept from student s join registration r on s.sid = r.sid join event e on e.eid = r.eid where e.name = ?");
			psmt.setString(1, eventName);
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				StudentModel model = new StudentModel();
				model.setSid(rs.getInt(1));
				model.setSname(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContact(rs.getString(4));
				model.setDept(rs.getString(5));
				
				list.add(model);
				
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return list;
	}

	@Override
	public List<EventModel> viewStudentWiseEventRegistrations(int studentIdS) {
		try {
			eventList = new ArrayList<EventModel>();
			
			psmt=conn.prepareStatement("select e.eid , e.name , e.edate , e.venue , e.capacity from event e join registration r on e.eid = r.eid join student s on s.sid = r.sid where s.sid = ? ");
			psmt.setInt(1, studentIdS);
			
			rs=psmt.executeQuery();
			while(rs.next()) {
				EventModel model = new EventModel();
				model.setEid(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setEdate(rs.getDate(3));
				model.setVenue(rs.getString(4));
				model.setCapacity(rs.getInt(5));
				
				eventList.add(model);
			}
		}
		catch(Exception e) {
			System.out.println("Error is :"+e);
		}
		return eventList;
	}

	@Override
	public EventModel getEventCapacityDetails(int eventId) {
		try {
			EventModel model=new EventModel();
	        // event name ,  capacity
	        psmt = conn.prepareStatement("select  name, capacity from event where eid = ?");
	        psmt.setInt(1, eventId);
	        rs = psmt.executeQuery();

	        if (!rs.next()) {
	            return null; // event not found
	        }

	        model.setEid(eventId);
	        model.setName(rs.getString("name"));
	        model.setCapacity(rs.getInt("capacity"));

	        // count how many students  register for the given event 
	        psmt = conn.prepareStatement("select count(*) from registration where eid = ?");
	        psmt.setInt(1, eventId);
	        
	        rs = psmt.executeQuery();
	        rs.next();

	        model.setRegistered(rs.getInt(1));
	        
	        model.setAvailable(model.getCapacity() - model.getRegistered());

	        return model;

	    } catch (Exception e) {
	        System.out.println("Error is"+e);
	        return null;
	    }
	}

	@Override
	public EventRegisterModel isUpdateStuddentEvent(EventRegisterModel model) {
		try {
			psmt=conn.prepareStatement("update registration set sid=? where eid=? and rid=?");
			psmt.setInt(1, model.getSid());
			psmt.setInt(2, model.getEid());
			psmt.setInt(3, model.getRid());
			
			int val = psmt.executeUpdate();
			if(val>0) {
				return model;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return null;
	}

	@Override
	public boolean deleteRegistrationById(int rid) {
		 try {
		        psmt = conn.prepareStatement("delete from registration where rid=?");
		        psmt.setInt(1, rid);

		        int val = psmt.executeUpdate();
		        if(val>0) {
		        	return true;
		        }
		        else {
		        	return false;
		        }
		    }
		    catch(Exception e) {
		        System.out.println("Error is : " + e);
		        return false;
		    }
		    
	}
}
