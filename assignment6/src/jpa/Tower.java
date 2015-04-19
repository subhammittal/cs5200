package jpa;



import java.util.List;
import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
@Entity
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Tower implements Serializable {	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private int id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private int height;
	@XmlAttribute
	private int sides;
	@ManyToOne
	@JoinColumn(name="siteId")
	@XmlTransient
	private Site site;	
	@OneToMany(mappedBy="tower",cascade = CascadeType.PERSIST, orphanRemoval = true)
	@XmlElement(name="equipment")
	private List<Equipment> equipments;	
	private static final long serialVersionUID = 1L;
	public Tower() {
		super();
	} 
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
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
	public int getHeight() {
		return this.height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Site getSite() {
		return this.site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public int getSides() {
		return this.sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	public Tower( String name, int height, int sides, Site site,
			List<Equipment> equipments) {
		super();
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.site = site;
		this.equipments = equipments;
	}   
	
   
}