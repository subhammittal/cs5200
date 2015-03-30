package cs5200;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserManagerDao {
	
DataSource ds;
	
	public UserManagerDao()
	{
		try{
			Context ctx = new InitialContext();
			ds= (DataSource) ctx.lookup("java:comp/env/jdbc/MovieSocialNetworkDB");
			System.out.println(ds);
		} catch(NamingException e){
		 e.printStackTrace();
		}
	}
	
	public User create(User user)
	{
		String sql = "insert into user values (?,?,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,user.getUsername());
			statement.setString(2,user.getPassword());
			statement.setString(3,user.getFirstname());
			statement.setString(4,user.getLastname());
			statement.setString(5,user.getEmail());
			statement.setDate(6,user.getDateOfBirth());			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<User>  findAllUsers()
	{
		List<User>  users = new ArrayList<User>();
		String sql = "select * from user";
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				User user = new User();
				user.setUsername(results.getString("username"));
				user.setPassword(results.getString("password"));
				user.setFirstname(results.getString("firstname"));
				user.setLastname(results.getString("lastname"));
				user.setEmail(results.getString("email"));
				user.setDateOfBirth(results.getDate("dateOfBirth"));
				users.add(user);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return users;
		
	}
	
	public User readUser(String username)
	{
		User user = new User();
		String sql = "select * from user where username= ?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				user.setUsername(result.getString("username"));
				user.setFirstname(result.getString("firstname"));
				user.setLastname(result.getString("lastname"));
				user.setPassword(result.getString("passsword"));
				user.setEmail(result.getString("email"));
				user.setDateOfBirth(result.getDate("dateOfBirth"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  return user;
	}
	
	public void updateUser(String username, User user)
	{
		
		String sql = "update user set  password=? , firstname=?,"
				+ "lastname=? , email=?, dateOfBirth=? where username=?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getFirstname());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getEmail());
			statement.setDate(5, user.getDateOfBirth());
			statement.setString(6, username);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String username)
	{
		String sql = "delete from user where username=?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			statement.executeUpdate();
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}	
