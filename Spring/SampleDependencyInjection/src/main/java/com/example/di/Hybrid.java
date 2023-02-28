package com.example.di;

import org.springframework.stereotype.Component;

@Component
public class Hybrid implements Engine {

	@Override
	public void start() {
		System.out.println("ハイブリッドエンジン起動");

	}

	@Override
	public void stop() {
		System.out.println("ハイブリッドエンジン停止");

	}

}
