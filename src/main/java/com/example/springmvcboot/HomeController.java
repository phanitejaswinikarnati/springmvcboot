package com.example.springmvcboot;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.springmvcboot.model.Alien;
import com.example.springmvcboot.repo.AlienRepo;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Alien");
	}
	
	@RequestMapping("/")
	public String home(Model m) {
		System.out.println("Home page requested.");
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("index");
		m.addAttribute("AllAliens", repo.findAll());
		return "index";
	}
	
	/*//ModelAndView
	 * @RequestMapping("/add") public ModelAndView add(@RequestParam("num1") int
	 * i, @RequestParam("num2") int j) {
	 * 
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("result"); int s = i+j;
	 * mv.addObject("result",s); return mv;
	 * 
	 * }
	 */

	/*//Model
	 * @RequestMapping("/add") public String add(@RequestParam("num1") int
	 * i, @RequestParam("num2") int j, Model m) {
	 * System.out.println("Result page requested"); int s = i+j;
	 * m.addAttribute("result",s); return "result";
	 * 
	 * }
	 */
	
	@RequestMapping("/add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m) {
		System.out.println("Result page requested");
		int s = i+j;
		m.addAttribute("result",s);
		return "result";
		
	}
	
	/*
	 * @RequestMapping("/addAlienData") public String AlienData(@RequestParam("aid")
	 * int aid, @RequestParam("aname") String aname, Model m) {
	 * 
	 * Alien a = new Alien(); a.setAid(aid); a.setAname(aname);
	 * 
	 * m.addAttribute("alien", a); return "alienData"; }
	 */
	
	/*
	 * @RequestMapping("/addAlienData") public String
	 * AlienData(@ModelAttribute("alienData") Alien alien) {
	 * return "alienData"; }
	 */
	/*
	 * @RequestMapping(value="/addAlienData", method=RequestMethod.POST) public
	 * String AlienData(@ModelAttribute("alienData") Alien alien) {
	 * return "alienData"; }
	 */
	@PostMapping(value="/addAlienData")
	public String AlienData(@ModelAttribute("alienData") Alien alien) {
		
		repo.save(alien);
		return "index";
	}
	
	@GetMapping("/getAliensList")
	public String getAliens(Model m) {
		m.addAttribute("AliensDataList", repo.findAll());
		return "alienData";
	}
	
	@PostMapping("/getAlienData")
	public String getAlien(Model m, @RequestParam int aid) {
		System.out.println(aid);
		m.addAttribute("AlienData", repo.getOne(aid));
		return "alienData";
	}
	
	@PostMapping("/deleteAlienData")
	public String removeAlien(@ModelAttribute Alien alien) {
		repo.delete(alien);
		return "index";
	}
	
	@PostMapping("/getAlienDataByName")
	public String getAlienDataByName(@RequestParam("aname") String aname, Model m) {
		m.addAttribute("findAliensByName", repo.find(aname));
		return "alienData";
	}
}
