package ro.stefanini.dataOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.stefanini.data.Answear;
import ro.stefanini.data.Question;

public class QuestionDAO {
	private Connection con;
	private PreparedStatement getQuestionStm;
	private PreparedStatement getQuestionsStm;
	private PreparedStatement insertQuestionStm;
	private PreparedStatement updateQuestionStm;
	private PreparedStatement deleteQuestionStm;
	
	public Question getQuestion(final Integer questionId) {
		ResultSet questionRs = null;
		Question question = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			getQuestionStm = con.prepareStatement("SELECT * FROM Question WHERE question_id=?");
			getQuestionStm.setInt(1, questionId);
			questionRs = getQuestionStm.executeQuery();
			question = createQuestions(questionRs).get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbUtills.closeQuietly(questionRs);
			DbUtills.closeQuietly(getQuestionStm);
			DbUtills.closeQuietly(con);
		}
		return question;
	}
	
	public List<Question> getQuestions(){
		ResultSet questionsRs = null;
		List<Question> questions = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			getQuestionsStm = con.prepareStatement("SELECT * FROM Question");
			questionsRs = getQuestionsStm.executeQuery();
			questions = createQuestions(questionsRs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(questionsRs);
			DbUtills.closeQuietly(getQuestionsStm);
			DbUtills.closeQuietly(con);
		}
		return questions;
	}
	
	private List<Question> createQuestions(ResultSet rs) throws SQLException {
		List<Question> questions = new ArrayList<>();
		while(rs.next()) {
			Integer qid = rs.getInt("question_id");
			String questionContent = rs.getString("question_content"); 
			List<Answear> answears = new AnswearDAO().getAnswearsByQuestionId(qid);
			questions.add(new Question(qid, questionContent, answears));
		}
		return questions;
	}
	
	public int addQuestion(final String questionContent) {
		int insertedRows = 0;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			insertQuestionStm = con.prepareStatement("INSERT INTO Question (question_content) VALUES(?)");
			insertQuestionStm.setString(1, questionContent);
			insertedRows = insertQuestionStm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(insertQuestionStm);
			DbUtills.closeQuietly(con);
		}
		
		return insertedRows;
	}
	
	public int updateQuestion(final Integer questionId, final String questionContent) {
		int updatedRows = 0;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			updateQuestionStm = con.prepareStatement("UPDATE Question SET question_content=? WHERE question_id=?");
			updateQuestionStm.setString(1, questionContent);
			updateQuestionStm.setInt(2, questionId);
			updatedRows = updateQuestionStm.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtills.closeQuietly(updateQuestionStm);
			DbUtills.closeQuietly(con);
		}
		return updatedRows;
	}
	
	public int deleteQuestion(final Integer questionId){
		int deletedRows = 0;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			deleteQuestionStm = con.prepareStatement("DELETE FROM Question WHERE question_id=?");
			deleteQuestionStm.setInt(1, questionId);
			deletedRows = deleteQuestionStm.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbUtills.closeQuietly(deleteQuestionStm);
			DbUtills.closeQuietly(con);
		}
		return deletedRows;
	}
}
