package br.com.arthurhenriqu3.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.enums.BookEntryTypeEnum;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.service.CategoryService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String getAllCategoryPage(final Model model) {

		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);

		return "category/listCategory";
	}

	@GetMapping("/new")
	public String getFormCategoryPage(final Model model) {
		model.addAttribute("types", Arrays.asList(BookEntryTypeEnum.values()));
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("category", new Category());
		
		return "category/formCategory";
	}
	
	@GetMapping("/{id}")
	public String getFormCategoryPage(@PathVariable String id, final Model model){
		model.addAttribute("types", Arrays.asList(BookEntryTypeEnum.values()));
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("category", categoryService.findById(id));
		
		return "category/formCategory";
	}
	
	@PostMapping("/register")
	public String doRegisterData(@Valid @ModelAttribute Category category, Model model) {
		categoryService.register(category);
		return "redirect:/category";
	}

	@PostMapping("/delete")
	public String doRegisterData(String id, Model model) {
		categoryService.deleteById(id);
		return "redirect:/category";
	}
}