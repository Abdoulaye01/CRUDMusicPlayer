package com.example.project.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.model.Library;
import com.example.project.model.Tracks;
import com.example.project.model.User;
import com.example.project.services.LibraryService;
import com.example.project.services.TracksService;
import com.example.project.services.UserService;

@Controller
public class ApplicationController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private TracksService tracksService;
	
	@Autowired
	BaseService baseService;
	
	
	
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request,HttpSession session) {
		request.setAttribute("mode", "MODE_HOME");
		baseService.getCurrentUserInfo(session);
		return "welcomepage";
	}
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request) throws ServletException {
		

		if(user.getUsername().isEmpty() && user.getFirstname().isEmpty()&& user.getLastname().isEmpty() &&
			user.getPassword().isEmpty()) {
			request.setAttribute("error", "Invalid Username ,Firtname,Lastname and Password");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
	
		}else {
			userService.saveMyUser(user);
			request.setAttribute("mode", "MODE_HOME");
			return "homepage";
		}
//return "homepage";
}

	//SHOW ALL THE SONG AVAILABLE ON THE WEBSITE FOR USER TO ADD TO HIS TRACK TABLE
	@GetMapping("/show-playlists")
	public String ShowAllPlaylists(HttpServletRequest request, HttpSession session)
	{

		baseService.getCurrentUserInfo(session);
		   request.setAttribute("lib",libraryService.showAllPlaylist());
		   request.setAttribute("mode", "ALL_PLAYLISTS");
		   baseService.getCurrentUserInfo(session);
		   return "welcomepage";
	 
	}
	@GetMapping("/add-song")
	public String addSong(@ModelAttribute User user,@RequestParam int id,HttpServletRequest request,Library library, Tracks tracks,HttpSession session) {
		
			request.setAttribute("li",libraryService.findByListid(id));
			request.setAttribute("mode", "ALL_PLAYLISTS");
			tracks.getAlbum();
			tracks.getName();
			baseService.getCurrentUserInfo(session);
			tracksService.saveMyTracks(tracks);
			return "homepage";
		
		
	      
	}
	    
	//Delete song 
	@RequestMapping("/delete-song")
	public String deleteSong(@RequestParam int id,HttpServletRequest request,HttpSession session) {	
		libraryService.deleteMySong(id);
		request.setAttribute("lib",libraryService.showAllPlaylist());
		request.setAttribute("mode", "ALL_PLAYLISTS");
		baseService.getCurrentUserInfo(session);
		return "welcomepage";
	}
	
	
	//update song
	@PostMapping("/save-song")
	public String registerSong(@ModelAttribute Library song,BindingResult bindingResult,HttpServletRequest request) {
		libraryService.saveMySong(song);
	request.setAttribute("mode", "MODE_HOME");
	return "welcomepage";	
}
	

	
	@GetMapping("/show-tracks")
	public String ShowAllTracks(HttpServletRequest request, HttpSession session)
	{
		   
		   request.setAttribute("lib",tracksService.showAllTracks());
		   baseService.getCurrentUserInfo(session);
		   request.setAttribute("mode", "ALL_TRACKS");
		   return "welcomepage";
	 
	}
	

			
			
	
	//Edit song
	@RequestMapping("/edit-song")
	public String editSong(@RequestParam int id,HttpServletRequest request,HttpSession session) {
		baseService.getCurrentUserInfo(session);
		request.setAttribute("li",libraryService.findByListid(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "welcomepage";
	}
	
	
	
	//Login Section
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";	
	}
	
	@RequestMapping ("/login-user")
	public String loginUser( HttpSession session,@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
		
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null ) {
		
			 session.setAttribute("user", user);
			return "homepage";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
			
		}
			
		
	}
	
	 @GetMapping("/logout")
	   public String logout(HttpSession session ) {
	      session.invalidate();
	      return "redirect:/welcome";
	   }
}
