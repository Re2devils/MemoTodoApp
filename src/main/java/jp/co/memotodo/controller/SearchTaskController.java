package jp.co.memotodo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.memotodo.controller.form.SearchCateForm;
import jp.co.memotodo.controller.form.SearchForm;
import jp.co.memotodo.entity.Todo;
import jp.co.memotodo.entity.Users;
import jp.co.memotodo.service.TodoService;

@Controller
public class SearchTaskController {
	@Autowired
	TodoService todoService;
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/search")
	public String search(@ModelAttribute("searchTodo") SearchForm searchForm, Model model) {
		return "search";
	}

	@RequestMapping(value = "/searchTask")
	public String search1(@ModelAttribute("searchTodo") SearchForm searchForm,
			@ModelAttribute("searchCate") SearchCateForm searchCateForm, Model model) {
		if(searchForm.getSearchItem() == null || searchForm.getSearchItem().isEmpty()) {
			session.removeAttribute("searchTodoList");
		}
		else {
			Users loginUser = (Users) session.getAttribute("loginUser");
			System.out.println("search task controller: " + searchForm.getSearchItem() + loginUser.getUserId());
			List<Todo> todoList = todoService.searchTodo(searchForm.getSearchItem(), loginUser.getUserId());
			System.out.println(todoList);
			session.setAttribute("searchTodoList", todoList);
		}
		return "todoManager";
	}

//	@RequestMapping(value = "/searchByCategory")
//	public String search2(@ModelAttribute("todo") SearchCateForm searchForm, Model model) {
//		if(searchForm.getCategoryId() == null || searchForm.getCategoryId().isEmpty()) {
//			session.removeAttribute("searchTodoList");
//		}
//		else {
//			List<Todo> todoList = todoService.searchTodo(searchForm.getCategoryId());
//			System.out.println(todoList);
//			session.setAttribute("searchTodoList", todoList);
//		}
//
//		return "todoManager";
//	}
}
