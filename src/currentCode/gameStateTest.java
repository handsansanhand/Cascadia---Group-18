/*
Student Number - Name - Github ID
21467574 - Jack Wright - #102315833
21447182 - Jack Neilan - #102314039
21350866 - Trystan Rothery - #102313516
*/

package currentCode;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class gameStateTest {

    @Test
    public void testPlayerToString()
    {
        player x = new player("Bob", 0);
        player y = new player("Steve", 0);

        assertEquals("Bob", x.name);
        assertEquals("Steve", y.name);
    }

    @Test
    public void testPlacing()
    {
        player x = new player("Bob", 0);
        //add a keystone tile to the board
        Tile tile = new Tile(habitatEnum.Forest, habitatEnum.Empty);
        tokenEnum token = tile.animal1;
        wildlifeToken wT = new wildlifeToken(token);

        try{
            x.getPlayerBoard().TileBoard[1][1] = tile;
            x.getPlayerBoard().TileBoard[1][1].token=wT;

            assertEquals(x.getPlayerBoard().TileBoard[1][1].token,wT);
        }catch (IllegalArgumentException ex){
            System.out.println("error placing token");
        }

        //now try placing a token to a tile that isnt there
        try{
            tokenEnum token2 = tile.animal1;
            wildlifeToken wT2 = new wildlifeToken(token2);
            x.getPlayerBoard().TileBoard[1][2].token=wT2;
            fail();
        }catch (NullPointerException exception){
            System.out.println("That position is full, test passed");
        }
    }

    @Test
    public void testCulling()
    {
        wildlifeToken bearToken = new wildlifeToken(tokenEnum.BEAR);
        gameBoard gB = new gameBoard();
        player x = new player("Bob",0);
        //testing culling, set the board equal to all bears
        gB.boardWildlifeTokens.set(0,bearToken);
        gB.boardWildlifeTokens.set(1,bearToken);
        gB.boardWildlifeTokens.set(2,bearToken);
        gB.boardWildlifeTokens.set(3,bearToken);

       assertEquals(gB.countAnimals(tokenEnum.BEAR),4); //counts the max amount of animals in the board
        assertFalse(gB.checkForCull(x));
    }


}