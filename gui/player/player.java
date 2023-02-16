package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class player extends Habitat{
	
static ArrayList<String> names = new ArrayList<String>();
static public  int playercount;
static public int CurrentPlayer = 0;
public static ArrayList<String> Score = new ArrayList(); 

/*
public static class ImageViewComparator implements Comparator<ImageView> {
    public int compare(ImageView iv1, ImageView iv2) {
        return iv1.getId().compareTo(iv2.getId());
    }
}
*/
public static int getplayercount() {
	return playercount;
}


public static int getScore(ArrayList<String> list) {
    int count = 0;
    HashSet<String> set = new HashSet<String>();

    for (String str : list) {
        if (set.contains(str)) {
            count++;
        } else {
            set.add(str);
        }
    }

    return count;
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
public static void AddImageView(ImageView x) {
	if(x.getImage() == Habitat.dessert) {
		Score.add("dessert");
	}
	if(x.getImage() == Habitat.dessert_forrest) {
		Score.add("desset_forest");
	}
	if(x.getImage() == Habitat.forest) {
		Score.add("forest");
	}
	if(x.getImage() == Habitat.marine) {
		Score.add("marine");
	}
	if(x.getImage() == Habitat.mountains) {
		Score.add("mountains");
	}
	if(x.getImage() == Habitat.rivers) {
		Score.add("rivers");
	}
	if(x.getImage() == Habitat.rock_forest) {
		Score.add("rock_forest");
	}
	
	if(x.getImage() == Habitat.rock_water) {
		Score.add("rock_water");
	}
	if(x.getImage() == Habitat.water_forest) {
		Score.add("water_forest");
	}
	else {
		Score.add("null");
	}

}

}

