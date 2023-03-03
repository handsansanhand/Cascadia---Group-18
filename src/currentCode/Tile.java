package backupcode;

import java.util.ArrayList;

public class Tile { // class for the tiles that will be inserted onto the board
    static int count;
    Tile up,left,right,down; //points to the tiles above, below, to the left and to the right of the tile
    ht landType; //this should never be empty
    ht landType2; // if tile only has one land type this should be empty enum
    wT animal1;
    wT animal2;
    wT animal3;
    wildlifeToken token;
    boolean isKeystoneTile=false; //this is to check if a tile is a keystone tile (meaning if it has only one landType i.e: Mountain / Empty)
    public static void gameEnd(){
        switch(playing.playerCount){
            case 2:
                if(count >= 37 ){
                    System.out.println("Out of tiles");
                    //System.exit(0);
                }
                break;
            case 3:
                if(count >= 54 ){
                    System.out.println("Out of tiles");
                    //System.exit(0);
                }
                break;
            case 4:
                if(count >= 71 ){
                    System.out.println("Out of tiles");
                    //System.exit(0);
                }
                break;
        }
    }
    Tile(ht landType, ht landType2) {
        count++;
        this.landType2 = landType2;
        this.landType = landType;
        if(landType2==ht.Empty)
        {
            isKeystoneTile = true;
        }
        switch(landType) {
            case Mountain:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        animal1 = wT.BEAR;
                        break;
                    case 1:
                        animal1 = wT.HAWK;
                        break;
                    case 2:
                        animal1 = wT.ELK;
                        break;
                }
            case Forest:
                switch((int) Math.round(Math.random()*3)){
                    case 0:
                        animal1 = wT.BEAR;
                        break;
                    case 1:
                        animal1 = wT.HAWK;
                        break;
                    case 2:
                        animal1 = wT.ELK;
                        break;
                    case 3:
                        animal1 = wT.FOX;
                        break;
                }
            case Prairie:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        animal1 = wT.HAWK;
                        break;
                    case 1:
                        animal1 = wT.ELK;
                        break;
                    case 2:
                        animal1 = wT.FOX;
                        break;
                }
            case Wetland:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        animal1 = wT.SALMON;
                        break;
                    case 1:
                        animal1 = wT.HAWK;
                        break;
                    case 2:
                        animal1 = wT.FOX;
                        break;
                }
            case River:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        animal1 = wT.SALMON;
                        break;
                    case 1:
                        animal1 = wT.HAWK;
                        break;
                    case 2:
                        animal1 = wT.BEAR;
                        break;
                }

        }
        switch(landType2) {
            case Mountain:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != wT.BEAR){
                            animal2 = wT.BEAR;
                        }
                        break;
                    case 1:
                        if(animal1 != wT.HAWK){
                            animal2 = wT.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != wT.ELK){
                            animal2 = wT.ELK;
                        }
                        break;
                }
            case Forest:
                switch((int) Math.round(Math.random()*3)){
                    case 0:
                        if(animal1 != wT.BEAR){
                            animal2 = wT.BEAR;
                        }
                        break;
                    case 1:
                        if(animal1 != wT.HAWK){
                            animal2 = wT.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != wT.ELK){
                            animal2 = wT.ELK;
                        }
                        break;
                    case 3:
                        if(animal1 != wT.FOX){
                            animal2 = wT.FOX;
                        }
                        break;
                }
            case Prairie:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != wT.HAWK){
                            animal2 = wT.HAWK;
                        }
                        break;
                    case 1:
                        if(animal1 != wT.ELK){
                            animal2 = wT.ELK;
                        }
                        break;
                    case 2:
                        if(animal1 != wT.FOX){
                            animal2 = wT.FOX;
                        }
                        break;
                }
            case Wetland:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != wT.SALMON){
                            animal2 = wT.SALMON;
                        }
                        break;
                    case 1:
                        if(animal1 != wT.HAWK){
                            animal2 = wT.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != wT.FOX){
                            animal2 = wT.FOX;
                        }
                        break;
                }
            case River:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != wT.SALMON){
                            animal2 = wT.SALMON;
                        }
                        break;
                    case 1:
                        if(animal1 != wT.HAWK){
                            animal2 = wT.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != wT.BEAR){
                            animal2 = wT.BEAR;
                        }
                        break;
                }
            case Empty:
                break;

        }
        switch(landType) {
            case Mountain:
                switch((int) Math.round(Math.random()*5)){
                    case 0:
                        if(animal1 != wT.BEAR){
                            animal3 = wT.BEAR;
                        }
                        break;
                    case 1:
                        if(animal1 != wT.HAWK){
                            animal3 = wT.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != wT.ELK){
                            animal3 = wT.ELK;
                        }
                        break;
                    default:
                        break;
                }
            case Forest:
                switch((int) Math.round(Math.random()*7)){
                    case 0:
                        if(animal1 != wT.BEAR){
                            animal3 = wT.BEAR;
                        }
                        break;
                    case 1:
                        if(animal1 != wT.HAWK){
                            animal3 = wT.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != wT.ELK){
                            animal3 = wT.ELK;
                        }
                        break;
                    case 3:
                        if(animal1 != wT.FOX){
                            animal3 = wT.FOX;
                        }
                        break;
                    default:
                        break;
                }
            case Prairie:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != wT.HAWK){
                            animal3 = wT.HAWK;
                        }
                        break;
                    case 1:
                        if(animal1 != wT.ELK){
                            animal3 = wT.ELK;
                        }
                        break;
                    case 2:
                        if(animal1 != wT.FOX){
                            animal3 = wT.FOX;
                        }
                        break;
                }
            case Wetland:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != wT.SALMON){
                            animal3 = wT.SALMON;
                        }
                        break;
                    case 1:
                        if(animal1 != wT.HAWK){
                            animal3 = wT.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != wT.FOX){
                            animal3 = wT.FOX;
                        }
                        break;
                }
            case River:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        animal1 = wT.SALMON;
                        break;
                    case 1:
                        animal1 = wT.HAWK;
                        break;
                    case 2:
                        animal1 = wT.BEAR;
                        break;
                }

        }

    }
    public static Tile randomTile(){ //returns a tile object of random habitat tile
        switch((int) Math.round(Math.random()*4)){
            case 0:
                switch((int) Math.round(Math.random()*3)){
                    case 0:
                        return new Tile(ht.Mountain, ht.Empty);
                    case 1:
                        return new Tile(ht.Forest, ht.Mountain);
                    case 2:
                        return new Tile(ht.Prairie, ht.Mountain);
                    case 3:
                        return new Tile(ht.Wetland, ht.Mountain);
                    case 4:
                        return new Tile(ht.River, ht.Mountain);
                    default:
                        return new Tile(ht.Error, ht.Error);
                }
            case 1:
                switch((int) Math.round(Math.random()*4)){
                    case 0:
                        return new Tile(ht.Mountain, ht.Forest);
                    case 1:
                        return new Tile(ht.Forest, ht.Empty);
                    case 2:
                        return new Tile(ht.Prairie, ht.Forest);
                    case 3:
                        return new Tile(ht.Wetland, ht.Forest);
                    case 4:
                        return new Tile(ht.River, ht.Forest);
                    default:
                        return new Tile(ht.Error, ht.Error);
                }
            case 2:
                switch((int) Math.round(Math.random()*4)){
                    case 0:
                        return new Tile(ht.Mountain, ht.Prairie);
                    case 1:
                        return new Tile(ht.Forest, ht.Prairie);
                    case 2:
                        return new Tile(ht.Prairie, ht.Empty);
                    case 3:
                        return new Tile(ht.Wetland, ht.Prairie);
                    case 4:
                        return new Tile(ht.River, ht.Prairie);
                    default:
                        return new Tile(ht.Error, ht.Error);
                }
            case 3:
                switch((int) Math.round(Math.random()*4)){
                    case 0:
                        return new Tile(ht.Mountain, ht.Wetland);
                    case 1:
                        return new Tile(ht.Forest, ht.Wetland);
                    case 2:
                        return new Tile(ht.Prairie, ht.Wetland);
                    case 3:
                        return new Tile(ht.Wetland, ht.Empty);
                    case 4:
                        return new Tile(ht.River, ht.Wetland);
                    default:
                        return new Tile(ht.Error, ht.Error);
                }
            case 4:
                switch((int) Math.round(Math.random()*4)){
                    case 0:
                        return new Tile(ht.Mountain, ht.River);
                    case 1:
                        return new Tile(ht.Forest, ht.River);
                    case 2:
                        return new Tile(ht.Prairie, ht.River);
                    case 3:
                        return new Tile(ht.Wetland, ht.River);
                    case 4:
                        return new Tile(ht.River, ht.Empty);
                    default:
                        return new Tile(ht.Error, ht.Error);
                }
            default:
                return new Tile(ht.Error, ht.Error);
        }
        //check if its a keystoneTile

    }
    public void addWildlifetoken(wildlifeToken x){
        while(true){
            try{
                if(x.animalType == animal1 || x.animalType == animal2 || x.animalType == animal3){
                    token = x;
                    break;
                }
                else{
                    throw new IllegalArgumentException();
                }
            }catch (IllegalArgumentException ex){
                System.out.println("incorrect wildlife token please try again\n");
            }
        }
    }
    public ht getLandType(){
        return landType;
    }
    public ht getLandType2(){
        return landType2;
    }

    public String printTile()
    {
        String tileString = "";
        if(isKeystoneTile)
        {//check something that indicates that its a special tile ()
            tileString = "*" + getLandType().toString() + "*";
        }
        else {tileString = getLandType().toString() + " / " + getLandType2().toString();}
        if(token!=null)
        {
            tileString = tileString +  " ( " + token + " )";
        }
        return tileString;
    }
    public String toString()
    {
        String str1 = null,str2 = null;
        switch(landType){
            case Forest:
                str1 = "Forest";
                break;
            case Wetland:
                str1 = "Wetland";
                break;
            case River:
                str1 = "River";
                break;
            case Prairie:
                str1 = "Prairie";
                break;
            case Mountain:
                str1 = "Mountain";
                break;

        }
        switch(landType2){
            case Empty:
                str2 = "";
                break;
            case Forest:
                str2 = "Forest";
                break;
            case Wetland:
                str2 = "Wetland";
                break;
            case River:
                str2 = "River";
                break;
            case Prairie:
                str2 = "Prairie";
                break;
            case Mountain:
                str2 = "Mountain";
                break;
        }
        return str1 + " " + str2;
    }
}
