/*
Student Number - Name - Github ID
21467574 - Jack Wright - #102315833
21447182 - Jack Neilan - #102314039
21350866 - Trystan Rothery - #102313516
*/

package currentCode;

import java.util.ArrayList;
import java.util.Comparator;

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
        if (hand.get(0) != null) {
            return "" + name + "'s Hand: [" + Tile.getAnimalColor(hand.get(0).getAnimalType()) + hand.get(0).animalType.toString() + Tile.RESET + "]";
        }
        return "Hand is empty";
    }

}
class PlayerComparator implements Comparator<player> {  //player comparator, used for sorting the score
    /*
Student Number - Name - Github ID
21467574 - Jack Wright - #102315833
21447182 - Jack Neilan - #102314039
21350866 - Trystan Rothery - #102313516
*/
    @Override
    public int compare(player o1, player o2) {
        return o2.getScore() - o1.getScore();
    }
}
