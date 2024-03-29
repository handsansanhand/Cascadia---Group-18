/*
Student Number - Name - Github ID
21467574 - Jack Wright - #102315833
21447182 - Jack Neilan - #102314039
21350866 - Trystan Rothery - #102313516
*/
package currentCode;

import java.util.ArrayList;
import java.util.Scanner;

//class that holds the wildlife scoring cards, habitat tiles(ht) and wildlife tokens
    public class gameBoard {
        ArrayList<Tile> boardHabitatTiles = new ArrayList<>();
        ArrayList<wildlifeToken> boardWildlifeTokens = new ArrayList<>();
        ArrayList<wildlifeToken> wildlifeTokenBag = wildlifeToken.makeWildlifeTokenBag();
        ArrayList<ScoringCard> scoringCards = new ArrayList<>();

        gameBoard() //gameboard will be constructed with 4 habitat tiles and 4 wildlifetoken tiles
        {
            for (int i = 0; i < 4; i++) {
                boardHabitatTiles.add(Tile.randomTile());
            }
            for (int j = 0; j < 4; j++) {
                    boardWildlifeTokens.add(wildlifeTokenBag.remove(j));
            }
            if (highestAnimalTypeCount()==4) { //automatically culls if all the same
                System.out.println(Tile.RED_BOLD + "Four identical wildlife tokens detected, an automatic cull has occurred." + Tile.RESET);
                cull(findMostCommonAnimal());
            }
            scoringCards.add(ScoringCard.generateScoringCardBear());
            scoringCards.add(ScoringCard.generateScoringCardElk());
            scoringCards.add(ScoringCard.generateScoringCardSalmon());
            scoringCards.add(ScoringCard.generateScoringCardHawk());
            scoringCards.add(ScoringCard.generateScoringCardFox());
        }

        public int highestAnimalTypeCount() //function that returns the highest amount of times an animal appears on the board
        {
            int highestCount=0;
            int temp=0;
            tokenEnum[] tokens = tokenEnum.values();
            for(tokenEnum animal: tokens)
            {
                temp = countAnimals(animal);
                if(temp>highestCount)
                {
                    highestCount=temp;
                }
            }
            return highestCount;
        }

        public boolean checkForCull(player user) //lets users know if a cull is available
        {
            boolean cullAvailabe=false;
            boolean stillCulling=true;
            if(highestAnimalTypeCount()==3) //only when there are 3 of the same animal and eligible tokens left
            {
                cullAvailabe=true;
                while (stillCulling) {
                    System.out.println(Tile.RED_BOLD + "A cull is available!" + Tile.RESET +  " Would you like to " + Tile.RED_BOLD + "cull" + Tile.RESET + "?"); //cull
                    System.out.println(Tile.RED_BOLD + "Y "+ Tile.RESET + "/" + Tile.GREEN_BOLD + " N" + Tile.RESET);
                    Scanner in = new Scanner(System.in);
                    switch (in.next()) {
                        case "y" -> {
                            tokenEnum animaltocull = findMostCommonAnimal();
                            cull(animaltocull);
                            String deathString= Tile.RED_BOLD + "The " + animaltocull + "'s have been culled." + Tile.RESET;
                            System.out.println(deathString);
                            System.out.println("The new board is:");
                            System.out.println(this);
                            stillCulling=false;
                            break;
                        }
                        case "n" -> {
                            System.out.println(Tile.GREEN_BOLD + "No cull happened" + Tile.RESET);
                            System.out.println("The board is:");
                            System.out.println(this);
                            stillCulling=false;
                            break;
                        }

                        default -> System.out.println("Invalid argument");
                    }
                }
            }
            else if(highestAnimalTypeCount()==4)
            {
                cull(findMostCommonAnimal());
                System.out.println("Too many " + findMostCommonAnimal() + "'s, an automatic cull has been implemented.");
            }
            return cullAvailabe;
            }
            public Tile removeHabitatTile(int i)  //function for removing the i'th
            {
                Tile returnTile = boardHabitatTiles.get(i);
                boardHabitatTiles.set(i, Tile.randomTile());
                return  returnTile;
                /*
                Tile temp = boardHabitatTiles.get(i);
                boardHabitatTiles.remove(i);
                boardHabitatTiles.add(Tile.randomTile());
                return temp;*/
            }
    public wildlifeToken removeWildlifeToken(int i)  //function for removing the i'th
    {
            wildlifeToken returnToken = boardWildlifeTokens.get(i);
            boardWildlifeTokens.set(i, wildlifeTokenBag.remove(0));
            return returnToken;
    }

        public void cull(tokenEnum animalToCull)   //function that replaces the culled animals
        {
            for(int i=0;i<boardWildlifeTokens.size();i++)
            {
                if(boardWildlifeTokens.get(i).animalType.equals(animalToCull))
                {
                    /*
                    boardWildlifeTokens.remove(i);
                    boardWildlifeTokens.add(wildlifeToken.generateWildlifeToken());
                    cull(animalToCull);*/
                        wildlifeTokenBag.add(boardWildlifeTokens.remove(i));
                        boardWildlifeTokens.add(wildlifeTokenBag.remove(0));
                       // cull(animalToCull);
                    }
                }
            }
        public tokenEnum findMostCommonAnimal()    //function that returns the animal type of the most frequent animal on the board
        {
            tokenEnum highestAnimal= tokenEnum.ELK;
            tokenEnum temp;
            tokenEnum[] tokens = tokenEnum.values();
            for(tokenEnum animal: tokens)
            {
                temp = animal;
                if(countAnimals(temp)>countAnimals(highestAnimal))
                {
                    highestAnimal=temp;
                }
            }
            return highestAnimal;
        }

        public int countAnimals(tokenEnum animalType) //function that counts the amount of animaltype in the current wildlifetokens(used for culling)
        {
            int count =0;
            for(int i=0;i<boardWildlifeTokens.toArray().length;i++)
            {
                if(boardWildlifeTokens.get(i).getAnimalType().equals(animalType))
                {
                    count++;
                }
                else
                {}
            }
            return count;
        }

        public String printHabitatTiles()   //for printing the current ht's
        {
            String hTString = "Habitat Tiles: ";
            for(int i=0;i<boardHabitatTiles.size();i++)
            {
                hTString = hTString +  "(" + i + ")" + "[ " + boardHabitatTiles.get(i).toString() + " ] ";
            }
            return hTString;
        }
        public String printWildlifeTokens()     //function for printing the current wt's
        {
            String wTString = "Wildlife Tokens:  ";
            for(int i=0;i<boardWildlifeTokens.size();i++)
            {
                wTString = wTString + "(" + i + ")" + "[ " + boardWildlifeTokens.get(i).toString() + " ]";
            }
            return wTString;
        }
        public void checkForBonus(Tile placementTile, wildlifeToken placementtoken, player currentPlayer)
        {
            if(placementTile.isKeystoneTile && (placementTile.animal1==placementtoken.getAnimalType()))
            {
                currentPlayer.natureTokens++;
                System.out.println(Tile.GREEN_BOLD + currentPlayer.name + " earned a nature token !" + Tile.RESET);
            }
        }

        public Tile chooseTile(player currentPlayer) //function for spending a wildlife token to choose a tile
        {
            Tile returnTile = null;
            System.out.println("Choose a tile:");
            System.out.println(printHabitatTiles());
            Scanner in = new Scanner(System.in);
            boolean stillPicking = true;
            while (stillPicking) {
                switch (in.next()) {
                    case "0": {
                        returnTile = removeHabitatTile(0);
                        stillPicking = false;
                        break;
                    }
                    case "1": {
                        returnTile = removeHabitatTile(1);
                        stillPicking = false;
                        break;

                    }
                    case "2": {
                        returnTile = removeHabitatTile(2);
                        stillPicking = false;
                        break;
                    }
                    case "3": {
                        returnTile = removeHabitatTile(3);
                        stillPicking = false;
                        break;
                    }
                    default: {
                        System.out.println("invalid input");
                    }
                }
            }
            currentPlayer.natureTokens--;
            currentPlayer.handTile = returnTile;
            return returnTile;
        }

    public wildlifeToken chooseToken(player currentPlayer) //function for spending a wildlife token to choose a tile
    {
        wildlifeToken returnToken = null;
        System.out.println("Pick a wildlife token [0-3]:");
        System.out.println(printWildlifeTokens());
        Scanner in = new Scanner(System.in);
        boolean stillPicking = true;
        while (stillPicking) {
            switch (in.next()) {
                case "0": {
                    returnToken = removeWildlifeToken(0);
                    stillPicking = false;
                    break;
                }
                case "1": {
                    returnToken = removeWildlifeToken(1);
                    stillPicking = false;
                    break;

                }
                case "2": {
                    returnToken = removeWildlifeToken(2);
                    stillPicking = false;
                    break;
                }
                case "3": {
                    returnToken = removeWildlifeToken(3);
                    stillPicking = false;
                    break;
                }
                default: {
                    System.out.println("invalid input");
                }

            }
        }
        currentPlayer.hand.add(returnToken);
        return returnToken;
    }
    public Tile spendTokenPickingTile(player currentPlayer) //function for spending a nature token for choosing a tile of your choice
    {
        currentPlayer.natureTokens--;
        currentPlayer.addToken(chooseToken(currentPlayer));
        //currentPlayer.getPlayerBoard().addTile(null, chooseTile(currentPlayer));
        //currentPlayer.addToken(chooseToken(currentPlayer));
        return chooseTile(currentPlayer);
    }

    public void spendTokenWipingBoard(player currentPlayer)
    {
        boolean a=true;
        Scanner sc = new Scanner(System.in);
        int numToCull=0;
        if(currentPlayer.natureTokens==0)
        {
            System.out.println("not enough nature tokens");
            return;
        }
        else {
            currentPlayer.natureTokens--;
            System.out.println(printWildlifeTokens());
            int input;
            while(a) {
                System.out.println("how many would you like to replace?");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input");
                    sc.next(); // consume remaining input
                }
                switch (sc.nextInt()) {
                    case 1:{numToCull = 1;
                                a=false;
                    break;}
                    case 2:{numToCull = 2;
                        a=false;
                    break;}
                    case 3:{numToCull = 3;
                        a=false;
                    break;}
                    case 4:{numToCull = 4;
                        a=false;
                    break;}
                    default:
                    {
                        System.out.println("invalid input, please try again:");
                    }
                }
                if(numToCull>wildlifeTokenBag.size())
                {
                    System.out.println("not enough tokens left in the bag for that amount");
                }
            }
            //get the ones to cull
            System.out.println("What tokens would you like to replace?");
            for(int i=0; i<numToCull;i++)
            {
                System.out.println(printWildlifeTokens());
                System.out.println("Replacements left: " + (numToCull-i));
                while(!sc.hasNextInt())
                {
                    System.out.println("invalid input");
                    sc.next(); // discard the invalid input
                }
                int tokenToReplace = sc.nextInt();
                sc.nextLine(); // consume the newline character

                switch (tokenToReplace)
                {
                    case 0 -> replaceWildlifeToken(0);
                    case 1 -> replaceWildlifeToken(1);
                    case 2 -> replaceWildlifeToken(2);
                    case 3 -> replaceWildlifeToken(3);
                }
            }
            System.out.println(printWildlifeTokens());
        }
    }

    public void replaceWildlifeToken(int i) //helper function for spending a naturetoken to wipe a particular token
    {
        wildlifeToken returnT = boardWildlifeTokens.get(i);
        boardWildlifeTokens.set(i, wildlifeTokenBag.remove(0));
        wildlifeTokenBag.add(returnT);
    }



        public String toString() //temporary tostring method for veiwing the board TEMPORARY
        {
            return printHabitatTiles() + "\n" + printWildlifeTokens() + "\nScoring Cards: " + scoringCards;
        }

    }

