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
