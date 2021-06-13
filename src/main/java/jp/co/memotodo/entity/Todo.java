package jp.co.memotodo.entity;

import java.sql.Timestamp;

public class Todo {
	private Integer todoId;
	private Integer userId;
	private String task;
	private String place;
	private String categoryId;
	private String note;
	private Timestamp startDate;
	private Timestamp endDate;
	private boolean isFinish;

//	ｓｑｌ文での名称
	private String enddate;
	private String startdate;
	private boolean finished;
	private String starttime;
	private String endtime;
	private String fullStartDate;
	private String fullEndDate;

	public Todo() {

	}

	public Todo(Integer todoId, Integer userId, String task, String categoryId, String note,
			String place, Timestamp startDate, Timestamp endDate, boolean isFinish) {
		this.todoId = todoId;
		this.userId = userId;
		this.task = task;
		this.categoryId = categoryId;
		this.note = note;
		this.place = place;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isFinish = isFinish;
	}
	public Todo(Integer todoId, Integer userId, String task, String categoryId, String note,
			String place, Timestamp startDate, Timestamp endDate) {
		this.todoId = todoId;
		this.userId = userId;
		this.task = task;
		this.categoryId = categoryId;
		this.note = note;
		this.place = place;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Todo(Integer userId, String task, String categoryId, String note,
			String place, Timestamp startDate, Timestamp endDate) {
		this.userId = userId;
		this.task = task;
		this.categoryId = categoryId;
		this.note = note;
		this.place = place;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public Integer getTodoId() {
		return todoId;
	}

	public void setTodoId(Integer todoId) {
		this.todoId = todoId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getFullStartDate() {
		return fullStartDate;
	}

	public void setFullStartDate(String fullStartDate) {
		this.fullStartDate = fullStartDate;
	}

	public String getFullEndDate() {
		return fullEndDate;
	}

	public void setFullEndDate(String fullEndDate) {
		this.fullEndDate = fullEndDate;
	}

}
