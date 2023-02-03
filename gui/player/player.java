package player;

import java.util.ArrayList;
import java.util.Collections;

public class player extends Habitat{
static ArrayList<String> names = new ArrayList<String>();
static public  int playercount;


public static void addplayer(String gg) {
	names.add(gg);
}
public int playercount() {
	return names.size();
}
public String getName(int x) {
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

}

