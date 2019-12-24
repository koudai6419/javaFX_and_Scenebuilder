package application;

public class Magician extends Character {
	public Magician(int hp, int mp, String name) {
		super(hp, mp, name);
	}
	@Override
	public String introduce() {
		return "私は魔術師。　hp: "+hp+" mp:"+mp+" name: "+ name;
	}

	public String attack(Character target) {
		return magic(target);
	}

	public String magic(Character target) {
		target.damage(mp/2);
		mp/=2;
		return name+"のMP攻撃！";
	}
}
