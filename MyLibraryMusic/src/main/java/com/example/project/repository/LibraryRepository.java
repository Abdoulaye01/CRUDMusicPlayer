package com.example.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.project.model.Library;

public interface LibraryRepository extends CrudRepository<Library, Integer> {


	public Library findByListid(int id);
	
	public List<Library>findAll();
}
