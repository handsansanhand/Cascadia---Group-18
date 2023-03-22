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
                    totalCount = keepCountingLandType1(enumToCount, totalCount, i - 1, j, user, false, true, visited); //start counting right (cant go back left)
                    //visited[i-1][j]=true;
                    // totalCount++;
            }

        //can i go up?
        if (user.getPlayerBoard().TileBoard[i][j + 1] != null && user.getPlayerBoard().TileBoard[i][j + 1].landType2 == enumToCount) //recursive call, when the tile above it matches
        {
            //i can go up
            totalCount = keepCountingLandType2(enumToCount,totalCount,i,j+1,user,true, visited);
           // visited[i][j+1]=true;
            //totalCount++; // move the increment here
        }
        else if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].isKeystoneTile && user.getPlayerBoard().TileBoard[i][j+1].landType==enumToCount)
        {//if theres a keystone tile above that matches, i can go up

            totalCount = keepCountingLandType1(enumToCount,totalCount,i,j+1,user,true,true,visited);
            //visited[i][j+1]=true;
            //totalCount++;
        }
        return totalCount+1;
    }
    public static int keepCountingLandType1(habitatEnum enumToCount, int totalCount, int i, int j, player user, boolean canGoLeft, boolean canGoRight, boolean[][] visited)
    {
        int rightCount = 0;
        boolean hasLeft=false;
        boolean keystoneJumpAvailable=false;
        boolean keystoneLeft=false;

        //check if i can go left
        if (user.getPlayerBoard().TileBoard[i + 1][j] != null) { //the tile to the lefts's is not null
            if (user.getPlayerBoard().TileBoard[i + 1][j].landType2 == enumToCount) { //and matches
                System.out.println(user.getPlayerBoard().TileBoard[i][j] + " i am a tile but with something to the left");
                hasLeft = true;
            }
            else if((user.getPlayerBoard().TileBoard[i + 1][j].isKeystoneTile && user.getPlayerBoard().TileBoard[i + 1][j].landType==enumToCount))
            {
                System.out.println(user.getPlayerBoard().TileBoard[i][j] + " i am a tile but with a keystone to the left");
                System.out.println("theres a keysotne left");
                keystoneLeft=true;
            }
        }
        else if (user.getPlayerBoard().TileBoard[i][j]!=null && user.getPlayerBoard().TileBoard[i][j].isKeystoneTile && user.getPlayerBoard().TileBoard[i - 1][j]!=null && user.getPlayerBoard().TileBoard[i - 1][j].landType == enumToCount && canGoRight) { //i am a keystone tile with an available tile to the RIGHT
            {
                System.out.println(user.getPlayerBoard().TileBoard[i][j] + " i am a keystone tile but with an eligible tile to the right");
                keystoneJumpAvailable = true;
            }
        }

        //can i go accross?
            //can i just go left
            if(hasLeft && canGoLeft)
            {
                System.out.println(user.getPlayerBoard().TileBoard[i][j] + " i am a tile but with something eligible to the left");
                totalCount = keepCountingLandType2(enumToCount,totalCount,i+1,j,user,false, visited); //start counting left
                //visited[i+1][j] =true;
                //totalCount++;
            }
            if(keystoneLeft && canGoLeft) //can i go left into a keystone tile
            {
                System.out.println(user.getPlayerBoard().TileBoard[i][j] + " i am a tile but with an eligible keystone to the left, i will now jump to it");
                totalCount = keepCountingLandType1(enumToCount,totalCount,i+1,j,user,true,false, visited);
                //visited[i+1][j] =true;
            }
            if(keystoneJumpAvailable) //i am a keystone tile, can i go right?
            {
                System.out.println(user.getPlayerBoard().TileBoard[i][j] + " i am a keystone tile but with an eligible jump to the right, jumping");
                totalCount = keepCountingLandType1(enumToCount,totalCount,i-1,j,user,false,true, visited);
                //visited[i-1][j]=true;
            }

            //ok i cant go left,
            //can i go up?
            if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j+1].landType==enumToCount && !visited[i][j+1]) //recursive call
            {
                //i can go up
                System.out.println(user.getPlayerBoard().TileBoard[i][j] + " i am a tile but with something eligible above me");
                totalCount = keepCountingLandType1(enumToCount,totalCount,i,j+1,user,true,true, visited);
                //visited[i][j+1]=true;
               // totalCount++;
            }
            else if(user.getPlayerBoard().TileBoard[i][j+1]!=null && user.getPlayerBoard().TileBoard[i][j].isKeystoneTile && user.getPlayerBoard().TileBoard[i][j+1].landType2==enumToCount && !visited[i][j+1])
            {//if im a keystone tile
                System.out.println(user.getPlayerBoard().TileBoard[i][j] + " i am a keystone tile but with something to the up right");
                totalCount = keepCountingLandType2(enumToCount,totalCount,i,j+1,user,true,visited);
                //visited[i][j+1]=true;
                //totalCount++;
            }
        System.out.println("total current count: " + (totalCount+1));
        return totalCount+1;
    }
}
