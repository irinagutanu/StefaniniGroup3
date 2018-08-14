package ro.stefanini.dataOperation;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
	private static String dbURL = "jdbc:mysql://localhost:3306/quiz";
	private static String dbUser = "root";
	private static String dbPassword = "parola123";
	
	public static void main(String[] args) {
		Connectionon con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
				
	}
}
