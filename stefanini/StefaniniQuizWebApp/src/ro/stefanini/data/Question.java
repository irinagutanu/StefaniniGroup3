package ro.stefanini.data;
import java.util.*;

public class Question {
	private Integer id;
	private String questionContent;
	private Integer countCorrectAnswear;
	private List<Answear> answears;
	
	public Integer getCountCorrectAnswear() {
		return countCorrectAnswear;
	}

	public void setCountCorrectAnswear(Integer countCorrectAnswear) {
		this.countCorrectAnswear = countCorrectAnswear;
	}
	
	public Question() {
	}

	public Question(Integer id, String questionContent, List<Answear> answears) {
		this.id = id;
		this.questionContent = questionContent;
		this.answears = answears;	
	}
	
	public Question (Integer id, String questionContent) {
		this(id, questionContent, new ArrayList<Answear>());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setQuestionContent(String questionContent) {
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
	
	public String getQuestionContent() {
		return this.questionContent;
	}
	
	public List<Answear> getAnswers() {
		return answears;
	}
	
	public void setAnswers(List<Answear> answears) {
		this.answears = answears;
	}
}
