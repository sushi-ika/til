package com.example.mvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.model.UserForm;
import com.example.mvc.model.UserService;

@Controller
public class UserController {
	@Autowired
	// usersデータベース操作クラス
	UserService userService;

	//ユーザー情報入力画面Get用
	@GetMapping("/user/input")
	public String getUser(@RequestParam(name = "user_id", defaultValue = "") String user_id,
			@ModelAttribute UserForm userForm,
			Model model) {
		//ユーザーIDが指定されている場合はデータを取得する
		if (!user_id.isEmpty()) {
			UserForm user = userService.searchUser(user_id);
			model.addAttribute("userForm", user);
		}
		//ユーザー情報入力画面に遷移
		return "userInput";
	}

	//ユーザー情報入力画面Post用
	@PostMapping("/user/input")
	public String postUser(@Validated @ModelAttribute UserForm userForm,
			BindingResult bindingResult,
			Model model) {
		//未入力の項目がある場合
		if (bindingResult.hasErrors()) {
			//入力画面に遷移する
			return "userInput";
		}
		//ユーザーIDが採番されていたら更新
		if (userForm.getUser_id().isEmpty()) {
			userService.registUser(userForm);
		} else {
			userService.updateUser(userForm);
		}
		//ユーザー一覧画面に遷移
		return "redirect:/user/list";
	}

	//ユーザー一覧検索
	@RequestMapping("user/list")
	public String searchList(@RequestParam(name = "search", defaultValue = "") String search, Model model) {
		//ユーザー一覧を検索
		List<Map<String, Object>> list = userService.searchList(search);
		//リクエストスコープに保存
		model.addAttribute("search", search);
		model.addAttribute("list", list);
		//ユーザー一覧画面に遷移
		return "userList";
	}
}
