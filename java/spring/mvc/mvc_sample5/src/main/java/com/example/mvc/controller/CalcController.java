package com.example.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mvc.model.CalcForm;
import com.example.mvc.model.CalcModel;

@Controller
public class CalcController {
	@Autowired
	//セッションオブジェクト
	HttpSession session;
	// 電卓入力画面Get用コントローラ
	@GetMapping("/input")
	public String getCalc(@ModelAttribute CalcForm calcForm, Model model) {
		//セッションスコープに保持されていない場合
		if(null == session.getAttribute("count")) {
			//セッションスコープに初期値を保存
			session.setAttribute("count",1);
		}
		// 電卓入力画面に遷移
		return "calcInput";
	}
	//セッション削除用メソッド
	@GetMapping("/delete")
	public String delete() {
		//回数を削除
		session.removeAttribute("count");
		return "redirect:/input";
	}
	

	//電卓入力画面POST用コントローラ
	@PostMapping("/input")
	public String postCalc(@Validated @ModelAttribute CalcForm calcForm,
						   BindingResult bindingResult,
						   Model model,
						   RedirectAttributes attr) {
		
		//Formオブジェクトから各項目を取得
		String num1 = calcForm.getParam1();
		String num2 = calcForm.getParam2();
		String operator = calcForm.getParam3();
		
		//未入力の項目がある場合
		if(bindingResult.hasErrors()) {
			return "calcInput";
		}
		//計算用に型変換する
		double dnum1 = Double.valueOf(num1);
		double dnum2 = Double.valueOf(num2);
		//計算処理呼び出し
		double num = CalcModel.calc(dnum1, dnum2, operator);
		
		//リクエストスコープに保存
		attr.addFlashAttribute("key1", num1);
		attr.addFlashAttribute("key2", num2);
		attr.addFlashAttribute("key3", operator);
		attr.addFlashAttribute("result", num);
		
		//計算した回数をインクリメントして更新
		int cnt = (Integer)session.getAttribute("count");
		cnt += 1;
		session.setAttribute("count", cnt);
		
		return "redirect:/output";
	}
	//電卓出力画面に遷移
	@GetMapping("/output")
	public String output() {
		return "calcOutput";
	}
}
