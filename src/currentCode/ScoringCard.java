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
    ScoringCard(){
        Random rand = new Random();
        cardType = rand.nextInt(15); // Constructor creates random card type
    }
    public int helperGroupCheckBear(Tile x, tokenEnum animal, int y, int z){ // Helper function for card type A to check if any of the surrounding tiles contains the animal. More than 2 of the type of animal is not considered a pair and are disqualifed from gaining points
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
        if(z == 1){
            if(y==0){
                if(x.up.token.animalType == animal){
                    if(x.down.token.animalType == animal || x.left.token.animalType == animal || x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.down.token.animalType == animal){
                    if(x.left.token.animalType == animal || x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.down, animal, 1 , 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
        
                }
                else if(x.left.token.animalType == animal){
                    if(x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.left, animal, 4, 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.right.token.animalType == animal){
                    if(helperGroupCheckBear(x.right, animal, 3, 0) == 1){
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
                if(x.down.token.animalType == animal){
                    if(x.left.token.animalType == animal || x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.down, animal, 1, 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
        
                }
                else if(x.left.token.animalType == animal){
                    if(x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.left, animal, 4, 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.right.token.animalType == animal){
                    if(helperGroupCheckBear(x.right, animal, 3, 0) == 1){
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
                if(x.up.token.animalType == animal){
                    if(x.down.token.animalType == animal || x.left.token.animalType == animal || x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.left.token.animalType == animal){
                    if(x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.left, animal, 4, 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.right.token.animalType == animal){
                    if(helperGroupCheckBear(x.right, animal, 3, 0) == 1){
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
                if(x.up.token.animalType == animal){
                    if(x.down.token.animalType == animal || x.left.token.animalType == animal || x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.down.token.animalType == animal){
                    if(x.left.token.animalType == animal || x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.down, animal, 1, 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
        
                }
                else if(x.right.token.animalType == animal){
                    if(helperGroupCheckBear(x.right, animal, 3, 0) == 1){
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
                if(x.up.token.animalType == animal){
                    if(x.down.token.animalType == animal || x.left.token.animalType == animal || x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(x.down.token.animalType == animal){
                    if(x.left.token.animalType == animal || x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.down, animal, 1, 0) == 1){
                        return 1;
                    }
                    else{
                        return 0;
                    }
        
                }
                else if(x.left.token.animalType == animal){
                    if(x.right.token.animalType == animal){
                        return 0;
                    }
                    if(helperGroupCheckBear(x.left, animal, 4, 0) == 1){
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
            if(x.up.token.animalType == animal){
                if(x.down.token.animalType == animal || x.left.token.animalType == animal || x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.down.token.animalType == animal){
                if(x.left.token.animalType == animal || x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.down, animal, 1 , 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
    
            }
            else if(x.left.token.animalType == animal){
                if(x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.left, animal, 4, 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.right.token.animalType == animal){
                if(helperGroupCheckBear(x.right, animal, 3, 0) == 1){
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
            if(x.down.token.animalType == animal){
                if(x.left.token.animalType == animal || x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.down, animal, 1, 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
    
            }
            else if(x.left.token.animalType == animal){
                if(x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.left, animal, 4, 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.right.token.animalType == animal){
                if(helperGroupCheckBear(x.right, animal, 3, 0) == 1){
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
            if(x.up.token.animalType == animal){
                if(x.down.token.animalType == animal || x.left.token.animalType == animal || x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.left.token.animalType == animal){
                if(x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.left, animal, 4, 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.right.token.animalType == animal){
                if(helperGroupCheckBear(x.right, animal, 3, 0) == 1){
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
            if(x.up.token.animalType == animal){
                if(x.down.token.animalType == animal || x.left.token.animalType == animal || x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.down.token.animalType == animal){
                if(x.left.token.animalType == animal || x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.down, animal, 1, 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
    
            }
            else if(x.right.token.animalType == animal){
                if(helperGroupCheckBear(x.right, animal, 3, 0) == 1){
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
            if(x.up.token.animalType == animal){
                if(x.down.token.animalType == animal || x.left.token.animalType == animal || x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(x.down.token.animalType == animal){
                if(x.left.token.animalType == animal || x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.down, animal, 1, 0) == 1){
                    return 0;
                }
                else{
                    return 1;
                }
    
            }
            else if(x.left.token.animalType == animal){
                if(x.right.token.animalType == animal){
                    return 0;
                }
                if(helperGroupCheckBear(x.left, animal, 4, 0) == 1){
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
        ArrayList<tokenEnum> animalList = new ArrayList();
        int temp=0;
        int ScoreNum=0;
        switch(cardType){
            case 0:
                for(int i=0;i<=tileBoard.BOARD_HEIGHT;i++){
                    for(int j=0;j<=tileBoard.BOARD_WIDTH;j++){
                        if(user.getPlayerBoard().TileBoard[i][j] != null) {
                            if(user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.BEAR){
                                    ScoreNum += helperGroupCheckBear(user.getPlayerBoard().TileBoard[i][j], tokenEnum.BEAR, 0, 0);
                            }
                        }
                }
            }
            break;
            case 1:
                for(int i=0;i<=tileBoard.BOARD_HEIGHT;i++){
                    for(int j=0;j<=tileBoard.BOARD_WIDTH;j++){
                        if(user.getPlayerBoard().TileBoard[i][j] != null) {
                            if(user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.BEAR){
                                    ScoreNum += helperGroupCheckBear(user.getPlayerBoard().TileBoard[i][j], tokenEnum.BEAR, 0, 1);
                            }
                        }
                }
            }
            break;
            case 2:
            for(int i=0;i<=tileBoard.BOARD_HEIGHT;i++){
                for(int j=0;j<=tileBoard.BOARD_WIDTH;j++){
                    if(user.getPlayerBoard().TileBoard[i][j] != null) {
                        if(user.getPlayerBoard().TileBoard[i][j].token.animalType == tokenEnum.FOX){
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

            break;
            case 4:
         
            break;
            case 5:

            break;
            case 6:
       
            break;
            case 7:

            break;
            case 8:
          
            break;
            case 9:

            break;
            case 10:

            break;
            case 11:

            break;
            case 12:

            break;
            case 13:

            break;
            case 14:

            break;
        }
        return 0;
    }

}