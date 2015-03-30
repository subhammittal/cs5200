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

public class CommentManagerDao {


DataSource ds;
	
	public CommentManagerDao()
	{
		try{
			Context ctx = new InitialContext();
			ds= (DataSource) ctx.lookup("java:comp/env/jdbc/MovieSocialNetworkDB");
			System.out.println(ds);
		} catch(NamingException e){
		 e.printStackTrace();
		}
	}
	
	public void  createComment(Comment newComment)
	{
		String sql = "insert into comment values (?,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,newComment.getId());
			statement.setString(2,newComment.getComment());
			statement.setDate(3,newComment.getDate());
			statement.setString(4,newComment.getUsername());
			statement.setInt(5,newComment.getMovieId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public List<Comment>  readAllComments()
	{
		List<Comment>  comments = new ArrayList<Comment>();
		String sql = "select * from comment";
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment comment = new Comment();
				comment.setId(results.getInt("id"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comment.setUsername(results.getString("usrename"));
				comment.setMovieId(results.getInt("movieId"));
				comments.add(comment);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return comments;
		
	}
	
	public List<Comment> readAllCommentsForUserName(String username)
	{
		List<Comment>  comments = new ArrayList<Comment>();
		String sql = "select * from comment where username=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment comment = new Comment();
				comment.setId(results.getInt("id"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comment.setUsername(results.getString("username"));
				comment.setMovieId(results.getInt("movieId"));
				comments.add(comment);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return comments;
	}
	// change the data type from string to int of Id private field as the id is the primary key of Class Movie
	public List<Comment> readAllCommentForMovie(int movieId)
	{
		List<Comment>  comments = new ArrayList<Comment>();
		String sql = "select * from comment where movieId=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, movieId);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment comment = new Comment();
				comment.setId(results.getInt("id"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comment.setUsername(results.getString("username"));
				comment.setMovieId(results.getInt("movieId"));
				comments.add(comment);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return comments;
	}
	// change the data type from string to int of Id private field as the id is the primary key of Class Comment
	public Comment readCommentForId(int commentId)
	{
		Comment comment = new Comment();
		String sql = "select * from comment where id= ?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, commentId);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				comment.setId(result.getInt("id"));
				comment.setComment(result.getString("comment"));
				comment.setDate(result.getDate("date"));
				comment.setUsername(result.getString("username"));
				comment.setMovieId(result.getInt("movieId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		  return comment;
	}
	// change the data type from string to int of Id private field as the id is the primary key of Class Comment
	public void updateComment(int commentId, String newComment)
	{
		
		String sql = "update comment set  comment=?   where id=?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,newComment );
			statement.setInt(2, commentId);			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// change the data type from string to int of Id private field as the id is the primary key of Class Comment
	public void deleteComment(int commentId)
	{
		String sql = "delete from comment where id=?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,commentId);
			statement.executeUpdate();
			
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
}	


