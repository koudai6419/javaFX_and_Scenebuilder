package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;


public class RPGController {
	@FXML private Button hogebutton;
	@FXML private Label hogeLabel;
	@FXML private Label messageLabel;
	@FXML private TextField nameField;

	@FXML private void onClicked() {
		String s = nameField.getText();
		hogeLabel.setText(s);
	}

	int x;
	int teamAHp;
	int teamBHp;
	boolean isEnded;

	Character[] teamA;
	Character[] teamB;

	public RPGController() {
		teamA = new Character[2];
		teamA[0] = new Character(100, 50 ,"勇者");
		teamA[1] = new Magician(50, 100 ,"魔法使い");

		teamB = new Character[2];
		teamB[0] = new Ossan(70, 30 ,"おっさん");
		teamB[1] = new Obasan(60, 30 ,"おばさん");

		x = 0;

		isEnded = false;

		Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
//			@Override
			public void handle(ActionEvent event) {
//				System.out.println("timer");
				if(isEnded)return;
				String message="";
				x++;
				int i = x%teamA.length;
				int j = (x/teamA.length)%2;

				messageLabel.setText("");
				if(j==0) {
					message = teamA[i].introduce();
					messageLabel.setText(messageLabel.getText()+message);

					message = teamA[i].attack(teamB[(int)(Math.random()*teamB.length)]);
					messageLabel.setText(messageLabel.getText()+message);

					teamAHp+=teamA[i].getHp();
				}else {
					message = teamB[i].introduce();
					messageLabel.setText(messageLabel.getText()+message);

					message = teamB[i].attack(teamA[(int)(Math.random()*teamA.length)]);
					messageLabel.setText(messageLabel.getText()+message);

					teamBHp+=teamB[i].getHp();
				}
				teamAHp=0;
				teamBHp=0;
				for(int k=0;k<teamA.length;k++) {
					teamAHp+=teamA[k].getHp();
				}
				for(int k=0;k<teamB.length;k++) {
					teamBHp+=teamB[k].getHp();
				}
				if(teamAHp<=0) {
					messageLabel.setText(messageLabel.getText()+"魔王たちの勝利だ！");
					isEnded = true;
				}
				if(teamBHp<=0) {
					messageLabel.setText(messageLabel.getText()+"勇者たちの勝利だ！");
					isEnded = true;
				}
			}
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}
}
/*java.util.Random r = new java.util.Random();
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
}*/