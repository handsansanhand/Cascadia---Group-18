import java.util.Scanner;

import Player.player;

public class GamePanel {
public static void main(String[] args) {
	int x = 0;
	player player = new player();
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

	player.setPlayerCount(x);
	player.initializeGame();
	 x = 0;
	 in.close();	
}
}
