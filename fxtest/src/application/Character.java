package application;

public class Character {
	protected int hp;
	protected int mp;
	protected String name;

//	コンストラクタ
	public Character(int hp, int mp, String name){
		this.hp = hp;
		this.mp = mp;
		this.name = name;
	}

//	インスタンスメソッド
	public String introduce() {
		return "私は勇者。　hp: "+hp+" mp:"+mp+" name: "+ name;
	}

	public String attack(Character target) {
		target.damage(30);
		return name+"の攻撃！";
	}

	public void damage(int atk) {
		this.hp-=atk;
		System.out.println(name+"は攻撃された! HP:"+hp);
	}

	public boolean isDead() {
		return hp<=0;
	}

	public int getHp() {
		return hp;
	}
}
