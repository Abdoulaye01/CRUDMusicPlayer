package com.example.project.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.project.model.Library;
//import com.example.project.model.Library;
import com.example.project.repository.LibraryRepository;


@Service
@Transactional
public class LibraryService {
	
	private final  LibraryRepository libraryRepository;
	
	
	public LibraryService(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}
		
	public List<Library>showAllPlaylist()
	{
		List<Library> lib = new ArrayList<Library>();
		for(Library li:libraryRepository.findAll())
		{
			lib.add(li);
		}
		return lib;
	}
	
	public List<Library>findAll(){
		return libraryRepository.findAll();
	}
	
	public void deleteMySong(int id)
	{
		libraryRepository.deleteById(id);
		
	}
	public void saveMySong(Library song) {
		libraryRepository.save(song);
	}
	
	public Library findByListid(int id)
	{
		return libraryRepository.findByListid(id);
		
	}
}