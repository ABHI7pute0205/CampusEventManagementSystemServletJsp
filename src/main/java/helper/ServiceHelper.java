package helper;



import service.AdminLoginService;
import service.AdminLoginServiceImpl;
import service.EventRegisterService;
import service.EventRegisterServiceImpl;
import service.EventService;
import service.EventServiceImpl;
import service.StudentLoginService;
import service.StudentLoginServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;

public class ServiceHelper {
	public static AdminLoginService adminService = new AdminLoginServiceImpl();
	public static StudentLoginService studentLogin = new StudentLoginServiceImpl();
	public static StudentService studentService = new StudentServiceImpl();
	public static EventService eventService = new EventServiceImpl();

	public static EventRegisterService eventRegService = new EventRegisterServiceImpl();
}
