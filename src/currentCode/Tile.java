package currentCode;

public class Tile { // class for the tiles that will be inserted onto the board
    public static final String RESET = "\033[0m";

    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN (forest)
    public static final String LIGHT_GREEN = "\u001B[92m";   // GREEN (forest)
    public static final String YELLOW = "\033[0;33m";  // YELLOW (prairie?)
    public static final String BLUE = "\033[0;34m";    // BLUE (rivers)
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN (wetlands)
    public static final String WHITE = "\033[0;37m";   // WHITE (mountains)
    public static final String BROWN = "\u001B[33m";   // WHITE (mountains)
    public static final String ORANGE = "\u001B[38;5;208m";   // WHITE (mountains)

    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    public static final String BOLD = "\u001B[1m";  // WHITE
    public static final String PINK = "\u001B[38;5;198m";  // pink?

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE



    static int count;
    public int x,y;
    Tile up,left,right,down; //points to the tiles above, below, to the left and to the right of the tile
    habitatEnum landType; //should never be empty
    habitatEnum landType2; //if only one habitat type should be empty
    tokenEnum animal1;
    tokenEnum animal2;
    tokenEnum animal3;
    wildlifeToken token;
    boolean isKeystoneTile=false; //this is to check if a tile is a keystone tile (meaning if it has only one landType i.e: Mountain / Empty)
    public static void gameEnd(){
        switch(gameState.playerCount){
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
        if(isKeystoneTile)
        {
            animal2 =null;
            animal3 = null;
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
    public void addWildlifetoken(wildlifeToken x){
                if (x.animalType == animal1 || x.animalType == animal2 || x.animalType == animal3) {
                    token = x;
                    return;
                } else {
                    throw new IllegalArgumentException();
                }
        }


    public wildlifeToken getToken() {
        return token;
    }

    public habitatEnum getLandType(){
        return landType;
    }
    public habitatEnum getLandType2(){
        return landType2;
    }

    public String printTile()
    {
        String tileString = "";
        String animals = "";
        animals = animals + animal1;
        if (animal2 != null && !animal2.equals(animal1)) {
            animals = animals + "/" + animal2;
        }
        if (animal3 != null && !animal3.equals(animal1) && !animal3.equals(animal2)) {
            animals = animals + "/" + animal3;
        }
        if (isKeystoneTile) {//check something that indicates that its a special tile ()
            if (token != null) { //filled keystone tile
                tileString = "*" + getLandType().toString() + "*" + "\033[32m" + " [" + token + "]" + "\033[0m";
            } else //empty keystone tile
            {
                tileString = "*" + getLandType().toString() + "*" + " [" + animals + "]";
            }
        } else //not a keystone tile
        {
            if (token != null) //and filled with token
            {
                tileString = getLandType().toString() + " / " + getLandType2().toString() + "\033[32m" + "[" + token + "]" + "\033[0m";
            } else //empty non keystone tile
            {
                tileString = getLandType().toString() + " / " + getLandType2().toString() + " [" + animals + "]";
            }
        }
        return tileString;
    }

    public static String getHabitatColor(habitatEnum habitat)
    {
        String returnString="";
        switch (habitat)
        {
            case River -> returnString=BLUE;
            case Forest -> returnString=GREEN;
            case Prairie -> returnString=YELLOW;
            case Mountain -> returnString=WHITE;
            case Wetland -> returnString=CYAN;
        }
        return returnString;
    }
    public static String getAnimalColor(tokenEnum animal)
    {
        String returnString="";
        switch (animal)
        {
            case BEAR -> returnString=BOLD+BROWN;
            case HAWK -> returnString=RED_BOLD;
            case ELK -> returnString=BOLD + LIGHT_GREEN;
            case SALMON -> returnString=BOLD + PINK;
            case FOX -> returnString=BOLD + ORANGE;
        }
        return returnString;
    }
    public String toString() {
        String tileString = "";
        String animals = "";
        animals = animals + getAnimalColor(animal1) + animal1 + RESET;
        if (animal2 != null && !animal2.equals(animal1)) {
            animals = animals + "/" + getAnimalColor(animal2) + animal2 + RESET;
        }
        if (animal3 != null && !animal3.equals(animal1) && !animal3.equals(animal2)) {
            animals = animals + "/" + getAnimalColor(animal3) + animal3 + RESET;
        }
        if (isKeystoneTile) {//check something that indicates that its a special tile ()
            if (token != null) { //filled keystone tile
                tileString = "*" + getHabitatColor(getLandType()) + getLandType().toString() + RESET + "*" + GREEN_BOLD + " [" + token + "]" + RESET;
            } else //empty keystone tile
            {
                tileString = "*" + getHabitatColor(getLandType()) + getLandType().toString() + RESET + "*" + " [" + animals + "]";
            }
        } else //not a keystone tile
        {
            if (token != null) //and filled with token
            {
                tileString = getHabitatColor(getLandType()) + getLandType().toString() + RESET + "\033[32m" + "[" + token + "]" + "\033[0m" + getHabitatColor(getLandType2()) + getLandType2().toString() + RESET;
            } else //empty non keystone tile
            {
                tileString = getHabitatColor(getLandType()) + getLandType().toString() + RESET + " [" + animals + "] " + getHabitatColor(getLandType2()) + getLandType2().toString() + RESET;
            }
        }
        return tileString;
    }
    public static void rotateTile(Tile tile)
    {
        habitatEnum tmp;
        tmp = tile.landType;
        tile.landType = tile.landType2;
        tile.landType2 = tmp;
    }

        public String uiPrintTIle()
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




