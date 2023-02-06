public class player {
    Board playerBoard = new Board();

    public Board getPlayerBoard() { // return visual representation of board
        return playerBoard;
    }

    String name;
    int score;

    public player(String x)
    {
        this.name = x;
        this.score = 0;
    }


    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }


}
