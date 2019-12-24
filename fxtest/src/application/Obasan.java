package application;

public class Obasan extends Character {
	public Obasan(int hp, int mp, String name) {
		super(hp, mp, name);
	}

	@Override
	public String introduce() {
		return "わたしはおばさん。　hp: "+hp+" mp:"+mp+" name: "+ name;
	}
}
