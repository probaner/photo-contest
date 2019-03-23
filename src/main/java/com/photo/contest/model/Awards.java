package com.photo.contest.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="awards")
public class Awards implements java.io.Serializable{
	
	private int id ;
	private String name;
	
	
	
	public Awards() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Awards(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	@Id 
	@GeneratedValue(strategy=IDENTITY)    
    @Column(name="id", unique=true, nullable=false)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


 @Column(name="name", nullable=false, unique=true,length=40)
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Awards [id=" + id + ", name=" + name + "]";
	}
	
	

}
