package br.com.arthurhenriqu3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.service.CategoryService;

@Controller
@RequestMapping("/")
public class DashboardController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(path = {"/", "/dashboard"})
	public String getHomePage(final Model model) {
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		return "home/dashboard";
	}
}