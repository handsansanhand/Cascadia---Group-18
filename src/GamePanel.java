import java.util.Scanner;

import Player.player;

public class GamePanel {
public static void main(String[] args) {
	player player = new player();
	Scanner in = new Scanner(System.in);
	System.out.println("enter number of players");
	int x = in.nextInt();
	if(x <2 || x>4) {
		throw new IllegalArgumentException("invalid nuber of players");
	}
	player.setPlayerCount(x);
	 x = 0;

	 
	 
	 
	 
	 in.close();	
}
}
