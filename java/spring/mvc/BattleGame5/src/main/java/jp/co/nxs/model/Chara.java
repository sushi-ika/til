package jp.co.nxs.model;

public class Chara {
	private String name;
	private int hp;
	private int mp;
	private int damage;
	
	public Chara(String name, int hp, int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.damage = (int)(hp * 0.3 + mp * 0.3);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void attack(Chara chara) {
		//HP、MPが0以下の場合は0にする。
		int consumedMp = (int)(this.damage * 0.1);
		this.mp = Math.max(this.mp - consumedMp, 0);
		chara.setHp(Math.max(chara.getHp() - this.damage, 0));	
	}
}
