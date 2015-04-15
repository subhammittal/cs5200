package jpa;

import jpa.Site;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Tower implements Serializable {	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int tId;
	private String name;
	private int height;
	private int slides;
	@ManyToOne
	@JoinColumn(name="sId")
	private Site site;
	
	@OneToMany(mappedBy="tower",cascade = CascadeType.PERSIST, orphanRemoval = true)
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
		return this.tId;
	}
	public void setId(int id) {
		this.tId = id;
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
	public int getSlides() {
		return this.slides;
	}
	public void setSlides(int slides) {
		this.slides = slides;
	}   
	
   
}
