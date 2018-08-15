package ro.stefanini.dataOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactory {

	private static String dbURL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7251937";
	private static String dbUser = "sql7251937";
	private static String dbPassword = "LCBKBgjWGd";

	public static Connection createConnection() {
		Connection con = null;
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