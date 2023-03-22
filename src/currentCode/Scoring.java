package currentCode;

import java.util.Arrays;

//class that will contain all the scoring options/methods
public class Scoring {


    //method that checks the largest corridor of habitatEnums
    public static void scoreHabitatCorridors(player user)
    {
        countHabitatOccurences(habitatEnum.Forest, user);
        countHabitatOccurences(habitatEnum.Mountain, user);
        countHabitatOccurences(habitatEnum.River, user);
        countHabitatOccurences(habitatEnum.Prairie, user);
        countHabitatOccurences(habitatEnum.Wetland, user);
    }
    public static int countHabitatOccurences(habitatEnum enumToCount, player user) //helper function that counts the highest occurences of a certain enum
    {

        int highestCount=0;
        int totalCount=0;
        for(int i=0;i<14;i++) //i=row
        {
            for(int j=0;j<14;j++) //j=column
            {
                int columnmCount=0;
                if(user.getPlayerBoard().TileBoard[i][j] != null) {
                    if (user.getPlayerBoard().TileBoard[i][j].landType2 == enumToCount) //if it matches
                    {
                        //columnmCount++;
                        //it is found, use recursion
                        columnmCount = keepCountingLandType2(enumToCount, columnmCount, i, j, user,true);
                        totalCount += columnmCount; // move the increment here
                    }
                }
                if(user.getPlayerBoard().TileBoard[i][j] != null)
                {
                    if(user.getPlayerBoard().TileBoard[i][j].landType == enumToCount) {
                        //columnmCount++;
                        //it is found, use recursion
                        columnmCount = keepCountingLandType1(enumToCount, columnmCount, i, j, user,true);
                        totalCount += columnmCount; // move the increment here
                    }
                }
                if(columnmCount>highestCount)
                {
                    highestCount=columnmCount;
                }
            }
        }
        System.out.println(user.name + " has a longest streak of " + (highestCount) + " of " + enumToCount);
        return totalCount;
    }

    public static int keepCountingLandType2(habitatEnum enumToCount, int totalCount, int i, int j, player user, boolean canGoRight) {
        int leftCount = 0;
        boolean hasRight=false;

        if (user.getPlayerBoard().TileBoard[i - 1][j] != null) { //the tile to the right's is not null
            if (user.getPlayerBoard().TileBoard[i - 1][j].landType == enumToCount) { //and matches
                hasRight=true;
            }
        }
        //ok can i go accross?

            if(hasRight && canGoRight) //i can go right
            {

                totalCount = keepCountingLandType1(enumToCount,totalCount,i-1,j,user,false); //start counting right (cant go back left)
               // totalCount++;
            }


        //can i go up?
        if (user.getPlayerBoard().TileBoard[i][j + 1] != null && user.getPlayerBoard().TileBoard[i][j + 1].landType2 == enumToCount) //recursive call, when the tile above it matches
        {
            //i can go up
            totalCount = keepCountingLandType2(enumToCount,totalCount,i,j+1,user,true);
            //totalCount++; // move the increment here
        }
        else if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].isKeystoneTile && user.getPlayerBoard().TileBoard[i][j+1].landType==enumToCount)
        {//if theres a keystone tile above that matches, i can go up

            totalCount = keepCountingLandType1(enumToCount,totalCount,i,j+1,user,true);
            //totalCount++;
        }
        //icant do any of these things
       // else{totalCount++;}
        return totalCount+1;
    }
    public static int keepCountingLandType1(habitatEnum enumToCount, int totalCount, int i, int j, player user, boolean canGoLeft)
    {
        int rightCount = 0;
        boolean hasLeft=false;
        boolean keystoneJumpAvailable=false;

        //check if i can go left
        if (user.getPlayerBoard().TileBoard[i + 1][j] != null) { //the tile to the lefts's is not null
            if (user.getPlayerBoard().TileBoard[i + 1][j].landType2 == enumToCount || (user.getPlayerBoard().TileBoard[i + 1][j].isKeystoneTile && user.getPlayerBoard().TileBoard[i + 1][j].landType==enumToCount)) { //and matches
                hasLeft = true;
            }
        }
        else if (user.getPlayerBoard().TileBoard[i][j]!=null && user.getPlayerBoard().TileBoard[i][j].isKeystoneTile && user.getPlayerBoard().TileBoard[i - 1][j]!=null && user.getPlayerBoard().TileBoard[i - 1][j].landType == enumToCount) { //i am a keystone tile with an available tile to the RIGHT
            {
                keystoneJumpAvailable = true;
                totalCount = keepCountingLandType1(enumToCount,totalCount-1,i-1,j,user,false);
            }
        }

        //can i go accross?
            //i can go left
            if(hasLeft && canGoLeft)
            {
                totalCount = keepCountingLandType2(enumToCount,totalCount,i+1,j,user,false); //start counting left
                //totalCount++;

            }
            //or else i could leap to the right (cannot go back left)
            /*
            else if(keystoneJumpAvailable)
            {
                totalCount = keepCountingLandType1(enumToCount,totalCount,i-1,j,user,false);
               // totalCount++;
            }*/

            //ok i cant go left,
            //can i go up?
            if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].landType==enumToCount) //recursive call
            {
                //i can go up
                totalCount = keepCountingLandType1(enumToCount,totalCount,i,j+1,user,true);
               // totalCount++;
            }
            else if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j].isKeystoneTile && user.getPlayerBoard().TileBoard[i][j+1].landType2==enumToCount)
            {//if im a keystone tile
                totalCount = keepCountingLandType2(enumToCount,totalCount,i,j+1,user,false);
                //totalCount++;
            }
            //icant do any of these things
            //else{totalCount++;}
        return totalCount+1;
    }
}
