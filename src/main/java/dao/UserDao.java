package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import models.User;

public class UserDao {
	
	/**
	 *  potrei anche creare un metodo per generare la connessione al datasource
	 *  e poterlo semplicemente richiamare invece di farla manualmente ogni volta
	 *  
	 */
	

	public boolean checkIdentity(String username, String password) {
		
		try {
			
			Context ctx = new InitialContext(); 
			Context envContext = (Context) ctx.lookup("java:/comp/env"); 
			DataSource ds = (DataSource) envContext.lookup("jdbc/MyDB_Login_Local"); 
			
			Connection connection = ds.getConnection();
			
			String query = "SELECT * FROM users WHERE username=? AND password=?";
			
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				
				try(ResultSet resultSet = preparedStatement.executeQuery()){
					
					return resultSet.next();
				}
				
			}
			
			
		} catch (NamingException | SQLException exception) {
            exception.printStackTrace();
        }
		
		return false;
		
	}
	
	
	
	
	public List<User> getAllUsers(){
		List<User> usersList = new ArrayList<>();
		
		try {
			
			Context ctx = new InitialContext(); 
			Context envContext = (Context) ctx.lookup("java:/comp/env"); 
			DataSource ds = (DataSource) envContext.lookup("jdbc/MyDB_Login_Local"); 
			
			Connection connection = ds.getConnection();
			
			String query = "SELECT * FROM users";
			
			Statement statement = connection.createStatement();
			
			try(ResultSet resultSet = statement.executeQuery(query)){
				
				while(resultSet.next()) {
					
					User user = new User();
					user.setId(resultSet.getInt("id"));
					user.setUsername(resultSet.getString("username"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					usersList.add(user);
				}
				
			}
		} catch (NamingException | SQLException exception) {
            exception.printStackTrace();
        }
		
		return usersList;
	}
	
	
	
	
}

