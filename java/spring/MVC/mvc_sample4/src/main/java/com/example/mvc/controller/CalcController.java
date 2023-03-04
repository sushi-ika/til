package com.example.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mvc.model.CalcModel;

import jakarta.servlet.http.HttpSession;

@Controller
public class CalcController {
	@Autowired
	//セッションオブジェクト
	HttpSession session;
	// 電卓入力画面Get用コントローラ
	@GetMapping("/input")
	public String getCalc() {
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
	@PostMapping("/output")
	public String postCalc(@RequestParam("param1") String num1,
						   @RequestParam("param2") String num2,
						   @RequestParam("param3") String operator,
						   Model model,
						   RedirectAttributes attr) {
		
		//未入力の項目がある場合
		if(num1.isEmpty() || num2.isEmpty()) {
			//フラッシュスコープに入力項目とメッセージを保存
			attr.addFlashAttribute("message", "未入力の項目があります");
			attr.addFlashAttribute("param1", num1);
			attr.addFlashAttribute("param2", num2);
			attr.addFlashAttribute("param3", operator);
			
			//入力画面にリダイレクト
			return "redirect:/input";
			
		}
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
		
		//計算した回数をインクリメントして更新
		int cnt = (Integer)session.getAttribute("count");
		cnt += 1;
		session.setAttribute("count", cnt);
		
		return "calcOutput";
	}
}
