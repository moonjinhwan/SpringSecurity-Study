package com.jin.security1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jin.security1.model.User;
import com.jin.security1.repository.UserRepository;

@Controller
public class IndexController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public @ResponseBody String index() {
		return "인덱스 페이지";
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "/loginForm";
	}

	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}

	@GetMapping("/manager")
	public String manager() {
		return "manager";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}

	@PostMapping("/join")
	public String joinProc(User user) {
		System.out.println(user);
		user.setRole("ROLE_USER");
		user.setEmail(user.getEmail());
		String rawPassword= user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		userRepository.save(user);
		return "redirect:/login";
	}
}
