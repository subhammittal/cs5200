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
// c and d part remaining 
public class CastManagerDao {

DataSource ds;
	
	public CastManagerDao()
	{
		try{
			Context ctx = new InitialContext();
			ds= (DataSource) ctx.lookup("java:comp/env/jdbc/MovieSocialNetworkDB");
			System.out.println(ds);
		} catch(NamingException e){
		 e.printStackTrace();
		}
	}
	
	public void  createCast(Cast newCast)
	{
		String sql = "insert into cast values (?,? ,? ,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,newCast.getId());
			statement.setString(2,newCast.getCharacterName());
			statement.setInt(3,newCast.getActorId());
			statement.setInt(4, newCast.getMovieId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public List<Cast>  readAllCast()
	{
		List<Cast>  casts = new ArrayList<Cast>();
		String sql = "select * from cast";
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getInt("id"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setActorId(results.getInt("actorId"));
				cast.setMovieId(results.getInt("movieId"));
				casts.add(cast);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return casts;
		
	}
	// change the data type from string to int of actorId private field as the id is the primary key of Class Actors
	public List<Cast>  readAllCastForActor(int actorId)
	{
		List<Cast>  casts = new ArrayList<Cast>();
		String sql = "select * from cast where actorId=?";
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, actorId);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getInt("id"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setActorId(results.getInt("actorId"));
				cast.setMovieId(results.getInt("movieId"));
				casts.add(cast);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return casts;
		
	}
	// change the data type from string to int of movieId private field as the id is the primary key of Class Movie
	public List<Cast>  readAllCastForMovie(int movieId)
	{
		List<Cast>  casts = new ArrayList<Cast>();
		String sql = "select * from cast where movieId=?";
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, movieId);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getInt("id"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setActorId(results.getInt("actorId"));
				cast.setMovieId(results.getInt("movieId"));
				casts.add(cast);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return casts;
		
	}
	// change the data type from string to int of castId private field as the id is the primary key of Class Movie
	public Cast readCastForId(int castId)
	{
		Cast cast = new Cast();
		String sql = "select * from cast where id= ?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, castId);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				cast.setId(result.getInt("id"));
				cast.setCharacterName(result.getString("characterName"));
				cast.setActorId(result.getInt("actorId"));
				cast.setMovieId(result.getInt("movieId"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		  return cast;
	}
	// change the data type from string to int of castId private field as the id is the primary key of Class Movie
	public void updateCast(int castId, Cast newCast)
	{
		
		String sql = "update cast set  characterName=? , actorid=?, movieId=?  where id=?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,newCast.getCharacterName() );
			statement.setInt(2, newCast.getActorId());
			statement.setInt(3, newCast.getMovieId());
			statement.setInt(4, castId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// change the data type from string to int of castId private field as the id is the primary key of Class Movie
	public void deleteCast(int castId)
	{
		String sql = "delete from cast where id=?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,castId);
			statement.executeUpdate();
			
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
}	



