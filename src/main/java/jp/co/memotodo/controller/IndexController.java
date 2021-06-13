package jp.co.memotodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping({"/", "/index"})
	public String index(Model model) {
		return "index";
	}
	@RequestMapping(value = "/footer")
	public String footer(Model model) {
		return "footer";
	}
	@RequestMapping(value = "/header")
	public String header(Model model) {
		return "header";
	}

	@RequestMapping(value = "/tabbar")
	public String tabbar(Model model) {
		return "tabbar";
	}
	@RequestMapping(value = "/signupResult")
	public String signupResult(Model model) {
		return "signupResult";
	}
	@RequestMapping(value = "/menu")
	public String menu(Model model) {
		return "menu";
	}
	@RequestMapping(value = "/delete")
	public String delete(Model model) {
		return "delete";
	}

}
