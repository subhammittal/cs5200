package cs5200;

public class Cast {
	// change the data type from string to int of Id,actorId and movieId
	// private field as the id is the primary key of Class Movie
	
	private int id;
	private String characterName;
	private int actorId;
	private int movieId;
	
	public Cast(){}

	public Cast( int id ,String characterName , int actorId , int movieId) {
		super();
		this.characterName = characterName;
		this.id =id;
		this.actorId=actorId;
		this.movieId=movieId;
	}



	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	
	
}
