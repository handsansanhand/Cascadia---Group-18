package currentCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

//THIS CLASS ACTS AS LIKE A DUNGEON MASTER, WILL PROB MOSTLY BE REPLACED BY THE UI, KEEPS TRACK OF PLAYERCOUNT ALL THE PLAYERS,
//AND THE GAMEBOARD (THE BOARD IN THE MIDDLE OF THE TABLE WHICH IS SAME FOR EVERYONE)
public class gameState {
    Scanner in = new Scanner(System.in);

    public static int playerCount;
    static ArrayList<player> Players = new ArrayList<player>();
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

    public static ArrayList<player> getPlayers()
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
        //displayControls();
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
        int i=0;
        nextTurn(i);
    }
    public static void gameEnd(){
        if(getPlayers().get(0).turnCount >= 20 || getPlayers().get(1).turnCount >= 20 || getPlayers().get(2).turnCount >= 20 || getPlayers().get(3).turnCount >=20){
            System.out.println("Maximum turn count exceeded, Game should end");
        }
        switch(gameState.playerCount){
            case 2:
                if(Tile.count >= 37 ){
                    System.out.println("Out of tiles");
                    //System.exit(0);
                }
                break;
            case 3:
                if(Tile.count >= 54 ){
                    System.out.println("Out of tiles");
                    //System.exit(0);
                }
                break;
            case 4:
                if(Tile.count >= 71 ){
                    System.out.println("Out of tiles");
                    //System.exit(0);
                }
                break;
        }
    }

    public void startTurn(int i) {
        getPlayers().get(i).turnCount += 1; //variable incremented for each player when they have a turn. every player should have exactly 20 turns (from rulebook)
        boolean stillTurn = true;
        boolean stillTokenPlace = true;
        System.out.println(getPlayers().get(i).getPlayerBoard());
        printInstructions(i);
        gameBoard.checkForCull(getPlayers().get(i));
        while (stillTurn) {
            switch (in.next()) {
                case "0": {
                    Tile t = gameBoard.removeHabitatTile(0);
                    getPlayers().get(i).handTile = t;
                    wildlifeToken w = gameBoard.removeWildlifeToken(0);
                    getPlayers().get(i).addToken(w); //adds the token to your hand
                    placeTile(i, t);
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    stillTurn = false;
                    break;
                }
                case "1": {
                    Tile t = gameBoard.removeHabitatTile(1);
                    getPlayers().get(i).handTile = t;
                    wildlifeToken w = gameBoard.removeWildlifeToken(1);
                    getPlayers().get(i).addToken(w); //adds the token to your hand
                    placeTile(i, t);
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    stillTurn = false;
                    break;
                }
                case "2": {
                    Tile t = gameBoard.removeHabitatTile(2);
                    getPlayers().get(i).handTile = t;
                    wildlifeToken w = gameBoard.removeWildlifeToken(2);
                    getPlayers().get(i).addToken(w); //adds the token to your hand
                    placeTile(i, t);
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    stillTurn = false;
                    break;
                }
                case "3": {
                    Tile t = gameBoard.removeHabitatTile(3);
                    getPlayers().get(i).handTile = t;
                    wildlifeToken w = gameBoard.removeWildlifeToken(3);
                    getPlayers().get(i).addToken(w); //adds the token to your hand
                   placeTile(i, t);
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    stillTurn = false;
                    break;
                }
                case "c": {
                    printInstructions(i);
                    break;
                }
                case "s": {
                    if(getPlayers().get(i).natureTokens==0)
                    {
                        System.out.println("not enough nature tokens");
                        break;}
                    spendNatureToken(i);
                   printInstructions(i);
                    break;
                }
                case "v":
                {
                    System.out.println(getPlayers().get(i).getPlayerBoard().printUserBoard());
                    printInstructions(i);
                    break;
                }
                case "t": //temporary case that tests the scoring
                {
                 Scoring.scoreHabitatCorridors(getPlayers().get(i));
                 break;
                }
                case "r": //temporary case that tests the scoring
                {
                    System.out.println("Cascadia Rules: https://www.alderac.com/wp-content/uploads/2021/08/Cascadia-Rules.pdf");;
                    break;
                }
                default: {
                    System.out.println("Invalid argument, press 'c' for instructions or 'r' for the rules");
                    break;
                }
            }
        }
        if(getPlayers().get(i).hand.get(0)!=null) {
            while (stillTokenPlace) {
                System.out.println("Would you like to place a wildlife token? Y/N");
                System.out.println(getPlayers().get(i).printHand());
                switch (in.next()) {

                    case "y": {
                        placeWildlifeToken(getPlayers().get(i).hand.get(0), i);
                        i++;
                        nextTurn(i);
                        stillTokenPlace = false;
                        break;
                    }
                    case "n": {
                        gameBoard.wildlifeTokenBag.add(getPlayers().get(i).hand.remove(0)); //get the wt out of here
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
                        System.out.println("incorrect input");
                    }
                }
            }
        } else{
            i++;
            nextTurn(i);}
            if (i + 1 == playerCount) {
                i = 0;
            }
            nextTurn(i);
        }
        public void printInstructions(int player)
        {
            System.out.println("CURRENT TURN: " + currentCode.player.name);
            System.out.println("Press s to spend a nature token. NATURE TOKENS: " + getPlayers().get(player).natureTokens);
            System.out.println("Press v to view your board");
            System.out.println("Pick a habitat token and wildlife token from the board. [0-3]");
            System.out.println(gameBoard);
        }

        public void spendNatureToken(int currentPlayer)
        {
            boolean stillSpending=true;
            Scanner in = new Scanner(System.in);
            System.out.println(gameBoard);
            System.out.println("Press 1 to choose a wildlife token and habitat tile of your choosing");
            System.out.println("Press 2 to replace any number of wildlife tokens");
            while(stillSpending) {
                while(!in.hasNextInt())
                {
                    System.out.println("invalid input");
                    in.next();
                }
                switch (in.nextInt())
                {
                    case 1:
                    {
                        Tile t = gameBoard.chooseTile(getPlayers().get(currentPlayer));
                        getPlayers().get(currentPlayer).handTile = t;
                        wildlifeToken w = gameBoard.chooseToken(getPlayers().get(currentPlayer));
                        placeTile(currentPlayer, t);
                        System.out.println(getPlayers().get(currentPlayer).getPlayerBoard());
                        stillSpending=false;
                        return;
                    }
                    case 2:{
                        gameBoard.spendTokenWipingBoard(getPlayers().get(currentPlayer));
                        return;
                    }
                    default:{
                        System.out.println("invalid input");
                    }

                }
            }
        }

        public void placeWildlifeToken(wildlifeToken tokenToPlace, int i) {
            System.out.println(getPlayers().get(i).getPlayerBoard());
            System.out.println("Where would you like to place the token?"); //ask for the location (tile number)
            System.out.println("Token: " + tokenToPlace.colorToString());
            String input = in.next();
            String[] numbers = input.split(",");
            int x = Integer.parseInt(numbers[0].trim());
            int y = Integer.parseInt(numbers[1].trim());
            int attempts = 3;
            while (attempts > 0) {
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
                        gameBoard.checkForBonus(getPlayers().get(i).getPlayerBoard().TileBoard[x][y], tokenToPlace, getPlayers().get(i));
                        System.out.println("Token placed successfully!");
                        getPlayers().get(i).hand.remove(0);
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

    public void placeTile(int i, Tile t) {
        Tile refTile = null;
        System.out.println(getPlayers().get(i).getPlayerBoard());
        System.out.println("Pick a reference tile on the board: ");
        System.out.println("Your tile that will be placed: [" + getPlayers().get(i).getHandTile() +"]");
        System.out.println("Or press 6 to rotate your tile: ");
        while (true) {
            try {
                String input = in.next();
                if (input.equals("6")) {
                    Tile.rotateTile(t);
                    System.out.println("Your rotated tile: [" + t + "]");
                    System.out.println("Enter a reference tile on the board: ");
                    continue;
                }
                if (input.equals("v")) {
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    System.out.println("Pick a reference tile on the board: ");
                    System.out.println("Your tile that will be placed: [" + getPlayers().get(i).getHandTile() + "]");
                    System.out.println("Or press 6 to rotate your tile: ");
                    continue;
                }
                if (!input.contains(",")) {
                    System.out.println("Please enter two digits seperated by a comma.");
                    continue;
                }

                    String[] numbers = input.split(",");
                    int x = Integer.parseInt(numbers[0].trim());
                    int y = Integer.parseInt(numbers[1].trim());

                    if (x > tileBoard.BOARD_WIDTH - 1 || y > tileBoard.BOARD_HEIGHT - 1) {
                        System.out.println("Incorrect position");
                        continue; // continue loop if input is incorrect
                    }

                    refTile = getPlayers().get(i).getPlayerBoard().getTile(x, y);

                    if (refTile == null) {
                        System.out.println("That tile doesn't exist.");
                    } else if (refTile.up != null && refTile.down != null && refTile.left != null && refTile.right != null) {
                        System.out.println("Invalid placement.");
                    } else {
                        // check if its not null before printing
                        getPlayers().get(i).getPlayerBoard().addTile(refTile, t);
                        break; // exit loop if successful
                    }
                }
            catch(NumberFormatException e){
                    System.out.println("Invalid input. Please enter two numbers separated by a comma.");
                } catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("That position is outside of the allowed space.");
                    getPlayers().get(i).getPlayerBoard().addTile(refTile, t);
                    break;
                }
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
