package jp.co.memotodo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.memotodo.dao.TodoDao;
import jp.co.memotodo.entity.Todo;
import jp.co.memotodo.entity.Users;

@Repository
public class TodoDaoImpl implements TodoDao {

	private static final String FIND_ALL_TODO = "select *,"
			+ " to_char(end_date, 'mm月dd日') as enddate,  "
			+ " to_char(start_date, 'mm月dd日') as startdate, "
			+ " is_finish as finished, "
			+ " to_char(start_date, 'yyyy-mm-dd hh:mm') as fullStartDate, "
			+ " to_char(end_date, 'yyyy-mm-dd hh:mm') as fullEndDate "
			+ " from todo";
	private static final String WHERE_USER_ID = " where user_id = :userId ";
	private static final String AND_LOGIN_ID = " and todo_id = :todoId";
	//	get current date
	//	private static final String CURRENT_DATE = "select to_char(now() :: date, 'yyyy/mm/dd')";
	//	ユーザーの一週間のタスクを取得
	private static final String WEEK_TODO = "select * ,"
			+ " to_char(end_date, 'mm月dd日') as enddate,  "
			+ " to_char(start_date, 'HH24時MM分') as starttime, "
			+ " to_char(end_date, 'HH24時MM分') as endtime "
			//			+ " is_finish as done "
			+ " from todo where (end_date between (select current_date) "
			+ " and (select current_date + interval'7day') "
			+ " and user_id = :userId and is_finish = false) or (user_id = :userId and end_date is null) ";
	private static final String ORDER_BY_END_DATE = " order by end_date";

	private static final String INSER_INTO_TODO = "insert into todo( user_id, task, start_date, end_date, place, category_id, note ) "
			+ " values ( :userId, :task, :startDate, :endDate, :place, :categoryId, :note ) ";

	private static final String UPDATE_TO = "update todo set task = :task, start_date = :startDate, "
			+ " end_date = :endDate, place = :place, category_id = :categoryId, note = :note "
			+ " where user_id = :userId and todo_id = :todoId";

	private static final String SEARCH_TODO = "select * from todo where task like :taskname "
			+ " and user_id = :userId";

	private static final String DELETE_TODO = "delete from todo where user_id = :userId and todo_id = :todoId";

	private static final String FINISH_TODO = "update todo set is_finish = not is_finish where "
			+ "user_id = :userId and todo_id = :todoId";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemple;

	@Override
	public List<Todo> getTodoList() {
		// TODO 自動生成されたメソッド・スタブ
		String sql = FIND_ALL_TODO;
		List<Todo> todoList = jdbcTemple.query(sql, new BeanPropertyRowMapper<Todo>(Todo.class));
		return todoList.isEmpty() ? null : todoList;
	}

	@Override
	public List<Todo> getWeekTodoList(Users user) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = WEEK_TODO + ORDER_BY_END_DATE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", user.getUserId());
		List<Todo> todoList = jdbcTemple.query(sql, param, new BeanPropertyRowMapper<Todo>(Todo.class));
		return todoList.isEmpty() ? null : todoList;
	}

	@Override
	public List<Todo> getAllTodoList(Users user) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = FIND_ALL_TODO + WHERE_USER_ID + ORDER_BY_END_DATE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", user.getUserId());
		List<Todo> todoList = jdbcTemple.query(sql, param, new BeanPropertyRowMapper<Todo>(Todo.class));
		return todoList.isEmpty() ? null : todoList;
	}

	@Override
	public Todo getTodo(int userId, int todoId) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = FIND_ALL_TODO + WHERE_USER_ID + AND_LOGIN_ID;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("todoId", todoId);
		List<Todo> todoList = jdbcTemple.query(sql, param, new BeanPropertyRowMapper<Todo>(Todo.class));
		return todoList.isEmpty() ? null : todoList.get(0);
	}

	@Override
	public void registerTodo(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = INSER_INTO_TODO;
		System.out.println("todo dao impl : " + todo.getStartDate());
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", todo.getUserId());
		param.addValue("task", todo.getTask());
		param.addValue("startDate", todo.getStartDate());
		param.addValue("endDate", todo.getEndDate());
		param.addValue("place", todo.getPlace());
		param.addValue("categoryId", todo.getCategoryId());
		param.addValue("note", todo.getNote());
		jdbcTemple.update(sql, param);

	}

	@Override
	public void updateTodo(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = UPDATE_TO;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("task", todo.getTask());
		param.addValue("startDate", todo.getStartDate());
		param.addValue("endDate", todo.getEndDate());
		param.addValue("place", todo.getPlace());
		param.addValue("categoryId", todo.getCategoryId());
		param.addValue("note", todo.getNote());
		param.addValue("userId", todo.getUserId());
		param.addValue("todoId", todo.getTodoId());
		//		System.out.println(sql);
		jdbcTemple.update(sql, param);
	}

	@Override
	public List<Todo> searchTodo(String task, int userId) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = SEARCH_TODO;
		System.out.println(task + " " + userId);
		String taskname = "%" + task.toLowerCase().trim() + "%";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("taskname", taskname);
		param.addValue("userId", userId);
		List<Todo> todoList = jdbcTemple.query(sql, param, new BeanPropertyRowMapper<Todo>(Todo.class));
		return todoList.isEmpty() ? null : todoList;
	}

	@Override
	public void deleteTodo(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = DELETE_TODO;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", todo.getUserId());
		param.addValue("todoId", todo.getTodoId());
		jdbcTemple.update(sql, param);
	}

	@Override
	public void finishTodo(int userId, int todoId) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = FINISH_TODO;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("todoId", todoId);
		jdbcTemple.update(sql, param);
	}
}
