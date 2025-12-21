package Exceptions;

public class DeleteEventIdNotFoundUserDefinedException extends Exception{

	int eid;
	public DeleteEventIdNotFoundUserDefinedException(int eid) {
		this.eid=eid;
	}
	
	public String getErrorMsg() {
		return "Event Not Found For the Given ID : "+eid;
	}
}
