import java.util.ArrayList;

public class Tile { // class for the tiles that will be inserted onto the board
    ArrayList<Tile> starterTiles = new ArrayList<>();
    ht landType;
    ht landType2;
    Tile(ht landType, ht landType2){
        this.landType2 = landType2;
        this.landType = landType;
    }

    public ArrayList<Tile> getStarterTiles() {
        return starterTiles;
    }

    public static Tile randomTile(){ //returns a tile object of random habitat tile
        switch((int) Math.round(Math.random()*4)){
            case 0:
                switch((int) Math.round(Math.random()*4)){
                    case 0:
                        return new Tile(ht.Mountain, null);
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
                        return new Tile(ht.Forest, null);
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
                        return new Tile(ht.Prairie, null);
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
                        return new Tile(ht.Wetland, null);
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
                        return new Tile(ht.River, null);
                    default:
                        return new Tile(ht.Error, ht.Error);
                }
            default:
                return new Tile(ht.Error, ht.Error);
        }
    }
    public ht getLandType(){
        return landType;
    }
    public String toString()
    {
        return getLandType().toString();
    }

}
