public class Tile { // class for the tiles that will be inserted onto the board
    ht ht1;
    ht ht2;
    public Tile(int habitat1, int habitat2) //the numbers will be random
    {

        this.ht1 = setTile(habitat1, ht1);
        this.ht2 = setTile(habitat2, ht2);
    }

    public ht setTile(int tileNum, ht assignedHabitat)
    {
        switch (tileNum)
        {
            case 0:
                assignedHabitat = ht.Forest;
                break;
            case 1:
                assignedHabitat = ht.Wetland;
                break;
            case 2:
                assignedHabitat = ht.River;
                break;
            case 3:
                assignedHabitat = ht.Mountain;
                break;
            case 4:
                assignedHabitat = ht.Prairie;
                break;
        }
        return assignedHabitat;
    }

    public String toString() //to display the tiles for now
    {
        return "[" + ht1.toString() + " " + ht2.toString() + "]";
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
