package com.example.mvc.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	// ユーザー情報を登録する
	public int registUser(UserForm user) {
		// SQL文作成
		String sql = "INSERT INTO users (user_id, name, pass) VALUES (?, ?, ?)";
		// ？の箇所を置換するデータの配列を定義
		Object[] param = { user.getUser_id(), user.getName(), user.getPass() };
		//クエリを実行
		int result = jdbcTemplate.update(sql, param);
		//実行件数を返す
		return result;
	}

	//ユーザー情報を更新する
	public int updateUser(UserForm user) {
		//SQL文作成
		String sql = "UPDATE users SET name=? , pass=? WHERE user_id=?";
		//？の箇所を置換するデータの配列を定義
		Object[] param = { user.getName(), user.getPass(), user.getUser_id() };
		//クエリを実行
		int result = jdbcTemplate.update(sql, param);
		//実行件数を返す
		return result;
	}

	//特定ユーザーを検索する
	public Map<String, Object> searchUser(String search) {
		//SQL文作成
		String sql = "SELECT * FROM users WHERE user_id= ?";
		//？の箇所を置換するデータの配列を定義
		Object[] param = { search };
		//クエリを実行
		Map<String, Object> user = jdbcTemplate.queryForMap(sql, param);
		//取得したデータを返す
		return user;
	}

	//ユーザー情報を検索する
	public List<Map<String, Object>> searchList(String search) {
		//SQL文作成
		String sql = "SELECT * FROM users WHERE name LIKE ? ORDER BY id DESC";
		//？の箇所を置換するデータの配列を定義
		Object[] param = { "%" + search + "%" };
		//クエリを実行
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, param);
		//取得したリストを返す
		return list;
	}
}
