import java.util.ArrayList;
public class Board { // class for the board object for each player
    ArrayList<Tile> TileList = new ArrayList<Tile>();
    public void addTile(ht x, ht y){
        TileList.add(new Tile(x, y));
    }

    public Board()
    {
        switch((int) Math.round(Math.random()*5)){ //basic starter tiles, will be changed later to have the half-half ones
            case 0:
                TileList.add(new Tile(ht.Forest));
                TileList.add(new Tile(ht.Wetland));
                TileList.add(new Tile(ht.Mountain));
                break;
            case 1:
                TileList.add(new Tile(ht.Wetland));
                TileList.add(new Tile(ht.Mountain));
                TileList.add(new Tile(ht.Prairie));
                break;
            case 2:
                TileList.add(new Tile(ht.River));
                TileList.add(new Tile(ht.Forest));
                TileList.add(new Tile(ht.Prairie));
                break;
            case 3:
                TileList.add(new Tile(ht.Forest));
                TileList.add(new Tile(ht.River));
                TileList.add(new Tile(ht.Wetland));
                break;
            case 4:
                TileList.add(new Tile(ht.Wetland));
                TileList.add(new Tile(ht.Prairie));
                TileList.add(new Tile(ht.Mountain));
                break;
            default:
                break;
        }
    }

    public String toString(){ //visual representation of board here
        return TileList.toString();
    }

}
