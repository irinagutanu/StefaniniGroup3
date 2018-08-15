import static org.junit.Assert.*;

import org.junit.Test;

import ro.stefanini.data.User;

public class UserTest {

	@Test
	public void FullConstructurTestID() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		
		Integer actual = u.getId();
		Integer expected = 1;
		assertEquals(actual, expected);
	}
	
	@Test
	public void FullConstructurTestUsername() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		
		String actual = u.getUsername();
		String expected = "JohnDoe";
		assertEquals(actual, expected);
	}
	
	@Test
	public void FullConstructurTestPassword() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		
		String actual = u.getPassword();
		String expected = "jhasebnvcas";
		assertEquals(actual, expected);
	}
	
	@Test
	public void FullConstructurTestName() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		
		String actual = u.getName();
		String expected = "John";
		assertEquals(actual, expected);
	}
	
	@Test
	public void FullConstructurTestSurname() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		
		String actual = u.getSurname();
		String expected = "Doe";
		assertEquals(actual, expected);
	}
	
	@Test
	public void FullConstructurTestScore() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		
		Integer actual = u.getScore();
		Integer expected = 0;
		assertEquals(actual, expected);
	}
	
	@Test
	public void PartialConstructurTestScore() {
		User u = new User();
		
		Integer actual = u.getScore();
		Integer expected = null;
		assertEquals(actual, expected);
	}
	
	@Test
	public void PartialConstructurStrings() {
		User u = new User();
		
		String actual = u.getUsername();
		String expected = null;
		assertEquals(actual, expected);
	}

	@Test
	public void PartialConstructurIntegers() {
		User u = new User();
		
		Integer actual = u.getId();
		Integer expected = null;
		assertEquals(actual, expected);
	}


}
