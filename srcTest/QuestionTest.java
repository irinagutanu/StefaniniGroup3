import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ro.stefanini.data.Answear;
import ro.stefanini.data.Question;

public class QuestionTest {
	Answear a1 = new Answear(1, 2, "3", true);
	Answear a2 = new Answear(2, 2, "4", false);
	Answear a3 = new Answear(3, 2, "1", false);
	Answear a4 = new Answear(4, 2, "2", false);
	Answear a5 = new Answear(5, 3, "8", false);
	List<Answear> lasw = new LinkedList<Answear>();
	
	@Test
	public void QuestionTestConstructorID() {
		lasw.add(a1);
		lasw.add(a2);
		lasw.add(a3);
		lasw.add(a4);
		lasw.add(a5);
		Question q = new Question(2, "Why", lasw);
		
		Integer actual = q.getId();
		Integer expected = 2;
		assertEquals(actual, expected);
	}
	
	@Test
	public void QuestionTestConstructorQuestionContent() {
		lasw.add(a1);
		lasw.add(a2);
		lasw.add(a3);
		lasw.add(a4);
		lasw.add(a5);
		Question q = new Question(2, "Why", lasw);
		
		String actual = q.getQuestion();
		String expected = "Why";
		assertEquals(actual, expected);
	}
	
	@Test
	public void QuestionTestConstructorCountCorrectAnswear() {
		lasw.add(a1);
		lasw.add(a2);
		lasw.add(a3);
		lasw.add(a4);
		lasw.add(a5);
		Question q = new Question(2, "Why", lasw);
		q.setCountCorrectAnswear(1);
		
		Integer actual = q.getCountCorrectAnswear();
		Integer expected = 1;
		assertEquals(actual, expected);
	}
	
	@Test
	public void QuestionTestConstructorAnswears() {
		lasw.add(a1);
		lasw.add(a2);
		lasw.add(a3);
		lasw.add(a4);
		lasw.add(a5);
		Question q = new Question(2, "Why", lasw);
		
		List<Answear> actual = q.getAnswears();
		assertEquals(actual, lasw);
	}
	
	@Test(expected = NullPointerException.class)
	public void QuestionTestFindCorrectAnswearCountNull() {
		List<Answear> list = null;
		Question q = new Question(2, "Why", list);
		q.findCountCorrectAnswears();
	}
	
	@Test
	public void QuestionTestFindCorrectAnswearCountTrueOne() {
		Question q = new Question(2, "Why", lasw);
		Integer actual = q.findCountCorrectAnswears();
		Integer expected = 1;
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void QuestionTestFindCorrectAnswearCountTrueThree() {
		Answear b1 = new Answear(1, 2, "3", true);
		Answear b2 = new Answear(2, 2, "4", true);
		Answear b3 = new Answear(3, 2, "1", false);
		Answear b4 = new Answear(4, 2, "2", true);
		Answear b5 = new Answear(5, 2, "8", false);
		List<Answear> las = new LinkedList<Answear>();
		las.add(b1);
		las.add(b2);
		las.add(b3);
		las.add(b4);
		las.add(b5);
		Question q = new Question(2, "Why", las);
		Integer actual = q.findCountCorrectAnswears();
		Integer expected = 3;
		
		assertEquals(actual, expected);
	}

	

}
