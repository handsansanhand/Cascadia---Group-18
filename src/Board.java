import java.util.ArrayList;
public class Board { // class for the board object
    ArrayList<Tile> TileList = new ArrayList<Tile>();

    public void addTile(ht x){
        TileList.add(new Tile(x));
    }
    public String toString(){ //visual representation of board here
        return "wip";
    }

}
