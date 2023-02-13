package player;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;

public class Habitat {
	
	public final static Image dessert = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/dessert.png");
	public final static Image forest = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/grass%20(2).png");
	public final static Image marine = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/marine.png");
	public final static Image rivers = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/river.png");
	public final static Image mountains = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/mountain.png");
	public final static Image rock_forest = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/pixil-frame-0.png");
	public final static Image dessert_forrest = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/forest_Dessert.png");
	public final static Image rock_water = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/marine_mountain.png");
	public final static Image water_forest = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/marine_forest.png");

	

static ArrayList<String> habittats = new ArrayList<String>();
static ArrayList<Image> habitattiles = new ArrayList<Image>();
public Habitat() {
	habittats.add("marine waters");
	habittats.add("forests");
	habittats.add("mountains");
	habittats.add("rivers");
	habittats.add("high deserts");
	habitattiles.add(dessert);
	habitattiles.add(forest);
	habitattiles.add(marine);
	habitattiles.add(dessert);
	habitattiles.add(mountains);
	habitattiles.add(rivers);
	habitattiles.add(dessert_forrest);
	habitattiles.add(rock_forest);
	habitattiles.add(water_forest);
	habitattiles.add(rock_water);


}
public static void addmoretiles() {
	habitattiles.add(dessert_forrest);
	habitattiles.add(rock_forest);
	habitattiles.add(water_forest);
	habitattiles.add(rock_water);
	
}

}
