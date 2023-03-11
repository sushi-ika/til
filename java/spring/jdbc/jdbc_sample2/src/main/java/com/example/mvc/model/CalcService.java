package com.example.mvc.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcService {
	@Autowired
	CalcDao calcDao;

	// 計算結果を登録する
	public int registCalc(String text) {
		int result = calcDao.registCalc(text);
		return result;
	}
	// 計算履歴を検索する
	public List<Map<String, Object>> searchHistory(String search) {
	List<Map<String, Object>> list = calcDao.searchHistory(search);
	return list;
	}
}
