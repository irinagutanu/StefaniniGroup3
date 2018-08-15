import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import ro.stefanini.data.Answear;
import ro.stefanini.data.Question;
import ro.stefanini.data.Quiz;
import ro.stefanini.data.User;

public class QuizTest {

	@Test
	public void QuizTestCreateQuizUserID() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		Answear a = new Answear(1, 2, "3", true);
		Answear b = new Answear(2, 2, "0.5", false);
		List<Answear> l = Arrays.asList(a, b);
		Question q = new Question(2, "What is the answear to pizza question?", l);
		HashMap<Question, List<Answear>> uInput = new HashMap<Question, List<Answear> >();
		uInput.put(q, l);
		Quiz quiz = new Quiz(u, uInput);
		
		User myUser = quiz.getUser();
		assertEquals(u, myUser);
	}
	
	@Test
	public void QuizTestCreateQuizInputAnswears() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		Answear a = new Answear(1, 2, "3", true);
		Answear b = new Answear(2, 2, "0.5", false);
		List<Answear> l = Arrays.asList(a, b);
		Question q = new Question(2, "What is the answear to pizza question?", l);
		HashMap<Question, List<Answear>> uInput = new HashMap<Question, List<Answear> >();
		uInput.put(q, l);
		Quiz quiz = new Quiz(u, uInput);
		
		HashMap<Question, List<Answear>> actual = quiz.getUserInput();
		List<Answear> actualAns = actual.get(q);
		assertEquals(l, actualAns);
	}
	
	@Test
	public void QuizTestCreateQuizInputQuestions() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		Answear a = new Answear(1, 2, "3", true);
		Answear b = new Answear(2, 2, "0.5", false);
		List<Answear> l = Arrays.asList(a, b);
		Question q = new Question(2, "What is the answear to pizza question?", l);
		HashMap<Question, List<Answear>> uInput = new HashMap<Question, List<Answear> >();
		uInput.put(q, l);
		Quiz quiz = new Quiz(u, uInput);
		
		Question act = null;
		HashMap<Question, List<Answear>> actual = quiz.getUserInput();
		for (Entry<Question, List<Answear>> entry : actual.entrySet()) {
            if (entry.getValue().equals(l)) {
                act = entry.getKey();
            }
        }
		assertEquals(q, act);
	}
	
	@Test
	public void QuizTestMethodCheckQuestionUsedTrue() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		Answear a = new Answear(1, 2, "3", true);
		Answear b = new Answear(2, 2, "0.5", false);
		List<Answear> l = Arrays.asList(a, b);
		Question q = new Question(2, "What is the answear to pizza question?", l);
		HashMap<Question, List<Answear>> uInput = new HashMap<Question, List<Answear> >();
		uInput.put(q, l);
		Quiz quiz = new Quiz(u, uInput);
		
		Boolean actual = quiz.checkQuestionUsed(q);
		Boolean expected = true;
		assertEquals(actual, expected);
	}
	
	@Test
	public void QuizTestMethodCheckQuestionUsedFalse() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		Answear a = new Answear(1, 2, "3", true);
		Answear b = new Answear(2, 2, "0.5", false);
		List<Answear> l = Arrays.asList(a, b);
		Question q = new Question(2, "What is the answear to pizza question?", l);
		HashMap<Question, List<Answear>> uInput = new HashMap<Question, List<Answear> >();
		uInput.put(q, l);
		Quiz quiz = new Quiz(u, uInput);
		
		Question falseQuestion = new Question(3, "Anything at all here", l);
		
		Boolean actual = quiz.checkQuestionUsed(falseQuestion);
		Boolean expected = false;
		assertEquals(actual, expected);
	}
	
	@Test
	public void QuizTestMethodCheckAnswerUsedFalse() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		Answear a = new Answear(1, 2, "3", true);
		Answear b = new Answear(2, 2, "0.5", false);
		List<Answear> l = Arrays.asList(a, b);
		Question q = new Question(2, "What is the answear to pizza question?", l);
		HashMap<Question, List<Answear>> uInput = new HashMap<Question, List<Answear> >();
		uInput.put(q, l);
		Quiz quiz = new Quiz(u, uInput);
		
		Boolean actual = quiz.checkAnswersUsed(q);
		Boolean expected = false;
		assertEquals(actual, expected);
	}
	
	@Test
	public void QuizTestMethodCheckAnswerUsedTrue() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		Answear a = new Answear(1, 2, "3", true);
		List<Answear> l = Arrays.asList(a);
		Question q = new Question(2, "What is the answear to pizza question?", l);
		HashMap<Question, List<Answear>> uInput = new HashMap<Question, List<Answear> >();
		uInput.put(q, l);
		Quiz quiz = new Quiz(u, uInput);
		
		Boolean actual = quiz.checkAnswersUsed(q);
		Boolean expected = true;
		assertEquals(actual, expected);
	}
	
	@Test
	public void QuizTestMethodCheckAnswerUsedFalseByNumber() {
		User u = new User(1, "JohnDoe", "jhasebnvcas", "John", "Doe", "johndoe@gmail.com", 0);
		Answear a = new Answear(1, 2, "3", true);
		List<Answear> l = Arrays.asList(a);
		Question q = new Question(2, "What is the answear to pizza question?", l);
		q.setCountCorrectAnswear(2);
		HashMap<Question, List<Answear>> uInput = new HashMap<Question, List<Answear> >();
		uInput.put(q, l);
		Quiz quiz = new Quiz(u, uInput);
		
		Boolean actual = quiz.checkAnswersUsed(q);
		Boolean expected = false;
		assertEquals(actual, expected);
	}
	
	

}
