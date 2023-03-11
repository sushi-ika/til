package com.example.mvc.model;

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
}
