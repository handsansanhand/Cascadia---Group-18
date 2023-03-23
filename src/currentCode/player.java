package currentCode;

import java.util.ArrayList;

//THIS CLASS IS FOR EACH INDIVIDUAL PLAYER, THEIR NAME SCORE, 'HAND' AND THEIR OWN BOARD
//EACH 'PLAYER' HAS THEIR OWN 'BOARD' CLASS TO PLACE THEIR HABITAT TILES
public class player {
    public tileBoard getPlayerBoard() { // return visual representation of board
        return playerBoard;
    }

    ArrayList<wildlifeToken> hand = new ArrayList<>();
    Tile handTile;

    public String getHandTile() {
        return handTile.toString();
    }

    public void addToken(wildlifeToken x){
        hand.add(x);
    }
    int turnCount=0;
    static String name;
    int score;
    tileBoard playerBoard;
    int natureTokens=1; //nature tokens
    public player(String x, int i)
    {
        this.name = x;
        this.score = 0;
        this.playerBoard = new tileBoard(i);

    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    public String toString()
    {
        return playerBoard.toString();
    }
    public String printHand() //function for printing the hand the user has (wildlifetokens)
    {
        if (hand.get(0) != null) {
            return "" + name + "'s Hand: [" + Tile.getAnimalColor(hand.get(0).getAnimalType()) + hand.get(0).animalType.toString() + Tile.RESET + "]";
        }
        return "Hand is empty";
    }

}
