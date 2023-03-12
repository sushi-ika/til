package com.example.mvc.model;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	// ユーザー情報を登録する
	public int registUser(UserForm user) {
		// ユーザーIDをランダムで生成する
		String user_id = RandomStringUtils.randomAlphabetic(10);
		user.setUser_id(user_id);
		int result = userDao.registUser(user);
		return result;
	}

	//ユーザー情報を更新する
	public int updateUser(UserForm user) {
		int result = userDao.updateUser(user);
		return result;
	}

	//特定ユーザーを検索する
	public UserForm searchUser(String search) {
		//指定したユーザーIDのデータを1件取得
		Map<String, Object> map = userDao.searchUser(search);
		//Mapオブジェクトの中身をUserFormに詰め替える
		UserForm user = new UserForm();
		user.setUser_id(String.valueOf(map.get("user_id")));
		user.setName(String.valueOf(map.get("name")));
		user.setPass(String.valueOf(map.get("pass")));
		return user;
	}

	//ユーザー情報を検索する
	public List<Map<String, Object>> searchList(String search) {
		//検索条件に合致するデータを取得
		List<Map<String, Object>> list = userDao.searchList(search);
		return list;
	}
}