package com.example.mvc.model;

import javax.validation.constraints.NotBlank;

public class UserForm {
	private String user_id; // ユーザーID
	@NotBlank(message = "名前を入力してください")
	private String name; // 名前
	@NotBlank(message = "パスワードを入力してください")
	private String pass; // パスワード

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
