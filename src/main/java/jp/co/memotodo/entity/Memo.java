package jp.co.memotodo.entity;

import java.util.Date;

public class Memo {
	private Integer memoId;
	private Integer userId;
	private String title;
	private Date createDate;
	private String categoryId;
	private String content;
	private String note;

	public Memo() {
	}
	public Memo(Integer memo, Integer user, String t, Date create, String cate, String c, String n) {
		memoId = memo;
		userId = user;
		title = t;
		createDate = create;
		categoryId = cate;
		content = c;
		note = n;
	}
	public Memo(Integer user, String t, Date create, String cate, String c, String n) {
		userId = user;
		title = t;
		createDate = create;
		categoryId = cate;
		content = c;
		note = n;
	}
	public Integer getMemoId() {
		return memoId;
	}
	public void setMemoId(Integer memoId) {
		this.memoId = memoId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
