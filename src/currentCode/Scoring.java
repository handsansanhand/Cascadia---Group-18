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
                        columnmCount++;
                        //it is found, use recursion
                        columnmCount = keepCountingLandType2(enumToCount, columnmCount, i, j, user);
                        totalCount += columnmCount; // move the increment here
                    }
                }
                if(user.getPlayerBoard().TileBoard[i][j] != null)
                {
                    if(user.getPlayerBoard().TileBoard[i][j].landType == enumToCount) {
                        columnmCount++;
                        //it is found, use recursion
                        columnmCount = keepCountingLandType1(enumToCount, columnmCount, i, j, user);
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

    public static int keepCountingLandType2(habitatEnum enumToCount, int totalCount, int i, int j, player user) {
        int leftCount = 0;
        boolean hasRight=false;

        if (user.getPlayerBoard().TileBoard[i - 1][j] != null) { //the tile to the right's is not null
            if (user.getPlayerBoard().TileBoard[i - 1][j].landType == enumToCount) { //and matches
                totalCount++;
                hasRight=true;
            }
        }
        if (user.getPlayerBoard().TileBoard[i][j + 1] != null && user.getPlayerBoard().TileBoard[i][j + 1].landType2 == enumToCount) //recursive call, when the tile above it matches
        {
            totalCount = keepCountingLandType2(enumToCount,totalCount+1,i,j+1,user);
           // totalCount++; // move the increment here
        }
        else if (user.getPlayerBoard().TileBoard[i][j + 1] == null || user.getPlayerBoard().TileBoard[i][j + 1].landType2 != enumToCount) //no more vertical tiles to count
        {
            if(hasRight && user.getPlayerBoard().TileBoard[i-1][j].landType==enumToCount)
            {
                totalCount = keepCountingLandType1(enumToCount,totalCount-1,i-1,j,user);
            }
            else{
           return totalCount;}
        }
        return totalCount;
    }
    public static int keepCountingLandType1(habitatEnum enumToCount, int totalCount, int i, int j, player user)
    {
        int rightCount = 0;
        boolean hasLeft=false;

        if (user.getPlayerBoard().TileBoard[i + 1][j] != null) { //the tile to the right's is not null
            if (user.getPlayerBoard().TileBoard[i + 1][j].landType2 == enumToCount || (user.getPlayerBoard().TileBoard[i + 1][j].isKeystoneTile && user.getPlayerBoard().TileBoard[i + 1][j].landType==enumToCount)) { //and matches
                totalCount++;
                hasLeft=true;
            }
        }
        if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].landType==enumToCount) //recursive call
        {
            totalCount = keepCountingLandType1(enumToCount,totalCount+1,i,j+1,user);
          //  totalCount++; // move the increment here
        }
        else if(user.getPlayerBoard().TileBoard[i][j+1]==null || user.getPlayerBoard().TileBoard[i][j+1].landType!=enumToCount) //no more vertical tiles to count
        {
            if(hasLeft && user.getPlayerBoard().TileBoard[i+1][j].landType==enumToCount)
            {
                totalCount = keepCountingLandType1(enumToCount,totalCount-1,i+1,j,user);
            }
            else{
           return totalCount;}
        }
        return totalCount;
    }
}
