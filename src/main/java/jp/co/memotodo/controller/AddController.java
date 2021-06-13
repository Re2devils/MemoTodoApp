package jp.co.memotodo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.memotodo.controller.form.AddForm;
import jp.co.memotodo.entity.Category;
import jp.co.memotodo.entity.Todo;
import jp.co.memotodo.entity.Users;
import jp.co.memotodo.service.CategoryService;
import jp.co.memotodo.service.TodoService;
import jp.co.memotodo.util.ParamUtil;

@Controller
public class AddController {

	@Autowired
	TodoService todoService;
	@Autowired
	HttpSession session;
	@Autowired
	CategoryService cateService;

	@RequestMapping(value="/add")
	public String addTodo(@ModelAttribute("addTodo") AddForm addForm, Model model) {
		List<Category> cateList = cateService.getAllCategory();
		session.setAttribute("cateList", cateList);
		return "add";
	}

	@PostMapping(value="/add")
	public String add(@Validated @ModelAttribute("addTodo") AddForm addForm,
			BindingResult bindingResult, Model model) {
		Users loginUser = (Users) session.getAttribute("loginUser");
//		System.out.println(ParamUtil.toStringDate(addForm.getEnddate()));
		Todo todo = new Todo(loginUser.getUserId(), addForm.getTask(), addForm.getCategoryId(),
				addForm.getNote(), addForm.getPlace(), ParamUtil.stringToDate(addForm.getStartdate()),
				ParamUtil.stringToDate(addForm.getEnddate()));

		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return "add";
		}
		else {
			session.setAttribute("addTodo", todo);
			todoService.registerTodo(todo);
			return "addResult";
		}

	}

}
