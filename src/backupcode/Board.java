package backupcode;

import java.util.ArrayList;
import java.util.Scanner;
//EACH 'BOARD' HOLDS AN ARRAYLIST OF TILES
public class Board { // class for the board object for each player
    ArrayList<Tile> TileList = new ArrayList<Tile>();
    Tile[][] TileBoard = new Tile[30][30];
    public void starterTiles(){
        //STARTER TILES ARE A FIXED 5 COMBINATION OF CERTAIN TILES

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
        TileList.add(newest);
    }

    public Board(int num) //3 random starter tiles created in middle, up, down positions on the board
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
