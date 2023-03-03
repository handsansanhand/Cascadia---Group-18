package player;


public class Tile { // class for the tiles that will be inserted onto the board
    static int count;
    public int x,y;
    Tile up,left,right,down; //points to the tiles above, below, to the left and to the right of the tile
    habitatEnum landType;
    habitatEnum landType2;
    tokenEnum animal1;
    tokenEnum animal2;
    tokenEnum animal3;
 //   wildlifeToken token;
    boolean isKeystoneTile=false; //this is to check if a tile is a keystone tile (meaning if it has only one landType i.e: Mountain / Empty)
    
    Tile(habitatEnum landType, habitatEnum landType2) {
        count++;
        this.landType2 = landType2;
        this.landType = landType;
        if(landType2==habitatEnum.Empty)
        {
            isKeystoneTile = true;
        }
        switch(landType) {
            case Mountain:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        animal1 = tokenEnum.BEAR;
                        break;
                    case 1:
                        animal1 = tokenEnum.HAWK;
                        break;
                    case 2:
                        animal1 = tokenEnum.ELK;
                        break;
                }
            case Forest:
                switch((int) Math.round(Math.random()*3)){
                    case 0:
                        animal1 = tokenEnum.BEAR;
                        break;
                    case 1:
                        animal1 = tokenEnum.HAWK;
                        break;
                    case 2:
                        animal1 = tokenEnum.ELK;
                        break;
                    case 3:
                        animal1 = tokenEnum.FOX;
                        break;
                }
            case Prairie:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        animal1 = tokenEnum.HAWK;
                        break;
                    case 1:
                        animal1 = tokenEnum.ELK;
                        break;
                    case 2:
                        animal1 = tokenEnum.FOX;
                        break;
                }
            case Wetland:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        animal1 = tokenEnum.SALMON;
                        break;
                    case 1:
                        animal1 = tokenEnum.HAWK;
                        break;
                    case 2:
                        animal1 = tokenEnum.FOX;
                        break;
                }
            case River:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        animal1 = tokenEnum.SALMON;
                        break;
                    case 1:
                        animal1 = tokenEnum.HAWK;
                        break;
                    case 2:
                        animal1 = tokenEnum.BEAR;
                        break;
                }

        }
        switch(landType2) {
            case Mountain:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != tokenEnum.BEAR){
                            animal2 = tokenEnum.BEAR;
                        }
                        break;
                    case 1:
                        if(animal1 != tokenEnum.HAWK){
                            animal2 = tokenEnum.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != tokenEnum.ELK){
                            animal2 = tokenEnum.ELK;
                        }
                        break;
                }
            case Forest:
                switch((int) Math.round(Math.random()*3)){
                    case 0:
                        if(animal1 != tokenEnum.BEAR){
                            animal2 = tokenEnum.BEAR;
                        }
                        break;
                    case 1:
                        if(animal1 != tokenEnum.HAWK){
                            animal2 = tokenEnum.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != tokenEnum.ELK){
                            animal2 = tokenEnum.ELK;
                        }
                        break;
                    case 3:
                        if(animal1 != tokenEnum.FOX){
                            animal2 = tokenEnum.FOX;
                        }
                        break;
                }
            case Prairie:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != tokenEnum.HAWK){
                            animal2 = tokenEnum.HAWK;
                        }
                        break;
                    case 1:
                        if(animal1 != tokenEnum.ELK){
                            animal2 = tokenEnum.ELK;
                        }
                        break;
                    case 2:
                        if(animal1 != tokenEnum.FOX){
                            animal2 = tokenEnum.FOX;
                        }
                        break;
                }
            case Wetland:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != tokenEnum.SALMON){
                            animal2 = tokenEnum.SALMON;
                        }
                        break;
                    case 1:
                        if(animal1 != tokenEnum.HAWK){
                            animal2 = tokenEnum.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != tokenEnum.FOX){
                            animal2 = tokenEnum.FOX;
                        }
                        break;
                }
            case River:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != tokenEnum.SALMON){
                            animal2 = tokenEnum.SALMON;
                        }
                        break;
                    case 1:
                        if(animal1 != tokenEnum.HAWK){
                            animal2 = tokenEnum.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != tokenEnum.BEAR){
                            animal2 = tokenEnum.BEAR;
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
                        if(animal1 != tokenEnum.BEAR){
                            animal3 = tokenEnum.BEAR;
                        }
                        break;
                    case 1:
                        if(animal1 != tokenEnum.HAWK){
                            animal3 = tokenEnum.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != tokenEnum.ELK){
                            animal3 = tokenEnum.ELK;
                        }
                        break;
                    default:
                        break;
                }
            case Forest:
                switch((int) Math.round(Math.random()*7)){
                    case 0:
                        if(animal1 != tokenEnum.BEAR){
                            animal3 = tokenEnum.BEAR;
                        }
                        break;
                    case 1:
                        if(animal1 != tokenEnum.HAWK){
                            animal3 = tokenEnum.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != tokenEnum.ELK){
                            animal3 = tokenEnum.ELK;
                        }
                        break;
                    case 3:
                        if(animal1 != tokenEnum.FOX){
                            animal3 = tokenEnum.FOX;
                        }
                        break;
                    default:
                        break;
                }
            case Prairie:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != tokenEnum.HAWK){
                            animal3 = tokenEnum.HAWK;
                        }
                        break;
                    case 1:
                        if(animal1 != tokenEnum.ELK){
                            animal3 = tokenEnum.ELK;
                        }
                        break;
                    case 2:
                        if(animal1 != tokenEnum.FOX){
                            animal3 = tokenEnum.FOX;
                        }
                        break;
                }
            case Wetland:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        if(animal1 != tokenEnum.SALMON){
                            animal3 = tokenEnum.SALMON;
                        }
                        break;
                    case 1:
                        if(animal1 != tokenEnum.HAWK){
                            animal3 = tokenEnum.HAWK;
                        }
                        break;
                    case 2:
                        if(animal1 != tokenEnum.FOX){
                            animal3 = tokenEnum.FOX;
                        }
                        break;
                }
            case River:
                switch((int) Math.round(Math.random()*2)){
                    case 0:
                        animal1 = tokenEnum.SALMON;
                        break;
                    case 1:
                        animal1 = tokenEnum.HAWK;
                        break;
                    case 2:
                        animal1 = tokenEnum.BEAR;
                        break;
                }

        }

    }
    public static Tile randomTile(){ //returns a tile object of random habitat tile
        switch((int) Math.round(Math.random()*4)){
            case 0:
                switch((int) Math.round(Math.random()*3)){
                    case 0:
                        return new Tile(habitatEnum.Mountain, habitatEnum.Empty);
                    case 1:
                        return new Tile(habitatEnum.Forest, habitatEnum.Mountain);
                    case 2:
                        return new Tile(habitatEnum.Prairie, habitatEnum.Mountain);
                    case 3:
                        return new Tile(habitatEnum.Wetland, habitatEnum.Mountain);
                    case 4:
                        return new Tile(habitatEnum.River, habitatEnum.Mountain);
                    default:
                        return new Tile(habitatEnum.Error, habitatEnum.Error);
                }
            case 1:
                switch((int) Math.round(Math.random()*4)){
                    case 0:
                        return new Tile(habitatEnum.Mountain, habitatEnum.Forest);
                    case 1:
                        return new Tile(habitatEnum.Forest, habitatEnum.Empty);
                    case 2:
                        return new Tile(habitatEnum.Prairie, habitatEnum.Forest);
                    case 3:
                        return new Tile(habitatEnum.Wetland, habitatEnum.Forest);
                    case 4:
                        return new Tile(habitatEnum.River, habitatEnum.Forest);
                    default:
                        return new Tile(habitatEnum.Error, habitatEnum.Error);
                }
            case 2:
                switch((int) Math.round(Math.random()*4)){
                    case 0:
                        return new Tile(habitatEnum.Mountain, habitatEnum.Prairie);
                    case 1:
                        return new Tile(habitatEnum.Forest, habitatEnum.Prairie);
                    case 2:
                        return new Tile(habitatEnum.Prairie, habitatEnum.Empty);
                    case 3:
                        return new Tile(habitatEnum.Wetland, habitatEnum.Prairie);
                    case 4:
                        return new Tile(habitatEnum.River, habitatEnum.Prairie);
                    default:
                        return new Tile(habitatEnum.Error, habitatEnum.Error);
                }
            case 3:
                switch((int) Math.round(Math.random()*4)){
                    case 0:
                        return new Tile(habitatEnum.Mountain, habitatEnum.Wetland);
                    case 1:
                        return new Tile(habitatEnum.Forest, habitatEnum.Wetland);
                    case 2:
                        return new Tile(habitatEnum.Prairie, habitatEnum.Wetland);
                    case 3:
                        return new Tile(habitatEnum.Wetland, habitatEnum.Empty);
                    case 4:
                        return new Tile(habitatEnum.River, habitatEnum.Wetland);
                    default:
                        return new Tile(habitatEnum.Error, habitatEnum.Error);
                }
            case 4:
                switch((int) Math.round(Math.random()*4)){
                    case 0:
                        return new Tile(habitatEnum.Mountain, habitatEnum.River);
                    case 1:
                        return new Tile(habitatEnum.Forest, habitatEnum.River);
                    case 2:
                        return new Tile(habitatEnum.Prairie, habitatEnum.River);
                    case 3:
                        return new Tile(habitatEnum.Wetland, habitatEnum.River);
                    case 4:
                        return new Tile(habitatEnum.River, habitatEnum.Empty);
                    default:
                        return new Tile(habitatEnum.Error, habitatEnum.Error);
                }
            default:
                return new Tile(habitatEnum.Error, habitatEnum.Error);
        }


    }
    public void setTileCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }




    public habitatEnum getLandType(){
        return landType;
    }
    public habitatEnum getLandType2(){
        return landType2;
    }
    @Override
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
    


