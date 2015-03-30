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

public class ActorManagerDao {


DataSource ds;
	
	public ActorManagerDao()
	{
		try{
			Context ctx = new InitialContext();
			ds= (DataSource) ctx.lookup("java:comp/env/jdbc/MovieSocialNetworkDB");
			System.out.println(ds);
		} catch(NamingException e){
		 e.printStackTrace();
		}
	}
	
	public void  createActor(Actor newActor)
	{
		String sql = "insert into actor values (?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,newActor.getId());
			statement.setString(2,newActor.getFirstname());
			statement.setString(3,newActor.getLastname());
			statement.setDate(4,newActor.getDateOfBirth());
						
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public List<Actor>  readAllActors()
	{
		List<Actor>  actors = new ArrayList<Actor>();
		String sql = "select * from actor";
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Actor actor = new Actor();
				actor.setId(results.getInt("id"));
				actor.setFirstname(results.getString("firstname"));
				actor.setLastname(results.getString("lastname"));
				actor.setDateOfBirth(results.getDate("dateOfBirth"));
				actors.add(actor);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return actors;
		
	}
	
	public Actor readActor(String actorId)
	{
		Actor actor = new Actor();
		String sql = "select * from actor where id= ?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actorId);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				actor.setId(result.getInt("id"));
				actor.setFirstname(result.getString("firstname"));
				actor.setLastname(result.getString("lastname"));
				actor.setDateOfBirth(result.getDate("dateOfBirth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		  return actor;
	}
	
	// change the data type from String to int for actorId which is equivalent to id in actor model class
	public void updateActor(int actorId, Actor actor)
	{
		
		String sql = "update actor set  firstname=? , lastname=?,"
				+ "dateOfBirth=? where id=?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actor.getFirstname());
			statement.setString(2, actor.getLastname());
			statement.setDate(3, actor.getDateOfBirth());
			statement.setInt(4,actorId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// change the data type from String to int for actorId which is equivalent to id in actor model class
	public void deleteActor(int actorId)
	{
		String sql = "delete from actor where id=?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,actorId);
			statement.executeUpdate();
			
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
}	

