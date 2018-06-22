package com.codingdojo.dojoninjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojoninjas.models.Dojo;
import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.service.DNService;

@Controller
public class DNController {
	private final DNService dnService;
	public DNController(DNService dnService) {
		this.dnService = dnService;
	}
	@RequestMapping("/dojos/new")
	public String index(@ModelAttribute Dojo dojo) {
		System.out.println("WOWOWW");
		return "index.jsp";
	}
	@RequestMapping(value="/dojos/create", method=RequestMethod.POST)
	public String dojocreate(@Valid @ModelAttribute("dojos") Dojo dojo, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo.jsp";
			}
		else {
			Dojo d = dnService.createDojo(dojo);
			return "redirect:/dojos/" + d.getId();
		}
	}
	@RequestMapping("ninjas/new")
	public String ninja(@ModelAttribute("ninjas") Ninja ninja, Model model) {
		model.addAttribute("dojos", dnService.findAllDojos());
		return "ninja.jsp";
	}
	@RequestMapping(value="/ninjas/create", method=RequestMethod.POST)
	public String ninjacreate(@Valid @ModelAttribute Ninja ninja, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "ninja.jsp";
			}
		else {
			Ninja n = dnService.createNinja(ninja);
			return "redirect:/dojos/" + n.getDojo().getId();
		}
			
	}
	@RequestMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo d = dnService.findDojo(id);
		model.addAttribute("dojo", d);
		Dojo n = dnService.findDojo(id);
		model.addAttribute("ninja", n.getNinjas());
		return "show.jsp";
	}
}
