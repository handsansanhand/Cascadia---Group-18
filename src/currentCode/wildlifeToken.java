package currentCode;

import java.util.ArrayList;
import java.util.Collections;

public class wildlifeToken {

    int bagOfWildlifeTokens=100;
    tokenEnum animalType;
    wildlifeToken(tokenEnum animalType){
        this.animalType = animalType;
    }

   /* public static wildlifeToken generateWildlifeToken(){ //returns a tile object of random habitat tile
        /*
        switch((int) Math.round(Math.random()*4)){
            case 0:
                return new wildlifeToken(tokenEnum.HAWK);
            case 1:
                return new wildlifeToken(tokenEnum.BEAR);
            case 2:
                return new wildlifeToken(tokenEnum.ELK);
            case 3:
                return new wildlifeToken(tokenEnum.SALMON);
            default:
                return new wildlifeToken(tokenEnum.FOX);
        }
    }*/
    public static ArrayList<wildlifeToken> makeWildlifeTokenBag()
    {
        ArrayList<wildlifeToken> WildlifeTokenBag = new ArrayList<>();
        int count=0;

        while(count<20)
        {
            WildlifeTokenBag.add(new wildlifeToken(tokenEnum.BEAR));
            count++;
        }
        while(count<40)
        {
            WildlifeTokenBag.add(new wildlifeToken(tokenEnum.ELK));
            count++;
        }
        while(count<60)
        {
            WildlifeTokenBag.add(new wildlifeToken(tokenEnum.HAWK));
            count++;
        }
        while(count<80)
        {
            WildlifeTokenBag.add(new wildlifeToken(tokenEnum.FOX));
            count++;
        }
        while(count<100)
        {
            WildlifeTokenBag.add(new wildlifeToken(tokenEnum.SALMON));
            count++;
        }
        Collections.shuffle(WildlifeTokenBag);
        return WildlifeTokenBag;
    }
    public tokenEnum getAnimalType(){
        return animalType;
    }

    public String colorToString()
    {
        return Tile.getAnimalColor(animalType) + animalType + Tile.RESET;
    }
    
    public String toString()
    {
        String returnString;
        switch (getAnimalType())
        {
            case ELK -> returnString="ELK";
            case HAWK -> returnString="HAWK";
            case FOX -> returnString="FOX";
            case SALMON -> returnString="SALMON";
            default -> returnString = "BEAR";
        }
        return returnString;
    }
}
