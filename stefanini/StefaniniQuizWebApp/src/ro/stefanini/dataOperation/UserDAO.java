package ro.stefanini.dataOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ro.stefanini.dataOperation.DatabaseConnectionFactory;
import ro.stefanini.data.User;

@Component
public class UserDAO {
	
	private Connection con;
	private PreparedStatement preparedStatement;

	public void register(User user) {
		con = DatabaseConnectionFactory.createConnection();
		preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement("insert into Users (username, password, name, surname, email) values (?,?,?,?,?)");
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
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public User getUser(final String name, final String password) {
		con = DatabaseConnectionFactory.createConnection();
		preparedStatement = null;
		ResultSet usersRs = null;
		User user = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement("SELECT * FROM Users WHERE name=? AND password = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			usersRs = preparedStatement.executeQuery();
			user = createUsers(usersRs).get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(usersRs);
			DbUtills.closeQuietly(preparedStatement);
			DbUtills.closeQuietly(con);
		}
		return user;
	}
	
	public User getUserById(final Integer id) {
		con = DatabaseConnectionFactory.createConnection();
		preparedStatement = null;
		ResultSet usersRs = null;
		User user = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement("SELECT * FROM Users WHERE user_id=?");
			preparedStatement.setInt(1, id);
			usersRs = preparedStatement.executeQuery();
			user = createUsers(usersRs).get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(usersRs);
			DbUtills.closeQuietly(preparedStatement);
			DbUtills.closeQuietly(con);
		}
		return user;
	}
	
	protected List<User> createUsers(ResultSet rs) throws SQLException{
		List<User> users = new ArrayList<>();
		while(rs.next()) {
			Integer userId = rs.getInt("user_id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			String email = rs.getString("email");
			Integer scor = rs.getInt("scor");
			users.add(new User(userId,username,password,name,surname,email,scor));
		}
		return users;
	}

}
