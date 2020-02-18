package com.example.project.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.project.model.Library;
import com.example.project.model.Tracks;
import com.example.project.model.User;
import com.example.project.repository.LibraryRepository;
import com.example.project.repository.TracksRepository;

@Service
@Transactional
public class TracksService {

	private final TracksRepository tracksRepository;
	
	
	Library library;
	private  LibraryRepository libraryRepository;

	public TracksService(TracksRepository tracksRepository) {
		this.tracksRepository = tracksRepository;
	}
	
	public List<Tracks>showAllTracks()
	{
		List<Tracks> lib = new ArrayList<Tracks>();
		for(Tracks li: tracksRepository.findAll())
		{
			lib.add(li);
		}
		return lib;
	}
	
	public Tracks saveMyTracks(Tracks tr) {
		return tracksRepository.save(tr);
	}
	public Tracks findById(Long id)
	{
		return tracksRepository.findById(id);
		
	}
}


