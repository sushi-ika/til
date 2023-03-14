package jp.co.nxs.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CharaForm {
	@NotBlank(message = "自分の名前を入力してください")
	private String myName;
	@NotNull(message = "自分のHPを入力してください")
	@Min(value = 1, message = "自分のHPに0以下の数値は入力できません")
	private Integer myHp;
	@NotNull(message = "自分のMPを入力してください")
	@Min(value = 1, message = "自分のMPに0以下の数値は入力できません")
	private Integer myMp;
	@NotBlank(message = "敵の名前を入力してください")
	private String enName;
	@NotNull(message = "敵のHPを入力してください")
	@Min(value = 1, message = "敵のHPに0以下の数値は入力できません")
	private Integer enHp;
	@NotNull(message = "敵のMPを入力してください")
	@Min(value = 1, message = "敵のHPに0以下の数値は入力できません")
	private Integer enMp;

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public Integer getMyHp() {
		return myHp;
	}

	public void setMyHp(Integer myHp) {
		this.myHp = myHp;
	}

	public Integer getMyMp() {
		return myMp;
	}

	public void setMyMp(Integer myMp) {
		this.myMp = myMp;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public Integer getEnHp() {
		return enHp;
	}

	public void setEnHp(Integer enHp) {
		this.enHp = enHp;
	}

	public Integer getEnMp() {
		return enMp;
	}

	public void setEnMp(Integer enMp) {
		this.enMp = enMp;
	}

}
