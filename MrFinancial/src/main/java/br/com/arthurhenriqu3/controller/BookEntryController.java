package br.com.arthurhenriqu3.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.arthurhenriqu3.model.BookEntry;
import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.model.enums.TypeEnum;
import br.com.arthurhenriqu3.service.BookEntryService;
import br.com.arthurhenriqu3.service.CategoryService;
import br.com.arthurhenriqu3.service.WalletService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/lancamento")
public class BookEntryController {

	@Autowired
	private BookEntryService bookEntryService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private WalletService walletService;
	
	private final String path = "bookEntry/";

	@GetMapping
	public String getListAllPage(final Model model) {
		model.addAttribute("bookEntries", bookEntryService.findAll(Sort.by(Sort.Direction.DESC, "date")));
		return path + "listBookEntry";
	}

	@GetMapping("/new")
	public String getFormPage(final Model model) {
		model.addAttribute("categories", categoryService.findAllByType(TypeEnum.DESPESA.getCode().toString(),
				Sort.by(Sort.Direction.ASC, "name")));
		model.addAttribute("wallets", walletService.findAll());
		model.addAttribute("types", Arrays.asList(TypeEnum.values()));
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));
		model.addAttribute("category", new Category());
		model.addAttribute("bookEntry", new BookEntry());

		return path + "formBookEntry";
	}

	@GetMapping("/{id}")
	public String getFormPage(@PathVariable String id, final Model model) {

		BookEntry be = bookEntryService.findById(id);

		model.addAttribute("wallets", walletService.findAll());
		model.addAttribute("categories", categoryService.findAllByType(TypeEnum.DESPESA.getCode().toString(),
				Sort.by(Sort.Direction.ASC, "name")));
		model.addAttribute("types", Arrays.asList(TypeEnum.values()));
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));
		model.addAttribute("category", be.getCategory());
		model.addAttribute("bookEntry", be);

		return path + "formBookEntry";
	}

	@PostMapping("/register")
	public String doRegisterData(@ModelAttribute @Valid BookEntry be, BindingResult bindingResult,
			final Model model) {

		System.out.println("### BindingResult ###");
		bindingResult.getAllErrors().forEach(System.out::println);

		if (bindingResult.hasErrors()) {

			model.addAttribute("categories", categoryService.findAllByType(TypeEnum.DESPESA.getCode().toString(),
					Sort.by(Sort.Direction.ASC, "name")));
			model.addAttribute("wallets", walletService.findAll());
			model.addAttribute("types", Arrays.asList(TypeEnum.values()));
			model.addAttribute("status", Arrays.asList(StatusEnum.values()));
			model.addAttribute("category", be.getCategory());
			model.addAttribute("bookEntry", be);

			return path + "formBookEntry";
		}

		bookEntryService.register(be);
		return "redirect:/lancamento";
	}

	@PostMapping("/delete")
	public String doRegisterData(String id, Model model) {
		bookEntryService.deleteById(id);
		return "redirect:/lancamento";
	}

	@PostMapping("/visible")
	public String doUpdateVisible(String id, String status) {

		BookEntry be = bookEntryService.findById(id);
		be.setStatus(status.equals(StatusEnum.ATIVO.getValue()) ? StatusEnum.INATIVO : StatusEnum.ATIVO);

		bookEntryService.register(be);
		return "redirect:/lancamento";
	}
}