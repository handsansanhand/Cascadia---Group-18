package currentCode;
import java.util.ArrayList;
import java.util.Random;

public class ScoringCard{ // This is the class for a single Scoring Card object. We will need to initialise 5 of these objects and use the calculate function on each one to return the score
    int cardType; // variable to identify card type out of the 15 available
    /*
     * 0 = Bear A
     * 1 = Bear B
     * 2 = Fox A
     * 3 = Fox B
     * 4 = Elk A
     * 5 = Elk B
     * 6 = Hawk A
     * 7 = Hawk B
     * 8 = Salman A
     * 9 = Salman B
     * 10 = Bear C
     * 11 = Fox C
     * 12 = Elk C
     * 13 = Hawk C
     * 14 = Salmon C
     */
    ScoringCard(int cardType){
        this.cardType = cardType;
    }
    public static ScoringCard generateScoringCardBear(){
        Random rand = new Random();
        switch(rand.nextInt(3)){
            case 0:
            return new ScoringCard(0);
            case 1:
            return new ScoringCard(1);
            case 2:
            return new ScoringCard(10);
            default:
            return null;
        }
    }
    public static ScoringCard generateScoringCardFox(){
        Random rand = new Random();
        switch(rand.nextInt(3)){
            case 0:
            return new ScoringCard(2);
            case 1:
            return new ScoringCard(3);
            case 2:
            return new ScoringCard(11);
            default:
            return null;
        }
    }
    public static ScoringCard generateScoringCardElk(){
        Random rand = new Random();
        switch(rand.nextInt(3)){
            case 0:
            return new ScoringCard(4);
            case 1:
            return new ScoringCard(5);
            case 2:
            return new ScoringCard(12);
            default:
            return null;
        }
    }
    public static ScoringCard generateScoringCardHawk(){
        Random rand = new Random();
        switch(rand.nextInt(3)){
            case 0:
            return new ScoringCard(6);
            case 1:
            return new ScoringCard(7);
            case 2:
            return new ScoringCard(13);
            default:
            return null;
        }
    }
    public static ScoringCard generateScoringCardSalmon(){
        Random rand = new Random();
        switch(rand.nextInt(3)){
            case 0:
            return new ScoringCard(8);
            case 1:
            return new ScoringCard(9);
            case 2:
            return new ScoringCard(14);
            default:
            return null;
        }
    }
    public int helperGroupCheckBear(Tile x, tokenEnum animal, int y, int z, boolean[][] marked){ // Helper function for card type A to check if any of the surrounding tiles contains the animal. More than 2 of the type of animal is not considered a pair and are disqualifed from gaining points
        /* y
         * 0 = nothing
         * 1 = exclude up
         * 2 = exclude down
         * 3 = exclude left
         * 4 = exclude right
         */
        /* z
         * 0 = pairs
         * 1 = groups of three
         */
        marked[x.x][x.y]=true;
        int temp=0;
        if(y==0){
            if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                temp++;
            }
            if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                temp++;
            }
            if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal  && !marked[x.x][x.y+1]){
                temp++;
            }
            if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                temp++;
            }
        }
        else if(y==1){
            if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal  && !marked[x.x-1][x.y]){
                temp++;
            }
            if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                temp++;
            }
            if(x.right!=null && x.right.token!=null &&x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                temp++;
            }
        }
        else if(y==2){
            if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                temp++;
            }
            if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                temp++;
            }
            if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                temp++;
            }
        }
        else if(y==3){
            if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                temp++;
            }
            if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                temp++;
            }
            if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                temp++;
            }
        }
        else if(y==4){
            if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                temp++;
            }
            if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                temp++;
            }
            if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                temp++;
            }
        }
        
        if(z == 1){
            if(y==0){
                if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                    if(helperGroupCheckBear(x.up, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                    if(helperGroupCheckBear(x.down, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
        
                }
                else if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                    if(helperGroupCheckBear(x.left, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                    if(helperGroupCheckBear(x.right, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else{
                    return 0;
                }
            }
    
            if(y==1){
                if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                    if(helperGroupCheckBear(x.down, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
        
                }
                else if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                    if(helperGroupCheckBear(x.right, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                    if(helperGroupCheckBear(x.right, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else{
                    return 0;
                }
            }
            if(y==2){
                if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                    if(helperGroupCheckBear(x.up, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                    if(helperGroupCheckBear(x.left, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                    if(helperGroupCheckBear(x.right, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else{
                    return 0;
                }
            }
            if(y==3){
                if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                    if(helperGroupCheckBear(x.up, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                    if(helperGroupCheckBear(x.down, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
        
                }
                else if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                    if(helperGroupCheckBear(x.right, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else{
                    return 0;
                }
            }
            if(y==4){
                if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                    if(helperGroupCheckBear(x.up, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                    if(helperGroupCheckBear(x.down, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
        
                }
                else if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                    if(helperGroupCheckBear(x.left, animal, 2, 0,marked) == 1){
                        if(temp==1){
                            return 1;
                        }
                    }
                    if(temp==2){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else{
                    return 0;
                }
            }
            else{
                return 0;
            }
        }
        if(y==0){
            if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                if((x.down!=null && x.down.token!=null && x.down.token.animalType == animal) || (x.left!=null && x.left.token!=null && x.left.token.animalType == animal) || (x.right!=null && x.right.token!=null && x.right.token.animalType == animal)){
                    return 0;
                }
                if(helperGroupCheckBear(x.up, animal, 2, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                if((x.left!=null && x.left.token!=null && x.left.token.animalType == animal) || (x.right!=null && x.right.token!=null && x.right.token.animalType == animal)){
                    return 0;
                }
                if(helperGroupCheckBear(x.down, animal, 1 , 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
    
            }
            else if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.left, animal, 4, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                if(helperGroupCheckBear(x.right, animal, 3, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else{
                return 0;
            }
        }

        if(y==1){
            if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                if((x.left!=null && x.left.token!=null && x.left.token.animalType == animal) || (x.right!=null && x.right.token!=null && x.right.token.animalType == animal)){
                    return 0;
                }
                if(helperGroupCheckBear(x.down, animal, 1, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
    
            }
            else if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.left, animal, 4, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                if(helperGroupCheckBear(x.right, animal, 3, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else{
                return 0;
            }
        }
        if(y==2){
            if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                if((x.down!=null && x.down.token!=null && x.down.token.animalType == animal) || (x.left!=null && x.left.token!=null && x.left.token.animalType == animal || x.right.token.animalType == animal)){
                    return 0;
                }
                if(helperGroupCheckBear(x.up, animal, 2, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.left, animal, 4, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                if(helperGroupCheckBear(x.right, animal, 3, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else{
                return 0;
            }
        }
        if(y==3){
            if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                if((x.down!=null && x.down.token!=null && x.down.token.animalType == animal) || (x.left!=null && x.left.token!=null && x.left.token.animalType == animal) || (x.right!=null && x.right.token!=null && x.right.token.animalType == animal)){
                    return 0;
                }
                if(helperGroupCheckBear(x.up, animal, 2, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                if((x.left!=null && x.left.token!=null && x.left.token.animalType == animal) || (x.right!=null && x.right.token!=null && x.right.token.animalType == animal)){
                    return 0;
                }
                if(helperGroupCheckBear(x.down, animal, 1, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
    
            }
            else if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal && !marked[x.x][x.y-1]){
                if(helperGroupCheckBear(x.right, animal, 3, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else{
                return 0;
            }
        }
        if(y==4){
            if(x.up!=null && x.up.token!=null && x.up.token.animalType == animal && !marked[x.x+1][x.y]){
                if((x.down!=null && x.down.token!=null && x.down.token.animalType == animal) || (x.left!=null && x.left.token!=null && x.left.token.animalType == animal) || (x.right!=null && x.right.token!=null && x.right.token.animalType == animal)){
                    return 0;
                }
                if(helperGroupCheckBear(x.up, animal, 2, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.down!=null && x.down.token!=null && x.down.token.animalType == animal && !marked[x.x-1][x.y]){
                if((x.left!=null && x.left.token!=null && x.left.token.animalType == animal) || (x.right!=null && x.right.token!=null && x.right.token.animalType == animal)){
                    return 0;
                }
                if(helperGroupCheckBear(x.down, animal, 1, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
    
            }
            else if(x.left!=null && x.left.token!=null && x.left.token.animalType == animal && !marked[x.x][x.y+1]){
                if(x.right!=null && x.right.token!=null && x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.left, animal, 4, 0,marked) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }


    public int calculateCardScore(player user){
        int bear=0,fox=0,elk=0,hawk=0,salmon=0;
        ArrayList<tokenEnum> animalList = new ArrayList<tokenEnum>();
        int temp=0;
        int GroupNum=0;
        int ScoreNum=0;
        switch(cardType){
            case 0:
                boolean[][] marked = new boolean[tileBoard.BOARD_WIDTH][tileBoard.BOARD_HEIGHT];
                for(int i=0;i<=tileBoard.BOARD_HEIGHT-1;i++){
                    for(int j=0;j<=tileBoard.BOARD_WIDTH-1;j++){
                        if(user.getPlayerBoard().TileBoard[i][j] != null) {
                            if(user.getPlayerBoard().TileBoard[i][j].token!=null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.BEAR && !marked[i][j]){
                                    GroupNum += helperGroupCheckBear(user.getPlayerBoard().TileBoard[i][j], tokenEnum.BEAR, 0, 0,marked);
                                    switch(GroupNum){
                                        case 0:
                                        break;
                                        case 1:
                                        ScoreNum += 4;
                                        case 2:
                                        ScoreNum += 11;
                                        case 3:
                                        ScoreNum += 19;
                                        case 4:
                                        ScoreNum += 27;
                                    }
                            }
                        }
                }
            }
            break;
            case 1:
                boolean[][] m = new boolean[tileBoard.BOARD_HEIGHT][tileBoard.BOARD_WIDTH];
                for(int i=0;i<=tileBoard.BOARD_HEIGHT-1;i++){
                    for(int j=0;j<=tileBoard.BOARD_WIDTH-1;j++){
                        if(user.getPlayerBoard().TileBoard[i][j] != null) {
                            if(user.getPlayerBoard().TileBoard[i][j].token!=null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.BEAR && !m[i][j]){
                                    GroupNum += helperGroupCheckBear(user.getPlayerBoard().TileBoard[i][j], tokenEnum.BEAR, 0, 1,m);
                                    ScoreNum += GroupNum * 10;
                            }
                        }
                }
            }
            break;
            case 2:
            for(int i=0;i<=tileBoard.BOARD_HEIGHT-1;i++){
                for(int j=0;j<=tileBoard.BOARD_WIDTH-1;j++){
                    if(user.getPlayerBoard().TileBoard[i][j] != null) {
                        if(user.getPlayerBoard().TileBoard[i][j].token!=null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.FOX){
                            if(user.getPlayerBoard().TileBoard[i][j].up != null){
                               if(user.getPlayerBoard().TileBoard[i][j].up.token !=null){
                                    animalList.add(user.getPlayerBoard().TileBoard[i][j].up.token.animalType);
                                    ScoreNum += 1;
                               }
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].down != null){
                                if(user.getPlayerBoard().TileBoard[i][j].down.token !=null){
                                    temp=0;
                                    for(int k=0;k<animalList.size();k++){
                                        if(animalList.get(k) == user.getPlayerBoard().TileBoard[i][j].down.token.animalType){
                                            temp++;
                                        }
                                    }
                                    if(temp==0){
                                        animalList.add(user.getPlayerBoard().TileBoard[i][j].down.token.animalType);
                                        ScoreNum += 1;                                     
                                    }
                            }
                        }
                            if(user.getPlayerBoard().TileBoard[i][j].left != null){
                                if(user.getPlayerBoard().TileBoard[i][j].left.token !=null){
                                    temp=0;
                                    for(int k=0;k<animalList.size();k++){
                                        if(animalList.get(k) == user.getPlayerBoard().TileBoard[i][j].left.token.animalType){
                                            temp++;
                                        }
                                    }
                                    if(temp==0){
                                        animalList.add(user.getPlayerBoard().TileBoard[i][j].left.token.animalType);
                                        ScoreNum += 1;                                     
                                    }
                            }
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].right != null){
                                if(user.getPlayerBoard().TileBoard[i][j].right.token !=null){
                                    temp=0;
                                    for(int k=0;k<animalList.size();k++){
                                        if(animalList.get(k) == user.getPlayerBoard().TileBoard[i][j].right.token.animalType){
                                            temp++;
                                        }
                                    }
                                    if(temp==0){
                                        animalList.add(user.getPlayerBoard().TileBoard[i][j].right.token.animalType);
                                        ScoreNum += 1;                                     
                                    }
                            }
                            }
                        }
                    }
            }
        }
            break;
            case 3:
            for(int i=0;i<=tileBoard.BOARD_HEIGHT-1;i++){
                for(int j=0;j<=tileBoard.BOARD_WIDTH-1;j++){
                    if(user.getPlayerBoard().TileBoard[i][j] != null && user.getPlayerBoard().TileBoard[i][j].token!=null) {
                        if(user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.FOX){
                            if(user.getPlayerBoard().TileBoard[i][j].up!=null && user.getPlayerBoard().TileBoard[i][j].up.token != null){
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.BEAR){
                                    bear++;
                                   }
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.FOX){
                                    fox++;
                                   }
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.ELK){
                                    elk++;
                                   }
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.HAWK){
                                    hawk++;
                                   }
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.SALMON){
                                    salmon++;
                                   }
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].down.token != null){
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.BEAR){
                                 bear++;
                                }
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.FOX){
                                 fox++;
                                }
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.ELK){
                                 elk++;
                                }
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.HAWK){
                                 hawk++;
                                }
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.SALMON){
                                 salmon++;
                                }
                         }
                         if(user.getPlayerBoard().TileBoard[i][j].left.token != null){
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.BEAR){
                             bear++;
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.FOX){
                             fox++;
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.ELK){
                             elk++;
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.HAWK){
                             hawk++;
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.SALMON){
                             salmon++;
                            }
                     }
                     if(user.getPlayerBoard().TileBoard[i][j].right.token != null){
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.BEAR){
                         bear++;
                        }
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.FOX){
                         fox++;
                        }
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.ELK){
                         elk++;
                        }
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.HAWK){
                         hawk++;
                        }
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.SALMON){
                         salmon++;
                        }
                 }
                 if(bear == 4 || bear == 2){
                    GroupNum++;
                 }
                 if(elk == 4 || elk == 2){
                    GroupNum++;
                 }
                 if(hawk == 4 || hawk == 2){
                    GroupNum++;
                 }
                 if(salmon == 4 || salmon == 2){
                    GroupNum++;
                 }
                 switch(GroupNum){
                    case 1:
                    ScoreNum += 3;
                    case 2:
                    ScoreNum += 5;
                 }
                        }
                    }
            }
        }
            break;
            case 4:
                ScoreNum+=scoreElk(1,user);
                break;
            case 5:
                ScoreNum+=scoreElk(1,user);
                break;
                case 6:
                ScoreNum+=scoreHawk(1,user);
                break;
            case 7:
                ScoreNum+=scoreHawk(2,user);

            break;
            case 8:
                //SALMON A (MAX RUN LENGTH=7)
                ScoreNum+=scoreSalmon(1,user);
            break;
            case 9:
                //SALMON A (MAX RUN LENGTH=5)
                ScoreNum+=scoreSalmon(2,user);
            break;
            case 10: // Bear Scoring Card C
                boolean[][] mKD = new boolean[tileBoard.BOARD_HEIGHT][tileBoard.BOARD_WIDTH];
            for(int i=0;i<=tileBoard.BOARD_HEIGHT-1;i++){
                for(int j=0;j<=tileBoard.BOARD_WIDTH-1;j++){
                    if(user.getPlayerBoard().TileBoard[i][j] != null) {
                        if(user.getPlayerBoard().TileBoard[i][j].token!=null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.BEAR && !mKD[i][j]){
                            bear = 1;
                            if(user.getPlayerBoard().TileBoard[i][j].up!=null && user.getPlayerBoard().TileBoard[i][j].up.token != null){
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.BEAR){
                                       mKD[i+1][j]=true;
                                    bear++;
                                    bear += helperGroupCheckBear(user.getPlayerBoard().TileBoard[i][j].up, tokenEnum.BEAR, 2, 0,mKD);
                            }
                        }
                            if(user.getPlayerBoard().TileBoard[i][j].down!=null && user.getPlayerBoard().TileBoard[i][j].down.token != null){
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.BEAR){
                                    mKD[i-1][j]=true;
                                        bear++;
                                        bear += helperGroupCheckBear(user.getPlayerBoard().TileBoard[i][j].down, tokenEnum.BEAR, 1, 0,mKD);
                                }
                         }
                         if(user.getPlayerBoard().TileBoard[i][j].left!=null && user.getPlayerBoard().TileBoard[i][j].left.token != null){
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.BEAR){
                                mKD[i][j-1]=true;
                                    bear++;
                                    bear += helperGroupCheckBear(user.getPlayerBoard().TileBoard[i][j].left, tokenEnum.BEAR, 4, 0,mKD);
                     }
                    }
                     if(user.getPlayerBoard().TileBoard[i][j].right!=null && user.getPlayerBoard().TileBoard[i][j].right.token != null){
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.BEAR){
                            mKD[i][j+1]=true;
                                bear++;
                                bear += helperGroupCheckBear(user.getPlayerBoard().TileBoard[i][j].right, tokenEnum.BEAR, 3, 0, mKD);
                        }
                 }
                 if(bear == 1){ //actual score here
                    ScoreNum += 2;
                 }
                 if(bear == 2){
                    ScoreNum += 5;
                 }
                 if(bear == 3){
                    ScoreNum += 8;
                 }
                        }
                    }
            }
        }
            break;
            case 11:
                boolean[][] markedArray=new boolean[tileBoard.BOARD_WIDTH][tileBoard.BOARD_HEIGHT];
            for(int i=0;i<=tileBoard.BOARD_HEIGHT-1;i++){
                for(int j=0;j<=tileBoard.BOARD_WIDTH-1;j++){
                    if(user.getPlayerBoard().TileBoard[i][j] != null && user.getPlayerBoard().TileBoard[i][j].token!=null) {
                        if(user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.FOX && !markedArray[i][j]){
                            if(user.getPlayerBoard().TileBoard[i][j].up.token != null){
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.BEAR){
                                    bear++;
                                   }
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.FOX){
                                    fox++;
                                   }
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.ELK){
                                    elk++;
                                   }
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.HAWK){
                                    hawk++;
                                   }
                                   if(user.getPlayerBoard().TileBoard[i][j].up.token.animalType == tokenEnum.SALMON){
                                    salmon++;
                                   }
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].down.token != null){
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.BEAR){
                                 bear++;
                                }
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.FOX){
                                 fox++;
                                }
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.ELK){
                                 elk++;
                                }
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.HAWK){
                                 hawk++;
                                }
                                if(user.getPlayerBoard().TileBoard[i][j].down.token.animalType == tokenEnum.SALMON){
                                 salmon++;
                                }
                         }
                         if(user.getPlayerBoard().TileBoard[i][j].left.token != null){
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.BEAR){
                             bear++;
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.FOX){
                             fox++;
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.ELK){
                             elk++;
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.HAWK){
                             hawk++;
                            }
                            if(user.getPlayerBoard().TileBoard[i][j].left.token.animalType == tokenEnum.SALMON){
                             salmon++;
                            }
                     }
                     if(user.getPlayerBoard().TileBoard[i][j].right.token != null){
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.BEAR){
                         bear++;
                        }
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.FOX){
                         fox++;
                        }
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.ELK){
                         elk++;
                        }
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.HAWK){
                         hawk++;
                        }
                        if(user.getPlayerBoard().TileBoard[i][j].right.token.animalType == tokenEnum.SALMON){
                         salmon++;
                        }
                 }
                 fox = 0;
                switch(Math.max(bear, Math.max(fox, Math.max(elk, Math.max(hawk, salmon))))){
                    case 0:
                    break;
                    case 1:
                    ScoreNum += 1;
                    case 2:
                    ScoreNum += 2;
                    case 3:
                    ScoreNum += 3;
                    case 4:
                    ScoreNum += 4;
                }
                        }
                    }
            }
        }
            break;
            case 12:
                ScoreNum+=scoreElk(3,user);
            break;
            case 13:
                ScoreNum+=scoreHawk(3,user);
            break;
            case 14:
                //SALMON C (MAX RUN LENGTH=5)
                ScoreNum+=scoreSalmon(3,user);
            break;
        }
        return ScoreNum;
    }

    public static int scoreElk(int whatCard, player user)
    {
        int score=0;
        //first, create a 2-d array of booleans
        boolean[][] marked = new boolean[tileBoard.BOARD_HEIGHT][tileBoard.BOARD_WIDTH];
        //filled with false by default
        switch (whatCard)
        {
            case 1:     //SCORE CARD A, find the elk, count the line, return the length
                for (int i = 0; i < tileBoard.BOARD_HEIGHT - 1; i++) { //go through the array
                    for (int j = 0; j < tileBoard.BOARD_WIDTH - 1; j++)
                    {
                        if (user.getPlayerBoard().TileBoard[i][j] != null) {
                            if (user.getPlayerBoard().TileBoard[i][j].token!=null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.ELK && !marked[i][j]) {
                                // a elk is found:
                                // find the line size
                                int lineSize =countElk(1,user,i,j,marked);
                                switch (lineSize)
                                {
                                    case 1:
                                    {
                                        score+=2;
                                        break;
                                    }
                                    case 2:
                                    {
                                        score+=5;
                                        break;
                                    }
                                    case 3:
                                    {
                                        score+=9;
                                        break;
                                    }
                                    case 4:
                                    {
                                        score+=13;
                                        break;
                                    }
                                    default:
                                    {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;

            case 2:
            {
                for (int i = 0; i < tileBoard.BOARD_HEIGHT - 1; i++) { //go through the array
                    for (int j = 0; j < tileBoard.BOARD_WIDTH - 1; j++) {
                        if (user.getPlayerBoard().TileBoard[i][j] != null) {
                            if (user.getPlayerBoard().TileBoard[i][j].token != null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.ELK && !marked[i][j]) {
                                // a elk is found:
                                // find group size
                                int groupSize=countElk(2,user,i,j,marked);
                                switch (groupSize)
                                {
                                    case 1:
                                    {
                                        score+=2;
                                        break;
                                    }
                                    case 2:
                                    {
                                        score+=4;
                                        break;
                                    }
                                    case 3:
                                    {
                                        score+=7;
                                        break;
                                    }
                                    case 4:
                                    {
                                        score+=10;
                                        break;
                                    }
                                    case 5:
                                    {
                                        score+=14;
                                        break;
                                    }
                                    case 6:
                                    {
                                        score+=18;
                                        break;
                                    }
                                    case 7:
                                    {
                                        score+=23;
                                        break;
                                    }
                                    default:
                                    {
                                        score+=28;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            }
            case 3:     //CASE 3, SHAPES
            {
                for (int i = 0; i < tileBoard.BOARD_HEIGHT - 1; i++) { //go through the array
                    for (int j = 0; j < tileBoard.BOARD_WIDTH - 1; j++) {
                        if (user.getPlayerBoard().TileBoard[i][j] != null) {
                            if (user.getPlayerBoard().TileBoard[i][j].token != null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.ELK && !marked[i][j]) {
                                //a hawk is found
                                int count = countElk(3, user, i, j, marked);
                                switch (count)
                                {
                                    case 1:
                                    {
                                        score+=2;
                                        break;
                                    }
                                    case 2:
                                    {
                                        score+=5;
                                        break;
                                    }
                                    case 3:
                                    {
                                        score+=9;
                                        break;
                                    }
                                    case 4:
                                    {
                                        score+=13;
                                        break;
                                    }
                                    default:
                                    {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return score;
    }

    public static int countElk(int whatCard, player user, int row, int column, boolean[][] marked)
    {
        //can be any lines, so mark each one in the line when counting, BUT, if we find an elk thats marked, we can unmark it and keep counting (allows multiple lines)
        marked[row][column]=true;
        int tally=1;
        int count=0;
        switch (whatCard) {
            case 1:
            if ((row > 0 && row < tileBoard.BOARD_WIDTH - 1) && (column > 0 && column < tileBoard.BOARD_WIDTH - 1)) {   //as long as we can keep counting
                if (user.getPlayerBoard().TileBoard[row][column + 1] != null && user.getPlayerBoard().TileBoard[row][column + 1].getToken() != null && user.getPlayerBoard().TileBoard[row][column + 1].getToken().getAnimalType() == tokenEnum.ELK) {
                    count = countElkHorizontal(user, row, column, marked, tally);
                } else if (user.getPlayerBoard().TileBoard[row + 1][column] != null && user.getPlayerBoard().TileBoard[row + 1][column].getToken() != null && user.getPlayerBoard().TileBoard[row + 1][column].getToken().getAnimalType() == tokenEnum.ELK) {
                    count = countElkVertical(user, row, column, marked, tally);
                }
                return count;
            }
            case 2: //card B, counting the largestgroup
                if((row > 0 && row < tileBoard.BOARD_WIDTH - 1) && (column > 0 && column < tileBoard.BOARD_WIDTH - 1)) //while it can be counted
                {
                    marked[row][column] = true;
                    int groupSize = 1;
                    if (row > 0 && user.getPlayerBoard().TileBoard[row - 1][column] != null && user.getPlayerBoard().TileBoard[row - 1][column].getToken() != null && user.getPlayerBoard().TileBoard[row - 1][column].getToken().getAnimalType() == tokenEnum.ELK && !marked[row - 1][column]) {
                        groupSize += countElk(2,user,row-1,column,marked);
                    }
                    if (row < tileBoard.BOARD_WIDTH - 1 && user.getPlayerBoard().TileBoard[row + 1][column] != null && user.getPlayerBoard().TileBoard[row + 1][column].getToken() != null && user.getPlayerBoard().TileBoard[row + 1][column].getToken().getAnimalType() == tokenEnum.ELK && !marked[row + 1][column]) {
                        groupSize += countElk(2,user,row+1,column,marked);
                    }
                    if (column > 0 && user.getPlayerBoard().TileBoard[row][column - 1] != null && user.getPlayerBoard().TileBoard[row][column - 1].getToken() != null && user.getPlayerBoard().TileBoard[row][column - 1].getToken().getAnimalType() == tokenEnum.ELK && !marked[row][column - 1]) {
                        groupSize += countElk(2,user,row,column-1,marked);
                    }
                    if (column < tileBoard.BOARD_WIDTH - 1 && user.getPlayerBoard().TileBoard[row][column + 1] != null && user.getPlayerBoard().TileBoard[row][column + 1].getToken() != null && user.getPlayerBoard().TileBoard[row][column + 1].getToken().getAnimalType() == tokenEnum.ELK && !marked[row][column + 1]) {
                        groupSize += countElk(2,user,row,column+1,marked);
                    }
                    return groupSize;
                }
            case 3:     //SCORE CARD C, SHAPES
            {
                if ((row > 0 && row < tileBoard.BOARD_WIDTH - 1) && (column > 0 && column < tileBoard.BOARD_WIDTH - 1)) {   //as long as we can keep counting
                    //check if theres a tile directly vertical or horizontal to this one
                    Tile currentTile = user.getPlayerBoard().TileBoard[row][column];
                    tally= findMatchingPattern(currentTile,user,marked);
                }
            }

        }
        return tally;
    }
    public static int findMatchingPattern(Tile t, player user, boolean[][] marked)
    {
        //t = starting tile
        marked[t.x][t.y]=true;
        int count=1; //incremented everytime we find an eligible tile
        if(findElkVerticallyNextTo(t,user,marked)!=null) //theres a tile vertically above t
        {
            count++; //increment the count, 2
            Tile upTile = findElkVerticallyNextTo(t,user,marked); //the tile we found
            if(findElkHorizontallyNextTo(upTile,user,marked)!=null)
            {
                count++; //3
                Tile upDiagonalTile=findElkHorizontallyNextTo(upTile,user,marked); //the tile we found
                if(upDiagonalTile.down!=null && upDiagonalTile.getToken()!=null && upDiagonalTile.down.getToken().getAnimalType()==tokenEnum.ELK) //if this tile is not null and an elk, we can mark it
                {
                    marked[t.x+1][t.y]=true;
                    count++; //4
                }
            }

        }
        if(findElkHorizontallyNextTo(t,user,marked)!=null) //or else if the tile has an eligible tile to its left
        {
            count++; //2
            Tile horizontalTile = findElkHorizontallyNextTo(t,user,marked); //the tile we found
            if(findElkVerticallyNextTo(horizontalTile,user,marked)!=null)
            {
                count++; //3
                Tile diagonalTile=findElkVerticallyNextTo(horizontalTile,user,marked);
                if(diagonalTile.right!=null && diagonalTile.getToken()!=null && diagonalTile.getToken().getAnimalType()==tokenEnum.ELK)
                {
                    marked[t.x][t.y+1]=true;
                    count++; //4
                }
            }
        }
        return count;
    }
    public static Tile findElkVerticallyNextTo(Tile t, player user, boolean[][] marked) //returns the tile that is vertically next to the current tile
    {
        if(t!=null) {
            if (t.x > 0 && t.x < tileBoard.BOARD_WIDTH - 1 && t.y > 0 && t.y < tileBoard.BOARD_HEIGHT) { //check its eligible first
                if (user.getPlayerBoard().TileBoard[t.x][t.y + 1] != null && user.getPlayerBoard().TileBoard[t.x][t.y + 1].getToken() != null && user.getPlayerBoard().TileBoard[t.x][t.y + 1].getToken().getAnimalType() == tokenEnum.ELK && !marked[t.x][t.y + 1]) {
                    //found a tile above
                    marked[t.x][t.y + 1] = true;
                    return user.getPlayerBoard().TileBoard[t.x][t.y + 1];
                }
                if (user.getPlayerBoard().TileBoard[t.x][t.y - 1] != null && user.getPlayerBoard().TileBoard[t.x][t.y - 1].getToken() != null && user.getPlayerBoard().TileBoard[t.x][t.y - 1].getToken().getAnimalType() == tokenEnum.ELK && !marked[t.x][t.y - 1]) {
                    //found a tile above
                    marked[t.x][t.y - 1] = true;
                    return user.getPlayerBoard().TileBoard[t.x][t.y - 1];
                }
            }
            return null; //found none
        }
        return null;
    }
    public static Tile findElkHorizontallyNextTo(Tile t, player user, boolean[][] marked) //returns the tile that is vertically next to the current tile
    {
        if(t!=null) {
            if (t.x > 0 && t.x < tileBoard.BOARD_WIDTH - 1 && t.y > 0 && t.y < tileBoard.BOARD_HEIGHT) { //check its eligible first
                if (user.getPlayerBoard().TileBoard[t.x + 1][t.y] != null && user.getPlayerBoard().TileBoard[t.x + 1][t.y].getToken() != null && user.getPlayerBoard().TileBoard[t.x + 1][t.y].getToken().getAnimalType() == tokenEnum.ELK && !marked[t.x + 1][t.y]) {
                    //found a tile above
                    marked[t.x + 1][t.y] = true;
                    return user.getPlayerBoard().TileBoard[t.x + 1][t.y];
                }
                if (user.getPlayerBoard().TileBoard[t.x - 1][t.y] != null && user.getPlayerBoard().TileBoard[t.x - 1][t.y].getToken() != null && user.getPlayerBoard().TileBoard[t.x - 1][t.y].getToken().getAnimalType() == tokenEnum.ELK && !marked[t.x - 1][t.y]) {
                    //found a tile above
                    marked[t.x - 1][t.y] = true;
                    return user.getPlayerBoard().TileBoard[t.x - 1][t.y];
                }
            }
            return null; //found none
        } return null;
    }
    public static int countElkVertical(player user, int row, int column, boolean[][] marked, int count)
    {
        if (user.getPlayerBoard().TileBoard[row+1][column]!=null && user.getPlayerBoard().TileBoard[row+1][column].getToken() != null && user.getPlayerBoard().TileBoard[row+1][column].getToken().getAnimalType() == tokenEnum.ELK) {
            if(count==4){return count;}
            marked[row+1][column]=true;
            count+=countElkVertical(user,row+1,column,marked, count);
        }
        return count;
    }
    public static int countElkHorizontal(player user, int row, int column, boolean[][] marked, int count)
    {
        if (user.getPlayerBoard().TileBoard[row][column+1]!=null && user.getPlayerBoard().TileBoard[row][column+1].getToken() != null && user.getPlayerBoard().TileBoard[row][column+1].getToken().getAnimalType() == tokenEnum.ELK) {
            if(count==4){return count;}
            marked[row][column+1]=true;
            count+=countElkHorizontal(user,row,column+1,marked, count);
        }
        return count;
    }

    public static int scoreHawk(int whatCard, player user) //method that returns the total score of a players salmon
    {
        int score=0;
        //first, create a 2-d array of booleans
        boolean[][] marked = new boolean[tileBoard.BOARD_HEIGHT][tileBoard.BOARD_WIDTH];
        //filled with false by default
        switch (whatCard)
        {
            case 1: //SCORE CARD A
            {
                int tally=0;
                for (int i = 0; i < tileBoard.BOARD_HEIGHT - 1; i++) { //go through the array
                    for (int j = 0; j < tileBoard.BOARD_WIDTH - 1; j++)
                    {
                        if (user.getPlayerBoard().TileBoard[i][j] != null) {
                            if (user.getPlayerBoard().TileBoard[i][j].token!=null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.HAWK && !marked[i][j]) {
                                // a hawk is found:
                               tally+=countHawks(user,1,i,j,marked,0,0);
                            }
                        }
                    }
                }
                switch (tally)
                {
                    case 0:
                        break;
                    case 1:
                        score=2;
                        break;
                    case 2:
                        score=5;
                        break;
                    case 3:
                        score=8;
                        break;
                    case 4:
                        score=11;
                        break;
                    case 5:
                        score=14;
                        break;
                    case 6:
                        score=18;
                        break;
                    case 7:
                        score=22;
                        break;
                    default:
                        score=26;
                        break;
                }


                return score;
            }
            case 2: {   //SCORE CARD B
                int tally=0;
                for (int i = 0; i < tileBoard.BOARD_HEIGHT - 1; i++) { //go through the array
                    for (int j = 0; j < tileBoard.BOARD_WIDTH - 1; j++) {
                        if (user.getPlayerBoard().TileBoard[i][j] != null) {
                            if (user.getPlayerBoard().TileBoard[i][j].token != null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.HAWK) {
                                tally+=countHawks(user,2,i,j,marked,0,0);
                            }
                        }
                    }
                }
                switch (tally)
                {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        score=5;
                        break;
                    case 3:
                        score=9;
                        break;
                    case 4:
                        score=12;
                        break;
                    case 5:
                        score=16;
                        break;
                    case 6:
                        score=20;
                        break;
                    case 7:
                        score=24;
                        break;
                    default:
                        score=28;
                        break;
                }
                return score;
            }
            case 3:     //SCORE CARD C
            {
                int tally=0;
                for (int i = 0; i < tileBoard.BOARD_HEIGHT - 1; i++) { //go through the array
                    for (int j = 0; j < tileBoard.BOARD_WIDTH - 1; j++) {
                        if (user.getPlayerBoard().TileBoard[i][j] != null) {
                            if (user.getPlayerBoard().TileBoard[i][j].token != null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.HAWK) {
                                tally+=countHawks(user,3,i,j,marked,0,0); //tally = amount of eligible hawk pairs
                            }
                        }
                    }
                }
                score = tally*3;
                return score;
            }
        }
        return score;
    }

    public static int countHawks(player user, int whatRule, int row, int column , boolean[][] marked, int minStreak, int maxStreak) //helper function that starts to tally the hawks based on the current rule
    {
        int lineTally=0;
        int streak=1;
        int tally=0;
        marked[row][column] = true; // mark the current cell as visited
        switch (whatRule)
        {
            case 1:     //if its rule A, check if the hawk is alone
                boolean isAlone = true;
                try {
                    for (int i = row - 1; i <= row + 1; i++) {
                        for (int j = column - 1; j <= column + 1; j++) {
                            if (i >= 0 && i < user.getPlayerBoard().TileBoard.length - 1 && j >= 0 && j < user.getPlayerBoard().TileBoard[i].length - 1) {
                                if (i == row && j == column) {
                                    continue; // skip the current cell
                                }
                                if (user.getPlayerBoard().TileBoard[i][j] != null && user.getPlayerBoard().TileBoard[i][j].token != null && user.getPlayerBoard().TileBoard[i][j].token.getAnimalType() == tokenEnum.HAWK) {
                                    isAlone = false; // theres another hawk in the surrounding cells, its not alone
                                    break;
                                } else {
                                    isAlone = true;
                                }
                            }
                        }
                        if (!isAlone) {
                            tally = 0;
                            break;
                        }
                    }
                    if (isAlone) { // if the hawk is alone, return 1
                        tally = 1;
                    } else {
                        tally = 0;
                    }
                }catch (Exception ex){return tally;}
                break;
            case 2: {
                try {
                    if (user.getPlayerBoard().TileBoard[row][column].token.animalType == tokenEnum.HAWK && countHawks(user, 1, row, column, marked, 0, 0) == 1) //this tile contains an alone hawk
                    {
                        if (user.getPlayerBoard().TileBoard[row][column + 2] != null && user.getPlayerBoard().TileBoard[row][column + 2].token != null && user.getPlayerBoard().TileBoard[row][column + 2].token.animalType == tokenEnum.HAWK && countHawks(user, 1, row, column + 2, marked, 0, 0) == 1) {
                            marked[row][column + 2] = true;
                            lineTally++;
                            tally++;
                        }
                        if (user.getPlayerBoard().TileBoard[row][column - 2] != null && user.getPlayerBoard().TileBoard[row][column - 2].token != null && user.getPlayerBoard().TileBoard[row][column - 2].token.animalType == tokenEnum.HAWK && countHawks(user, 1, row, column - 2, marked, 0, 0) == 1) {
                            marked[row][column - 2] = true;
                            lineTally++;
                            tally++;
                        }
                        if (user.getPlayerBoard().TileBoard[row + 2][column] != null && user.getPlayerBoard().TileBoard[row + 2][column].token != null && user.getPlayerBoard().TileBoard[row + 2][column].token.animalType == tokenEnum.HAWK && countHawks(user, 1, row + 2, column, marked, 0, 0) == 1) {
                            marked[row + 2][column] = true;
                            lineTally++;
                            tally++;
                        }
                        if (user.getPlayerBoard().TileBoard[row - 2][column] != null && user.getPlayerBoard().TileBoard[row - 2][column].token != null && user.getPlayerBoard().TileBoard[row - 2][column].token.animalType == tokenEnum.HAWK && countHawks(user, 1, row - 2, column, marked, 0, 0) == 1) {
                            marked[row - 2][column] = true;
                            lineTally++;
                            tally++;
                        }
                    }
                }catch (ArrayIndexOutOfBoundsException ex)
                {
                    return lineTally;
                }

                return lineTally; //tally=the number of hawks that are in line of sight and eligible
            }
            case 3:     //if its rule C, check that this hawk has another hawk in its line of sight
        {
            //a hawk is found, marked
                for(int j=0;j<tileBoard.BOARD_WIDTH-1;j++)
                {
                    if(user.getPlayerBoard().TileBoard[row][j]!=null && user.getPlayerBoard().TileBoard[row][j].token!=null && user.getPlayerBoard().TileBoard[row][j].token.getAnimalType()==tokenEnum.HAWK && !marked[row][j])
                    {
                        //a hawk is found, mark it as well as the current tile as its the number of pairs
                        marked[row][j] = true;
                        marked[row][column] = true;
                        tally += 1; //tally is the amount of eligible hawks
                    }
                }
            for(int i=0;i<tileBoard.BOARD_HEIGHT-1;i++)
            {
                if(user.getPlayerBoard().TileBoard[i][column]!=null && user.getPlayerBoard().TileBoard[i][column].token!=null && user.getPlayerBoard().TileBoard[i][column].token.getAnimalType()==tokenEnum.HAWK && !marked[i][column])
                {
                    //a hawk is found, mark it as well as the current tile as its the number of pairs
                    marked[i][column] = true;
                    marked[row][column] = true;
                    tally += 1; //tally is the amount of eligible hawks
                }
            }
            return tally;
        }
        }

        return tally; //its not alone, return 0
    }

    public static int scoreSalmon(int whatCard, player user) //method that returns the total score of a players salmon
    {
        int score=0;
        //first, create a 2-d array of booleans
        boolean[][] marked = new boolean[tileBoard.BOARD_HEIGHT][tileBoard.BOARD_WIDTH];
        //filled with false by default
        switch (whatCard) {
            case 1: // SCORE TYPE A
            {
                for (int i = 0; i < tileBoard.BOARD_HEIGHT - 1; i++) { //go through the array
                    for (int j = 0; j < tileBoard.BOARD_WIDTH - 1; j++) {
                        if (user.getPlayerBoard().TileBoard[i][j] != null) {
                            if (user.getPlayerBoard().TileBoard[i][j].token!=null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.SALMON && !marked[i][j]) {
                                //a tally is found:
                                int tally = countSalmonRun(user, i, j, marked, 7, 0);
                                //score it
                                switch (tally)
                                {
                                    case 0:
                                        break;
                                    case 1:
                                        score+=2;
                                        break;
                                    case 2:
                                        score+=4;
                                        break;
                                    case 3:
                                        score+=7;
                                        break;
                                    case 4:
                                        score+=11;
                                        break;
                                    case 5:
                                        score+=15;
                                        break;
                                    case 6:
                                        score+=20;
                                        break;
                                    default: //default is just 7 and above
                                        score+=26;
                                        break;
                                }
                            }
                        }
                    }
                }
                return score;
            }
            case 2: //SCORE TYPE B
            {
                for (int i = 0; i < tileBoard.BOARD_HEIGHT - 1; i++) { //go through the array
                    for (int j = 0; j < tileBoard.BOARD_WIDTH - 1; j++) {
                        if (user.getPlayerBoard().TileBoard[i][j] != null) {
                            if (user.getPlayerBoard().TileBoard[i][j].token != null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.SALMON && !marked[i][j]) {
                                //find the tally
                                int tally=countSalmonRun(user, i, j, marked, 4, 0);
                                //score them
                                switch (tally)
                                {
                                    case 0:
                                        break;
                                    case 1:
                                        score+=2;
                                        break;
                                    case 2:
                                        score+=4;
                                        break;
                                    case 3:
                                        score+=8;
                                        break;
                                    default:
                                        score+=12;
                                        break;
                                }
                            }
                        }
                    }
                }
                return score;
            }
            case 3: //SCORE TYPE C
            {
                for (int i = 0; i < tileBoard.BOARD_HEIGHT - 1; i++) { //go through the array
                    for (int j = 0; j < tileBoard.BOARD_WIDTH - 1; j++) {
                        if (user.getPlayerBoard().TileBoard[i][j] != null) {
                            if (user.getPlayerBoard().TileBoard[i][j].token != null && user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.SALMON && !marked[i][j]) {
                                //find the tally
                                int tally = countSalmonRun(user, i, j, marked, 5, 0);
                                //score them
                                switch (tally)
                                {
                                    case 0:
                                        break;
                                    case 1:
                                        score+=2;
                                        break;
                                    case 2:
                                        score+=4;
                                        break;
                                    case 3:
                                        score+=9;
                                        break;
                                    case 4:
                                        score+=11;
                                        break;
                                    default:
                                        score+=17;
                                        break;
                                }
                            }
                        }
                    }
                }
                return score;
            }
        }
        return score; //score = total score of the player's salmon?
    }
    public static int countSalmonRun(player user, int row, int column, boolean[][] marked, int maxRunLength, int minRunLenght) //helper function that counts the largest salmon in a run from a tile, maxRunLength and minRunLEngth are for the different types of scoring cards (A, B, C ...)
    {
        marked[row][column] = true; // mark the current cell as visited
        int tally=1; //start the tally at 1
        //check adjacent cells for salmon tokens
        for (int i = row - 1; i <= row + 1; i++) { //check the horizontal neighboors
            for (int j = column - 1; j <= column + 1; j++) //check the vertical neightboors
            {
                if (i == row || j == column) { // only count adjacent cells in the same row or column
                    if (user.getPlayerBoard().TileBoard[i][j] != null && user.getPlayerBoard().TileBoard[i][j].token!= null && i < user.getPlayerBoard().TileBoard.length && j < user.getPlayerBoard().TileBoard[0].length && user.getPlayerBoard().TileBoard[i][j].getToken().getAnimalType() == tokenEnum.SALMON && !marked[i][j]) {
                        //IF the tile we are looking at is: not null, is a horizontal or vertical neighboor, within bounds, is a salmon and is unvisited:
                        //first check if it doesnt exceed the allowed tally:
                        tally = tally + countSalmonRun(user, i, j, marked,maxRunLength,minRunLenght);


                        if (tally >= maxRunLength) {
                            return tally;
                        } else if (tally >= minRunLenght) {
                            return tally;
                        }
                    }
                }
            }
        }
        return tally; //return the total run length
    }
   public String toString(){
    switch(cardType){
       case 0:
       return Tile.getAnimalColor(tokenEnum.BEAR) + "Bear A" + Tile.RESET;
       case 1:
       return Tile.getAnimalColor(tokenEnum.BEAR) + "Bear B" + Tile.RESET;
       case 2:
       return Tile.getAnimalColor(tokenEnum.FOX) + "Fox A" + Tile.RESET;
       case 3:
       return Tile.getAnimalColor(tokenEnum.FOX) + "Fox B" + Tile.RESET;
       case 4:
       return Tile.getAnimalColor(tokenEnum.ELK) + "Elk A" + Tile.RESET;
       case 5:
       return Tile.getAnimalColor(tokenEnum.ELK)+"Elk B" + Tile.RESET;
       case 6:
       return Tile.getAnimalColor(tokenEnum.HAWK)+"Hawk A" + Tile.RESET;
       case 7:
       return Tile.getAnimalColor(tokenEnum.HAWK)+"Hawk B" + Tile.RESET;
       case 8:
       return Tile.getAnimalColor(tokenEnum.SALMON)+"Salmon A" + Tile.RESET;
       case 9:
       return Tile.getAnimalColor(tokenEnum.SALMON)+"Salmon B" + Tile.RESET;
       case 10:
       return Tile.getAnimalColor(tokenEnum.BEAR)+"Bear C" + Tile.RESET;
       case 11:
       return Tile.getAnimalColor(tokenEnum.FOX)+"Fox C" + Tile.RESET;
       case 12:
       return Tile.getAnimalColor(tokenEnum.ELK)+"Elk C" + Tile.RESET;
       case 13:
       return Tile.getAnimalColor(tokenEnum.HAWK)+"Hawk C" + Tile.RESET;
       case 14:
       return Tile.getAnimalColor(tokenEnum.SALMON)+"Salmon C" + Tile.RESET;
       default:
       return "toString cardType error";
    }
   }
}