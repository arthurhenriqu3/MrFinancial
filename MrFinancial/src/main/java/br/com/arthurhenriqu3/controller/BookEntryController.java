package br.com.arthurhenriqu3.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.arthurhenriqu3.model.BookEntry;
import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.model.enums.TypeEnum;
import br.com.arthurhenriqu3.service.CategoryService;

@Controller
@RequestMapping("/lancamentos")
public class BookEntryController {

	@Autowired
	private CategoryService categoryService;
	
	private final String path = "bookEntry/";

	@GetMapping
	public String getAllCategoryPage(final Model model) {
		model.addAttribute("categories", categoryService.findAll(Sort.by(Sort.Direction.ASC, "name")));
		return path + "list";
	}

	@GetMapping("/new")
	public String getFormCategoryPage(final Model model) {
		model.addAttribute("categories", categoryService.findAll(Sort.by(Sort.Direction.ASC, "name")));
		model.addAttribute("types", Arrays.asList(TypeEnum.values()));
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));
		model.addAttribute("category", new Category());
		model.addAttribute("bookEntry", new BookEntry());

		return path + "form";
	}
}