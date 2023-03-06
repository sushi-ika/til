package jp.co.nxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.nxs.model.Chara;

@Controller
public class GameController {

	@GetMapping("input")
	public String input() {
		return "gameInput";
	}
	@PostMapping("output")
	public String output() {
		//対戦処理
		Chara myChara = new Chara("エグチ", 100, 80);
		Chara enChara = new Chara("ミヨシ", 100, 80);
		myChara.attack(enChara);
		
		//対戦結果をコンソールで確認
		System.out.println("自分のHP：" + myChara.getHp() + "自分のMP：" + myChara.getMp());
		System.out.println("敵のHP：" + enChara.getHp() + "敵のMP：" + enChara.getMp());
		
		//対戦結果画面に遷移
		return "gameOutput";
	}
}

