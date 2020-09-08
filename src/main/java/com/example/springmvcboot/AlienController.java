package com.example.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmvcboot.model.Alien;
import com.example.springmvcboot.repo.AlienRepo;

//@Controller
@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping(path="/aliensList", produces="application/xml")
//	@ResponseBody
	public List<Alien> getAliens() {
		List<Alien> aliens = repo.findAll();
//		int i = 4/0;
		return aliens;
	}
	
	@GetMapping("/alien/{aid}")
//	@ResponseBody
	public Alien getAlien(@PathVariable("aid") int aid) {
		Alien aliens = repo.findById(aid).orElse(new Alien(0,""));
		return aliens;
	}

	@PostMapping(path="/alien", consumes="application/json")
//	@ResponseBody
	public Alien  addAlien(@RequestBody Alien alien) {
		Alien a = repo.save(alien);
		return a;
	}
}
