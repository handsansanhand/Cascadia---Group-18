/*
Student Number - Name - Github ID
21467574 - Jack Wright - #102315833
21447182 - Jack Neilan - #102314039
21350866 - Trystan Rothery - #102313516
*/

package currentCode;

import java.util.Random;

public class Bot extends player{



    public Bot(String x, int i) {
        super(x, i);
        // TODO Auto-generated constructor stub
    }

    public int Makemove() {
        Random rand = new Random();
        int randTileIndex = rand.nextInt(4);
        return randTileIndex;

    }
    // *Do this function if the bots hand contains a Bear token to pair up, remove bear token from hand after*
    public void checkBearsAndPlace(tileBoard theBotsBoard) throws InterruptedException { // Takes in the bots board, scans through the board and places bear 
        for(int i=0;i<=tileBoard.BOARD_HEIGHT-1;i++){
            for(int j=0;j<=tileBoard.BOARD_WIDTH-1;j++) {
                if(theBotsBoard.TileBoard[i][j].token.animalType == tokenEnum.BEAR) { // Bear Scoring Card A move
                    if(theBotsBoard.TileBoard[i][j].up.token.animalType != tokenEnum.BEAR && theBotsBoard.TileBoard[i][j].down.token.animalType != tokenEnum.BEAR && theBotsBoard.TileBoard[i][j].left.token.animalType != tokenEnum.BEAR && theBotsBoard.TileBoard[i][j].right.token.animalType != tokenEnum.BEAR) {
                        if(theBotsBoard.TileBoard[i][j].up != null && theBotsBoard.TileBoard[i][j].up.token == null ){
                            gameState.placeWildlifeToken(new wildlifeToken(tokenEnum.BEAR), i);
                        }
                    }
                }
            }

        }
    }




    public static int[] makeMove1(tileBoard playerBoard, Tile t) {
        int x, y;
        Random rand = new Random();
        boolean isValid = false;

        while (!isValid) {
            // randomly generate x and y coordinates
            x = rand.nextInt(tileBoard.BOARD_WIDTH);
            y = rand.nextInt(tileBoard.BOARD_HEIGHT);
            if (playerBoard.canPlaceTile(x, y, t)) {
                isValid = true;
                return new int[] {x, y};
            }
            // check if the tile can be placed in this position

        }

        return null;
    }


    public static boolean makeMove2() {
        // TODO Auto-generated method stub
        return Math.random() < 0.5;
    }

}
