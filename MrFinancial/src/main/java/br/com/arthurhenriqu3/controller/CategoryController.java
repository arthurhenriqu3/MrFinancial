package br.com.arthurhenriqu3.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.model.enums.TypeEnum;
import br.com.arthurhenriqu3.service.CategoryService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String getAllCategoryPage(final Model model) {
		model.addAttribute("categories", categoryService
				.findAll(Sort.by(Sort.Direction.ASC, "parent.name").and(Sort.by(Sort.Direction.ASC, "name"))));
		return "category/listCategory";
	}

	@GetMapping("/new")
	public String getFormCategoryPage(final Model model) {
		return getFormCategoryPage(model, TypeEnum.DESPESA, new Category());
	}

	@GetMapping("/{id}")
	public String getFormCategoryPage(@PathVariable String id, final Model model) {
		return getFormCategoryPage(model, null, categoryService.findById(id));
	}

	@PostMapping("/register")
	public String doRegisterData(@ModelAttribute @Valid Category category, BindingResult bindingResult,
			final Model model) {

		System.out.println("### BindingResult ###");
		bindingResult.getAllErrors().forEach(System.out::println);

		if (bindingResult.hasErrors()) {
			return getFormCategoryPage(model, null, category);
		}

		categoryService.register(category);
		return "redirect:/category";
	}

	@PostMapping("/delete")
	public String doRegisterData(String id, Model model) {
		categoryService.deleteById(id);
		return "redirect:/category";
	}

	@PostMapping("/visible")
	public String doUpdateVisible(String id, String status) {

		Category c = categoryService.findById(id);
		c.setStatus(status.equals(StatusEnum.ATIVO.getValue()) ? StatusEnum.INATIVO : StatusEnum.ATIVO);

		categoryService.register(c);
		return "redirect:/category";
	}

	@PostMapping("/findAllBy/{type}")
	public ResponseEntity<List<Category>> findAll(@PathVariable String type) {
		return new ResponseEntity<List<Category>>(categoryService.findAllByType(type), HttpStatus.OK);
	}

	private String getFormCategoryPage(Model model, TypeEnum type, Category category) {
		model.addAttribute("types", Arrays.asList(TypeEnum.values()));
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));
		model.addAttribute("category", category);

		if(type == null) {
			model.addAttribute("categories", categoryService.findAllByType(category.getType().getCode().toString(), Sort.by(Sort.Direction.ASC, "name")));			
		}else {
			model.addAttribute("categories", categoryService.findAllByType(type.getCode().toString(), Sort.by(Sort.Direction.ASC, "name")));			
		}
		
		return "category/formCategory";
	}
}