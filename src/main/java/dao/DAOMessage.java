package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import io.Message;
import dao.DAOException;


public class DAOMessage implements DAO<Message> {
	private static final Logger LOG = Logger.getLogger(DAOMessage.class.getName());
	private static final String URL ="jdbc:mysql://localhost:3306/cnam?useSSL=false";
	private static final String LOGIN ="root";
	private static final String PASSWORD = "";
	
	public Message find(Object id) throws DAOException {

		if(!(id instanceof Integer))
			throw new DAOException("Id not take in charge.");
		final String sql = "SELECT * FROM `message` WHERE `id` = ?";
		
		Connection c = null;
		PreparedStatement st = null;
		ResultSet r = null;
		Message a = new Message();
		
		try{
			c = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			st = c.prepareStatement(sql);
			st.setInt(1,  (Integer) id);
			r = st.executeQuery();
			
			if (r.next()){
				a.setId(r.getInt("id"));
				a.setNickname(r.getString("nickname"));
				a.setDate(r.getDate("date"));
				a.setCanal(r.getString("canal"));
				a.setMessage(r.getString("message"));
				return a;
			}
			else{
				throw new DAOException("error no bank for this id ");
			}
		}catch (SQLException e) {
			throw new DAOException("error in SQL engins ");
		} finally{
			try{
				if(r != null)
				r.close();
				if(st != null)
				st.close();
				if(c != null)
				c.close();
			} catch (SQLException e){
				LOG.error("Error during closing open connection");
			}
			
		}
	}

	public Message create(Message obj) throws DAOException {
		if(!(obj instanceof Message))
		throw new DAOException("Object not take in charge.");
	final String sql = "INSERT INTO `accounts`(`id`,`nickname`,`date`,`canal`,`message`) VALUES  (NULL, ? , ? , ? , ? )";
	
	Connection c = null;
	PreparedStatement st = null;
	ResultSet r = null;
	
	try{
		c = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		st = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setNString(1,  (String) obj.getNickname());
		st.setDate(2,  (Date) obj.getDate());
		st.setNString(3,  (String) obj.getCanal());
		st.setNString(4,  (String) obj.getMessage());
		st.executeUpdate();
		
		r = st.getGeneratedKeys();
		
		if(r.next()){
			obj.setId(r.getInt(1));
		}
		else{
			throw new DAOException("error during account creation ");
		}
		
		return null;
	}catch (SQLException e) {
		throw new DAOException("error in SQL engins ");
	} finally{
		try{
			if(r != null)
			r.close();
			if(st != null)
			st.close();
			if(c != null)
			c.close();
		} catch (SQLException e){
			LOG.error("Error during closing open connection");
		}
		
	}
	}

	public Message update(Message obj) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Message obj) throws DAOException {
		// TODO Auto-generated method stub
		
	}


	
}

