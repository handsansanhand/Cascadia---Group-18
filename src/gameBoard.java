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

}
