package ro.stefanini.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ro.stefanini.dataOperation.QuestionDAO;

public class Quiz {
	private User user;
	private List<Question> dbQuestions;
	private HashMap<Question, List<Answear> > userInput;
	
	public Quiz(User us, HashMap<Question, List<Answear> > userInput) {
		this(us, userInput, new QuestionDAO().getQuestions());
	}
	
	public Quiz(User us, HashMap<Question, List<Answear> > userInput, List<Question> questions) {
		this.user = user;
		this.userInput = userInput;
		this.dbQuestions = questions;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Question> getDbQuestions() {
		return dbQuestions;
	}
	public void setDbQuestions(List<Question> dbQuestions) {
		this.dbQuestions = dbQuestions;
	}
	public HashMap<Question, List< Answear> > getUserInput() {
		return userInput;
	}
	public void setUserInput(HashMap<Question, List<Answear> > userInput) {
		this.userInput = userInput;
	}
	
	public Boolean checkQuestionUsed(Question q) {
		for( Map.Entry<Question, List<Answear>> entry:userInput.entrySet()) {
			if(entry.getKey().equals(q)) return true;
		}
		return false;
	}
	
	public Boolean checkAnswersUsed(Question q) {
		List<Answear> userAnswear =  userInput.get(q);
		Integer value = 0;
		for(Answear ans:userAnswear) {
			if( !ans.getValue()) {
				return false;
			}
			else {
				value++;
			}
		}
		if(!q.getCountCorrectAnswear().equals(value)) return false;
		return true;
	}
}
