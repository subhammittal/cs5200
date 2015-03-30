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

public class MovieManagerDao {

	
DataSource ds;
	
	public MovieManagerDao()
	{
		try{
			Context ctx = new InitialContext();
			ds= (DataSource) ctx.lookup("java:comp/env/jdbc/MovieSocialNetworkDB");
			System.out.println(ds);
		} catch(NamingException e){
		 e.printStackTrace();
		}
	}
	
	public void  createMovie(Movie newMovie)
	{
		String sql = "insert into movie values (?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,newMovie.getId());
			statement.setString(2,newMovie.getTitle());
			statement.setString(3,newMovie.getPosterImage());
			statement.setDate(4,newMovie.getReleaseDate());
						
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public List<Movie>  readAllMovies()
	{
		List<Movie>  movies = new ArrayList<Movie>();
		String sql = "select * from movie";
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Movie movie = new Movie();
				movie.setId(results.getInt("id"));
				movie.setTitle(results.getString("title"));
				movie.setPosterImage(results.getString("posterImage"));
				movie.setReleaseDate(results.getDate("releaseDate"));
				movies.add(movie);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return movies;
		
	}
	// change the data type from string to int of Id private field as the id is the primary key of Class Movie
	public Movie readMovie(int movieId)
	{
		Movie movie = new Movie();
		String sql = "select * from movie where id= ?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, movieId);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				movie.setId(result.getInt("id"));
				movie.setTitle(result.getString("title"));
				movie.setPosterImage(result.getString("posterImage"));
				movie.setReleaseDate(result.getDate("releaseDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		  return movie;
	}
	// change the data type from string to int of Id private field as the id is the primary key of Class Movie
	public void updateMovie(int movieId, Movie movie)
	{
		
		String sql = "update movie set  title=? , posterImage=?,"
				+ "releaseDate=? where id=?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getPosterImage());
			statement.setDate(3, movie.getReleaseDate());
			statement.setInt(4,movieId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// change the data type from string to int of Id private field as the id is the primary key of Class Movie
	public void deleteMovie(int movieId)
	{
		String sql = "delete from movie where id=?";
		Connection connection;
		try {
			connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,movieId);
			statement.executeUpdate();
			
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
}	

