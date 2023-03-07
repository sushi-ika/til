package jp.co.nxs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.nxs.model.Chara;

@Controller
public class GameController {
	@Autowired
	//セッションオブジェクト
	HttpSession session;

	@GetMapping("/input")
	public String input() {
		//セッションスコープに初期値を保存
		session.setAttribute("count",1);
			
		return "gameInput";
	}
	@PostMapping("/output")
	public String output(@RequestParam("myName") String myName,
						 @RequestParam("myHp") String myHp,
						 @RequestParam("myMp") String myMp,
						 @RequestParam("enName") String enName,
						 @RequestParam("enHp") String enHp,
						 @RequestParam("enMp") String enMp,
						 Model model,
						 RedirectAttributes attr) {
		
		//フラッシュスコープに入力項目を保存
		attr.addFlashAttribute("myName", myName);
		attr.addFlashAttribute("myHp", myHp);
		attr.addFlashAttribute("myMp", myMp);
		attr.addFlashAttribute("enName", enName);
		attr.addFlashAttribute("enHp", enHp);
		attr.addFlashAttribute("enMp", enMp);
		
		//未入力の項目がある場合
		if(myName.isEmpty() || myHp.isEmpty() || myMp.isEmpty() || enName.isEmpty() || enHp.isEmpty() || enMp.isEmpty()) {
			//フラッシュスコープにメッセージを保存
			attr.addFlashAttribute("message", "未入力の項目があります");

			//入力画面にリダイレクト
			return "redirect:/input";
		}
		
		//int型に変換する
		int iMyHp = Integer.parseInt(myHp);
		int iMyMp = Integer.parseInt(myMp);
		int iEnHp = Integer.parseInt(enHp);
		int iEnMp = Integer.parseInt(enMp);
		
		//HP,MPが0以下の場合
		if(iMyHp <= 0 || iMyMp <= 0 || iEnHp <= 0 || iEnMp <= 0) {
			//フラッシュスコープにメッセージを保存
			attr.addFlashAttribute("message", "0以下の数値は入力できません");
			
			//入力画面にリダイレクト
			return "redirect:/input";
		}
		//キャラクター作成
		Chara myChara = new Chara(myName, iMyHp, iMyMp);
		Chara enChara = new Chara(enName, iEnHp, iEnMp);
		//対戦処理
		myChara.attack(enChara);
		enChara.attack(myChara);
		
		//勝敗判定
		String winner = "";
		if(myChara.getHp() <= 0 && enChara.getHp() <= 0) {
			winner = "引き分け";
		}else if(enChara.getHp() <= 0) {
			winner = (String)myChara.getName() + "の勝ち";
		}else if(myChara.getHp() <= 0) {
			winner = (String)enChara.getName() + "の勝ち";
		}
		
		//ターン数をインクリメントして更新
		int cnt = (Integer)session.getAttribute("count");
		cnt += 1;
		session.setAttribute("count", cnt);
		
		//リクエストスコープにキャラクター情報と勝敗を保存
		model.addAttribute("myName", myChara.getName());
		model.addAttribute("myHp", myChara.getHp());
		model.addAttribute("myMp", myChara.getMp());
		model.addAttribute("enName", enChara.getName());
		model.addAttribute("enHp", enChara.getHp());
		model.addAttribute("enMp", enChara.getMp());
		model.addAttribute("winner", winner);
		
		//画面遷移の判定処理
		if(winner == "") {
			return "gameOutput";
		}else {
			return result();
		}
	}
	@GetMapping("/result")
	public String result() {
		return "gameResult";
	}
}
	
