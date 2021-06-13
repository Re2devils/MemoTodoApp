package jp.co.memotodo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.memotodo.controller.form.SignupForm;
import jp.co.memotodo.entity.Users;
import jp.co.memotodo.service.UsersService;

@Controller
public class SignupController {
	@Autowired
	HttpSession session;
	@Autowired
	UsersService userService;

	@RequestMapping(value = "/signup")
	public String signup (@ModelAttribute("signup") SignupForm signupForm, Model model) {
		return "signup";
	}

	@PostMapping(value = "/register")
	public String register(@Validated @ModelAttribute("signup") SignupForm signupForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "signup";
		}
		else {
			Users user = userService.findByLoginId(signupForm.getLoginId());
			if(user != null) {
				model.addAttribute("signupErrMsg", "ユーザー名は重複しています");
				return "signup";
			}
			else {
				if(!signupForm.getPassword().equals(signupForm.getRePass())) {
					model.addAttribute("signupErrMsg", "パスワードは一致しません");
					return "signup";
				}
				else {
					userService.register(new Users(signupForm.getLoginId(), signupForm.getUserName(),
							signupForm.getEmail(), signupForm.getPassword()));
					System.out.println("ユーザーが登録された");
					return "signupResult";
				}
			}
		}
	}

}
