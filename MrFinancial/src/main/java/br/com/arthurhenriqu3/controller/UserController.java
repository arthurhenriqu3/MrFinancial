package br.com.arthurhenriqu3.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.service.UserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String getHomePage(final Model model) {

		List<User> users = userService.findAll();
		model.addAttribute("users", users);

		return "user/listUser";
	}

	@GetMapping("/new")
	public String getFormPage(final Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));

		return "user/formUser";
	}

	@GetMapping("/{id}")
	public String getFormPage(@PathVariable String id, final Model model) {
		model.addAttribute("user", userService.findById(id));
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));

		return "user/formUser";
	}

	@PostMapping("/register")
	public String doRegisterData(@ModelAttribute @Valid User user, BindingResult bindingResult, final Model model) {

		System.out.println("### BindingResult ###");
		bindingResult.getAllErrors().forEach(System.out::println);

		if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("status", Arrays.asList(StatusEnum.values()));

			return "usuario/formUser";
		}

		userService.register(user);
		return "redirect:/usuario";
	}

	@PostMapping("/delete")
	public String doRegisterData(String id, Model model) {
		userService.deleteById(id);
		return "redirect:/usuario";
	}

	@PostMapping("/visible")
	public String doUpdateVisible(String id, String status) {

		User u = userService.findById(id);
		u.setStatus(status.equals(StatusEnum.ATIVO.getValue()) ? StatusEnum.INATIVO : StatusEnum.ATIVO);

		userService.register(u);
		return "redirect:/usuario"; 
	}
}