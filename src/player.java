import java.util.ArrayList;

public class player {

    public Board getPlayerBoard() { // return visual representation of board
        return playerBoard;
    }

    ArrayList<wildlifeToken> hand = new ArrayList<>();
    public void addToken(wildlifeToken x){
        hand.add(x);
    }
    String name;
    int score;
    Board playerBoard;

    public player(String x, int i)
    {
        this.name = x;
        this.score = 0;
        this.playerBoard = new Board(i);

    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    public String toString()
    {
        return playerBoard.TileList.toString();
    }

}
