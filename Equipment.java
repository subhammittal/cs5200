package jpa;

import jpa.Tower;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;



@Entity
public class Equipment implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int eId;
	private String name;
	private double price;
	private String brand;
	private String description;	
	@ManyToOne
	@JoinColumn(name="towerId")
	private Tower tower;
	private static final long serialVersionUID = 1L;

	public Equipment() {
		super();
	}   
	public int getId() {
		return this.eId;
	}
	
	public void setId(int id) {
		this.eId = id;
	}   
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	} 
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}  
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Tower getTower() {
		return this.tower;
	}
	public void setTower(Tower tower) {
		this.tower = tower;
	}
   
}
