package player;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;

public class Habitat {
	
	public final static Image dessert = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/tileSand_tile.png");
	public final static Image forest = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/application/grass.png");
	public final static Image marine = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/Habitats/tileWater_tile.png");
	public final static Image mountains = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/application/grass.png");
	public final static Image rivers = new Image("file:///C:/Users/jackn/eclipse-workspace/Cascadia/src/application/grass.png");
	

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


}

}
