package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mvc.model.CalcModel;

@Controller
public class CalcController {
	// 電卓入力画面Get用コントローラ
	@GetMapping("/input")
	public String getCalc() {
		// 電卓入力画面に遷移
		return "calcInput";
	}

	//電卓入力画面POST用コントローラ
	@PostMapping("/output")
	public String postCalc() {
		//計算処理呼び出し
		double num = CalcModel.calc(1, 2, "×");
		System.out.println(num);
		return "calcOutput";
	}
}
