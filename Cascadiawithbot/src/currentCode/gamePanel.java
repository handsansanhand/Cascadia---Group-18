/*
Student Number - Name - Github ID
21467574 - Jack Wright - #102315833
21447182 - Jack Neilan - #102314039
21350866 - Trystan Rothery - #102313516
*/
package currentCode;

import java.util.Scanner;

//CLASS THAT CURRENTLY PLAYS THE GAME AND CALLS ALL THE FUNCTIONS FROM THE PLAYING CLASS
public class gamePanel {
public static void main(String[] args) throws InterruptedException {
	System.out.println(Tile.GREEN_BOLD + "Welcome to Cascadia!");
	System.out.println("The Rules: https://www.alderac.com/wp-content/uploads/2021/08/Cascadia-Rules.pdf" + Tile.RESET );
	int x = 0;
	gameState gameState = new gameState();
	Scanner in = new Scanner(System.in);
	System.out.println("Enter number of players: [2-4]");
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
	//ask if you want bot mode or normal mode?
	System.out.println("Press 1 for Bot Mode, Press 2 for Human Mode");
	int mode = 0;
	while(in.hasNext())
	{
		if(in.hasNextInt())
		{
			mode = in.nextInt();
			if(x != 1 && x != 2)
			{
				System.out.println("Invalid Input\nPlease try again");
				in.nextLine();
			}
			else {break;}
		} else {System.out.println("Invalid Input\nPlease try again");
			in.nextLine();}
	}
	gameState.setPlayerCount(x);
	gameState.initializeGame(mode);
	gameState.playGame();

	 x = 0;
	 in.close();	
}
}
