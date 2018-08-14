package ro.stefanini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import ro.stefanini.data.DatabaseConnectionFactory;
import ro.stefanini.data.User;

@Component
public class UserDaoImpl {

	public void register(User user) {
		Connection con = DatabaseConnectionFactory.createConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("insert into users (username, password, name, surname, email) values (?,?,?,?,?)");
			preparedStatement.setString(1, user.getUsername()); 
			preparedStatement.setString(2, user.getPassword()); 
			preparedStatement.setString(3, user.getName()); 
			preparedStatement.setString(4, user.getSurname());
			preparedStatement.setString(5, user.getEmail());
			System.out.println("Updated = " + preparedStatement.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
