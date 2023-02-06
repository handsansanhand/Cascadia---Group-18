import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class playing {
    Scanner in = new Scanner(System.in);

    int playerCount;
    ArrayList<player> Players = new ArrayList<player>();
    gameBoard gameBoard = new gameBoard();

    public int getPlayerCount() {
        return this.playerCount;
    }


    public void addPlayer(String g) {
        player newplayer = new player(g);
        Players.add(newplayer);
    }

    public void setPlayerCount(int x) {
        // TODO Auto-generated method stub
        this.playerCount = x;
    }

    public ArrayList<player> getPlayers()
    {
        return Players;
    }

    public void initializeGame() //function that receives the playernames and randomizes the order in which they play
    {
        for(int i=1;i<=getPlayerCount();i++)
        {
            System.out.println("Enter player " + i + "'s Name: ");
            addPlayer(in.next());
        }
        Collections.shuffle(getPlayers()); //randomise the arraylist of names
        System.out.println("Order: "); //will be a neater/more appealing way of doing this
        for(int j=0;j<getPlayerCount();j++)
        {
            System.out.println(Players.get(j).getName());
        }
        //display the instructions
        displayControls();
        //player one will start
        System.out.println(getPlayers().get(0).getName() + " will start");
    }

    public void nextTurn(int i) //a small function that just prints these out for now, will be changed
    {
        if(i>=playerCount)
        {
            i=0;
            System.out.println(getPlayers().get(i).getName() + "'s turn!");

        }
        else {
            System.out.println(getPlayers().get(i).getName() + "'s turn!");
        }
    }

    public void playGame()
    {
        boolean stillPlaying=true; //bool to check if the game is still being played
        int i=0;
        nextTurn(i);
        i++;
        while(stillPlaying)	//the instructions for playing the game will prob go here
        {
            switch (in.next()) {
                case "n" -> {
                    nextTurn(i);
                    if (i + 1 == playerCount) {
                        i = 0;
                    } else {
                        i++;
                    }
                }
                case "c" -> {
                    displayControls();
                }
                case "b" -> {
                    System.out.println(gameBoard);
                }
                case "q" -> {
                    System.out.println("ty for playing");
                    stillPlaying = false;
                }
            }

        }
    }

    public void displayControls()
    {
        System.out.println("Press 'n' to pass"); //this should pop ur board up
        System.out.println("Press 'c' for controls");
        System.out.println("Press 'q' to quit the game");
        System.out.println("Press 'b' to view the game board");
        System.out.println("Press 'r' for the rules of the game"); //to display the instructions of the game ??
    }
}
