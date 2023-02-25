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

        public String toString() //temporary tostring method for veiwing the board TEMPORARY
        {
            return printHabitatTiles() + "\n" + printWildlifeTokens();
        }

    }

