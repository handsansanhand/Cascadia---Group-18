public class Tile { // class for the tiles that will be inserted onto the board


    ht landType;
    Tile(ht landType){
        this.landType = landType;
    }
    public Tile starterTiles(){ //returns a tile object of random habitat tile
        switch((int) Math.round(Math.random()*4)){
            case 0:
                return new Tile(ht.Mountain);
            case 1:
                return new Tile(ht.Forest);
            case 2:
                return new Tile(ht.Prairie);
            case 3:
                return new Tile(ht.Wetland);
            case 4:
                return new Tile(ht.River);
            default:
                return new Tile(ht.Error);
        }
    }
}
