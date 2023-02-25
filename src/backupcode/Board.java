package backupcode;

import java.util.ArrayList;
import java.util.Scanner;
//EACH 'BOARD' HOLDS AN ARRAYLIST OF TILES
public class Board { // class for the board object for each player
    //ArrayList<Tile> TileList = new ArrayList<Tile>();
    final int BOARD_HEIGHT=15;
    final int BOARD_WIDTH=15;
    Tile[][] TileBoard = new Tile[BOARD_WIDTH][BOARD_HEIGHT];

    public void starterTiles(){
        //STARTER TILES ARE A FIXED 5 COMBINATION OF CERTAIN TILES?
        TileBoard[(BOARD_WIDTH/2) -1][0] = Tile.randomTile();
        TileBoard[(BOARD_WIDTH/2)][1] = Tile.randomTile();
        TileBoard[(BOARD_WIDTH/2) +1][0] = Tile.randomTile();
    }
    public void addTile(Tile oldest, Tile newest){ // Tile newest is the one being placed and tile oldest is the reference tile
        int input;
        System.out.println("1 to place tile above\n2to place tile below\n3 to place tile to the left\n4 to place tile to the right\n");
        Scanner in = new Scanner(System.in);
        while(!in.hasNextInt()){
            System.out.println("incorrect input please try again\n");
            in.next();
        }
        input = in.nextInt();
        switch(input){
            case 1:
                if(oldest.up != null){
                    System.out.println("That position is filled\n");
                    addTile(oldest, newest);
                }
                oldest.up = newest;
                newest.down = oldest;
                break;
            case 2:
                if(oldest.down != null){
                    System.out.println("That position is filled\n");
                    addTile(oldest, newest);
                }
                oldest.down = newest;
                newest.up = oldest;
                break;
            case 3:
                if(oldest.left != null){
                    System.out.println("That position is filled\n");
                    addTile(oldest, newest);
                }
                oldest.left = newest;
                newest.right = oldest;
                break;
            case 4:
                if(oldest.right != null){
                    System.out.println("That position is filled\n");
                    addTile(oldest, newest);
                }
                oldest.right = newest;
                newest.left = oldest;
                break;
        }
        //TileList.add(newest);
    }
    public void addTileCoOrdinates(int x, int y, Tile newTile)    //temporary tile adder using co ordinates until we get the other method working
    {
        TileBoard[x][y] = newTile;
    }

    public Board(int num) //3 random starter tiles created in middle, up, down positions on the board
    {
        starterTiles();
    }

    public String printUserBoard() {
        String userBoard = "";
        System.out.println("Your Board:");
        for (int i = BOARD_HEIGHT-1; i>=0; i--) //TILEBOARD.LENGTH = HEIGHT // TILEBOARD[0].LENGTH = WIDTH
        {
            for (int j = BOARD_WIDTH-1; j >= 0; j--) {
                if (TileBoard[j][i] == null) {
                    userBoard = userBoard + "[ EMPTY ]";
                } else {
                    userBoard = userBoard + "[ " + TileBoard[j][i].toString() + " ] ";
                }
            }
            userBoard = userBoard + "  " + i + "\n";
        }
        return userBoard;
    }

    public String toString(){ //visual representation of board here
        return printUserBoard();
    }

}
