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
                        totalCount++;
                        columnmCount++;
                        //it is found, use recursion
                        columnmCount = columnmCount + keepCountingLandType2(enumToCount, columnmCount, i, j, user);
                    }
                }
                if(user.getPlayerBoard().TileBoard[i][j] != null)
                {
                    if(user.getPlayerBoard().TileBoard[i][j].landType == enumToCount) {
                        totalCount++;
                        columnmCount++;
                        //it is found, use recursion
                        columnmCount = columnmCount + keepCountingLandType1(enumToCount, columnmCount, i, j, user);
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

    public static int keepCountingLandType2(habitatEnum enumToCount, int totalCount, int i, int j, player user)
    {
         if(user.getPlayerBoard().TileBoard[i][j].isKeystoneTile) {
        if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].landType==enumToCount)
        {
            totalCount = totalCount + keepCountingLandType1(enumToCount,totalCount,i,j+1,user);
        }
        if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].landType2==enumToCount)
        {
            totalCount = totalCount + keepCountingLandType2(enumToCount,totalCount,i,j+1,user);
        }
    }
        else if(user.getPlayerBoard().TileBoard[i][j+1]==null || user.getPlayerBoard().TileBoard[i][j+1].landType2!=enumToCount)
        {
            return 0;
        }
        else if(user.getPlayerBoard().TileBoard[i][j+1].landType2 == enumToCount || (user.getPlayerBoard().TileBoard[i][j+1].landType2==habitatEnum.Empty && user.getPlayerBoard().TileBoard[i][j+1].landType==enumToCount))
        {
            totalCount = totalCount + keepCountingLandType2(enumToCount,totalCount,i,j+1,user);
        }
        return totalCount;
    }
    public static int keepCountingLandType1(habitatEnum enumToCount, int totalCount, int i, int j, player user)
    {
         if(user.getPlayerBoard().TileBoard[i][j].isKeystoneTile) {
        if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].landType==enumToCount)
        {
            totalCount = totalCount + keepCountingLandType1(enumToCount,totalCount,i,j+1,user);
        }
        if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].landType2==enumToCount)
        {
            totalCount = totalCount + keepCountingLandType2(enumToCount,totalCount,i,j+1,user);
        }
    }
        else if(user.getPlayerBoard().TileBoard[i][j+1]==null || user.getPlayerBoard().TileBoard[i][j+1].landType!=enumToCount)
        {
            return 0;
        }
       else if(user.getPlayerBoard().TileBoard[i][j+1].landType == enumToCount)
        {
            totalCount = totalCount + keepCountingLandType1(enumToCount,totalCount,i,j+1,user);
        }
        return totalCount;
    }

}
