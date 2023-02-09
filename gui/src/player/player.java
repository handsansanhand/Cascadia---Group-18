package player;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.Image;

public class player extends Habitat{
static ArrayList<String> names = new ArrayList<String>();
static public  int playercount;
static public int CurrentPlayer = 0;


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
	return habitattiles.get(x).toString();

}

}

