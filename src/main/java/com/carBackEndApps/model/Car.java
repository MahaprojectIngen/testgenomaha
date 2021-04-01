package com.carBackEndApps.model;


import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
public class Car {
    @Id @GeneratedValue
    private Long id;
    private  String name;
    private  String commentaire;
    
    public Car(){
    	
    }
    public Car(String name, String commentaire){
    	this.name        = name;
    	this.commentaire = commentaire;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
    
}