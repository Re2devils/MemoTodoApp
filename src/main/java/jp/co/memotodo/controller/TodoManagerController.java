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
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.memotodo.controller.form.SearchCateForm;
import jp.co.memotodo.controller.form.UpdateForm;
import jp.co.memotodo.entity.Todo;
import jp.co.memotodo.entity.Users;
import jp.co.memotodo.service.TodoService;
import jp.co.memotodo.util.ParamUtil;

@Controller
public class TodoManagerController {
	@Autowired
	HttpSession session;
	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/todoManager")
	public String todo(@ModelAttribute("searchCate") SearchCateForm searchForm, Model model) {
		return "todoManager";
	}
	@RequestMapping(value = "/updateTodo")
	public String updatetodo(@ModelAttribute("update") UpdateForm updateForm, Model model) {
		return "updateTodo";
	}
//	update button
	@GetMapping(value = "/crud", params="update")
	public String crud(@RequestParam("update") String todoId, @ModelAttribute("update")
	UpdateForm updateForm, Model model) {
		Users user = (Users) session.getAttribute("loginUser");
		Todo todo = todoService.getTodo(user.getUserId(), Integer.parseInt(todoId));
		session.setAttribute("nowTodo", todo);
		updateForm.setCategoryId(todo.getCategoryId());
		updateForm.setTask(todo.getTask());
		updateForm.setPlace(todo.getPlace());
		updateForm.setNote(todo.getNote());
		model.addAttribute("startdate", ParamUtil.dateToString(todo.getStartDate()));
		model.addAttribute("enddate", ParamUtil.dateToString(todo.getEndDate()));
		return "updateTodo";
	}

//  update 処理
	@PostMapping(value = "/toUpdate")
	public String update(@Validated @ModelAttribute("update") UpdateForm updateForm,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return "updateTodo";
		}
		else {
			Users user = (Users) session.getAttribute("loginUser");
			Todo nowTodo = (Todo) session.getAttribute("nowTodo");
			System.out.println(ParamUtil.stringToDate(updateForm.getEndDate()));
			Todo todo = new Todo(nowTodo.getTodoId(), nowTodo.getUserId(), updateForm.getTask(),
					updateForm.getCategoryId(), updateForm.getNote(), updateForm.getPlace(),
					ParamUtil.stringToDate(updateForm.getStartDate()),
					ParamUtil.stringToDate(updateForm.getEndDate()));
			todoService.updateTodo(todo);
			List<Todo> allTodoList = todoService.getAllTodoList(user);
			session.setAttribute("allTodoList", allTodoList);
			System.out.println("更新されました");
			return "updateResult";
		}
	}
//	delete button
	@GetMapping(value = "/crud", params="delete")
	public String crud(@RequestParam("delete") String todoId, Model model) {
		Users user = (Users) session.getAttribute("loginUser");
		Todo todo = todoService.getTodo(user.getUserId(), Integer.parseInt(todoId));
		session.setAttribute("nowTodo", todo);

		return "delete";
	}
//  delete 処理
	@PostMapping(value = "/deleteTodo")
	public String delete(@ModelAttribute("searchCate") SearchCateForm searchForm, Model model) {
		Todo todo = (Todo) session.getAttribute("nowTodo");
		todoService.deleteTodo(todo);
		Users user = (Users) session.getAttribute("loginUser");
		List<Todo> allTodoList = todoService.getAllTodoList(user);
		session.setAttribute("allTodoList", allTodoList);
		System.out.println("Todoが削除されました");
		return "todoManager";
	}
//	finish 処理
	@RequestMapping(value ="/finishTodo", params="finish")
	public String finish(@RequestParam("finish") String todoId, @ModelAttribute("searchCate") SearchCateForm searchForm, Model model) {
//		Todo todo = (Todo) session.getAttribute("nowTodo");
		Users user = (Users) session.getAttribute("loginUser");
		todoService.finishTodo(user.getUserId(), Integer.parseInt(todoId));
		List<Todo> allTodoList = todoService.getAllTodoList(user);
		session.setAttribute("allTodoList", allTodoList);
		return "todoManager";
	}

}