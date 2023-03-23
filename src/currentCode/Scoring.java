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
        boolean[][] visited = new boolean[14][14];
        for(int i=0;i<14;i++)
        {
            for(int j=0;j<14;j++)
            {
                visited[i][j]=false;
            }
        }
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
                        columnmCount = keepCountingLandType2(enumToCount, columnmCount, i, j, user,true, visited);
                        totalCount += columnmCount; // move the increment here
                    }
                }
                if(user.getPlayerBoard().TileBoard[i][j] != null)
                {
                    if(user.getPlayerBoard().TileBoard[i][j].landType == enumToCount) {
                        //columnmCount++;
                        //it is found, use recursion
                        columnmCount = keepCountingLandType1(enumToCount, columnmCount, i, j, user,true,true,visited);
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

    public static int keepCountingLandType2(habitatEnum enumToCount, int totalCount, int i, int j, player user, boolean canGoRight, boolean[][] visited) {
        boolean hasRight=false;
        boolean hasDown=false;
        visited[i][j]=true;

        if (i>0 && user.getPlayerBoard().TileBoard[i - 1][j] != null) { //the tile to the right's is not null
            if (user.getPlayerBoard().TileBoard[i - 1][j].landType == enumToCount) { //and matches
                hasRight=true;
            }
        }
        if (j>0 && user.getPlayerBoard().TileBoard[i][j-1] != null) { //the tile to the down
            if (user.getPlayerBoard().TileBoard[i][j-1].landType2 == enumToCount) { //and matches
                hasDown=true;
            }
        }

        //ok can i go accross?
            if(hasRight && canGoRight) //i can go right
            {
                if (!visited[i - 1][j]) {
                    visited[i-1][j]=true;
                    totalCount = keepCountingLandType1(enumToCount, totalCount, i - 1, j, user, false, true, visited); //start counting right (cant go back left)
                }
            }

        //can i go up?
        if (user.getPlayerBoard().TileBoard[i][j + 1] != null && user.getPlayerBoard().TileBoard[i][j + 1].landType2 == enumToCount) //recursive call, when the tile above it matches
        {
            //i can go up
            if (j<tileBoard.BOARD_HEIGHT-1 && !visited[i][j + 1]) {
                visited[i][j+1]=true;
                totalCount = keepCountingLandType2(enumToCount, totalCount, i, j + 1, user, true, visited);
            }
        }
        else if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].isKeystoneTile && user.getPlayerBoard().TileBoard[i][j+1].landType==enumToCount) {//if theres a keystone tile above that matches, i can go up
            if (j<tileBoard.BOARD_HEIGHT-1 && !visited[i][j + 1])
            {
                visited[i][j + 1] = true;
                totalCount = keepCountingLandType1(enumToCount, totalCount, i, j + 1, user, true, true, visited);
            }
        }
        if(hasDown)
        {
            if(!visited[i][j-1])
            {
                visited[i][j-1]=true;
                totalCount = keepCountingLandType2(enumToCount, totalCount, i, j - 1, user, true, visited);
            }
        }
        return totalCount+1;
    }
    public static int keepCountingLandType1(habitatEnum enumToCount, int totalCount, int i, int j, player user, boolean canGoLeft, boolean canGoRight, boolean[][] visited)
    {
        boolean hasLeft=false;
        boolean keystoneJumpAvailable=false;
        boolean keystoneLeft=false;
        boolean hasDown=false;
        visited[i][j]=true;

        //check if i can go left
        if (i<tileBoard.BOARD_WIDTH-1 && user.getPlayerBoard().TileBoard[i + 1][j] != null) { //the tile to the lefts's is not null
            if (user.getPlayerBoard().TileBoard[i + 1][j].landType2 == enumToCount) { //and matches
                hasLeft = true;
            }
            else if((user.getPlayerBoard().TileBoard[i + 1][j].isKeystoneTile && user.getPlayerBoard().TileBoard[i + 1][j].landType==enumToCount))
            {
                keystoneLeft=true;
            }
        }
        if(j>0 && user.getPlayerBoard().TileBoard[i][j-1] != null)
        {
            if (user.getPlayerBoard().TileBoard[i][j-1].landType == enumToCount) { //and matches
                hasDown = true;
            }
        }
        else if (i>0 && user.getPlayerBoard().TileBoard[i][j]!=null && user.getPlayerBoard().TileBoard[i][j].isKeystoneTile && user.getPlayerBoard().TileBoard[i - 1][j]!=null && user.getPlayerBoard().TileBoard[i - 1][j].landType == enumToCount && canGoRight) { //i am a keystone tile with an available tile to the RIGHT
            {
                keystoneJumpAvailable = true;
            }
        }

        //can i go accross?
            //can i just go left
            if(hasLeft && canGoLeft)
            {
                totalCount = keepCountingLandType2(enumToCount,totalCount,i+1,j,user,false, visited); //start counting left

            }
            if(keystoneLeft && canGoLeft) //can i go left into a keystone tile
            {
                totalCount = keepCountingLandType1(enumToCount,totalCount,i+1,j,user,true,false, visited);
            }
            if(keystoneJumpAvailable) //i am a keystone tile, can i go right?
            {
                totalCount = keepCountingLandType1(enumToCount,totalCount,i-1,j,user,false,true, visited);
            }

            //ok i cant go left,
            //can i go up?
            if(j<tileBoard.BOARD_HEIGHT-1 && user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].landType==enumToCount && !visited[i][j+1]) //recursive call
            {
                //i can go up
                totalCount = keepCountingLandType1(enumToCount,totalCount,i,j+1,user,true,true, visited);
            }
            else if(j<tileBoard.BOARD_HEIGHT-1 && user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j].isKeystoneTile && user.getPlayerBoard().TileBoard[i][j+1].landType2==enumToCount && !visited[i][j+1])
            {//if im a keystone tile
                totalCount = keepCountingLandType2(enumToCount,totalCount,i,j+1,user,true,visited);
            }

            //can i go down?
            if(hasDown)
            {
                if(!visited[i][j-1])
                {
                    visited[i][j-1]=true;
                    totalCount = keepCountingLandType2(enumToCount,totalCount,i,j-1,user,true,visited);
                }
            }
        return totalCount+1;
    }
}
