package ro.stefanini.data;

public class Answear {
	private Integer id;
	private Integer questionId;
	private String contentAnswear;
	private Boolean truthValue;
	
	public Answear() {
	}
	
	public Answear(Integer aid, Integer qid, String answearContent, Boolean truthValue) {
		this.id = aid;
		this.questionId = qid;
		this.contentAnswear = answearContent;
		this.truthValue = truthValue;
	}
		
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
	
	public String getAnswer() {
		return contentAnswear;
	}
	public Boolean getValue() {
		return truthValue;
	}
	public void setAnswer(String contentAnswear) {
		this.contentAnswear = contentAnswear;
	}
	public void setValue(Boolean value) {
		this.truthValue = value;
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        }

	        if (!Answear.class.isAssignableFrom(obj.getClass())) {
	            return false;
	        }

	        final Answear answear = (Answear) obj;
	        if ((this.truthValue == null) ? (answear.truthValue != null) : !this.truthValue.equals(answear.truthValue)) {
	            return false;
	        }

	        return true;
	    }
	
}
