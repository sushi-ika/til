package jp.co.nxs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.nxs.model.Chara;
import jp.co.nxs.model.CharaForm;

@Controller
public class GameController {
	@Autowired
	//セッションオブジェクト
	HttpSession session;

	@GetMapping("/input")
	public String input(@ModelAttribute CharaForm charaForm, Model model) {
		//セッションスコープに初期値を保存
		session.setAttribute("count",1);

		return "gameInput";
	}
	@PostMapping("/input")
	public String input(@Validated @ModelAttribute CharaForm charaForm,
						 BindingResult bindingResult,
						 Model model,
						 RedirectAttributes attr) {
		
		//Formオブジェクトから各項目を取得
		String myName = charaForm.getMyName();
		Integer myHp = charaForm.getMyHp();
		Integer myMp = charaForm.getMyMp();
		String enName = charaForm.getEnName();
		Integer enHp = charaForm.getEnHp();
		Integer enMp = charaForm.getEnMp();

		//バリデーションエラーがある場合
		if(bindingResult.hasErrors()) {
			//入力画面にリダイレクト
			return "gameInput";
		}

		//キャラクター作成
		Chara myChara = new Chara(myName, myHp, myMp);
		Chara enChara = new Chara(enName, enHp, enMp);
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
		
		//フラッシュスコープにキャラクター情報と勝敗を保存
		attr.addFlashAttribute("myName", myChara.getName());
		attr.addFlashAttribute("myHp", myChara.getHp());
		attr.addFlashAttribute("myMp", myChara.getMp());
		attr.addFlashAttribute("enName", enChara.getName());
		attr.addFlashAttribute("enHp", enChara.getHp());
		attr.addFlashAttribute("enMp", enChara.getMp());
		attr.addFlashAttribute("winner", winner);
		
		//画面遷移の判定処理
		if(winner == "") {
			return "redirect:/output";
		}else {
			return "redirect:/result";
		}
	}
	@GetMapping("/output")
	public String output() {
		return "gameOutput";
	}
	@GetMapping("/result")
	public String result() {
		return "gameResult";
	}
}
	


