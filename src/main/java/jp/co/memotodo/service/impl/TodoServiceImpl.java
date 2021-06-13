package jp.co.memotodo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.memotodo.dao.TodoDao;
import jp.co.memotodo.entity.Todo;
import jp.co.memotodo.entity.Users;
import jp.co.memotodo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	TodoDao todoDao;
	@Override
	public List<Todo> getTodoList() {
		// TODO 自動生成されたメソッド・スタブ
		return todoDao.getTodoList();
	}
	@Override
	public List<Todo> getWeekTodoList(Users user) {
		// TODO 自動生成されたメソッド・スタブ
		return todoDao.getWeekTodoList(user);
	}
	@Override
	public List<Todo> getAllTodoList(Users user) {
		// TODO 自動生成されたメソッド・スタブ
		return todoDao.getAllTodoList(user);
	}
	@Override
	public Todo getTodo(int userId, int todoId) {
		// TODO 自動生成されたメソッド・スタブ
		return todoDao.getTodo(userId, todoId);
	}
	@Override
	public void registerTodo(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		todoDao.registerTodo(todo);
	}
	@Override
	public void updateTodo(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		todoDao.updateTodo(todo);
	}
	@Override
	public List<Todo> searchTodo(String task, int userId) {
		// TODO 自動生成されたメソッド・スタブ
		return todoDao.searchTodo(task, userId);
	}
	@Override
	public void deleteTodo(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		todoDao.deleteTodo(todo);
	}
	@Override
	public void finishTodo(int userId, int todoId) {
		// TODO 自動生成されたメソッド・スタブ
		todoDao.finishTodo(userId, todoId);
	}

}
