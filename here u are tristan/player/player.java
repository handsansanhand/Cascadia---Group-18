package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class player extends Habitat{
	public static boolean placed = true;
static ArrayList<String> names = new ArrayList<String>();
static public  int playercount;
static public int CurrentPlayer = 0;
public static ArrayList<String> Score = new ArrayList(); 




public static int getplayercount() {
	return playercount;
}

public static void addplayer(String gg) {
	names.add(gg);
}

public int playercount() {
	return names.size();
}
public static String getName(int x) {
	return names.get(x);
}
public static void shuffle() {
	Collections.shuffle(names);
}






public static LinearGradient getHabcolor(Tile x) {

	
	
	
	if(x.getLandType() == habitatEnum.Forest && x.getLandType2() == habitatEnum.Empty) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#32CD32")),
		        new Stop(0.5,Color.web("#32CD32")),
		        new Stop(0.5, Color.web("#32CD32")),
		        new Stop(1,Color.web("#32CD32")));	
		return gradient;

	}
	else if(x.getLandType() == habitatEnum.Mountain&&x.getLandType2() == habitatEnum.Empty) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#B2BEB5")),
		        new Stop(0.5,Color.web("#B2BEB5")),
		        new Stop(0.5, Color.web("#B2BEB5")),
		        new Stop(1,Color.web("#B2BEB5")));	
		return gradient;

	}
	else if(x.getLandType() == habitatEnum.Prairie && x.getLandType2() == habitatEnum.Empty) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#FFFF00")),
		        new Stop(0.5,Color.web("#FFFF00")),
		        new Stop(0.5, Color.web("#FFFF00")),
		        new Stop(1,Color.web("#FFFF00")));	
		return gradient;

	}
	else if(x.getLandType() == habitatEnum.River && x.getLandType2() == habitatEnum.Empty) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#ADD8E6")),
		        new Stop(0.5,Color.web("#ADD8E6")),
		        new Stop(0.5, Color.web("#ADD8E6")),
		        new Stop(1,Color.web("#ADD8E6")));	
		return gradient;
	}
	else if(x.getLandType() == habitatEnum.Wetland&&x.getLandType2() == habitatEnum.Empty) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#023020")),
		        new Stop(0.5,Color.web("#023020")),
		        new Stop(0.5, Color.web("#023020")),
		        new Stop(1,Color.web("#023020")));	
		return gradient;
	}
	else if(x.getLandType() == habitatEnum.Wetland && x.getLandType2() == habitatEnum.Forest || x.getLandType2() == habitatEnum.Wetland && x.getLandType() == habitatEnum.Forest) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#023020")),
		        new Stop(0.5,Color.web("#023020")),
		        new Stop(0.5, Color.web("#32CD32")),
		        new Stop(1,Color.web("#32CD32")));	
		return gradient;
	}
	else if(x.getLandType() ==habitatEnum.Wetland&& x.getLandType2() == habitatEnum.Mountain || x.getLandType2() ==habitatEnum.Wetland&& x.getLandType() == habitatEnum.Mountain) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#023020")),
		        new Stop(0.5,Color.web("#023020")),
		        new Stop(0.5, Color.web("#B2BEB5")),
		        new Stop(1,Color.web("#B2BEB5")));	
		return gradient;
	}
	
	else if(x.getLandType() ==habitatEnum.Wetland&& x.getLandType2() == habitatEnum.River || x.getLandType2() ==habitatEnum.Wetland&& x.getLandType() == habitatEnum.River) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#023020")),
		        new Stop(0.5,Color.web("#023020")),
		        new Stop(0.5, Color.web("#ADD8E6")),
		        new Stop(1,Color.web("#ADD8E6")));	
		return gradient;
	}
	else if(x.getLandType() ==habitatEnum.Wetland&& x.getLandType2() == habitatEnum.Prairie || x.getLandType2() ==habitatEnum.Wetland&& x.getLandType() == habitatEnum.Prairie) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#023020")),
		        new Stop(0.5,Color.web("#023020")),
		        new Stop(0.5, Color.web("#FFFF00")),
		        new Stop(1,Color.web("#FFFF00")));	
		return gradient;
	}
	else if(x.getLandType() ==habitatEnum.Forest&& x.getLandType2() == habitatEnum.Mountain || x.getLandType2() ==habitatEnum.Forest&& x.getLandType() == habitatEnum.Mountain) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#32CD32")),
		        new Stop(0.5,Color.web("#32CD32")),
		        new Stop(0.5, Color.web("#B2BEB5")),
		        new Stop(1,Color.web("#B2BEB5")));	
		return gradient;
	}
	else if(x.getLandType() ==habitatEnum.Forest&& x.getLandType2() == habitatEnum.River || x.getLandType2() ==habitatEnum.Forest&& x.getLandType() == habitatEnum.River) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#32CD32")),
		        new Stop(0.5,Color.web("#32CD32")),
		        new Stop(0.5, Color.web("#ADD8E6")),
		        new Stop(1,Color.web("#ADD8E6")));	
		return gradient;
	}
	else if(x.getLandType() ==habitatEnum.Forest&& x.getLandType2() == habitatEnum.Prairie || x.getLandType2() ==habitatEnum.Forest&& x.getLandType() == habitatEnum.Prairie) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#32CD32")),
		        new Stop(0.5,Color.web("#32CD32")),
		        new Stop(0.5, Color.web("#FFFF00")),
		        new Stop(1,Color.web("#FFFF00")));	
		return gradient;
	}
	else if(x.getLandType() ==habitatEnum.Mountain&& x.getLandType2() == habitatEnum.River || x.getLandType2() ==habitatEnum.Mountain&& x.getLandType() == habitatEnum.River) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#B2BEB5")),
		        new Stop(0.5,Color.web("#B2BEB5")),
		        new Stop(0.5, Color.web("#ADD8E6")),
		        new Stop(1,Color.web("#ADD8E6")));	
		return gradient;
	}
	else if(x.getLandType() ==habitatEnum.Mountain&& x.getLandType2() == habitatEnum.Prairie || x.getLandType2() ==habitatEnum.Mountain&& x.getLandType() == habitatEnum.Prairie) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#B2BEB5")),
		        new Stop(0.5,Color.web("#B2BEB5")),
		        new Stop(0.5, Color.web("#FFFF00")),
		        new Stop(1,Color.web("#FFFF00")));	
		return gradient;
	}

	else if(x.getLandType() ==habitatEnum.River&& x.getLandType2() == habitatEnum.Prairie || x.getLandType2() ==habitatEnum.River&& x.getLandType() == habitatEnum.Prairie) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#ADD8E6")),
		        new Stop(0.5,Color.web("#ADD8E6")),
		        new Stop(0.5, Color.web("#FFFF00")),
		        new Stop(1,Color.web("#FFFF00")));	
		return gradient;
	}
	
	LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
	        new Stop(0, Color.web("#90EE90")),
	        new Stop(0.5,Color.web("#90EE90")),
	        new Stop(0.5, Color.web("#90EE90")),
	        new Stop(1,Color.web("#90EE90")));
	return gradient;
	
}





// should take in tile 

public static String StartingWildlifeToken(Tile x) {
	if(x.landType == habitatEnum.Mountain) {
		switch((int) Math.round(Math.random()*2)){
        case 0:
            animal1 = tokenEnum.BEAR;
            break;
        case 1:
            animal1 = tokenEnum.HAWK;
            break;
        case 2:
            animal1 = tokenEnum.ELK;
            break;
	}
    	return animal1.toString();

	}
		if(x.landType == habitatEnum.Forest) {
	        switch((int) Math.round(Math.random()*3)){
            case 0:
                animal1 = tokenEnum.BEAR;
                break;
            case 1:
                animal1 = tokenEnum.HAWK;
                break;
            case 2:
                animal1 = tokenEnum.ELK;
                break;
            case 3:
                animal1 = tokenEnum.FOX;
                break;
        }
        	return animal1.toString();

		}
	        if(x.landType == habitatEnum.Prairie) {
	            switch((int) Math.round(Math.random()*2)){
                case 0:
                    animal1 = tokenEnum.HAWK;
                    break;
                case 1:
                    animal1 = tokenEnum.ELK;
                    break;
                case 2:
                    animal1 = tokenEnum.FOX;
                    break;
            }
	        	return animal1.toString();

	        }
	        if(x.landType == habitatEnum.River) {
	        	switch((int) Math.round(Math.random()*2)){
                case 0:
                    animal1 = tokenEnum.SALMON;
                    break;
                case 1:
                    animal1 = tokenEnum.HAWK;
                    break;
                case 2:
                    animal1 = tokenEnum.FOX;
                    break;
            }
	        	return animal1.toString();

	        }
	        if(x.landType == habitatEnum.Wetland) {
	        	switch((int) Math.round(Math.random()*2)){
                case 0:
                    animal1 = tokenEnum.SALMON;
                    break;
                case 1:
                    animal1 = tokenEnum.HAWK;
                    break;
                case 2:
                    animal1 = tokenEnum.BEAR;
                    break;
            }
	        	return animal1.toString();

	        }
		
	
	
	return tokenEnum.BEAR.toString();


}













public static boolean isValidClick(int row, int col,Rectangle[][] rectangles) {
    // Check if the rectangle is adjacent to a filled rectangle
    if(row != 0 && col != 0 && row !=6 && col !=6) {
	if (rectangles[row+1][col].getFill() != Color.WHITE || rectangles[row-1][col].getFill() != Color.WHITE || rectangles[row][col+1].getFill() != Color.WHITE|| rectangles[row][col-1].getFill() != Color.WHITE) {
        return true;
    }
    }
    if(row == 0 && col != 0)
    if (rectangles[row+1][col].getFill() != Color.WHITE || rectangles[row][col+1].getFill() != Color.WHITE|| rectangles[row][col-1].getFill() != Color.WHITE) {
        return true;
    }
    if(row == 0 )
        if (rectangles[row+1][col].getFill() != Color.WHITE || rectangles[row][col+1].getFill() != Color.WHITE) {
            return true;
        }
    if(row == 6 && col != 6 ) {
        if ( rectangles[row][col+1].getFill() != Color.WHITE || rectangles[row-1][col].getFill() != Color.WHITE ||rectangles[row][col-1].getFill() != Color.WHITE) {
            return true;
        }
    }

    return false;
}
















public void setPlayerCount(int x) {
    // TODO Auto-generated method stub
	playercount = x;
}














}

