package ro.stefanini.dataOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.stefanini.data.Answear;

public class AnswearDAO {

	public Answear getAnswear(Integer id) {
		ResultSet answearRs = null;
		List<Answear> answears = null;
		Connection con = null;
		PreparedStatement answearStm = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			answearStm = con.prepareStatement("SELECT * FROM Answer WHERE IDAnswer=?");
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
	protected List<Answear> getAnswearsByQuestionId(final Integer questionId){
		return getAnswearsByQuestionId(questionId, null);
	}

	protected List<Answear> getAnswearsByQuestionId(final Integer questionId, Connection connection) {
		ResultSet answearRs = null;
		List<Answear> answears = null;
		Connection con = connection;
		PreparedStatement answearStm = null;
		try {
			if(con == null) {
				con = DatabaseConnectionFactory.createConnection();
			}
			con.setAutoCommit(false);
			answearStm = con.prepareStatement("SELECT * FROM Answer WHERE FKQuestion =?");
			answearStm.setInt(1, questionId);
			answearRs = answearStm.executeQuery();
			answears = createAnswears(answearRs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(answearRs);
			DbUtills.closeQuietly(answearStm);
			//DbUtills.closeQuietly(con);
		}
		return answears;
	}

	public int updateAnswear(final Integer answearId, final String answearContent) {
		int updatedRows = 0;
		Connection con = null;
		PreparedStatement answearStm = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			answearStm = con.prepareStatement("UPDATE Question SET Atext=? WHERE IDAnswer=?");
			answearStm.setString(1, answearContent);
			answearStm.setInt(2, answearId);
			updatedRows = answearStm.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(answearStm);
			DbUtills.closeQuietly(con);
		}
		return updatedRows;
	}

	public int deleteAnswear(final Integer answearId) {
		int updatedRows = 0;
		Connection con = null;
		PreparedStatement answearStm = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			answearStm = con.prepareStatement("DELETE FROM Answer WHERE IDAnswer=?");
			answearStm.setInt(1, answearId);
			updatedRows = answearStm.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(answearStm);
			DbUtills.closeQuietly(con);
		}
		return updatedRows;
	}

	public int addAnswear(final Integer questionId, final String answearContent, Boolean truthValue) {
		int insertedRows = 0;
		Connection con = null;
		PreparedStatement answearStm = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			con.setAutoCommit(false);
			answearStm = con.prepareStatement("INSERT INTO Answer (IDQuestion,Atext,truth_value) VALUES(?,?,?)");
			answearStm.setInt(1, questionId);
			answearStm.setString(2, answearContent);
			answearStm.setBoolean(3, truthValue);
			insertedRows = answearStm.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtills.closeQuietly(answearStm);
			DbUtills.closeQuietly(con);
		}
		return insertedRows;
	}

	private List<Answear> createAnswears(ResultSet rs) throws SQLException {
		List<Answear> answears = new ArrayList<>();
		while (rs.next()) {
			Integer aid = rs.getInt("IDAnswer");
			String answearContent = rs.getString("Atext");
			Integer qid = rs.getInt("FKQuestion");
			 Boolean truthValue = rs.getBoolean("truth_value");
			 answears.add(new Answear(aid, qid, answearContent, truthValue));
		}
		return answears;
	}

}
