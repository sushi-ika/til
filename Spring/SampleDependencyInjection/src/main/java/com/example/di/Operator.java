package com.example.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Operator {
	
	//インスタンスをフィールド変数で定義
	private static Gasoline gasoline;
	private static Hybrid hybrid;

	public static void main(String[] args) {
		//Spring Bootアプリケーションを起動
		SpringApplication.run(Operator.class, args);
		
		Engine gEngine = gasoline;
		Engine hEngine = hybrid;
		
		//ガソリン車を作成
		Car gCar = new Car(gEngine);
		//ハイブリッド車を作成
		Car hCar = new Car(hEngine);
		
		//エンジンをかける
		gCar.engineStart();
		hCar.engineStart();
		
		//エンジンを止める
		gCar.engineStop();
		hCar.engineStop();

	}
	
	@Autowired
	public void setEngine(Gasoline gasoline) {
		Operator.gasoline = gasoline;
	}
	
	@Autowired
	public void setEngine(Hybrid hybrid) {
		Operator.hybrid = hybrid;
	}
}
