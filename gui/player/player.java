package player;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class player extends Habitat{
	
static ArrayList<String> names = new ArrayList<String>();
static public  int playercount;
static public int CurrentPlayer = 0;
public static ArrayList<ImageView> placedimages = new ArrayList(); 



public static int getplayercount() {
	return playercount;
}

public static void addlastplacetile(ImageView lastClickedImage) {
	placedimages.add(lastClickedImage);

}
public static int getScore(ArrayList<ImageView> x) {
    int score = 0;
    for (int i = 0; i < x.size(); i++) {
        for (int j = i + 1; j < x.size(); j++) {
            if (x.get(i).equals(x.get(j)) && !placedimages.contains(x.get(i))) {
                score++;
                placedimages.add(x.get(i));
            }
        }
    }
    return score;
}


public static void addplayer(String gg) {
	names.add(gg);
}
public static int getcurrentPlayer() {
	return CurrentPlayer;
}
public int playercount() {
	return names.size();
}
public static String getName(int x) {
	return names.get(x);
}
public void shuffle() {
	Collections.shuffle(names);
}
public void shufflehabitats() {
	Collections.shuffle(habittats);
}


public String getHabitat(int x) {
	return habittats.get(x);
}
public static Image getstarttile(int currentplayer) {
if(habittats.get(currentplayer).contains("water")) {
	return marine;
}
if(habittats.get(currentplayer).contains("forest")) {
	return forest;
}
if(habittats.get(currentplayer).contains("rivers")) {
	return rivers;
}
if(habittats.get(currentplayer).contains("mountains")) {
	return mountains;
}
else return dessert;
}
public static void shuffletiles() {
	Collections.shuffle(habitattiles);
	
}
public static Image getTile(int x) {
	return habitattiles.get(x);
}
public static String gettilename(int x) {

	if(habitattiles.get(x) == dessert) {
		return "dessert";
	}
	if(habitattiles.get(x) == forest) {
		return "forest";
	}	if(habitattiles.get(x) == marine) {
		return "marine";
	}	if(habitattiles.get(x) == mountains) {
		return "mountains";
	}
	if(habitattiles.get(x) == dessert_forrest) {
	return "dessert + forest";
	}	if(habitattiles.get(x) == rock_forest) {
	return "rock + forest";	}	if(habitattiles.get(x) == water_forest) {
	return "water+forest";
	}	if(habitattiles.get(x) == rock_water) {
	return "rock+water";
}
	else {
		return "river";
	}
}

}

