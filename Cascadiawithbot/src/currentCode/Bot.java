/*
Student Number - Name - Github ID
21467574 - Jack Wright - #102315833
21447182 - Jack Neilan - #102314039
21350866 - Trystan Rothery - #102313516
*/

package currentCode;

import java.util.Random;
import java.util.*;

public class Bot extends player{
    static   int index=0;
    public  static HashMap<Integer,Integer> gg = new HashMap<Integer,Integer>();

    public static int bonus = 0;



    public Bot(String x, int i) {
        super(x, i);
        // TODO Auto-generated constructor stub
    }

    public static int[] makeMove1(tileBoard board, Tile tile) {
        int[] move = new int[2];
        ArrayList<Tile> tileList = new ArrayList<>();
        for (int i = 0; i < tileBoard.BOARD_WIDTH; i++) {
            for (int j = 0; j < tileBoard.BOARD_HEIGHT; j++) {
                Tile t = board.getTile(i, j);
                if (t != null && (t.up == null || t.down == null || t.left == null || t.right == null)) {
                    tileList.add(t);
                }
            }
        }
        if (tileList.size() == 0) {
            move[0] = tileBoard.BOARD_WIDTH / 2;
            move[1] = tileBoard.BOARD_HEIGHT / 2;
        } else {
            Tile refTile = tileList.get((int) (Math.random() * tileList.size()));
            move[0] = refTile.x;
            move[1] = refTile.y;
        }
        return move;
    }

        private static int minimax(tileBoard board, Tile tile, boolean maximizingPlayer) {



        if (maximizingPlayer) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < tileBoard.BOARD_WIDTH; i++) {
                for (int j = 0; j < tileBoard.BOARD_HEIGHT; j++) {
                    Tile t = board.getTile(i, j);
                    if (t != null && (t.up == null || t.down == null || t.left == null || t.right == null)) {
                        int[] move = {i, j};
                        int score = evaluateMove(board, tile, move);
                        board.placeTile(tile, i, j);
                        score += minimax(board, tile, false);
                        board.removeTile(i, j);
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
            return bestScore;
        } else {
            int worstScore = Integer.MAX_VALUE;
            for (int i = 0; i < tileBoard.BOARD_WIDTH; i++) {
                for (int j = 0; j < tileBoard.BOARD_HEIGHT; j++) {
                    Tile t = board.getTile(i, j);
                    if (t != null && (t.up == null || t.down == null || t.left == null || t.right == null)) {
                        int[] move = {i, j};
                        int score = evaluateMove(board, tile, move);
                        board.placeTile(tile, i, j);
                        score += minimax(board, tile, true);
                        board.removeTile(i, j);
                        worstScore = Math.min(worstScore, score);
                    }
                }
            }
            return worstScore;
        }
    }

    private static int evaluateMove(tileBoard board, Tile tile, int[] move) {
        int score = 0;
        ScoringCard gg = new ScoringCard(1); player pp = new player("bot", 1);
        score += gg.calculateCardScore(pp);
        score += gg.calculateCardScore(pp);
        score += gg.calculateCardScore(pp);
        return score;
    }



    public static void addtomap(int i, int j) {

        gg.put(i, j);

    }

    public static int calculateBonus(Tile tile, wildlifeToken tokenToPlace, player player) {
        return bonus;
    }


    public int Makemove() {
        Random rand = new Random();
        int randTileIndex = rand.nextInt(4);
        return randTileIndex;

    }
    // *Do this function if the bots hand contains a Bear token to pair up, remove bear token from hand after*


    public static boolean makeMove2(tileBoard playerBoard, String score) {
        // TODO Auto-generated method stub
        return Math.random() < 0.5;
    }





    public static boolean makeMove2() {
        // TODO Auto-generated method stub
        return Math.random() < 0.5;
    }

}
