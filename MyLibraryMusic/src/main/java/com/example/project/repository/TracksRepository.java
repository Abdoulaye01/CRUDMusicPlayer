package com.example.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.project.model.Library;
import com.example.project.model.Tracks;

public interface TracksRepository extends CrudRepository<Tracks, Integer>{ 
	
	public Tracks findById(Long id);
	//public Library findByListid(int listid);
}
