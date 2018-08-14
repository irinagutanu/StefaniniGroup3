package ro.stefanini.dataOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.sql.Statement;

public class Test {
	private static String dbURL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7251937";
	private static String dbUser = "sql7251937";
	private static String dbPassword = "LCBKBgjWGd";
	
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM Answer");
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnCount());
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
}
