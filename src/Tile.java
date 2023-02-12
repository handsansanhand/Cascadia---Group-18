import java.util.ArrayList;

public class Tile { // class for the tiles that will be inserted onto the board
    ArrayList<Tile> starterTiles = new ArrayList<>();
    ht landType;
    ht landType2;
    wT animal1;
    wT animal2;
    wT animal3;

    Tile(ht landType, ht landType2) {
        if(landType2 != null){
            this.landType2 = landType2;
        }
        this.landType = landType;
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
    }

    public ArrayList<Tile> getStarterTiles() {
        return starterTiles;
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
    }
    public void addWildlifetoken(wildlifeToken x){

    }
    public ht getLandType(){
        return landType;
    }
    public ht getLandType2(){
        return landType2;
    }
    public String toString()
    {
        return getLandType().toString();
    }

}
