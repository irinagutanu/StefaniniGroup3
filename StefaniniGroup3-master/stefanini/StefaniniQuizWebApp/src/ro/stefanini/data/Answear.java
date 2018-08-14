package ro.stefanini.data;

public class Answear {
	private Integer id;
	private Integer questionId;
	private String contentAnswear;
	private Boolean truthValue;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	public String getAnswear() {
		return contentAnswear;
	}
	public Boolean getValue() {
		return truthValue;
	}
	public void setAnswear(String contentAnswear) {
		this.contentAnswear = contentAnswear;
	}
	public void setValue(Boolean value) {
		this.truthValue = value;
	}
}
