package backupcode;

import java.util.Scanner;

public class GamePanel {
public static void main(String[] args) {
	System.out.println("Welcome to Cascadia!");
	int x = 0;
	playing playing = new playing();
	Scanner in = new Scanner(System.in);
	System.out.println("Enter number of players");
	while(in.hasNext()) {
		if(in.hasNextInt()){
			x = in.nextInt();
			if(x < 2 || x > 4) {
				System.out.println("Invalid number of players\nPlease try again");
				in.nextLine();
			}
			else{
				break;
			}
		}
		else{
			System.out.println("Invalid input\nPlease try again");
			in.next();
		}
	}
	playing.setPlayerCount(x);
	playing.initializeGame();
	playing.playGame();

	 x = 0;
	 in.close();	
}
}
