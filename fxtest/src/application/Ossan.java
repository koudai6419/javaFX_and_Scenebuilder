package application;

class Ossan extends Character {
	public Ossan (int hp, int mp, String name) {
		super(hp, mp, name);
	}

	@Override
	public String introduce() {
		return "わたしはおっさん。　hp: "+hp+" mp:"+mp+" name: "+ name;
	}

}
