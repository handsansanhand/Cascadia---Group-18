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
            if(highestAnimalTypeCount()==3) //only when there are 3 of the same animal
            {
                System.out.println("A cull is available! Would you like to cull?"); //cull
                System.out.println("Y / N");
                Scanner in = new Scanner(System.in);
                    switch (in.next()) {
                        case "y" -> {
                            tokenEnum animaltocull = findMostCommonAnimal();
                            cull(animaltocull);
                            System.out.println("The " + animaltocull + "'s have been culled.");
                            System.out.println("The new board is: \n" + this.toString());
                            break;
                        }
                        case "n" -> {
                            System.out.println("No cull happened");
                            System.out.println("The board is: \n" + this.toString());
                            break;
                        }
                        default -> System.out.println("Invalid argument");
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
                hTString = hTString + "[ " + boardHabitatTiles.get(i).toString() + " ] ";
            }
            return hTString;
        }
        public String printWildlifeTokens()     //function for printing the current wt's
        {
            String wTString = "Wildlife Tokens: ";
            for(int i=0;i<boardWildlifeTokens.size();i++)
            {
                wTString = wTString + "[ " + boardWildlifeTokens.get(i).toString() + " ] ";
            }
            return wTString;
        }
        public boolean checkForBonus(Tile placementTile, wildlifeToken placementtoken, player currentPlayer)
        {
            if(placementTile.isKeystoneTile && (placementTile.animal1==placementtoken.getAnimalType()))
            {
                currentPlayer.natureTokens--;
                return true;
            }
            return false;
        }
        public Tile chooseTile(player currentPlayer) //function for spending a wildlife token to choose a tile
        {
            Tile returnTile = null;
            System.out.println("Press 1 for Mountains, 2 for Rivers, 3 for Wetlands, 4 for Forest, 5 for Prairie");
            Scanner in = new Scanner(System.in);
            boolean stillPicking = true;
            while (stillPicking) {
                switch (in.next()) {
                    case "1": {
                        returnTile = new Tile(habitatEnum.Mountain, habitatEnum.Empty);
                        stillPicking = false;
                        break;
                    }
                    case "2": {
                        returnTile = new Tile(habitatEnum.River, habitatEnum.Empty);
                        stillPicking = false;
                        break;

                    }
                    case "3": {
                        returnTile = new Tile(habitatEnum.Wetland, habitatEnum.Empty);
                        stillPicking = false;
                        break;
                    }
                    case "4": {
                        returnTile = new Tile(habitatEnum.Forest, habitatEnum.Empty);
                        stillPicking = false;
                        break;
                    }
                    case "5": {
                        returnTile = new Tile(habitatEnum.Prairie, habitatEnum.Empty);
                        stillPicking = false;
                        break;
                    }
                    default: {
                        System.out.println("invalid input");
                    }
                }
            }
            return returnTile;
        }

    public wildlifeToken chooseToken(player currentPlayer) //function for spending a wildlife token to choose a tile
    {
        wildlifeToken returnToken = null;
        System.out.println("Press 1 for Bear, 2 for Salmon, 3 for Elk, 4 for Hawk, 5 for Fox");
        Scanner in = new Scanner(System.in);
        boolean stillPicking = true;
        while (stillPicking) {
            switch (in.next()) {
                case "1": {
                    returnToken = new wildlifeToken(tokenEnum.BEAR);
                    stillPicking = false;
                    break;
                }
                case "2": {
                    returnToken = new wildlifeToken(tokenEnum.SALMON);
                    stillPicking = false;
                    break;

                }
                case "3": {
                    returnToken = new wildlifeToken(tokenEnum.ELK);
                    stillPicking = false;
                    break;
                }
                case "4": {
                    returnToken = new wildlifeToken(tokenEnum.HAWK);
                    stillPicking = false;
                    break;
                }
                case "5": {
                    returnToken = new wildlifeToken(tokenEnum.FOX);
                    stillPicking = false;
                    break;
                }
                default: {
                    System.out.println("invalid input");
                }

            }
        }
        return returnToken;
    }
    public Tile spendToken(player currentPlayer)
    {
        currentPlayer.natureTokens--;
        currentPlayer.addToken(chooseToken(currentPlayer));
        //currentPlayer.getPlayerBoard().addTile(null, chooseTile(currentPlayer));
        //currentPlayer.addToken(chooseToken(currentPlayer));
        return chooseTile(currentPlayer);
    }



        public String toString() //temporary tostring method for veiwing the board TEMPORARY
        {
            return printHabitatTiles() + "\n" + printWildlifeTokens();
        }

    }

