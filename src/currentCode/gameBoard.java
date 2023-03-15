package currentCode;

import java.util.ArrayList;
import java.util.Scanner;

//class that holds the wildlife scoring cards, habitat tiles(ht) and wildlife tokens
    public class gameBoard {
        ArrayList<Tile> boardHabitatTiles = new ArrayList<>();
        ArrayList<wildlifeToken> boardWildlifeTokens = new ArrayList<>();

        gameBoard() //gameboard will be constructed with 4 habitat tiles and 4 wildlifetoken tiles
        {
            for (int i = 0; i < 4; i++) {
                boardHabitatTiles.add(Tile.randomTile());
            }
            for (int j = 0; j < 4; j++) {
                boardWildlifeTokens.add(wildlifeToken.generateWildlifeToken());
            }
            if (highestAnimalTypeCount()==4) { //automatically culls if all the same
                System.out.println("Four identical wildlife tokens detected, an automatic cull has occurred.");
                cull(findMostCommonAnimal());
            }
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

        public void checkForCull() //lets users know if a cull is available
        {
            boolean stillCulling=true;
            if(highestAnimalTypeCount()==3) //only when there are 3 of the same animal
            {
                while (stillCulling) {
                    System.out.println("A cull is available! Would you like to cull?"); //cull
                    System.out.println("Y / N");
                    System.out.println("The board: " + this);
                    Scanner in = new Scanner(System.in);
                    switch (in.next()) {
                        case "y" -> {
                            tokenEnum animaltocull = findMostCommonAnimal();
                            cull(animaltocull);
                            System.out.println("The " + animaltocull + "'s have been culled.");
                            System.out.println("The new board is: \n");
                            stillCulling=false;
                            break;
                        }
                        case "n" -> {
                            System.out.println("No cull happened");
                            System.out.println("The board is: \n");
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
            }
            public Tile removeHabitatTile(int i)  //function for removing the i'th
            {
                Tile temp = boardHabitatTiles.get(i);
                boardHabitatTiles.remove(i);
                boardHabitatTiles.add(Tile.randomTile());
                return temp;
            }
    public wildlifeToken removeWildlifeToken(int i)  //function for removing the i'th
    {
        wildlifeToken temp = boardWildlifeTokens.get(i);
        boardWildlifeTokens.remove(i);
        boardWildlifeTokens.add(wildlifeToken.generateWildlifeToken());
        return temp;
    }

        public void cull(tokenEnum animalToCull)   //function that replaces the culled animals
        {
            for(int i=0;i<boardWildlifeTokens.size();i++)
            {
                if(boardWildlifeTokens.get(i).animalType.equals(animalToCull))
                {
                    boardWildlifeTokens.remove(i);
                    boardWildlifeTokens.add(wildlifeToken.generateWildlifeToken());
                    cull(animalToCull);
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
                if(boardWildlifeTokens.get(i).toString().equals(animalType.toString()))
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
            String wTString = "Wildlife Tokens: ";
            for(int i=0;i<boardWildlifeTokens.size();i++)
            {
                wTString = wTString + "(" + i + ")" + "[ " + boardWildlifeTokens.get(i).toString() + " ] ";
            }
            return wTString;
        }
        public void checkForBonus(Tile placementTile, wildlifeToken placementtoken, player currentPlayer)
        {
            if(placementTile.isKeystoneTile && (placementTile.animal1==placementtoken.getAnimalType()))
            {
                currentPlayer.natureTokens++;
                System.out.println(currentPlayer.name + " earned a nature token !");
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
        }
    }

    public void replaceWildlifeToken(int i) //helper function for spending a naturetoken to wipe a particular token
    {
        boardWildlifeTokens.set(i, wildlifeToken.generateWildlifeToken());
    }



        public String toString() //temporary tostring method for veiwing the board TEMPORARY
        {
            return printHabitatTiles() + "\n" + printWildlifeTokens();
        }

    }

