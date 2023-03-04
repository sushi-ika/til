package com.example.mvc.model;

public class CalcModel {
	//2つの数値と演算子を引数で受け取り、計算結果を返すメソッド
	public static double calc(double x, double y, String operator) {
		//計算結果を格納する変数
		double result = 0.0;
		//演算子により計算結果を分岐
		switch (operator) {
		case "+":
			result = x + y;
			break;
		case "-":
			result = x - y;
			break;
		case "×":
			result = x * y;
			break;
		case "÷":
			result = x / y;
			break;
		}
		//計算結果を返す
		return result;
	}
}
