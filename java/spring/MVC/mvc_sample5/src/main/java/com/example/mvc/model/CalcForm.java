package com.example.mvc.model;

import javax.validation.constraints.NotBlank;


public class CalcForm {
	@NotBlank(message="1つ目の数値を入力してください")
	private String param1; //1つ目の数値
	@NotBlank(message="2つ目の数値を入力してください")
	private String param2; //2つ目の数値
	private String param3; //演算子
	
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getParam3() {
		return param3;
	}
	public void setParam3(String param3) {
		this.param3 = param3;
	}

}
