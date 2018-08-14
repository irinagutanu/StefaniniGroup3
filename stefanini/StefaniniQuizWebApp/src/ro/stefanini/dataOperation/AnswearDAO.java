package ro.stefanini.dataOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.stefanini.data.Answear;
import ro.stefanini.data.Question;

public class AnswearDAO {
	private Connection con;
	private PreparedStatement answearStm;
	
	public Answear getAnswear(Integer id){
		ResultSet answearRs = null;
		List<Answear> answears = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			answearStm = con.prepareStatement("SELECT * FROM Answer WHERE id=?");
			answearStm.setInt(1, id);
			answearRs = answearStm.executeQuery();
			answears = createAnswears(answearRs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(answearRs);
			DbUtills.closeQuietly(answearStm);
			DbUtills.closeQuietly(con);
		}
		return answears.get(0);
	}

	public List<Answear> getAnswearsByQuestionId(final Integer questionId) {
		ResultSet answearRs = null;
		List<Answear> answears = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			answearStm = con.prepareStatement("SELECT * FROM Answer WHERE question_id =?");
			answearStm.setInt(1, questionId);
			answearRs = answearStm.executeQuery();
			answears = createAnswears(answearRs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(answearRs);
			DbUtills.closeQuietly(answearStm);
			DbUtills.closeQuietly(con);
		}
		return answears;
	}
	
	public int updateAnswear(final Integer answearId, final String answearContent) {
		int updatedRows = 0;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			answearStm = con.prepareStatement("UPDATE Question SET answear_content=? WHERE answear_id=?");
			answearStm.setString(1, answearContent);
			answearStm.setInt(2, answearId);
			updatedRows = answearStm.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtills.closeQuietly(answearStm);
			DbUtills.closeQuietly(con);
		}
		return updatedRows;
	}
	
	public int deleteAnswear(final Integer answearId) {
		int updatedRows = 0;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			answearStm = con.prepareStatement("DELETE FROM Answear WHERE answear_id=?");
			answearStm.setInt(1, answearId);
			updatedRows = answearStm.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtills.closeQuietly(answearStm);
			DbUtills.closeQuietly(con);
		}
		return updatedRows;
	}
	
	public int addAnswear(final Integer questionId, final String answearContent, Boolean truthValue) {
		int insertedRows = 0;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			answearStm = con.prepareStatement("INSERT INTO Answear (question_id,answear_content,truth_value) VALUES(?,?,?,?)");
			answearStm.setInt(1, questionId);
			answearStm.setString(1, answearContent);
			answearStm.setBoolean(1, truthValue);
			insertedRows = answearStm.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtills.closeQuietly(answearStm);
			DbUtills.closeQuietly(con);
		}
		return insertedRows;
	}
	
	private List<Answear> createAnswears(ResultSet rs) throws SQLException{
		List<Answear> answears = new ArrayList<>();
		while(rs.next()) {
			Integer aid= rs.getInt("answear_id");
			String answearContent = rs.getString("answear_content");
			Integer qid = rs.getInt("question_id");
			Boolean truthValue = rs.getBoolean("truth_value");
			answears.add(new Answear(aid, qid, answearContent, truthValue));
		}
		return answears;
	}
	
	

}
