import java.util.ArrayList;

//class that holds the wildlife scoring cards, habitat tiles(ht) and wildlife tokens
public class gameBoard {
    ArrayList<Tile> boardHabitatTiles = new ArrayList<>();
    ArrayList<widlifeTokens> boardWildlifeTokens = new ArrayList<>();
    gameBoard() //gameboard will be constructed with 4 habitat tiles and 4 wildlifetoken tiles
    {
        for(int i=0;i<4;i++) {
            boardHabitatTiles.add(Tile.starterTiles());
        }
        for(int j=0;j<4;j++)
        {
            boardWildlifeTokens.add(widlifeTokens.generateWildlifeToken());
        }
    }

    public String toString() //temporary tostring method for veiwing the board TEMPORARY
    {
        return "Habitat Tiles:[ " + boardHabitatTiles.get(0).getLandType() + " , "  + boardHabitatTiles.get(1).getLandType() + " , "  + boardHabitatTiles.get(2).getLandType() + " , "  + boardHabitatTiles.get(3).getLandType() + " ] "  +  "\nWildlife Tokens: [ " + boardWildlifeTokens.get(0).animalType + " , "  +  boardWildlifeTokens.get(1).animalType + " , "  +  boardWildlifeTokens.get(2).animalType + " , "  +  boardWildlifeTokens.get(3).animalType + " ] ";
    }

}
