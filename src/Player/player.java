package Player;

import java.util.ArrayList;

public class player {
int playerCount;
ArrayList<String> names = new ArrayList<String>();


public int getPlayerCount() {
	return this.playerCount;
}

public void addPLayer(String g) {
	names.add(g);
}
public String getPLayername(int x) {
	return this.names.get(x);
}
public void setPlayerCount(int x) {
	// TODO Auto-generated method stub
	this.playerCount = x;

}

}
