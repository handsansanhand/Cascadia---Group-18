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

    public static int scoreSalmon(int whatCard, player user) //method that returns the maximum score (run) of salmon in the 2-d array
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
                                    default: //5 and above
                                        score+=17;
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
                                int tally = countSalmonRun(user, i, j, marked, 5, 3);
                                //score them
                                switch (tally)
                                {
                                    case 3:
                                        score+=10;
                                        break;
                                    case 4:
                                        score+=12;
                                        break;
                                    case 5: //5 and above
                                        score+=15;
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