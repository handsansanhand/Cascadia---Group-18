package currentCode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
        int temp=0;
        if(y==0){
            if(x.up.token.animalType == animal){
                temp++;
            }
            if(x.down.token.animalType == animal){
                temp++;
            }
            if(x.left.token.animalType == animal){
                temp++;
            }
            if(x.right.token.animalType == animal){
                temp++;
            }
        }
        else if(y==1){
            if(x.down.token.animalType == animal){
                temp++;
            }
            if(x.left.token.animalType == animal){
                temp++;
            }
            if(x.right.token.animalType == animal){
                temp++;
            }
        }
        else if(y==2){
            if(x.up.token.animalType == animal){
                temp++;
            }
            if(x.left.token.animalType == animal){
                temp++;
            }
            if(x.right.token.animalType == animal){
                temp++;
            }
        }
        else if(y==3){
            if(x.up.token.animalType == animal){
                temp++;
            }
            if(x.down.token.animalType == animal){
                temp++;
            }
            if(x.right.token.animalType == animal){
                temp++;
            }
        }
        else if(y==4){
            if(x.up.token.animalType == animal){
                temp++;
            }
            if(x.down.token.animalType == animal){
                temp++;
            }
            if(x.left.token.animalType == animal){
                temp++;
            }
        }
        
        if(z == 1){
            if(y==0){
                if(x.up.token.animalType == animal){
                    if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
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
                else if(x.down.token.animalType == animal){
                    if(helperGroupCheckBear(x.down, animal, 2, 0) == 1){
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
                else if(x.left.token.animalType == animal){
                    if(helperGroupCheckBear(x.left, animal, 2, 0) == 1){
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
                else if(x.right.token.animalType == animal){
                    if(helperGroupCheckBear(x.right, animal, 2, 0) == 1){
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
                if(x.down.token.animalType == animal){
                    if(helperGroupCheckBear(x.down, animal, 2, 0) == 1){
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
                else if(x.left.token.animalType == animal){
                    if(helperGroupCheckBear(x.right, animal, 2, 0) == 1){
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
                else if(x.right.token.animalType == animal){
                    if(helperGroupCheckBear(x.right, animal, 2, 0) == 1){
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
                if(x.up.token.animalType == animal){
                    if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
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
                else if(x.left.token.animalType == animal){
                    if(helperGroupCheckBear(x.left, animal, 2, 0) == 1){
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
                else if(x.right.token.animalType == animal){
                    if(helperGroupCheckBear(x.right, animal, 2, 0) == 1){
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
                if(x.up.token.animalType == animal){
                    if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
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
                else if(x.down.token.animalType == animal){
                    if(helperGroupCheckBear(x.down, animal, 2, 0) == 1){
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
                else if(x.right.token.animalType == animal){
                    if(helperGroupCheckBear(x.right, animal, 2, 0) == 1){
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
                if(x.up.token.animalType == animal){
                    if(helperGroupCheckBear(x.up, animal, 2, 0) == 1){
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
                else if(x.down.token.animalType == animal){
                    if(helperGroupCheckBear(x.down, animal, 2, 0) == 1){
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
                else if(x.left.token.animalType == animal){
                    if(helperGroupCheckBear(x.left, animal, 2, 0) == 1){
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
                //SALMON A (MAX RUN LENGTH=7)
                ScoreNum+=scoreSalmon(1,user);
            break;
            case 9:
                //SALMON A (MAX RUN LENGTH=5)
                ScoreNum+=scoreSalmon(2,user);
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
                //SALMON A (MAX RUN LENGTH=5)
                ScoreNum+=scoreSalmon(3,user);
            break;
        }
        return 0;
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
                                        score+=5;
                                        break;
                                    case 3:
                                        score+=8;
                                        break;
                                    case 4:
                                        score+=12;
                                        break;
                                    case 5:
                                        score+=16;
                                        break;
                                    case 6:
                                        score+=20;
                                        break;
                                    default: //default is just 7 and above
                                        score+=25;
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
    public int calculateScore(int x){ // takes number returned from calculateCardScore function and depending on the cardType, calculates the actual score to be given to the player
        return 0;
    }

}