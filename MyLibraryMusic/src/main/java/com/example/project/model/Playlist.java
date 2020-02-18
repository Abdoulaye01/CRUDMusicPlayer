package com.example.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Playlist {
	
	
private String name;
private String artist;
private String album;
private String genre;
private int year;		
private int trackId;
//
//@OneToMany
//@JoinColumn(name = "id")
//private List<Tracks>tracks = new ArrayList();
//
//
//
//public List<Tracks> getTracks() {
//	return tracks;
//}
//public void setTracks(List<Tracks> tracks) {
//	this.tracks = tracks;
//}
//public int getTrackId() {
//	return trackId;
//}
//public void setTrackId(int trackId) {
//	this.trackId = trackId;
//}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getArtist() {
	return artist;
}
public void setArtist(String artist) {
	this.artist = artist;
}
public String getAlbum() {
	return album;
}
public void setAlbum(String album) {
	this.album = album;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}

}
