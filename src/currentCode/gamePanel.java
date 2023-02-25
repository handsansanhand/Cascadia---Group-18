package currentCode;

import java.util.Scanner;

//CLASS THAT CURRENTLY PLAYS THE GAME AND CALLS ALL THE FUNCTIONS FROM THE PLAYING CLASS
public class gamePanel {
public static void main(String[] args) {
	System.out.println("Welcome to Cascadia!");
	int x = 0;
	gameState gameState = new gameState();
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
	gameState.setPlayerCount(x);
	gameState.initializeGame();
	gameState.playGame();

	 x = 0;
	 in.close();	
}
}
