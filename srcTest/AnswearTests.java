import static org.junit.Assert.*;

import org.junit.Test;

import ro.stefanini.data.Answear;

public class AnswearTests {

	@Test
	public void createAnswearTestAnswearID() {
		Answear ans = new Answear(1, 2, "3", true);
		Integer expected = 1;
		assertEquals(expected, ans.getId());
	}
	
	@Test
	public void createAnswearTestQuestionID() {
		Answear ans = new Answear(1, 2, "3", true);
		Integer expected = 2;
		assertEquals(expected, ans.getQuestionId());
	}
	
	@Test
	public void createAnswearTestAnswer() {
		Answear ans = new Answear(1, 2, "3", true);
		String expected = "3";
		assertEquals(expected, ans.getAnswear());
	}
	
	@Test
	public void createAnswearTestValueTrue() {
		Answear ans = new Answear(1, 2, "3", true);
		Boolean expected = true;
		assertEquals(expected, ans.getValue());
	}
	
	@Test
	public void createAnswearTestValueFalse() {
		Answear ans = new Answear(1, 2, "4",false);
		Boolean expected =false;
		assertEquals(expected, ans.getValue());
	}

}
