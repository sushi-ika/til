package com.example.di;

public class Car {
	
	Engine eng; //エンジン
	
	//コンストラクタでエンジンを決定
	public Car(Engine en) {
		this.eng = en;
	}
	
	//エンジンをかける
	public void engineStart() {
		eng.start();
	}
	
	public void engineStop() {
		eng.stop();
	}
}
