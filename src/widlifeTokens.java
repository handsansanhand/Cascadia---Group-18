public class widlifeTokens {

    wT animalType;
    widlifeTokens(wT animalType){
        this.animalType = animalType;
    }

    public static widlifeTokens generateWildlifeToken(){ //returns a tile object of random habitat tile
        switch((int) Math.round(Math.random()*4)){
            case 0:
                return new widlifeTokens(wT.HAWK);
            case 1:
                return new widlifeTokens(wT.BEAR);
            case 2:
                return new widlifeTokens(wT.ELK);
            case 3:
                return new widlifeTokens(wT.SALMON);
            case 4:
                return new widlifeTokens(wT.FOX);
            default:
                return new widlifeTokens(wT.ERROR);
        }
    }
    public wT getAnimalType(){
        return animalType;
    }
}
