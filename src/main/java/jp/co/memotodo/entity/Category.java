package jp.co.memotodo.entity;

public class Category {
	private String categoryId;
	private String categoryName;
	private String note;

	public Category() {

	}
	public Category(String id, String name, String n) {
		categoryId = id;
		categoryName = name;
		note = n;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
