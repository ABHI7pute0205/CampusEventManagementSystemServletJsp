package service;

import Exceptions.LoginAttemptsUserDefinedException;

// Service login attempts count + exception throw kar nar i.e.  Business logic

import Model.AdminLoginModel;
import repository.AdminLoginRepo;
import repository.AdminLoginRepoImpl;
 
public class AdminLoginServiceImpl implements AdminLoginService{
	
// in service layer we create an object of the Repository class 
	AdminLoginRepo adminRepo = new AdminLoginRepoImpl();
	
// variable to count login attempts 
	private static int loginAttempts=0;
	@Override
	public boolean validateAdminLogin(AdminLoginModel model) {

/* in this res variabel we get true if login success else we get false if details invalid
   then this go to if and check !res means false -> true and ente in if condition and increase
   loginAttempts if we put continusly 3 times wrong password or user name then we get this 
   msg |[ here in this we throw the class object which is created by user to manage user define
   exceptions and msg written in this class goes to LoginAttemptsUserDefinedException this
   class and this msg catch in client application ]| 
   [he logic eith ch ka lihi l tar adminLoginRepoImpl cha Object ServiceImpl madhe create kela 
   and te login zalya natar ch true false eith retun kar t so tya sathi he login attempts ch 
   logic eith lihil ]
*/
		boolean res = adminRepo.validateAdminLogin(model);
		if(!res) {
			loginAttempts++;
			if(loginAttempts == 3) {
				throw new LoginAttemptsUserDefinedException("Login Limit reach please try again after some time");
			}
		}
		else {
			loginAttempts=0;  // this will reset login attempts after login successfully
		}
		return res;
	}
}
