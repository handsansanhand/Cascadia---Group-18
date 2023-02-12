public class wildlifeToken {

    wT animalType;
    wildlifeToken(wT animalType){
        this.animalType = animalType;
    }

    public static wildlifeToken generateWildlifeToken(){ //returns a tile object of random habitat tile
        switch((int) Math.round(Math.random()*4)){
            case 0:
                return new wildlifeToken(wT.HAWK);
            case 1:
                return new wildlifeToken(wT.BEAR);
            case 2:
                return new wildlifeToken(wT.ELK);
            case 3:
                return new wildlifeToken(wT.SALMON);
            case 4:
                return new wildlifeToken(wT.FOX);
            default:
                return new wildlifeToken(wT.ERROR);
        }
    }
    public wT getAnimalType(){
        return animalType;
    }
}
