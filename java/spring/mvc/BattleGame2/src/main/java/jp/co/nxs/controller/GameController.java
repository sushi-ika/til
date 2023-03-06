package jp.co.nxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.nxs.model.Chara;

@Controller
public class GameController {

	@GetMapping("/input")
	public String input() {
		return "gameInput";
	}
	@PostMapping("/output")
	public String output(@RequestParam("myName") String myName,
						 @RequestParam("myHp") String myHp,
						 @RequestParam("myMp") String myMp,
						 @RequestParam("enName") String enName,
						 @RequestParam("enHp") String enHp,
						 @RequestParam("enMp") String enMp,
						 Model model) {
		//int型に変換する
		int iMyHp = Integer.parseInt(myHp);
		int iMyMp = Integer.parseInt(myMp);
		int iEnHp = Integer.parseInt(enHp);
		int iEnMp = Integer.parseInt(enMp);
		
		//キャラクター作成
		Chara myChara = new Chara(myName, iMyHp, iMyMp);
		Chara enChara = new Chara(enName, iEnHp, iEnMp);
		//対戦処理
		myChara.attack(enChara);
		enChara.attack(myChara);
		
		//リクエストスコープにキャラクター情報を保存
		model.addAttribute("myName", myChara.getName());
		model.addAttribute("myHp", myChara.getHp());
		model.addAttribute("myMp", myChara.getMp());
		model.addAttribute("enName", enChara.getName());
		model.addAttribute("enHp", enChara.getHp());
		model.addAttribute("enMp", enChara.getMp());
		
		//対戦結果画面に遷移
		return "gameOutput";
	}
}
