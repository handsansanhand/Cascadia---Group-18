import java.util.ArrayList;
public class Board { // class for the board object for each player
    ArrayList<Tile> TileList = new ArrayList<Tile>();
    public void addTile(ht x, ht y){
        TileList.add(new Tile(x, y));
    }

    public Board()
    {
       TileList.add(Tile.randomTile());
    }

    public String toString(){ //visual representation of board here
        return TileList.toString();
    }

}
