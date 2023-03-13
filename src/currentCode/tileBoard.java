package currentCode;

import java.util.Scanner;
//EACH 'BOARD' HOLDS AN ARRAYLIST OF TILES
public class tileBoard { // class for the board object for each player
//HEEEELELOO TOOOOOPOO SDDSADXDF
    final int BOARD_HEIGHT=15;
    final int BOARD_WIDTH=15;
    Tile[][] TileBoard = new Tile[BOARD_WIDTH][BOARD_HEIGHT];

    public void starterTiles() {
        //STARTER TILES ARE A FIXED 5 COMBINATION OF CERTAIN TILES?
        TileBoard[(BOARD_WIDTH / 2)][BOARD_HEIGHT / 2] = Tile.randomTile();
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) + 1] = Tile.randomTile();
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) - 1] = Tile.randomTile();
        TileBoard[(BOARD_WIDTH / 2)][BOARD_HEIGHT / 2].setTileCoordinates((BOARD_WIDTH / 2), (BOARD_HEIGHT / 2));

        //middle tile pointers
        TileBoard[(BOARD_WIDTH / 2)][BOARD_HEIGHT / 2].up = TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) + 1];
        TileBoard[(BOARD_WIDTH / 2)][BOARD_HEIGHT / 2].down = TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) - 1];
        TileBoard[(BOARD_WIDTH / 2)][BOARD_HEIGHT / 2].left = TileBoard[(BOARD_WIDTH / 2) + 1][(BOARD_HEIGHT / 2)];
        TileBoard[(BOARD_WIDTH / 2)][BOARD_HEIGHT / 2].right = TileBoard[(BOARD_WIDTH / 2) - 1][(BOARD_HEIGHT / 2)];

        //upper tile coordinates
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) + 1].setTileCoordinates((BOARD_WIDTH / 2), (BOARD_HEIGHT / 2) + 1);
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) + 1].up = TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) + 2];
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) + 1].down = TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2)];
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) + 1].left = TileBoard[(BOARD_WIDTH / 2) + 1][(BOARD_HEIGHT / 2) + 1];
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) + 1].right = TileBoard[(BOARD_WIDTH / 2) - 1][(BOARD_HEIGHT / 2) + 1];

        //lower tile coordinates
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) - 1].setTileCoordinates((BOARD_WIDTH / 2), (BOARD_HEIGHT / 2) - 1);
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) - 1].up = TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2)];
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) - 1].down = TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) - 2];
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) - 1].left = TileBoard[(BOARD_WIDTH / 2) + 1][(BOARD_HEIGHT / 2) - 1];
        TileBoard[(BOARD_WIDTH / 2)][(BOARD_HEIGHT / 2) - 1].right = TileBoard[(BOARD_WIDTH / 2) - 1][(BOARD_HEIGHT / 2) - 1];




    }

    public void printReference(Tile tile)
    {
        String returnString="";
        String tileRightString="";
        String tileLeftString="";
        String tileUpString="";
        String tileDownString="";
        if(tile.right == null)
        {tileRightString = tileRightString + "[("  + 3 + ")]";} else{tileRightString = tileRightString + "[" +tile.right+ "]";}
        if(tile.left == null)
        {tileLeftString = tileLeftString + "[("  + 4 + ")]";} else{tileLeftString = tileLeftString + "[" +tile.left+ "]";}
        if(tile.up == null)
        {tileUpString = tileUpString + "[("  + 1 + ")]";} else {tileUpString = tileUpString + "[" +tile.up+ "]";}
        if(tile.down == null)
        {tileDownString = tileDownString + "[("  + 2 + ")]";} else {tileDownString = tileDownString + "[" + tile.down + "]";}

        returnString = returnString + "      " + tileUpString + "\n";
        returnString = returnString + tileLeftString;
        returnString = returnString + " [" + tile + "] ";
        returnString = returnString + tileRightString;
        returnString = returnString + "\n       " + tileDownString;
        System.out.println(returnString);
    }
    public void addTile(Tile oldest, Tile newest) { // Tile newest is the one being placed and tile oldest is the reference tile
        int input;
        while (true) {
            System.out.println("Tile to be placed: " + newest);
            System.out.println("1 to place tile above\n2 to place tile below\n3 to place tile to the right\n4 to place tile to the left");
            System.out.println("Or press 0 to select a different tile");
            printReference(oldest);
            Scanner in = new Scanner(System.in);
            if (!in.hasNextInt()) {
                System.out.println("incorrect input please try again\n");
                in.next();
                continue;
            }
            input = in.nextInt();
            while (input > 5 || input < 0) {
                System.out.println("incorrect input please try again\n");
                continue;
            }
            switch (input) {
                case 0:
                {
                    System.out.println("Enter the x and y coordinates of the tile you want to select (e.g. 2,3):");
                    String inp = in.next();
                    String[] numbers = inp.split(",");
                    int x = Integer.parseInt(numbers[0].trim());
                    int y = Integer.parseInt(numbers[1].trim());
                    if (TileBoard[x][y] == null) {
                        System.out.println("No tile found at coordinates (" + x + ", " + y + ")");
                        continue;
                    }
                    oldest = TileBoard[x][y];
                    break;
                }
                case 1:
                    if (oldest.up != null) {
                        System.out.println("That position is filled\n");
                        continue;
                    }
                        oldest.up = newest;
                        newest.down = oldest;
                        TileBoard[oldest.x][oldest.y+1] = newest;
                        newest.setTileCoordinates(oldest.x, oldest.y + 1);
                        return;

                case 2:
                    if (oldest.down != null) {
                        System.out.println("That position is filled\n");
                        continue;
                    }
                        oldest.down = newest;
                        newest.up = oldest;
                        TileBoard[oldest.x][oldest.y - 1] = newest;
                        newest.setTileCoordinates(oldest.x, oldest.y - 1);
                        return;

                case 3:
                    if (oldest.left != null) {
                        System.out.println("That position is filled\n");
                        continue;
                    }
                        oldest.left = newest;
                        newest.right = oldest;
                        TileBoard[oldest.x-1][oldest.y] = newest;
                        newest.setTileCoordinates(oldest.x - 1, oldest.y);
                        return;

                case 4:
                    if (oldest.right != null) {
                        System.out.println("That position is filled\n");
                        continue;
                    }
                        oldest.right = newest;
                        newest.left = oldest;
                        TileBoard[oldest.x + 1][oldest.y] = newest;
                        newest.setTileCoordinates(oldest.x + 1, oldest.y);
                        return;

                default:
                    System.out.println("incorrect input please try again\n");
                    break;
            }
        }
    }
    public tileBoard(int num) //3 random starter tiles created in middle, up, down positions on the board
    {
        starterTiles();
    }

    public Tile getTile(int x, int y) {
        return TileBoard[x][y];
    }
    public Tile[][] getTileBoard() {
        return TileBoard;
    }

    public String printUserBoard() {
        String userBoard = "";
        System.out.println("Your Board:");
        for (int i = BOARD_HEIGHT-1; i>=0; i--) //TILEBOARD.LENGTH = HEIGHT // TILEBOARD[0].LENGTH = WIDTH
        {
            for (int j = BOARD_WIDTH-1; j >= 0; j--) {
                if (TileBoard[j][i] == null) {
                    userBoard = userBoard + "\u001B[30m" + String.format("[ %5s ]", "EMPTY") + "\u001B[0m";
                } else {
                    userBoard = userBoard + String.format("[%-25s]", TileBoard[j][i].toString());
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
