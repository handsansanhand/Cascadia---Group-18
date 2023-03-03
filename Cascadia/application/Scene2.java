package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import player.Habitat;
import player.player;

public class Scene2 extends player{
	private static Scene scene;
	///---------------------------------------------------------------
	///---------------------------------------------------------------
	///---------------------------------------------------------------
	///---------------------------------------------------------------

//	
	// 2 player name chooser
	//
	
	///---------------------------------------------------------------
	///---------------------------------------------------------------
	///---------------------------------------------------------------
	///---------------------------------------------------------------
	///---------------------------------------------------------------
	static {
		try {
			FXMLLoader loader = new FXMLLoader(Scene2.class.getResource("Scene2.fxml"));
			Parent root = loader.load();

			TextField textfield1 = (TextField) root.lookup("#textbox1");
			TextField textfield2 = (TextField) root.lookup("#textbox2");
			Button button5 = (Button) root.lookup("#Button5");

			button5.setOnAction(event -> {
			    gettext(textfield1.getText());
			    gettext(textfield2.getText());
			    player.playercount = 2;
			    player.shuffle();
			    player.shufflehabitats();
			    
			    Stage stage = (Stage) button5.getScene().getWindow();
			    stage.setScene(GamePanel.getScene());
			    stage.show();
			});

			
			

			scene = new Scene(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void gettext(String g) {

		player.addplayer(g);
		System.out.println(g);
		
	}

	public static Scene getScene() {
		return scene;
	}
}