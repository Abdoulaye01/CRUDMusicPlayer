package com.example.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tracks")
public class Tracks {
	
	@Id
	private int id;
	private String name;
	private String album;
	
	@ManyToOne( cascade = CascadeType.ALL)
	private Library library;
	
	
	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Tracks(String name, String album, Library library) {
		super();
		this.name = name;
		this.album = album;
		this.library= library;
		
	}

//	public Library getLibrary() {
//		return library;
//	}

//	public void setLibrary(Library library) {
//		this.library = library;'
//	}

	public Tracks() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Tracks [id=" + id + ", name=" + name + ", album=" + album + "]";
	}
	
	

}
