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

import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.service.WalletService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/carteira")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@GetMapping
	public String getHomePage(final Model model) {
		
		List<Wallet> wallets = walletService.findAll();
		model.addAttribute("wallets", wallets);
		
		return "wallet/listWallet";
	}
	
	@GetMapping("/new")
	public String getFormCategoryPage(final Model model) {
		model.addAttribute("wallet", new Wallet());
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));

		return "wallet/formWallet";
	}
	
	@GetMapping("/{id}")
	public String getFormCategoryPage(@PathVariable String id, final Model model) {
		model.addAttribute("wallet", walletService.findById(id));
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));

		return "wallet/formWallet";
	}
	
	@PostMapping("/register")
	public String doRegisterData(@ModelAttribute @Valid Wallet wallet, BindingResult bindingResult,
			final Model model) {

		System.out.println("### BindingResult ###");
		bindingResult.getAllErrors().forEach(System.out::println);

		if (bindingResult.hasErrors()) {
			model.addAttribute("wallet", wallet);
			model.addAttribute("status", Arrays.asList(StatusEnum.values()));

			return "wallet/formWallet";
		}

		walletService.register(wallet);
		return "redirect:/carteira";
	}
	
	@PostMapping("/delete")
	public String doRegisterData(String id, Model model) {
		walletService.deleteById(id);
		return "redirect:/carteira";
	}

	@PostMapping("/visible")
	public String doUpdateVisible(String id, String status) {

		Wallet w = walletService.findById(id);
		w.setStatus(status.equals(StatusEnum.ATIVO.getValue()) ? StatusEnum.INATIVO : StatusEnum.ATIVO);

		walletService.register(w);
		return "redirect:/carteira";
	}
}