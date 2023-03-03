package currentCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//THIS CLASS ACTS AS LIKE A DUNGEON MASTER, WILL PROB MOSTLY BE REPLACED BY THE UI, KEEPS TRACK OF PLAYERCOUNT ALL THE PLAYERS,
//AND THE GAMEBOARD (THE BOARD IN THE MIDDLE OF THE TABLE WHICH IS SAME FOR EVERYONE)
public class gameState {
    Scanner in = new Scanner(System.in);

    public static int playerCount;
    ArrayList<player> Players = new ArrayList<player>();
    gameBoard gameBoard = new gameBoard();

    public int getPlayerCount() {
        return playerCount;
    }


    public void addPlayer(String g, int i) {
        player newplayer = new player(g, i);
        Players.add(newplayer);
    }

    public void setPlayerCount(int x) {
        // TODO Auto-generated method stub
        playerCount = x;
    }

    public ArrayList<player> getPlayers()
    {
        return Players;
    }


    public void initializeGame() //function that receives the playernames and randomizes the order in which they play
    {
        ArrayList<String> playersArrayList = new ArrayList<>();
        ArrayList<Integer> intArrayList = new ArrayList<>(); //for replacement
        for(int i=1;i<=getPlayerCount();i++)
        {
            System.out.println("Enter player " + i + "'s Name: ");
            playersArrayList.add(in.next());
            //addPlayer(in.next(), (int) (Math.round(Math.random())*getPlayerCount()));
        }
        for(int j=0;j<getPlayerCount();j++)
        {
            intArrayList.add(j);
        }
        Collections.shuffle(playersArrayList);
        Collections.shuffle(intArrayList);
        for(int j=0;j<getPlayerCount();j++) //initialize the players with random numbers
        {
            addPlayer(playersArrayList.get(j),intArrayList.get(j));
        }
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
            startTurn(i); //asks the user to draw a tile
            System.out.println("\n" + getPlayers().get(i).getPlayerBoard());
            displayControls();
        }
        else {
            System.out.println(getPlayers().get(i).getName() + "'s turn!");
            startTurn(i); //asks the user to draw a tile
            System.out.println("\n" + getPlayers().get(i).getPlayerBoard());
            displayControls();
        }
    }

    public void playGame()
    {
        boolean stillPlaying=true; //bool to check if the game is still being played
        int i=0;
        nextTurn(i);
        i++;
        while(stillPlaying)	//still playing = still playing the game
        {
            switch (in.next()) {
                case "v" -> {
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                }
                case "p" -> {
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
                case "y" -> {
                    //tile placement goes here
                }
            }

        }
    }

    public void startTurn(int i) {
        boolean stillTurn = true;
        boolean stillTokenPlace = true;
        System.out.println(gameBoard);
        gameBoard.checkForCull();
        System.out.println("Pick a habitat token and wildlife token from the board. [0-4]");
        while (stillTurn) {
            switch (in.next()) {
                case "0": {
                    Tile t = gameBoard.removeHabitatTile(0);
                    wildlifeToken w = gameBoard.removeWildlifeToken(0);
                    getPlayers().get(i).addToken(w); //adds the token to your hand
                    placeTile(i, t);
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    stillTurn = false;
                    break;
                }
                case "1": {
                    Tile t = gameBoard.removeHabitatTile(1);
                    wildlifeToken w = gameBoard.removeWildlifeToken(1);
                    getPlayers().get(i).addToken(w); //adds the token to your hand
                    placeTile(i, t);
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    stillTurn = false;
                    break;
                }
                case "2": {
                    Tile t = gameBoard.removeHabitatTile(2);
                    wildlifeToken w = gameBoard.removeWildlifeToken(2);
                    getPlayers().get(i).addToken(w); //adds the token to your hand
                    placeTile(i, t);
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    stillTurn = false;
                    break;
                }
                case "3": {
                    Tile t = gameBoard.removeHabitatTile(3);
                    wildlifeToken w = gameBoard.removeWildlifeToken(3);
                    getPlayers().get(i).addToken(w); //adds the token to your hand
                    placeTile(i, t);
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    stillTurn = false;
                    break;
                }
                case "c": {
                    displayControls();
                    System.out.println("\nPick a habitat token and wildlife token from the board. [0-4]");
                    System.out.println(gameBoard);
                    break;
                }
                default: {
                    break;
                }
            }
        }
            System.out.println("Would you like to place a wildlife token? Y/N");
            switch (in.next()) {
                case "y": {
                   placeToken(i);
                    i++;
                    nextTurn(i);
                    stillTokenPlace = false;
                    break;
                }
                case "n": {
                    i++;
                    nextTurn(i);
                    stillTokenPlace = false;
                    break;
                }
                case "c": {
                    displayControls();
                    System.out.println("\nWould you like to place a wildlife token?. [0-4]");
                    System.out.println(gameBoard);
                    break;
                }
                default: {
                    break;
                }
            }
            if (i + 1 == playerCount) {
                i = 0;
            }
            nextTurn(i);
        }



    public void placeToken(int i)   //placing wildlife tokens
    {
        System.out.println("What token would you like to place?");  //asks the user what token they wanna place
        System.out.println(getPlayers().get(i).printHand());
        int inputToken = Integer.parseInt(in.next());
        wildlifeToken tokenToPlace = getPlayers().get(i).hand.get(inputToken);

        System.out.println(getPlayers().get(i).getPlayerBoard());
        System.out.println("Where would you like to place the token?"); //ask for the location (tile number)
        System.out.println("Token: " + tokenToPlace);
        String input = in.next();
        String[] numbers = input.split(",");

        int x = Integer.parseInt(numbers[0].trim());
        int y = Integer.parseInt(numbers[1].trim());
        int attempts=3;
        while (attempts>0) {
            try {
                if (y > getPlayers().get(i).getPlayerBoard().TileBoard.length || x > getPlayers().get(i).getPlayerBoard().TileBoard[0].length) {
                    System.out.println("incorrect position");
                    System.out.println("This tile is null");
                    input = in.next();
                    numbers = input.split(",");
                    x = Integer.parseInt(numbers[0].trim());
                    y = Integer.parseInt(numbers[1].trim());
                    continue;
                }
                // Check if TileBoard[x][y] is null
                if (getPlayers().get(i).getPlayerBoard().TileBoard[x][y] == null) {
                    System.out.println("This tile is null");
                    input = in.next();
                    numbers = input.split(",");
                    x = Integer.parseInt(numbers[0].trim());
                    y = Integer.parseInt(numbers[1].trim());
                    continue;
                }

               getPlayers().get(i).getPlayerBoard().TileBoard[x][y].addWildlifetoken(tokenToPlace);

                if (getPlayers().get(i).getPlayerBoard().TileBoard[x][y].getToken() == tokenToPlace) //you can place a token
                {

                    System.out.println("Token placed successfully!");
                    getPlayers().get(i).hand.remove(inputToken);
                    break;
                } else {
                    System.out.println("Unable to place token.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Incorrect position, please try again.");
                attempts--;
                input = in.next();
                numbers = input.split(",");
                x = Integer.parseInt(numbers[0].trim());
                y = Integer.parseInt(numbers[1].trim());
            }
        }
    }



    public void placeTile(int i, Tile t)
    {
        System.out.println(getPlayers().get(i).getPlayerBoard());
        System.out.println("Where would you like to place the tile? [X,Y]");
        String input = in.next();
        String[] numbers = input.split(",");
        int x = Integer.parseInt(numbers[0].trim());
        int y = Integer.parseInt(numbers[1].trim());
       /* if (input > getPlayers().get(i).getPlayerBoard().TileList.size()) {
            System.out.println("Incorrect position");
        } else //place tile*/
        {
            //getPlayers().get(i).getPlayerBoard().addTile(x,y,t);
        }
    }

    public void displayControls()
    {
        System.out.println("Press v to view your board"); //this should pop ur board up
        System.out.println("Press 'p' to pass");
        System.out.println("Press 'c' for controls");
        System.out.println("Press 'b' to view the game board");
        System.out.println("Press 'r' for the rules of the game"); //to display the instructions of the game ?? maybe a html
    }
}