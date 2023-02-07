package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import player.player;

public class GameMain extends player{
	
	private static Scene scene;

	static {
		try {
			FXMLLoader loader = new FXMLLoader(Scene2.class.getResource("Board.fxml"));
			
			Parent root = loader.load();
			Label label1 = (Label) root.lookup("#labelone");
			label1.setText("Player "+player.getName(0));

			scene = new Scene(root, 800, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Scene getScene() {
		return scene;
	}
}
