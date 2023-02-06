//class that contains players names, their score and if it's their turn

public class players {

    String name;
    int score;

    public players(String x)
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
