package cs5200;

import java.sql.Date;

public class Movie {

	// change the data type from string to int of Id private field as the id is the primary key of Class Movie
	private int Id;
	private String title ;
	private String posterImage;
	private Date releaseDate;
	
	public Movie(){}
	
	

	public Movie(int id, String title, String posterImage, Date releaseDate) {
		super();
		this.Id = Id;
		this.title = title;
		this.posterImage = posterImage;
		this.releaseDate = releaseDate;
	}



	



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPosterImage() {
		return posterImage;
	}

	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	

}
