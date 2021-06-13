package jp.co.memotodo.controller.form;

import javax.validation.constraints.NotBlank;

//import org.springframework.format.annotation.DateTimeFormat;

public class AddForm {
	@NotBlank(message = "タスクは必須です")
	private String task;
	private String place;
	private String categoryId;
	private String note;
	private String enddate;
	private String startdate;

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

}
