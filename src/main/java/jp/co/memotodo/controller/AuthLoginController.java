package jp.co.memotodo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.memotodo.controller.form.LoginForm;
import jp.co.memotodo.entity.Category;
import jp.co.memotodo.entity.Todo;
import jp.co.memotodo.entity.Users;
import jp.co.memotodo.service.CategoryService;
import jp.co.memotodo.service.TodoService;
import jp.co.memotodo.service.UsersService;

@Controller
public class AuthLoginController {
	@Autowired
	HttpSession session;
	@Autowired
	UsersService userService;
	@Autowired
	TodoService todoService;
	@Autowired
	CategoryService cateService;

	@RequestMapping(value = "/login")
	public String login (@ModelAttribute("login") LoginForm loginForm, Model model) {
		return "login";
	}
//	logout page
	@RequestMapping(value = "/logout")
	public String logout(Model model) {
		session.invalidate();
		System.out.println("sessionが廃棄さらた");
		return "logout";
	}
	@GetMapping(value = "/mypage")
	public String mypageGet(@ModelAttribute("login") LoginForm loginForm, Model model) {

		Users loginUser = (Users) session.getAttribute("loginUser");
		List<Todo> todoList = todoService.getWeekTodoList(loginUser);
		List<Todo> allTodoList = todoService.getAllTodoList(loginUser);
		session.setAttribute("todoList", todoList);
		session.setAttribute("allTodoList", allTodoList);
		return "mypage";
	}
	@PostMapping(value = "/mypage")
	public String mypage (@Validated @ModelAttribute("login") LoginForm loginForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors())
		{
			return "login";
		}
		else {
			Users user = userService.authLogin(loginForm.getLoginId(), loginForm.getPassword());
			if(user == null){
				model.addAttribute("loginErrMsg", "ユーザー名またはパスワードを正しく入力してください");
				return "login";
			}
			else {
				List<Todo> todoList = todoService.getWeekTodoList(user);
				List<Category> cateList = cateService.getAllCategory();
				List<Todo> allTodoList = todoService.getAllTodoList(user);
				session.setAttribute("loginUser", user);
				session.setAttribute("todoList", todoList);
				session.setAttribute("cateList", cateList);
				session.setAttribute("allTodoList", allTodoList);
				return "mypage";
			}
		}
	}
}
