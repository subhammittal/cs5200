package jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@NamedQueries({ @NamedQuery(name="Site.findAll", query="select s from Site s")})
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Site implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private int id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private double latitude;
	@XmlAttribute
	private double longitude;
	@OneToMany(mappedBy="site",cascade=CascadeType.PERSIST,orphanRemoval = true)
	@XmlElement(name="tower")
	private List<Tower> towers;
	private static final long serialVersionUID = 1L;
	public Site() {
		super();
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Site(int siteId, String name, double latitude, double longitude,
			List<Tower> towers) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.towers = towers;
	}   
	
}