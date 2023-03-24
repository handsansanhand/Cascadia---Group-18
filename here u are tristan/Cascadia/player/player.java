package player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class player extends Habitat{
	
public static ArrayList<Text> wildlifetokenplaced = new ArrayList<Text>();
	public static boolean placed = true;
static ArrayList<String> names = new ArrayList<String>();
public static HashMap<Integer ,ArrayList<Double>> alreadycounted = new HashMap<Integer, ArrayList<Double>>();
static public  int playercount;
public static HashMap<Integer,Integer> NatureTokens = new HashMap<Integer,Integer>();
static public int CurrentPlayer = 0;
public static ArrayList<String> Score = new ArrayList(); 
public static HashMap<Integer,Integer> HawkCount = new HashMap<Integer,Integer>();
public static boolean iskeystone = false;
public static HashMap<Integer,Integer> numtimesbeara = new HashMap<Integer,Integer>();
public static HashMap<Integer,Integer> numtimeshawka = new HashMap<Integer,Integer>();
public static HashMap<Integer,Integer> numtimeshawkb = new HashMap<Integer,Integer>();
public static HashMap<Integer,Integer> numtimeselka = new HashMap<Integer,Integer>();
public static HashMap<Integer,Integer> numtimeselkb = new HashMap<Integer,Integer>();



public static boolean hasNatureTokens(int x) {
	if(NatureTokens.get(x) > 0) {
		NatureTokens.put(x, NatureTokens.get(x)-1);
		return true;	
	}
	else {
		return false;
	}
}

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


public static String Wildlifecounter(ArrayList<Text> gg) {
	int ELK = 0;
	int SALMON = 0;
	int FOX = 0;
	int HAWK = 0;
	int BEAR = 0;
	
	for (Text textggg : gg) {
		if(textggg.getText().contains("ELK")) {
			ELK++;
		
		}
		if(textggg.getText().contains("HAWK")) {
			HAWK++;
		
		}
		if(textggg.getText().contains("SALMON")) {
			SALMON++;
		}
		if(textggg.getText().contains("FOX")) {
			FOX++;
		}
		if(textggg.getText().contains("BEAR")) {
			BEAR++;
		}
		
		
	}
	return "ELK: "+ELK+" BEAR: "+BEAR+" FOX: "+FOX+" SALMON: "+SALMON+" HAWK: "+HAWK;
}









public static LinearGradient getHabcolor(Tile x) {
	int randomNumber = (int) (Math.random() * 10) + 1;
if(randomNumber == 5 ) {
	iskeystone = true;
}
else {
	iskeystone = false;
}
	if(iskeystone == false) {
	
	
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
		        new Stop(0, Color.web("#6d735f")),
		        new Stop(0.5,Color.web("#6d735f")),
		        new Stop(0.5, Color.web("#6d735f")),
		        new Stop(1,Color.web("#6d735f")));	
		return gradient;
	}
	else if(x.getLandType() == habitatEnum.Wetland && x.getLandType2() == habitatEnum.Forest || x.getLandType2() == habitatEnum.Wetland && x.getLandType() == habitatEnum.Forest) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#6d735f")),
		        new Stop(0.5,Color.web("#6d735f")),
		        new Stop(0.5, Color.web("#32CD32")),
		        new Stop(1,Color.web("#32CD32")));	
		return gradient;
	}
	else if(x.getLandType() ==habitatEnum.Wetland&& x.getLandType2() == habitatEnum.Mountain || x.getLandType2() ==habitatEnum.Wetland&& x.getLandType() == habitatEnum.Mountain) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#6d735f")),
		        new Stop(0.5,Color.web("#6d735f")),
		        new Stop(0.5, Color.web("#B2BEB5")),
		        new Stop(1,Color.web("#B2BEB5")));	
		return gradient;
	}
	
	else if(x.getLandType() ==habitatEnum.Wetland&& x.getLandType2() == habitatEnum.River || x.getLandType2() ==habitatEnum.Wetland&& x.getLandType() == habitatEnum.River) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#6d735f")),
		        new Stop(0.5,Color.web("#6d735f")),
		        new Stop(0.5, Color.web("#ADD8E6")),
		        new Stop(1,Color.web("#ADD8E6")));	
		return gradient;
	}
	else if(x.getLandType() ==habitatEnum.Wetland&& x.getLandType2() == habitatEnum.Prairie || x.getLandType2() ==habitatEnum.Wetland&& x.getLandType() == habitatEnum.Prairie) {
		LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#6d735f")),
		        new Stop(0.5,Color.web("#6d735f")),
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
	
	
	}
	
	if(iskeystone == true) {
		if(x.getLandType() == habitatEnum.Forest && x.getLandType2() == habitatEnum.Empty) {
			LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
			        new Stop(0, Color.web("#FF0000")),
			        new Stop(0.5,Color.web("#32CD32")),
			        new Stop(0.5, Color.web("#32CD32")),
			        new Stop(1,Color.web("#32CD32")));	
			return gradient;

		}
		else if(x.getLandType() == habitatEnum.Mountain&&x.getLandType2() == habitatEnum.Empty) {
			LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
			        new Stop(0, Color.web("#FF0000")),
			        new Stop(0.5,Color.web("#B2BEB5")),
			        new Stop(0.5, Color.web("#B2BEB5")),
			        new Stop(1,Color.web("#B2BEB5")));	
			return gradient;

		}
		else if(x.getLandType() == habitatEnum.Prairie && x.getLandType2() == habitatEnum.Empty) {
			LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
			        new Stop(0, Color.web("#FF0000")),
			        new Stop(0.5,Color.web("#FFFF00")),
			        new Stop(0.5, Color.web("#FFFF00")),
			        new Stop(1,Color.web("#FFFF00")));	
			return gradient;

		}
		else if(x.getLandType() == habitatEnum.River && x.getLandType2() == habitatEnum.Empty) {
			LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
			        new Stop(0, Color.web("#FF0000")),
			        new Stop(0.5,Color.web("#ADD8E6")),
			        new Stop(0.5, Color.web("#ADD8E6")),
			        new Stop(1,Color.web("#ADD8E6")));	
			return gradient;
		}
		else if(x.getLandType() == habitatEnum.Wetland&&x.getLandType2() == habitatEnum.Empty) {
			LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
			        new Stop(0, Color.web("#FF0000")),
			        new Stop(0.5,Color.web("#6d735f")),
			        new Stop(0.5, Color.web("#6d735f")),
			        new Stop(1,Color.web("#6d735f")));	
			return gradient;
		}
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
public static String getMajorityColor(Paint paint) {
    if (paint instanceof LinearGradient) {
        LinearGradient lg = (LinearGradient) paint;
        List<Stop> stops = lg.getStops();
        int[] counts = {0, 0, 0, 0, 0};

        for (Stop stop : stops) {
            Color color = (Color) stop.getColor();
            if (color.equals(Color.web("#32CD32"))) {
                counts[0]++;
            } else if (color.equals(Color.web("#B2BEB5"))) {
                counts[1]++;
            } else if (color.equals(Color.web("#FFFF00"))) {
                counts[2]++;
            } else if (color.equals(Color.web("#ADD8E6"))) {
                counts[3]++;
            } else if (color.equals(Color.web("#023020"))) {
                counts[4]++;
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > counts[maxIndex]) {
                maxIndex = i;
            }
        }

        switch (maxIndex) {
            case 0:
                return "forest";
            case 1:
                return "mountain";
            case 2:
                return "prairie";
            case 3:
                return "river";
            case 4:
                return "wetland";
            default:
                return "";
        }
    }

    return "";
}





public static boolean canPlacetokenHere(int row,int col,Rectangle[][] rectangles,String token) {
	if(rectangles[row][col].getFill() == Color.WHITE) {
		return false;
	}
	else if(token == "HAWK" && getMajorityColor(rectangles[row][col].getFill())== "river"||token == "HAWK" && getMajorityColor(rectangles[row][col].getFill())== "forest") {
		return true;
	}
	else if(token == "HAWK" && getMajorityColor(rectangles[row][col].getFill())== "mountain"||token == "HAWK" && getMajorityColor(rectangles[row][col].getFill())== "prairie") {
		return true;
	}
	else if(token == "HAWK" && getMajorityColor(rectangles[row][col].getFill())== "wetland") {
		return true;
	}
	else if(token == "BEAR" && getMajorityColor(rectangles[row][col].getFill())== "wetland"||token == "BEAR" && getMajorityColor(rectangles[row][col].getFill())== "forest") {
		return true;
	}
	else if(token == "BEAR" && getMajorityColor(rectangles[row][col].getFill())== "mountain") {
		return true;
	}
	else if(token == "SALMON" && getMajorityColor(rectangles[row][col].getFill())== "wetland"||token == "SALMON" && getMajorityColor(rectangles[row][col].getFill())== "river") {
		return true;
	}
	else if(token == "ELK" && getMajorityColor(rectangles[row][col].getFill())== "forest"||token == "ELK" && getMajorityColor(rectangles[row][col].getFill())== "prairie") {
		return true;
	}
	else if(token == "ELK" && getMajorityColor(rectangles[row][col].getFill())== "mountain") {
		return true;
	}
	
	else if(token == "FOX" && getMajorityColor(rectangles[row][col].getFill())== "forest"||token == "FOX" && getMajorityColor(rectangles[row][col].getFill())== "prairie") {
		return true;
	}
	else if(token == "FOX" && getMajorityColor(rectangles[row][col].getFill())== "river") {
		return true;
	}
	
	return false;
}







public static int BearScoringA( ArrayList<Text> gg, int currentPlayer2) {
	ArrayList<Double> templist = new ArrayList<>(alreadycounted.get(currentPlayer2));

	int score = 0;
	
	for(Text text:gg ) {
    	String compare = text.getText();
    	double X = text.getX();
    	double Y = text.getY();
    	if(compare.contains("BEAR")) {
    		if(!templist.contains(X)&&!templist.contains(Y)) {
    			for(Text text1:gg) {
    				if(text1.getText().contains("BEAR")) {
    			 double rightcaseX = text1.getX() - X;
    			 double rightcaseY = text1.getX() - Y;
    			 double leftcaseX = text1.getX() + X;
    			 double leftcaseY = text1.getX() + Y;
    			 if(rightcaseX==60 && rightcaseY!=60&&leftcaseX!=60&&leftcaseY!=60||rightcaseX!=60 && rightcaseY==60&&leftcaseX!=60&&leftcaseY!=60||rightcaseX!=60 && rightcaseY!=60&&leftcaseX!=60&&leftcaseY==60) {
    				templist.add(X);
    	    		templist.add(Y);
    	    		alreadycounted.put(currentPlayer2, templist);
    	    		score = score + getbearAScore(numtimesbeara.get(currentPlayer2));
 
    	    		int temp = numtimesbeara.get(currentPlayer2) + 1;
    	    		numtimesbeara.put(currentPlayer2, temp);
    	    		
    	    		
    			 }
    			}
    			}
    			}
    		}	
}

return score;

}
private static int getbearAScore(int numtime) {
    if (numtime == 1) {
        return 2;
    } else if (numtime == 2) {
        return 5;
    } else if (numtime == 3) {
        return 9;
    } else if (numtime == 4) {
        return 13;
    } else {
        return 0;
    }
}
public static int BearScoringB(ArrayList<Text> gg, int currentPlayer2) {
	ArrayList<Double> templist = new ArrayList<>(alreadycounted.get(currentPlayer2));

	int score = 0;
	
	for(Text text:gg ) {
    	String compare = text.getText();
    	double X = text.getX();
    	double Y = text.getY();
    	if(compare.contains("BEAR")) {
    		System.out.println("checkeboxer");
    		if(!templist.contains(X)&&!templist.contains(Y)) {
    			for(Text text1:gg) {
    				if(text1.getText().contains("BEAR")) {
    			 double rightcaseX = text1.getX() - X;
    			 double rightcaseY = text1.getX() - Y;
    			 double leftcaseX = text1.getX() + X;
    			 double leftcaseY = text1.getX() + Y;
    			 if(rightcaseX==60&&rightcaseY==60&&leftcaseX!=60&&leftcaseY!=60 || rightcaseX==60 && rightcaseY!=60&&leftcaseX==60&&leftcaseY!=60 || rightcaseX==60 && rightcaseY!=60&&leftcaseX!=60&&leftcaseY==60) {
    				templist.add(X);
    	    		templist.add(Y);
    	    		alreadycounted.put(currentPlayer2, templist);
    	    		score = score + 10;
 
    	    		
    	    		
    	    		
    			 }
    			 else  if(rightcaseX!=60 && rightcaseY==60&&leftcaseX==60&&leftcaseY!=60||rightcaseX!=60 && rightcaseY==60&&leftcaseX!=60&&leftcaseY==60) {
     				templist.add(X);
     	    		templist.add(Y);
     	    		alreadycounted.put(currentPlayer2, templist);
     	    		score = score + 10;
     	    		
     	    		
     			 }
    			 else  if(rightcaseX!=60 && rightcaseY!=60&&leftcaseX==60&&leftcaseY==60) {
      				templist.add(X);
      	    		templist.add(Y);
      	    		alreadycounted.put(currentPlayer2, templist);
      	    		score = score + 10;
      	    		
      	    		
      			 }
    			}
    			}
    			}
    		}	
}

return score;

}
public static int BearScoringC(ArrayList<Text> gg, int currentPlayer2) {
	ArrayList<Double> templist = new ArrayList<>(alreadycounted.get(currentPlayer2));

	int score = 0;
	
	for(Text text:gg ) {
    	String compare = text.getText();
    	double X = text.getX();
    	double Y = text.getY();
    	if(compare.contains("BEAR")) {
    		if(!templist.contains(X)&&!templist.contains(Y)) {
    			for(Text text1:gg) {
    				if(text1.getText().contains("BEAR")) {
    			 double rightcaseX = text1.getX() - X;
    			 double rightcaseY = text1.getX() - Y;
    			 double leftcaseX = text1.getX() + X;
    			 double leftcaseY = text1.getX() + Y;
    			 if(rightcaseX!=60 && rightcaseY!=60&&leftcaseX!=60&&leftcaseY!=60) {
    				templist.add(X);
    	    		templist.add(Y);
    	    		alreadycounted.put(currentPlayer2, templist);
    	    		score = 2;
 	
    			 }
    			 if(rightcaseX==60 && rightcaseY!=60&&leftcaseX!=60&&leftcaseY!=60||rightcaseX!=60 && rightcaseY==60&&leftcaseX!=60&&leftcaseY!=60||rightcaseX!=60 && rightcaseY!=60&&leftcaseX!=60&&leftcaseY==60) {
    					templist.add(X);
        	    		templist.add(Y);
        	    		alreadycounted.put(currentPlayer2, templist);
        	    		score = 5;
        	    		}
    			 
    			 
    			 if(rightcaseX!=60 && rightcaseY!=60&&leftcaseX==60&&leftcaseY==60||rightcaseX!=60 && rightcaseY==60&&leftcaseX==60&&leftcaseY!=60||rightcaseX!=60 && rightcaseY==60&&leftcaseX!=60&&leftcaseY==60||rightcaseX==60&&rightcaseY==60&&leftcaseX!=60&&leftcaseY!=60 || rightcaseX==60 && rightcaseY!=60&&leftcaseX==60&&leftcaseY!=60 || rightcaseX==60 && rightcaseY!=60&&leftcaseX!=60&&leftcaseY==60) {
     				templist.add(X);
     	    		templist.add(Y);
     	    		alreadycounted.put(currentPlayer2, templist);
     	    		score = 8;
    			}
    			}
    			}
    		}	
}


}
	return score;

}
public static int HawkScoringA( ArrayList<Text> gg, int currentPlayer2) {
	ArrayList<Double> templist = new ArrayList<>(alreadycounted.get(currentPlayer2));

	int score = 0;
	
	for(Text text:gg ) {
    	String compare = text.getText();
    	double X = text.getX();
    	double Y = text.getY();
    	
    	if(compare.contains("HAWK")) {
    		

    		if(!templist.contains(X)&&!templist.contains(Y)) {
    			for(Text text1:gg) {
    				if(text1.getText().contains("HAWK")) {
    			 double rightcaseX = text1.getX() - X;
    			 double rightcaseY = text1.getX() - Y;
    			 double leftcaseX = text1.getX() + X;
    			 double leftcaseY = text1.getX() + Y;
					


    			 if(rightcaseX!=60 && rightcaseY!=60&&leftcaseX!=60&&leftcaseY!=60&&!templist.contains(text1.getX())||!templist.contains(text1.getY())) {
    				 System.out.println("hawk on board not next to another");
    				 System.out.println(numtimeshawka.get(currentPlayer2));
    				templist.add(X);
    	    		templist.add(Y);
    	    		alreadycounted.put(currentPlayer2, templist);
    	    		score = gethawkAScore(numtimeshawka.get(currentPlayer2));
    	    		int temp = numtimeshawka.get(currentPlayer2) + 1;
    	    		numtimeshawka.put(currentPlayer2, temp);
    			 }
    			 else if(rightcaseX==60&&templist.contains(text1.getY())&&templist.contains(text1.getX())||rightcaseY==60&&templist.contains(text1.getY())&&templist.contains(text1.getX())||leftcaseX==60&&templist.contains(text1.getY())&&templist.contains(text1.getX())||leftcaseY==60&&templist.contains(text1.getY())&&templist.contains(text1.getX())) {
    				 
    				 int temp = numtimeshawka.get(currentPlayer2) - 1;
     	    		 numtimeshawka.put(currentPlayer2, temp);
     	    		score = gethawkAScore(numtimeshawka.get(currentPlayer2));
    			 }
    			}
    	
    			}
    			}
    		}	
}

return score;

}
private static int gethawkAScore(int numtime) {
    if (numtime == 1) {
        return 2;
    } else if (numtime == 2) {
        return 5;
    } else if (numtime == 3) {
        return 8;
    } else if (numtime == 4) {
        return 11;
    } else {
        return 14;
    }
}
public static int HawkScoringB(ArrayList<Text> gg, int currentPlayer2) {
	ArrayList<Double> templist = new ArrayList<>(alreadycounted.get(currentPlayer2));
    int score = 0;

    for (Text text : gg) {
        String compare = text.getText();
        double X = text.getX();
        double Y = text.getY();

        if (compare.contains("HAWK")) {
            if (!templist.contains(X) && !templist.contains(Y)) {
                for (Text text1 : gg) {
                    if (text1.getText().contains("HAWK")) {
                        double distance = Math.sqrt(Math.pow(text1.getX() - X, 2) + Math.pow(text1.getY() - Y, 2));
                        if (distance == 0) {
                            templist.add(X);
                            templist.add(Y);
                            alreadycounted.put(currentPlayer2, templist);
                            score = gethawkBScore(numtimeshawkb.get(currentPlayer2));
                            numtimeshawkb.put(currentPlayer2, numtimeshawkb.get(currentPlayer2) + 1);
                            break;  
                        }
                    }
                }
            }
        }
    }

    return score;
}




private static int gethawkBScore(int numtime) {
    if (numtime == 1) {
        return 2;
    } else if (numtime == 2) {
        return 5;
    } else if (numtime == 3) {
        return 4;
    } else if (numtime == 4) {
        return 3;
    } else {
        return 4;
    }
}
public static int HawkScoringC( ArrayList<Text> gg, int currentPlayer2) {
	ArrayList<Double> templist = new ArrayList<>(alreadycounted.get(currentPlayer2));
	int score = 0;
	for(Text text:gg ) {
    	String compare = text.getText();
    	double X = text.getX();
    	double Y = text.getY();
    	if(compare.contains("HAWK")) {
    		if(!templist.contains(X)&&!templist.contains(Y)) {
    			for(Text text1:gg) {
    				if(text1.getText().contains("HAWK")) {
    			 double rightcaseX = text1.getX() - X;
    			 double rightcaseY = text1.getX() - Y;
    			 double leftcaseX = text1.getX() + X;
    			 double leftcaseY = text1.getX() + Y;
    			 if(rightcaseX==180||rightcaseY==180||leftcaseX==180||leftcaseY==180) {
    				templist.add(X);
    	    		templist.add(Y);
    	    		alreadycounted.put(currentPlayer2, templist);
    	    		score = 3;
    			 }}}}}}

return score;
}
public static int ElkScoring(ArrayList<Text> gg, int currentPlayer2) {
    ArrayList<Double> templist = new ArrayList<>(alreadycounted.get(currentPlayer2));
    int score = 0;
    for (Text text : gg) {
        String compare = text.getText();
        double X = text.getX();
        double Y = text.getY();
        if (compare.contains("ELK")) {
            if (!templist.contains(X) && !templist.contains(Y)) {
                boolean foundStraightLine = false;
                int countAdjacentElk = 1;
                double prevX = X;
                double prevY = Y;
                for (Text text1 : gg) {
                    if (text1.getText().contains("ELK")) {
                        double nextX = text1.getX();
                        double nextY = text1.getY();
                        if ((prevX + 60 == nextX && prevY == nextY) || (prevX - 60 == nextX && prevY == nextY) || (prevX == nextX && prevY + 60 == nextY) || (prevX == nextX && prevY - 60 == nextY)) {
                            foundStraightLine = true;
                            countAdjacentElk++;
                            prevX = nextX;
                            prevY = nextY;
                        }
                    }
                }
                if (foundStraightLine) {
                    templist.add(X);
                    templist.add(Y);
                    alreadycounted.put(currentPlayer2, templist);
                    score += getElkScore(countAdjacentElk);
                    int temp = numtimeselka.get(currentPlayer2) + 1;
                    numtimeselka.put(currentPlayer2, temp);
                }
            }
        }
    }
    return score;
}

private static int getElkScore(int countAdjacentElk) {
    if (countAdjacentElk == 1) {
        return 2;
    } else if (countAdjacentElk == 2) {
        return 5;
    } else if (countAdjacentElk == 3) {
        return 9;
    } else if (countAdjacentElk == 4) {
        return 13;
    } else {
        return 0;
    }
}
public static int ElkScoring1(ArrayList<Text> gg, int currentPlayer2) {
    ArrayList<Double> templist = new ArrayList<>(alreadycounted.get(currentPlayer2));
    int score = 0;
    for (Text text : gg) {
        String compare = text.getText();
        double X = text.getX();
        double Y = text.getY();
        if (compare.contains("ELK")) {
            if (!templist.contains(X) && !templist.contains(Y)) {
                boolean foundStraightLine = false;
                int countAdjacentElk = 1;
                double prevX = X;
                double prevY = Y;
                for (Text text1 : gg) {
                    if (text1.getText().contains("ELK")) {
                        double nextX = text1.getX();
                        double nextY = text1.getY();
                        if ((prevX + 60 == nextX && prevY == nextY) || (prevX - 60 == nextX && prevY == nextY) || (prevX == nextX && prevY + 60 == nextY) || (prevX == nextX && prevY - 60 == nextY)) {
                            foundStraightLine = true;
                            countAdjacentElk++;
                            prevX = nextX;
                            prevY = nextY;
                        }
                    }
                }
                if (foundStraightLine) {
                    templist.add(X);
                    templist.add(Y);
                    alreadycounted.put(currentPlayer2, templist);
                    score += getElkScore(countAdjacentElk);
                    int temp = numtimeselka.get(currentPlayer2) + 1;
                    numtimeselka.put(currentPlayer2, temp);
                }
            }
        }
    }
    return score;
}

private static int getElkScore1(int countAdjacentElk) {
    if (countAdjacentElk == 1) {
        return 2;
    } else if (countAdjacentElk == 2) {
        return 5;
    } else if (countAdjacentElk == 3) {
        return 9;
    } else if (countAdjacentElk == 4) {
        return 13;
    } else {
        return 0;
    }
}

private static int getElkScoreB(int countAdjacentElk) {
    if (countAdjacentElk == 1) {
        return 2;
    } else if (countAdjacentElk == 2) {
        return 5;
    } else if (countAdjacentElk == 3) {
        return 9;
    } else if (countAdjacentElk == 4) {
        return 13;
    } else {
        return 0;
    }
}

public static int ElkScoringB(ArrayList<Text> gg, int currentPlayer2) {
    ArrayList<Double> templist = new ArrayList<>(alreadycounted.get(currentPlayer2));
    int score = 0;
    for (Text text : gg) {
        String compare = text.getText();
        double X = text.getX();
        double Y = text.getY();
        if (compare.contains("ELK")) {
            if (!templist.contains(X) && !templist.contains(Y)) {
                boolean foundStraightLine = false;
                int countAdjacentElk = 1;
                double prevX = X;
                double prevY = Y;
                for (Text text1 : gg) {
                    if (text1.getText().contains("ELK")) {
                        double nextX = text1.getX();
                        double nextY = text1.getY();
                        if ((prevX + 60 == nextX && prevY == nextY) || (prevX - 60 == nextX && prevY == nextY) || (prevX == nextX && prevY + 60 == nextY) || (prevX == nextX && prevY - 60 == nextY) || (prevX + 60 == nextX && prevY + 60 == nextY) || (prevX + 60 == nextX && prevY - 60 == nextY) || (prevX - 60 == nextX && prevY + 60 == nextY) || (prevX - 60 == nextX && prevY - 60 == nextY)) {
                            foundStraightLine = true;
                            countAdjacentElk++;
                            prevX = nextX;
                            prevY = nextY;
                        }
                    }
                }
                if (foundStraightLine) {
                    templist.add(X);
                    templist.add(Y);
                    alreadycounted.put(currentPlayer2, templist);
                    score += getElkScoreB(countAdjacentElk);
                    int temp = numtimeselkb.get(currentPlayer2) + 1;
                    numtimeselkb.put(currentPlayer2, temp);
                }
            }
        }
    }
return score;
}
}
