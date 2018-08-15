package ro.stefanini.dataOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import ro.stefanini.data.Answear;
import ro.stefanini.data.Question;
import ro.stefanini.data.Quiz;
import ro.stefanini.data.User;

public class UserAnswerDAO {
	
	public Quiz getUserAnswers(final Integer userId) {
		Quiz quiz = null;
		ResultSet userAnswersRs = null;
		Connection con = null;
		PreparedStatement getUserAnswersStm = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			getUserAnswersStm = con.prepareStatement("SELECT * FROM UserAnswer WHERE user_id_fk=?");
			getUserAnswersStm.setInt(1, userId);
			userAnswersRs = getUserAnswersStm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(userAnswersRs);
			DbUtills.closeQuietly(getUserAnswersStm);
			DbUtills.closeQuietly(con);
		}
		return quiz;
	}
	
	public Quiz createQuiz(ResultSet rs) throws SQLException {
		Quiz quiz = null;
		Integer userId = rs.getInt("user_id_fk");
		User user = new UserDAO().getUserById(userId);
		
		QuestionDAO questionDAO = new QuestionDAO();
		AnswearDAO andswerDAO = new AnswearDAO();
		
		List<Question> questions = new ArrayList<>();
		List<Answear> forUserInput = new ArrayList<>();
		HashMap<Question, List<Answear>> userInput;
	
		while(rs.next()) {
			Integer questionId = rs.getInt("IDQuestion");
			Question question = questionDAO.getQuestion(questionId);
			if(!questions.contains(question)) {
				questions.add(question);
			}
			
			Integer answerId = rs.getInt("IDAnswer");
			Answear answer = andswerDAO.getAnswear(answerId);
			if(!forUserInput.contains(answer)) {
				forUserInput.add(answer);
			}	
		}
		
		userInput = createQuizMap(questions, forUserInput);
		return quiz;
	}
	
	public HashMap<Question, List<Answear>> createQuizMap(List<Question> questions, List<Answear> answears){
		HashMap<Question, List<Answear>> userInput = new HashMap<>();
		for(Question question: questions) {
			List<Answear> temp = answears.stream().filter(ans -> question.getId().equals(ans.getQuestionId())).collect(Collectors.toList());
			userInput.put(question, temp);
		}
		
		return userInput;
	}
	
	public int addUserAnswer(final Integer userId, final Integer questionId, final Integer answerId) {
		int insertedRows = 0;
		Connection con = null;
		PreparedStatement insertUserAnswerStm=null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			insertUserAnswerStm = con.prepareStatement("INSERT INTO UserAnswer (question_id_fk, answer_id_fk, user_id_fk) VALUES(?,?,?)");
			insertUserAnswerStm.setInt(1, questionId);
			insertUserAnswerStm.setInt(2, answerId);
			insertUserAnswerStm.setInt(3, userId);
			insertedRows = insertUserAnswerStm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(insertUserAnswerStm);
			DbUtills.closeQuietly(con);
		}
		
		return insertedRows;
	}
}
