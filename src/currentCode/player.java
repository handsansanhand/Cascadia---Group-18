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
    String name;
    int score;
    tileBoard playerBoard;
    int natureTokens; //nature tokens
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
        String handString = "Hand: ";
        for(int i = 0;i< hand.size();i++)
        {
            handString = handString + "[(" + i + ")" + Tile.getAnimalColor(hand.get(i).getAnimalType()) + hand.get(i).animalType.toString() + Tile.RESET + "] , ";
        }
        return handString.substring(0, handString.length() - 2);
    }

}
