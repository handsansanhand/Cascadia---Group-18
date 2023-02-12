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
            if (checkWtEqual()) {
                boardWildlifeTokens.clear();
                for (int j = 0; j < 4; j++) {
                    boardWildlifeTokens.add(wildlifeToken.generateWildlifeToken());
                }
            }

        }

        public boolean checkWtEqual() //should return true if an automatic cull is needed
        {
            return boardWildlifeTokens.isEmpty() || Collections.frequency(boardWildlifeTokens, boardWildlifeTokens.get(0)) == boardWildlifeTokens.size();
        }

        public String toString() //temporary tostring method for veiwing the board TEMPORARY
        {
            return "Habitat Tiles:[ " + boardHabitatTiles.get(0).getLandType() + " , " + boardHabitatTiles.get(1).getLandType() + " , " + boardHabitatTiles.get(2).getLandType() + " , " + boardHabitatTiles.get(3).getLandType() + " ] " + "\nWildlife Tokens: [ " + boardWildlifeTokens.get(0).animalType + " , " + boardWildlifeTokens.get(1).animalType + " , " + boardWildlifeTokens.get(2).animalType + " , " + boardWildlifeTokens.get(3).animalType + " ] ";
        }

    }

