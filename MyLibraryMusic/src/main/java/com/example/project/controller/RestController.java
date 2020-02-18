package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.model.Tracks;
import com.example.project.model.User;
import com.example.project.services.TracksService;
import com.example.project.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService userService;
	
	
	//private TracksService tracksService;
	
	@GetMapping("/")
	public String hello() {
		return "this is home page";
	}
	
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String username, @RequestParam String firstname,@RequestParam String lastname,
			@RequestParam int age, @RequestParam String password) {
		User user = new User(username,firstname,lastname,age,password);
		userService.saveMyUser(user);
		return "User saved";
	}
	
	
	
//	@PostMapping("/addsong")
//	public String saveUser(@RequestParam String name, @RequestParam String album) {
//		Tracks tracks = new Tracks(name,album);
//		tracksService.saveMyTracks(tracks);
//		return "Track saved";
//	}
}
