package base.usermanage.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import base.usermanage.com.model.UserModel;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {

	@GetMapping("/Login")
	String signIn() {
		return "login";
	}

	@GetMapping("/Register")
	String signUpPage(UserModel user) {

		return "register";
	}

	@PostMapping("/Register")
	String signUp(UserModel user) {

		userService.signUpUser(user);

		return "redirect:/sign-in";
	}

}
