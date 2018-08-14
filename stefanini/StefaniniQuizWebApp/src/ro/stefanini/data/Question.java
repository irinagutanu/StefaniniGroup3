package ro.stefanini.data;
import java.util.*;

public class Question {
	private String questionContent;
	List<Answear> answears = new ArrayList<Answear>();
	
	public Question(String questionContent, Answear[] answears) {
		this.questionContent = questionContent;
		 for (int i = 0; i < answears.length; i++) {
			 this.answears.add(answears[i]);
	        }	
	}
	
	public void setQuestion(String questionContent) {
		this.questionContent = questionContent;
	}
	
	public void addAnswears(Answear[] answears) {
		 for (int i = 0; i < answears.length; i++) {
			 this.answears.add(answears[i]);
	        }
	}
	public void addAnswear(Answear answear) {
		this.answears.add(answear);
	}
	
	public String getQuestion() {
		return this.questionContent;
	}
	
	public Answear[] getAnswears() {
		Answear[] answears = new Answear[this.answears.size()];
		answears = this.answears.toArray(answears);
		return answears;
	}
	
}
