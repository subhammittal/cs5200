package jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import javax.persistence.*;
@Entity
@NamedQueries({ @NamedQuery(name="Site.findAll", query="select s from Site s")})
public class Site implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int sId;
	private String name;
	private double latitude;
	private double longitude;
	@OneToMany(mappedBy="site",cascade=CascadeType.PERSIST,orphanRemoval = true)
	private List<Tower> towers;
	private static final long serialVersionUID = 1L;
	public Site() {
		super();
	}
	public int getId() {
		return this.sId;
	}
	public void setId(int id) {
		this.sId = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return this.latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}   
	public double getLongitude() {
		return this.longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public List<Tower> getTowers() {
		return towers;
	}
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}   
}
