package currentCode;

import java.util.ArrayList;
import java.util.Collections;
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
        printInstructions(i);
        gameBoard.checkForCull();
        System.out.println(getPlayers().get(i).name + "'s turn!");
        while (stillTurn) {
            switch (in.next()) {
                case "0": {
                    Tile t = gameBoard.removeHabitatTile(0);
                    getPlayers().get(i).handTile = t;
                    wildlifeToken w = gameBoard.removeWildlifeToken(0);
                    getPlayers().get(i).addToken(w); //adds the token to your hand
                    placeTile(i, t);
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    Scoring.countHabitatOccurences(habitatEnum.Forest, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Mountain, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.River, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Prairie, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Wetland, getPlayers().get(i));
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
                    Scoring.countHabitatOccurences(habitatEnum.Forest, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Mountain, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.River, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Prairie, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Wetland, getPlayers().get(i));
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
                    Scoring.countHabitatOccurences(habitatEnum.Forest, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Mountain, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.River, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Prairie, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Wetland, getPlayers().get(i));
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
                    Scoring.countHabitatOccurences(habitatEnum.Forest, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Mountain, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.River, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Prairie, getPlayers().get(i));
                    Scoring.countHabitatOccurences(habitatEnum.Wetland, getPlayers().get(i));
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
                case "h":
                {
                    System.out.println(getPlayers().get(i).printHand());
                    break;
                }
                case "t": //temporary case that tests the scoring
                {
                 Scoring.scoreHabitatCorridors(getPlayers().get(i));
                 break;
                }
                default: {
                    System.out.println("Invalid argument, press 'c' for instructions");
                    break;
                }
            }
        }
        if(!getPlayers().get(i).hand.isEmpty()) {
            while (stillTokenPlace) {
                System.out.println("Would you like to place a wildlife token? Y/N");
                System.out.println(getPlayers().get(i).printHand());
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
            System.out.println("CURRENT TURN: " + getPlayers().get(player).name);
            System.out.println("Press s to spend a nature token. NATURE TOKENS: " + getPlayers().get(player).natureTokens);
            System.out.println("Press v to view your board");
            System.out.println("Press h to see your hand");
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
                        System.out.println("New Board is:");
                        return;
                    }
                    default:{
                        System.out.println("invalid input");
                    }

                }
            }
        }

        public void placeWildlifeToken(wildlifeToken tokenToPlace, int i, int inputToken) {
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

    public void placeToken(int i)   //placing wildlife tokens
    {
        int input;
        System.out.println("What token would you like to place?");  //asks the user what token they wanna place
        System.out.println(getPlayers().get(i).printHand());
        Scanner in = new Scanner(System.in);
        while(!in.hasNextInt()){

            System.out.println("incorrect input please try again\n");
            in.next();
        }
        input = in.nextInt();
        while(input > getPlayers().get(i).hand.size() || input < 0){
            System.out.println("incorrect input please try again\n");
            input = Integer.parseInt(in.next());
        }
        wildlifeToken tokenToPlace = getPlayers().get(i).hand.get(input);
        placeWildlifeToken(tokenToPlace, i, input);
    }



    public void placeTile(int i, Tile t) {
        System.out.println(getPlayers().get(i).getPlayerBoard());
        System.out.println("Pick a reference tile on the board: ");
        System.out.println("Your tile that will be placed: [" + getPlayers().get(i).getHandTile() +"]");
        String input = in.next();
        String[] numbers = input.split(",");
        int x = Integer.parseInt(numbers[0].trim());
        int y = Integer.parseInt(numbers[1].trim());
            if (x > getPlayers().get(i).getPlayerBoard().BOARD_WIDTH || y > getPlayers().get(i).getPlayerBoard().BOARD_HEIGHT) {
                System.out.println("Incorrect position");
            }
            while(getPlayers().get(i).getPlayerBoard().getTile(x,y)==null)
            {
                System.out.println("That tile doesnt exist");
                input = in.next();
                numbers = input.split(",");
                x = Integer.parseInt(numbers[0].trim());
                y = Integer.parseInt(numbers[1].trim());
                if(getPlayers().get(i).getPlayerBoard().getTile(x,y).up!=null && getPlayers().get(i).getPlayerBoard().getTile(x,y).down!=null && getPlayers().get(i).getPlayerBoard().getTile(x,y).left!=null && getPlayers().get(i).getPlayerBoard().getTile(x,y).right!=null)
                {
                    System.out.println("Invalid placement");
                    input = in.next();
                    numbers = input.split(",");
                    x = Integer.parseInt(numbers[0].trim());
                    y = Integer.parseInt(numbers[1].trim());
                }
            }
            Tile refTile =  getPlayers().get(i).getPlayerBoard().getTile(x,y);
                getPlayers().get(i).getPlayerBoard().addTile(refTile,t);
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
