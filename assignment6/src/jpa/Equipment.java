package jpa;


import jpa.Tower;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


@Entity
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Equipment implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private int id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private double price;
	@XmlAttribute
	private String brand;
	@XmlAttribute
	private String description;	
	@ManyToOne
	@JoinColumn(name="towerId")
	@XmlTransient
	private Tower tower;
	private static final long serialVersionUID = 1L;

	public Equipment() {
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
	public Equipment( String name, double price, String brand,
			String description, Tower tower) {
		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.description = description;
		this.tower = tower;
	}
   
}