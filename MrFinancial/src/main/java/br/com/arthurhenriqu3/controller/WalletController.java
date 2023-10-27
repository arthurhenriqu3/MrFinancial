package br.com.arthurhenriqu3.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.model.dto.UserDto;
import br.com.arthurhenriqu3.model.dto.WalletDto;
import br.com.arthurhenriqu3.model.dto.mapper.UserDTOMapper;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.service.UserService;
import br.com.arthurhenriqu3.service.WalletService;

@Controller
@RequestMapping("/carteira")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDTOMapper userDTOMapper;
	
	@GetMapping
	public String getHomePage(Pageable pageable, final Model model) {
		model.addAttribute("wallets", walletService.findAll(pageable));
		return "wallet/listWallet";
	}

	@GetMapping("/new")
	public String getFormPage(final Model model) {
		Wallet wallet = new Wallet();
		wallet.setUser(userService.findAll().get(0));
		
		model.addAttribute("walletDto", new WalletDto(wallet));
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));
		
		return "wallet/formWallet";
	}

	@GetMapping("/{id}")
	public String getFormPage(@PathVariable String id, final Model model) {
		model.addAttribute("walletDto", walletService.findById(id));
		model.addAttribute("status", Arrays.asList(StatusEnum.values()));
		
		return "wallet/formWallet";
	}
	
	@PostMapping("/register")
	public String doRegisterData(@ModelAttribute("walletDto") WalletDto walletDto, BindingResult bindingResult, final Model model) {
		System.out.println("### walletDTO ###"); 
		System.out.println(walletDto.getName()); 
		System.out.println(walletDto.getStatus()); 
		System.out.println(walletDto.getUserDTO()); 

		if (bindingResult.hasErrors()) {
			model.addAttribute("walletDto", walletDto);
			model.addAttribute("status", Arrays.asList(StatusEnum.values()));

			return "wallet/formWallet";
		}

		
		///walletService.register(walletDTO);
		return "redirect:/carteira";
	}

	@PostMapping("/delete")
	public String doRegisterData(String id, Model model) {
		walletService.deleteById(id);
		return "redirect:/carteira";
	}

	@PostMapping("/visible")
	public String doUpdateVisible(String id, String status) {

//		Wallet w = walletService.findById(id);
//		w.setStatus(status.equals(StatusEnum.ATIVO.getValue()) ? StatusEnum.INATIVO : StatusEnum.ATIVO);

		//walletService.register(w);
		return "redirect:/carteira";
	}
}