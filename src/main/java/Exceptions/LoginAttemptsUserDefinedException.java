package Exceptions;

// this exception class is use to display type of errors here we can not write Business logic 
public class LoginAttemptsUserDefinedException extends RuntimeException{

	public LoginAttemptsUserDefinedException(String msg) {
/*eith super ha parent class la point karto LoginAttemptsUserDefinedException ya cha parent 
 RuntimeException ye eith throw madhe jo msg dela ye to runtimeException cha (ex.getMessage()) 
 ne call kela jato so tya sathi super(msg) cha use kela 	
*/	
		super(msg);
	}
}
