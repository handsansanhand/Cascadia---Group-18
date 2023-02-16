import java.util.ArrayList;
public class Board { // class for the board object for each player
    ArrayList<Tile> TileList = new ArrayList<Tile>();
    public void addTile(ht x, ht y){
        TileList.add(new Tile(x, y));
    }

    public Board(int num) //constructing the board will give the player a starter tile?
    {
        switch (num)
        {
            case 0:
                addTile(ht.River,ht.Forest);
                addTile(ht.Wetland,ht.Wetland);
                addTile(ht.Mountain,ht.Prairie);
                break;
            case 1:
                addTile(ht.Forest,ht.Wetland);
                addTile(ht.Mountain,ht.Mountain);
                addTile(ht.Prairie,ht.River);
                break;
            case 2:
                addTile(ht.Mountain,ht.River);
                addTile(ht.Forest,ht.Forest);
                addTile(ht.Prairie,ht.River);
                break;
            case 3:
                addTile(ht.Prairie,ht.Forest);
                addTile(ht.River,ht.River);
                addTile(ht.Wetland,ht.Mountain);
                break;
            case 4:
                addTile(ht.Wetland,ht.River);
                addTile(ht.Prairie,ht.Prairie);
                addTile(ht.Mountain,ht.Forest);
                break;
            default:
                break;
        }
    }

    public String printUserBoard()
    {
        String userBoard="Your Board: ";
        for(int i=0;i<TileList.size();i++)
        {
            userBoard = userBoard + "[ " + TileList.get(i).toString() + " ] ";
        }
        return userBoard;
    }

    public String toString(){ //visual representation of board here
        return printUserBoard();
    }

}
