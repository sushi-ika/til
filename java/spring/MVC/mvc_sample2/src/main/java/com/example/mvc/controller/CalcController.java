package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String postCalc(@RequestParam("param1") String num1,
						   @RequestParam("param2") String num2,
						   @RequestParam("param3") String operator,
						   Model model) {
		//計算用に型変換する
		double dnum1 = Double.valueOf(num1);
		double dnum2 = Double.valueOf(num2);
		//計算処理呼び出し
		double num = CalcModel.calc(dnum1, dnum2, operator);
		
		//リクエストスコープに保存
		model.addAttribute("key1", num1);
		model.addAttribute("key2", num2);
		model.addAttribute("key3", operator);
		model.addAttribute("result", num);
		return "calcOutput";
	}
}
