package DBConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.io.*;

public class DBInitialize {

// ya na jar private kel tar class chya and package chya baher access kar ta yet nahi
	protected PreparedStatement psmt;
	public Connection conn;
	protected ResultSet rs;
	
	protected FileInputStream fin;
	
	public DBInitialize() {
		try {
// campusEvenentManagementServletApp/target/m2e-wtp/web-resources/db.properties
// campusEvenentManagementServletApp/src/main/java/resources/db.properties
			File f = new File("C:\\Users\\abhis\\eclipse-workspace\\campusEvenentManagementServletApp\\src\\main\\java\\resources\\db.properties");
			
			
			fin = new FileInputStream(f);
			
			Properties p = new Properties();
			p.load(fin);
			
			String uname=p.getProperty("uname");
			String pass = p.getProperty("pass");
			String url=p.getProperty("url");
			String driver=p.getProperty("driver");
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url,uname,pass);
			
			if(conn != null) {
				//System.out.println("Database is Connected");
			}
			else {
				System.out.println("Database is NOT Connected Something Wrong...");
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);		}
	}

// this is to check the data base is connected or not properly  
//	public static void main(String x[]) {
//		new DBInitialize();
//	}
}




