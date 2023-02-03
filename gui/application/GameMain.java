package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import player.player;

public class GameMain {
	
	
	private static Scene scene;
	static player player = new player();

	static {
		BorderPane root = new BorderPane();



		scene = new Scene(root, 800, 600);
	}
	
	
	public static Scene getScene() {
		return scene;
	}
}
