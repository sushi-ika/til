package com.example.di;

import org.springframework.stereotype.Component;

@Component
public class Gasoline implements Engine {

	@Override
	public void start() {
		System.out.println("ガソリンエンジン起動");

	}

	@Override
	public void stop() {
		System.out.println("ガソリンエンジン停止");

	}

}
