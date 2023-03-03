package player;

import java.util.ArrayList;


public class Habitat {
    static tokenEnum animal1;
    static  tokenEnum animal2;
    static tokenEnum animal3;
    
    
	

	

static ArrayList<String> habittats = new ArrayList<String>();
public Habitat() {
	habittats.add("Forest");
	habittats.add("Wetland");
	habittats.add("River");
	habittats.add("Mountain");
	habittats.add("Prairie");

	habittats.add("Forest_Wetland");
	habittats.add("Forest_River");
	habittats.add("Forest_Mountain");
	habittats.add("Forest_Prairie");
	habittats.add("Wetland_River");
	
	habittats.add("Wetland_Mountain");
	habittats.add("Wetland_Prairie");
}


}