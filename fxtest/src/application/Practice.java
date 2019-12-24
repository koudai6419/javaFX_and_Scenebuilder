package application;

public class Practice {
	public static void main (String[] args) {
		System.out.println("RPG開始");
		Character[][] characters= new Character[2][3];
		characters[0][0] = new Character(100, 50 ,"勇者");
		characters[0][1] = new Magician(50, 100 ,"魔法使い");
		characters[1][0] = new Ossan(70, 30 ,"おっさん");
		characters[1][1] = new Obasan(60, 30 ,"おばさん");

		java.util.Random r = new java.util.Random();
		boolean isFinished = false;
		int turn =0;
		while(!isFinished) {
			Character player, enemy;
			do {
				player = characters[turn%2][r.nextInt(2)];
				enemy = characters[(turn%2-1)*-1][r.nextInt(2)];
			}while(player.isDead() || enemy.isDead());
			player.attack(enemy);

			boolean temp=true;
			for(int i=0;i<2;i++) {
				if(!characters[0][i].isDead()) temp=false;
			}
			if(temp) {
				System.out.println("敵の勝ち");
				isFinished=true;
			}
			temp=true;
			for(int i=0;i<2;i++) {
				if(!characters[1][i].isDead()) temp=false;
			}
			if(temp) {
				System.out.println("味方の勝ち");
				isFinished=true;
			}
			System.out.println("=========="+turn+"ターン==========");
			turn++;
		}
	}
}