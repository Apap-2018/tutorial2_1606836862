package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()){
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value="a",required=false,defaultValue="0") String getA, @RequestParam(value="b",required=false,defaultValue="0") String getB, Model model) {
		int a = Integer.parseInt(getA);
		int b = Integer.parseInt(getB);
		model.addAttribute("a", a);
		model.addAttribute("b", b);
	
		String word = "h";
		if (a == 0) {
			a = 1;
		}if (b == 0) {
			b = 1;
		}
		int x = a;
		while(x>0) {
			word += "m";
			x--;
		}
		String res = word;
		int i =b;
		while (i >1) {
			res += " " +word;
			i--;
		}
	
		model.addAttribute("result", res);
	
		return "generator";
	
	}
 
}