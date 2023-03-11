package com.example.mvc.model;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CalcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	// 計算結果を登録する
	public int registCalc(String text) {
		// 現在の日時を取得（DB登録するにはSQLで扱うDate型に変換する必要があります）
		Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		// SQL文作成
		String sql = "INSERT INTO histories (text, regist_date) VALUES (?, ?)";
		// ？の箇所を置換するデータの配列を定義
		Object[] param = { text, date };
		// クエリを実行
		int result = jdbcTemplate.update(sql, param);
		// 実行件数を返す
		return result;
	}
}
