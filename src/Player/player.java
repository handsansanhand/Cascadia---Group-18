package Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class player {
int playerCount;
ArrayList<String> names = new ArrayList<String>();


public int getPlayerCount() {
	return this.playerCount;
}

public void addPlayer(String g) {
	names.add(g);
}
public String getPlayername(int x) {
	return this.names.get(x);
}
public ArrayList<String> getNames()
{
	return this.names;
}
public void setPlayerCount(int x) {
	// TODO Auto-generated method stub
	this.playerCount = x;
}

public void initializeGame() //function that receives the playernames and randomizes the order in which they play
{
	Scanner in = new Scanner(System.in);
	for(int i=1;i<=getPlayerCount();i++)
	{
		System.out.println("Enter player " + i + "'s Name: ");
		addPlayer(in.next());
	}
	Collections.shuffle(getNames()); //randomise the arraylist of names
	System.out.println("Order: "); //will be a neater/more appealing way of doing this
	for(int j=0;j<getPlayerCount();j++)
	{
		System.out.println(getPlayername(j));
	}
}

}
