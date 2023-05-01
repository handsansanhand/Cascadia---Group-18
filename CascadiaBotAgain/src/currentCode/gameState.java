/*
Student Number - Name - Github ID
21467574 - Jack Wright - #102315833
21447182 - Jack Neilan - #102314039
21350866 - Trystan Rothery - #102313516
*/
/*
Student Number - Name - Github ID
21467574 - Jack Wright - #102315833
21447182 - Jack Neilan - #102314039
21350866 - Trystan Rothery - #102313516
*/

package currentCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//THIS CLASS ACTS AS LIKE A DUNGEON MASTER, WILL PROB MOSTLY BE REPLACED BY THE UI, KEEPS TRACK OF PLAYERCOUNT ALL THE PLAYERS,
//AND THE GAMEBOARD (THE BOARD IN THE MIDDLE OF THE TABLE WHICH IS SAME FOR EVERYONE)
public class gameState {
    static Scanner in = new Scanner(System.in);

    public static int playerCount;
    public static int gameMode; //variable that 1==bot mode, 2==human mode
    static ArrayList<player> Players = new ArrayList<player>();
    static gameBoard gameBoard = new gameBoard();

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


    public void initializeGame(int mode) {
        // Create bot 1 and bot 2
        if(mode == 1) {
            gameMode = 1;
            Bot bot1 = new Bot("Bot 1", 0);
            Bot bot2 = new Bot("Bot 2", 1);
            // Add bot 1 and bot 2 to the Players list
            Players.add(bot1);
            Players.add(bot2);
        }
        else {
            gameMode = 2;
            ArrayList<String> playersArrayList = new ArrayList<>();
            for(int i=1;i<=getPlayerCount();i++) {
                System.out.println("Enter player " + i + "'s Name: ");
                playersArrayList.add(in.next());
            }
            Collections.shuffle(playersArrayList);
            for(int x=0;x<getPlayerCount();x++)
            {
                Players.add(new player(playersArrayList.get(x), x));
            }
        }

        // Shuffle the Players list
        Collections.shuffle(Players);

        // Print the order of the players
        System.out.println("Order: ");
        for(int j=0; j<getPlayerCount(); j++) {
            System.out.println(Players.get(j).getName());
        }

        // Print the name of the player who will start the game
        System.out.println(getPlayers().get(0).getName() + " will start");
    }



    public void nextTurn(int i) throws InterruptedException //a small function that just prints these out for now, will be changed
    {
        if(i>=playerCount)
        {
            i=0;
            if(gameMode == 1 ) {Thread.sleep(1500);}
            System.out.println(Tile.GREEN_BOLD + getPlayers().get(i).getName() + "'s turn!" + Tile.RESET);
            startTurn(i); //asks the user to draw a tile
            System.out.println("\n" + getPlayers().get(i).getPlayerBoard());
        }
        else {
            if(gameMode == 1 ) {Thread.sleep(1500);}
            System.out.println(Tile.GREEN_BOLD + getPlayers().get(i).getName() + "'s turn!" + Tile.RESET);
            startTurn(i); //asks the user to draw a tile
            System.out.println("\n" + getPlayers().get(i).getPlayerBoard());
        }
    }

    public void playGame() throws InterruptedException {
        boolean stillPlaying=true;
        int i=0;
        nextTurn(i);
        i++;
        while(stillPlaying)	//still playing = still playing the game
        {
            switch (in.next()) {
                case "v" -> {
                }
                case "c" -> {
                }
                case "q" -> {
                }
                case "y" -> {
                    //tile placement goes here
                }
            }

        }
    }

    public static void endTheGame() throws InterruptedException {
        //first score the animals:
        for(int x=0;x<playerCount;x++)
        {
            for(int i=0;i<gameBoard.scoringCards.size();i++) {
                int score = gameBoard.scoringCards.get(i).calculateCardScore(getPlayers().get(x));
                System.out.println(getPlayers().get(x).name + " score for " + gameBoard.scoringCards.get(i) + " is " + score);
            }
            System.out.println(Tile.GREEN_BOLD + getPlayers().get(x).name + " total animal score is: " + getPlayers().get(x).score + Tile.RESET);
            System.out.println();
            Thread.sleep(2000);
        }
        for(int x=0;x<playerCount;x++)
        {
            Scoring.scoreHabitatCorridors(getPlayers().get(x)); //count up each max habitat corridor
        }
        Scoring.compareLargestCorridors(); //count up who has the biggest of each type
        System.out.println();
        for(int x=0;x<playerCount;x++) //tally up the remaining nature tokens
        {
            if(getPlayers().get(x).natureTokens>0)
            {
                System.out.println(Tile.GREEN_BOLD + getPlayers().get(x).name + " has " + getPlayers().get(x).natureTokens + " Nature Tokens Left! " + "+ " + getPlayers().get(x).natureTokens + " POINTS" + Tile.RESET);
                getPlayers().get(x).score+=getPlayers().get(x).natureTokens;
            }
            Thread.sleep(1000);
        }

        //find the ranking
        Collections.sort(getPlayers(), new PlayerComparator());
        System.out.println(Tile.GREEN_BOLD + " LEADERBOARD: \n" + Tile.RESET);
        Thread.sleep(1500);
        if(playerCount>3){
            System.out.println(Tile.BOLD + Tile.PINK + "4th Place: " + getPlayers().get(3).name + "\n" + getPlayers().get(3).score + " POINTS" +  Tile.RESET);
        }
        Thread.sleep(700);
        if(playerCount>2){
            System.out.println(Tile.RED_BOLD + "3rd Place: " + getPlayers().get(2).name + "\n" + getPlayers().get(2).score + " POINTS"+ Tile.RESET);
        }
        Thread.sleep(2000);
        System.out.println(Tile.WHITE_BOLD + "2nd Place: " + getPlayers().get(1).name + "\n" + getPlayers().get(1).score + " POINTS"+ Tile.RESET);
        Thread.sleep(2000);
        System.out.println(Tile.YELLOW_BOLD + "1st Place: " + getPlayers().get(0).name + "\n" + getPlayers().get(0).score + " POINTS"+ Tile.RESET);
        System.out.println("\n");
        Thread.sleep(1400);
        System.out.println(Tile.YELLOW_BOLD + getPlayers().get(0).getName() + " WINS!");
        System.exit(0);
    }
    public static void gameEnd() throws InterruptedException {
        switch(gameState.playerCount){
            case 2:
                if(Tile.count==35)
                {
                    System.out.println(Tile.RED_BOLD + "Only 2 Tiles Left!" + Tile.RESET);
                }
                if(Tile.count==36)
                {
                    System.out.println(Tile.RED_BOLD + "Final Turn!" + Tile.RESET);
                }
                if(getPlayers().get(0).turnCount == 18 || getPlayers().get(1).turnCount == 18 )
                {
                    System.out.println(Tile.RED_BOLD + "Only 2 Turns Left!" + Tile.RESET);
                }
                if(getPlayers().get(0).turnCount == 19 || getPlayers().get(1).turnCount == 19 )
                {
                    System.out.println(Tile.RED_BOLD + "Final Turn!" + Tile.RESET);
                }
                if(getPlayers().get(0).turnCount >= 20 && getPlayers().get(1).turnCount >= 20 )
                {
                    //end the game
                    endTheGame();
                }
                if(Tile.count >= 37 ){
                    System.out.println("Out of tiles");
                    //System.exit(0);
                    endTheGame();
                }
                break;
            case 3:
                if(getPlayers().get(0).turnCount == 18 || getPlayers().get(1).turnCount == 18 || getPlayers().get(2).turnCount == 18 )
                {
                    System.out.println(Tile.RED_BOLD + "Only 2 Turns Left!" + Tile.RESET);
                }
                if(getPlayers().get(0).turnCount == 19 || getPlayers().get(1).turnCount == 19 || getPlayers().get(2).turnCount == 18 )
                {
                    System.out.println(Tile.RED_BOLD + "Final Turn!" + Tile.RESET);
                }
                if(getPlayers().get(0).turnCount == 20 && getPlayers().get(1).turnCount == 20 && getPlayers().get(2).turnCount == 20 )
                {
                    //end the game
                    endTheGame();
                }
                if(Tile.count==52)
                {
                    System.out.println(Tile.RED_BOLD + "Only 2 Tiles Left!" + Tile.RESET);
                }
                if(Tile.count==53)
                {
                    System.out.println(Tile.RED_BOLD + "Only 1 Tile Left!" + Tile.RESET);
                }
                if(Tile.count >= 54 ){
                    System.out.println("Out of tiles");
                    //System.exit(0);
                }
                break;
            case 4:
                if(getPlayers().get(0).turnCount == 18 || getPlayers().get(1).turnCount == 18 || getPlayers().get(2).turnCount == 18 || getPlayers().get(3).turnCount == 18 )
                {
                    System.out.println(Tile.RED_BOLD + "Only 2 Turns Left!" + Tile.RESET);
                }
                if(getPlayers().get(0).turnCount == 19 || getPlayers().get(1).turnCount == 19 || getPlayers().get(2).turnCount == 18  || getPlayers().get(3).turnCount == 19 )
                {
                    System.out.println(Tile.RED_BOLD + "Final Turn!" + Tile.RESET);
                }
                if(getPlayers().get(0).turnCount == 20 && getPlayers().get(1).turnCount == 20 && getPlayers().get(2).turnCount == 20  && getPlayers().get(3).turnCount == 20 )
                {
                    //end the game
                    endTheGame();
                }
                if(Tile.count==69)
                {
                    System.out.println(Tile.RED_BOLD + "Only 2 Tiles Left!" + Tile.RESET);
                }
                if(Tile.count==70)
                {
                    System.out.println(Tile.RED_BOLD + "Only 1 Tile Left!" + Tile.RESET);
                }
                if(Tile.count >= 71 ){
                    System.out.println("Out of tiles");
                    //System.exit(0);
                }
                break;
        }
    }

    public void startTurn(int i) throws InterruptedException {
        gameEnd(); //check to see if the game should still be played
        getPlayers().get(i).turnCount += 1; //variable incremented for each player when they have a turn. every player should have exactly 20 turns (from rulebook)
        boolean stillTurn = true;
        boolean stillTokenPlace = true;
        boolean stillPlaying=true;
          //BOT MODE TURN TAKING:
        if(gameMode==1) {
            System.out.println(getPlayers().get(i).name + "'s Board:\n" + getPlayers().get(i).getPlayerBoard());
            System.out.println("Game Board:\n" + gameBoard);
            Thread.sleep(1500);
            Random rand = new Random();
            //BOT CLASS:

            int randIndex = rand.nextInt(4); // generate a random index between 0 and 3 (inclusive) for tile placement
           // int randTokenIndex = rand.nextInt(4); // generate a random index between 0 and 3 (inclusive) for token placement
        Tile t = gameBoard.removeHabitatTile(randIndex);
        getPlayers().get(i).handTile = t;
            System.out.println();
            System.out.println(getPlayers().get(i).name + " picked Tile: " + t);
        wildlifeToken w = gameBoard.removeWildlifeToken(randIndex);
            System.out.println(getPlayers().get(i).name + " picked Wildlife Token: " + w);
            Thread.sleep(2500);
        getPlayers().get(i).addToken(w); //adds the token to your hand
            placeTile(i, t);
            placeWildlifeToken(w,i);
        }
        //HUMAN MODE TURN TAKING:
        else{
            System.out.println(getPlayers().get(i).name + "'s Board:\n" + getPlayers().get(i).getPlayerBoard());
            printInstructions(i);
            gameBoard.checkForCull(getPlayers().get(i)); //this needs to be adjusted for bots
            while (stillTurn) {
                System.out.println("Current Turn: " + getPlayers().get(i).getName());
                switch (in.next()) {
                    case "0": {
                        Tile t = gameBoard.removeHabitatTile(0);
                        getPlayers().get(i).handTile = t;
                        wildlifeToken w = gameBoard.removeWildlifeToken(0);
                        getPlayers().get(i).addToken(w); //adds the token to your hand
                        placeTile(i, t);
                        placeWildlifeToken(w,i);
                        Thread.sleep(1000);
                        stillTurn = false;
                        break;
                    }
                    case "1": {
                        Tile t = gameBoard.removeHabitatTile(1);
                        getPlayers().get(i).handTile = t;
                        wildlifeToken w = gameBoard.removeWildlifeToken(1);
                        getPlayers().get(i).addToken(w); //adds the token to your hand
                        placeTile(i, t);
                        placeWildlifeToken(w,i);
                        Thread.sleep(1000);
                        stillTurn = false;
                        break;
                    }
                    case "2": {
                        Tile t = gameBoard.removeHabitatTile(2);
                        getPlayers().get(i).handTile = t;
                        wildlifeToken w = gameBoard.removeWildlifeToken(2);
                        getPlayers().get(i).addToken(w); //adds the token to your hand
                        placeTile(i, t);
                        placeWildlifeToken(w,i);
                        Thread.sleep(1000);
                        stillTurn = false;
                        break;
                    }
                    case "3": {
                        Tile t = gameBoard.removeHabitatTile(3);
                        getPlayers().get(i).handTile = t;
                        wildlifeToken w = gameBoard.removeWildlifeToken(3);
                        getPlayers().get(i).addToken(w); //adds the token to your hand
                        placeTile(i, t);
                        placeWildlifeToken(w,i);
                        Thread.sleep(1000);
                        stillTurn = false;
                        break;
                    }
                    case "c": {
                        printInstructions(i);
                        break;
                    }
                    case "s": {
                        if (getPlayers().get(i).natureTokens == 0) {
                            System.out.println("not enough nature tokens");
                            break;
                        }
                        boolean hasTakenATurn=false;
                        hasTakenATurn = spendNatureToken(i); //if its true, taken a turn
                        if(!hasTakenATurn){
                            //i have shuffled the wildlife tokens, i still need to take a turn
                            System.out.println(getPlayers().get(i).getPlayerBoard());
                            printInstructions(i);
                            System.out.println("Current Turn: " + getPlayers().get(i).name);
                            break;
                        }
                        System.out.println(gameBoard);
                        boolean anotherSpendChoice = true;
                        //offer the user a chance to spend another nature token
                        while (anotherSpendChoice && getPlayers().get(i).natureTokens > 0) {
                            System.out.println("Current Turn: " + getPlayers().get(i).name);
                            System.out.println("Would " +  getPlayers().get(i).name + " like to spend another nature token? Y / N");
                            System.out.println("Nature Tokens left: " + getPlayers().get(i).natureTokens);
                            switch (in.next()) {
                                case "y":
                                    spendNatureToken(i);
                                case "n":
                                    anotherSpendChoice=false;
                                    continue;
                                default:
                                    System.out.println("Invalid argument");
                            }
                        }
                        //pass the turn
                        Thread.sleep(1000);
                        stillTurn = false;
                    }
                    case "v": {
                        System.out.println(getPlayers().get(i).getPlayerBoard().printUserBoard());
                        printInstructions(i);
                        break;
                    }
                    case "q": //temporary case that quits the game
                    {
                        System.out.println(Tile.RED_BOLD + "Are you sure you want to end the game? Y / N" + Tile.RESET);
                        boolean endthegame=true;
                        while(endthegame) {
                            switch (in.next()) {
                                case "y": {
                                    endTheGame();
                                }
                                case "n": {
                                    endthegame=false;
                                    break;
                                }
                                default:
                                {
                                    break;
                                }
                            }
                        }
                        endTheGame();
                        break;
                    }
                    case "r": //temporary case that tests the scoring
                    {
                        System.out.println("Cascadia Rules: https://www.alderac.com/wp-content/uploads/2021/08/Cascadia-Rules.pdf");
                        break;
                    }
                    default: {
                        System.out.println("Invalid argument, press 'c' for instructions or 'r' for the rules");
                        break;
                    }
                }
            }
        }
        Thread.sleep(1000);
        stillTurn = false;
        //move on to the next players turn
        if(stillPlaying)
        {
            i++;
            nextTurn(i);
            if (i + 1 == playerCount) {
                i = 0;
            }
        }
    }
    public void printInstructions(int player)
    {
        System.out.println("Press s to spend a nature token. NATURE TOKENS: " + getPlayers().get(player).natureTokens);
        System.out.println("Press v to view your board");
        System.out.println("Pick a habitat token and wildlife token from the board. [0-3]");
        System.out.println(gameBoard);
    }

    public boolean spendNatureToken(int currentPlayer) throws InterruptedException {
        boolean tookTurn=true; //true == i already placed my tile+tokens
        Scanner in = new Scanner(System.in);
        System.out.println(gameBoard);
        System.out.println("Press 1 to choose a wildlife token and habitat tile of your choosing");
        System.out.println("Press 2 to replace any number of wildlife tokens");
        while(true) {
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
                    placeWildlifeToken(w,currentPlayer);
                    System.out.println(getPlayers().get(currentPlayer).getPlayerBoard());
                    tookTurn=true; //i have taken a turn
                    return tookTurn;
                }
                case 2:{
                    gameBoard.spendTokenWipingBoard(getPlayers().get(currentPlayer));
                    tookTurn=false; //i have not taken a turn
                    return tookTurn;
                }
                default:{
                    System.out.println("invalid input");
                }

            }
        }

    }

     public static void placeWildlifeToken(wildlifeToken tokenToPlace, int i) throws InterruptedException //method for placing a wildlife token
    {
        System.out.println(getPlayers().get(i).name + " is placing a Wildlife Token ...");
        if(gameMode == 1) {Thread.sleep(1500);}
        System.out.println(getPlayers().get(i).printHand());
        if(gameMode == 1) {Thread.sleep(100);}
        System.out.println(getPlayers().get(i).name + "'s Board:\n" + getPlayers().get(i).getPlayerBoard());
        if(gameMode == 1) {Thread.sleep(1500);}
        if (gameMode == 1) { //bot token implementation
            if (!tokenCanBePlaced(tokenToPlace, getPlayers().get(i))) //the token cannot be placed, remove it from your hand
            {
                System.out.println("The " + getPlayers().get(i).hand.get(0) + " cannot be placed.");
                Thread.sleep(1500);
                wildlifeToken removedToken = getPlayers().get(i).hand.get(0);
                gameBoard.wildlifeTokenBag.add(getPlayers().get(i).hand.remove(0)); //get the wt out of here
                System.out.println("The " + Tile.getAnimalColor(removedToken.animalType) + removedToken + Tile.RESET + " has been put back in the bag.");
                Thread.sleep(3000);
            } else {
                boolean stillPlacing = true;
                System.out.println("Placing a wildlife token...");
                Thread.sleep(1500);
                List<String> choices = Arrays.asList("y", "n");
                Random rand = new Random();

                // Evaluate each tile on the board and calculate a score for each tile
                int bestScore = Integer.MIN_VALUE;
                int bestX = -1;
                int bestY = -1;
                for (int x = 0; x < getPlayers().get(i).getPlayerBoard().TileBoard.length; x++) {
                    for (int y = 0; y < getPlayers().get(i).getPlayerBoard().TileBoard[0].length; y++) {
                        Tile tile = getPlayers().get(i).getPlayerBoard().TileBoard[x][y];
                        if (tile != null && tile.getToken() == null) {
                            int score = Bot.calculateBonus(tile, tokenToPlace, getPlayers().get(i));
                            if (score > bestScore) {
                                bestScore = score;
                                bestX = x;
                                bestY = y;
                            }
                        }
                    }
                }

                if (bestScore <= 0) { // no valid tile to place the token
                    System.out.println("No valid tile to place the token.");
                    Thread.sleep(1500);
                    wildlifeToken removedToken = getPlayers().get(i).hand.get(0);
                    gameBoard.wildlifeTokenBag.add(getPlayers().get(i).hand.remove(0));
                    System.out.println("The " + Tile.getAnimalColor(removedToken.animalType) + removedToken + Tile.RESET + " has been put back in the bag.");
                    Thread.sleep(3000);
                    stillPlacing = false;
                } else { // place the token on the tile with the highest score
                    System.out.println(getPlayers().get(i).getPlayerBoard());
                    System.out.println("Placing token " + tokenToPlace.colorToString() + "...");
                    Thread.sleep(1500);
                    getPlayers().get(i).getPlayerBoard().TileBoard[bestX][bestY].addWildlifetoken(tokenToPlace);
                    gameBoard.checkForBonus(getPlayers().get(i).getPlayerBoard().TileBoard[bestX][bestY], tokenToPlace, getPlayers().get(i));
                    System.out.println(getPlayers().get(i).name + " placed a " + tokenToPlace + " successfully!");
                    getPlayers().get(i).hand.remove(0);
                    Thread.sleep(3000);
                    stillPlacing = false;
                        }
                    }
                }


        else { //human token placing implementation
            if (!tokenCanBePlaced(tokenToPlace, getPlayers().get(i))) //the token cannot be placed, remove it from your hand
            {
                System.out.println("The " + getPlayers().get(i).hand.get(0) + " cannot be placed.");
                Thread.sleep(1500);
                wildlifeToken removedToken = getPlayers().get(i).hand.get(0);
                gameBoard.wildlifeTokenBag.add(getPlayers().get(i).hand.remove(0)); //get the wt out of here
                System.out.println("The " + Tile.getAnimalColor(removedToken.animalType) + removedToken + Tile.RESET + " has been put back in the bag.");
            } else {
                boolean stillPlacing=true;
                System.out.println("Would you like to place a wildlife token? Y / N");
                System.out.println(getPlayers().get(i).printHand());
                while (stillPlacing) {
                    switch (in.next()) {

                        case "y": { // place the token
                            System.out.println(getPlayers().get(i).getPlayerBoard());
                            System.out.println("Where would you like to place the token? [X,Y]"); //ask for the location (tile number)
                            System.out.println("Token: " + tokenToPlace.colorToString());

                            String input;
                            while (true) { //asks the user where to place the token
                                try {
                                    input = in.next();
                                    String[] numbers = input.split(",");
                                    if (numbers.length != 2) {
                                        throw new IllegalArgumentException("Please enter two digits separated by a comma.");
                                    }
                                    int x = Integer.parseInt(numbers[0].trim());
                                    int y = Integer.parseInt(numbers[1].trim());
                                    if (x < 0 || x >= getPlayers().get(i).getPlayerBoard().TileBoard.length ||
                                            y < 0 || y >= getPlayers().get(i).getPlayerBoard().TileBoard[0].length) {
                                        throw new IllegalArgumentException("Invalid position.");
                                    }
                                    if (getPlayers().get(i).getPlayerBoard().TileBoard[x][y] == null) {
                                        throw new IllegalArgumentException("This tile is null.");
                                    }
                                    if (getPlayers().get(i).getPlayerBoard().TileBoard[x][y].getToken()!=null) {
                                        throw new IllegalArgumentException("This tile is full. Please try again");
                                    }
                                    getPlayers().get(i).getPlayerBoard().TileBoard[x][y].addWildlifetoken(tokenToPlace);
                                    if (getPlayers().get(i).getPlayerBoard().TileBoard[x][y].getToken() == tokenToPlace) {
                                        gameBoard.checkForBonus(getPlayers().get(i).getPlayerBoard().TileBoard[x][y], tokenToPlace, getPlayers().get(i));
                                        System.out.println(tokenToPlace + " placed successfully!");
                                        getPlayers().get(i).hand.remove(0);
                                        break;
                                    } else {
                                        System.out.println("Unable to place token.");
                                    }
                                } catch (IllegalArgumentException ex) {
                                    System.out.println("Cannot place a " + tokenToPlace + " on that tile.");
                                }
                            }
                            //token has been placed, return
                            stillPlacing=false;
                            break;
                        }
                        case "n": { //user does not want to place a token
                            wildlifeToken removedToken = getPlayers().get(i).hand.get(0);
                            gameBoard.wildlifeTokenBag.add(getPlayers().get(i).hand.remove(0)); //get the wt out of here
                            System.out.println("The " + Tile.getAnimalColor(removedToken.animalType) + removedToken + Tile.RESET + " has been put back in the bag.");
                            stillPlacing=false;
                            break;
                        }
                        case "c": {
                            System.out.println("\nWould you like to place a wildlife token?. Y / N");
                            System.out.println(gameBoard);
                            break;
                        }
                        default: {
                            System.out.println("incorrect input, press 'c' for instructions");
                        }
                    }
                }
            }
        }
    }

    public static boolean tokenCanBePlaced(wildlifeToken tokenToPlace, player user) //helper function that finds if a token can be placed, if it doesnt, then it gets passed back into the bag
    {
        for(int i=0;i<tileBoard.BOARD_HEIGHT-1;i++)
        {
            for(int j=0; j<tileBoard.BOARD_WIDTH-1;j++)
            {
                if(user.getPlayerBoard().TileBoard[i][j]!=null && (user.getPlayerBoard().TileBoard[i][j].animal1 == tokenToPlace.animalType || user.getPlayerBoard().TileBoard[i][j].animal2 == tokenToPlace.animalType || user.getPlayerBoard().TileBoard[i][j].animal3 == tokenToPlace.animalType) && user.getPlayerBoard().TileBoard[i][j].token==null)
                {
                    return true;
                }
            }
        }
        return false;
    }


    public static void placeTile(int i, Tile t) throws InterruptedException {
        if (gameMode == 1) { //bot tile placing implementation
            System.out.println(getPlayers().get(i).name + " is Placing Tile ... ");
            Thread.sleep(1500);
            Scanner in = new Scanner(System.in);
            Tile refTile = null;
            System.out.println(getPlayers().get(i).getPlayerBoard());
            Thread.sleep(1000);
            // makemove1 should take in all nessaary parameters
            // so that a minimax algorthim can be used to determine the best move
            // make move one should take in playboard and tile object
            int[] move = Bot.makeMove1(getPlayers().get(i).getPlayerBoard(), t);
            int x = move[0];
            int y = move[1];


            System.out.println("X : " + x + "Y:  " + y);

            //System.out.println("I am placing my tile at " + x + "," + y);
            refTile = getPlayers().get(i).getPlayerBoard().getTile(x, y);
            getPlayers().get(i).getPlayerBoard().BotaddTile(refTile, t);

            Thread.sleep(3000);
            // End of modification
        } else //human tile placing implementation
        {
            Scanner in = new Scanner(System.in);
            Tile refTile = null;
            System.out.println(getPlayers().get(i).getPlayerBoard());
            System.out.println("Pick a reference tile on the board: [X,Y]");
            System.out.println("Your tile that will be placed: [" + getPlayers().get(i).getHandTile() + "]");
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
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter two numbers separated by a comma.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("That position is outside of the allowed space.");
                    placeTile(i, t);
                    break;
                }
            }
        }
    }public static void validtiles() {


    }


    }

