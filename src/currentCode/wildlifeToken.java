package currentCode;

public class wildlifeToken {


    tokenEnum animalType;
    wildlifeToken(tokenEnum animalType){
        this.animalType = animalType;
    }

    public static wildlifeToken generateWildlifeToken(){ //generates random wildlife toke object
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
    }
    public tokenEnum getAnimalType(){
        return animalType;
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
