package jp.co.memotodo.service;

import java.util.List;

import jp.co.memotodo.entity.Todo;
import jp.co.memotodo.entity.Users;

public interface TodoService {
	public List<Todo> getTodoList();
	public List<Todo> getWeekTodoList(Users user);
	public List<Todo> getAllTodoList(Users user);
	public Todo getTodo(int userId, int todoId);
	public void registerTodo(Todo todo);
	public void updateTodo(Todo todo);
	public List<Todo> searchTodo(String task, int userId);
	public void deleteTodo(Todo todo);
	public void finishTodo(int userId, int todoId);
}
