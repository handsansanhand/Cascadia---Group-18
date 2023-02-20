import java.util.ArrayList;
import java.util.Scanner;

public class Board { // class for the board object for each player
    ArrayList<Tile> TileList = new ArrayList<Tile>();
    public void starterTiles(){
        TileList.add(Tile.randomTile());
        TileList.add(Tile.randomTile());
        TileList.add(Tile.randomTile());
        TileList.get(0).up = TileList.get(1);
        TileList.get(1).down = TileList.get(0);
        TileList.get(0).down = TileList.get(2);
        TileList.get(2).up = TileList.get(0);
    }
    public void addTile(Tile oldest, Tile newest){ // Tile newest is the one being placed and tile oldest is the reference tile
        int input;
        System.out.println("1 to place tile above\n2to place tile below\n3 to place tile to the left\n4 to place tile to the right");
        Scanner in = new Scanner(System.in);
        while(!in.hasNextInt()){
            System.out.println("incorrect input please try again\n");
            in.next();
        }
        input = in.nextInt();
        switch(input){
            case 1:
                oldest.up = newest;
                newest.down = oldest;
            break;
            case 2:
                oldest.down = newest;
                newest.up = oldest;
            break;
            case 3:
                oldest.left = newest;
                newest.right = oldest;
            break;
            case 4:
                oldest.right = newest;
                newest.left = oldest;
            break;
        }
        TileList.add(newest);
    }

    public Board(int num) //3 random starter tiles created in middle, up, down positions
    {
        starterTiles();
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
