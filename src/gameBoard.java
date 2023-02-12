import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

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
            if (highestAnimalTypeCount()==4) {
                boardWildlifeTokens.clear();
                System.out.println("Four identical wildlife tokens detected, an automatic cull has occurred.");
                for (int j = 0; j < 4; j++) {
                    boardWildlifeTokens.add(wildlifeToken.generateWildlifeToken());
                }
            }
        }

        public int highestAnimalTypeCount()
        {
            int highestCount=0;
            int temp=0;
            wT[] tokens = wT.values();
            for(wT animal: tokens)
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
            if(highestAnimalTypeCount()==3)
            {
                System.out.println("A cull is available!");
            }
        }

        public int countAnimals(wT animalType) //function that counts the amount of animaltype in the current wildlifetokens(used for culling)
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

        public String toString() //temporary tostring method for veiwing the board TEMPORARY
        {
            return "Habitat Tiles:[ " + boardHabitatTiles.get(0).getLandType() + " , " + boardHabitatTiles.get(1).getLandType() + " , " + boardHabitatTiles.get(2).getLandType() + " , " + boardHabitatTiles.get(3).getLandType() + " ] " + "\nWildlife Tokens: [ " + boardWildlifeTokens.get(0).animalType + " , " + boardWildlifeTokens.get(1).animalType + " , " + boardWildlifeTokens.get(2).animalType + " , " + boardWildlifeTokens.get(3).animalType + " ] ";
        }

    }

