package cs5200;

import java.sql.Date;

public class Comment {
	// change the data type from string to int of Id private field as the id is the primary key of Class Comment
	private int id;
	private String comment;
	private Date date;
	private String username;
	private int movieId;
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	// No argument constructor
	public Comment()
	{
		
	}
	
	// Constructor using all the fields in the Class 
	public Comment(int id, String comment , Date date , String username , int  movieId  )
	{
		this.comment = comment;
		this.date = date;
		this.id=id;
		this.username=username;
		this.movieId=movieId;
	}
	

}
