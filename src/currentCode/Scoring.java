package currentCode;


import java.sql.Time;
import java.util.ArrayList;

//class that will contain all the scoring options/methods
public class Scoring {

    ArrayList<player> currentPlayers=gameState.Players;
    static ArrayList<habitatEnum> habitats = new ArrayList<>();

    //method that scores all the habitatEnums
    public static void scoreHabitatCorridors(player user) throws InterruptedException {

        //find the largest corridor of each type
        int forest = countHabitatOccurences(habitatEnum.Forest, user);
        System.out.println(Tile.getHabitatColor(habitatEnum.Forest) + user.name + " has a Highest Corridor of " + forest + " Forest's" + Tile.RESET);
        Thread.sleep(600);
       int mountain = countHabitatOccurences(habitatEnum.Mountain, user);
        System.out.println(Tile.getHabitatColor(habitatEnum.Mountain) + user.name + " has a Highest Corridor of " + mountain + " Mountain's" + Tile.RESET);
        Thread.sleep(600);
        int river =countHabitatOccurences(habitatEnum.River, user);
        System.out.println(Tile.getHabitatColor(habitatEnum.River) + user.name + " has a Highest Corridor of " + river  + " River's" + Tile.RESET);
        Thread.sleep(600);
        int prairie=countHabitatOccurences(habitatEnum.Prairie, user);
        System.out.println(Tile.getHabitatColor(habitatEnum.Prairie) + user.name + " has a Highest Corridor of " + prairie+ " Prairie's" + Tile.RESET);
        Thread.sleep(600);
        int wetland=countHabitatOccurences(habitatEnum.Wetland, user);
        System.out.println(Tile.getHabitatColor(habitatEnum.Wetland) + user.name + " has a Highest Corridor of " + wetland + " Wetland's" + Tile.RESET);
        Thread.sleep(600);
        //add them up
        int totalScore= forest+mountain+river+prairie+wetland;
        System.out.println(Tile.GREEN_BOLD + "" + user.name + "'s Total Habitat Score = " + totalScore + Tile.RESET);
        System.out.println();
        user.score+=totalScore; //increment the score
        Thread.sleep(1500);
    }
    public static void compareLargestCorridors() throws InterruptedException {
        habitats.add(habitatEnum.Forest);
        habitats.add(habitatEnum.Mountain);
        habitats.add(habitatEnum.River);
        habitats.add(habitatEnum.Prairie);
        habitats.add(habitatEnum.Wetland);

        for(int x=0;x<habitats.size();x++) {
            int maxSize=0;
            int secondMaxSize=0;
            player winningPlayer = gameState.getPlayers().get(0);
            player winningPlayer2 = gameState.getPlayers().get(0);
            for (int i = 0; i < gameState.getPlayers().size(); i++) //compare each
            {
                int count = countHabitatOccurences(habitats.get(x), gameState.getPlayers().get(i));
                if(count>maxSize)
                {
                    secondMaxSize=maxSize;
                    maxSize=count;
                    winningPlayer2 = winningPlayer;
                    winningPlayer = gameState.getPlayers().get(i);
                }
                else if(count>secondMaxSize && count<=maxSize)
                {
                    secondMaxSize=count;
                    winningPlayer2 = gameState.getPlayers().get(i);
                }
            }
            if(gameState.playerCount==2)
               {
                   if(secondMaxSize==maxSize) //a tie
                   {
                       winningPlayer2.score+=1;
                       winningPlayer.score+=1;
                       System.out.println(winningPlayer2.name +" and " + winningPlayer.name + " have the same largest corridor of " + Tile.getHabitatColor(habitats.get(x)) + habitats.get(x) + Tile.RESET + " with a score of " + Tile.getHabitatColor(habitats.get(x)) + maxSize + " +1 POINTS" + Tile.RESET);
                   }
                   else{
                       System.out.println(winningPlayer.name + " has the largest corridor of " + Tile.getHabitatColor(habitats.get(x)) + habitats.get(x) + Tile.RESET + "'s with a score of " + Tile.getHabitatColor(habitats.get(x)) + maxSize + " +2 POINTS" + Tile.RESET);
                       Thread.sleep(1000);
                       if(secondMaxSize>0) {
                           System.out.println(winningPlayer2.name + " has the second largest corridor of " + Tile.getHabitatColor(habitats.get(x)) + habitats.get(x) + Tile.RESET + "'s with a score of " + Tile.getHabitatColor(habitats.get(x)) + secondMaxSize + Tile.RESET);
                       }
                       winningPlayer.score += 2;}}

            else if(gameState.playerCount>=3)
            {
                if(secondMaxSize==maxSize) //a tie
                {
                    winningPlayer2.score+=1;
                    winningPlayer.score+=1;
                    System.out.println(winningPlayer2.name +" and " + winningPlayer.name + " have the same largest corridor of " + Tile.getHabitatColor(habitats.get(x)) + habitats.get(x) + Tile.RESET + " with a score of " + Tile.getHabitatColor(habitats.get(x)) + maxSize + " +1 POINT" + Tile.RESET);
                }
                else {
                    System.out.println(winningPlayer.name + " has the largest corridor of " + Tile.getHabitatColor(habitats.get(x)) + habitats.get(x) + Tile.RESET + "'s with a score of " + Tile.getHabitatColor(habitats.get(x)) + maxSize + " +3 POINTS" + Tile.RESET);
                    Thread.sleep(1000);
                    if(secondMaxSize>0) {
                        System.out.println(winningPlayer2.name + " has the second largest corridor of " + Tile.getHabitatColor(habitats.get(x)) + habitats.get(x) + Tile.RESET + "'s with a score of " + Tile.getHabitatColor(habitats.get(x)) + secondMaxSize + " +1 POINT" + Tile.RESET);
                        winningPlayer2.score += 1;
                    }
                    winningPlayer.score += 3;
                }
            }
            Thread.sleep(3000);
        }
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
      //  System.out.println(user.name + " has a longest streak of " + (highestCount) + " of " + enumToCount);
        return highestCount;
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
