package ro.stefanini.dataOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactory {

	// TODO: de verificat URL-ul dupa ce avem baza de date
	private static Connection con = null;
	private static String dbURL = "jdbc:mysql://localhost:3306/quiz";
	private static String dbUser = "root";
	private static String dbPassword = "parola123";

	public static Connection createConnection() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error: unable to load driver class!");
				System.exit(1);
			}
			con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
		} catch (SQLException sqe) {
			System.out.println("Error: While Creating connection to database");
			sqe.printStackTrace();
		}
		if (con!= null) {
			System.out.println("Connection to Quiz established");
		}
		return con;
	}

}