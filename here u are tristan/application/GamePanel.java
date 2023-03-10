package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import player.Habitat;
import player.player;
///---------------------------------------------------------------
///---------------------------------------------------------------
///---------------------------------------------------------------
///---------------------------------------------------------------

//
// scene that displays order
//

///---------------------------------------------------------------
///---------------------------------------------------------------
///---------------------------------------------------------------
///---------------------------------------------------------------
///---------------------------------------------------------------
public class GamePanel extends player {
	ArrayList<String> names = new ArrayList<String>();

	private static Scene scene;
	static player player = new player();
	Habitat habitat = new Habitat();

	static {
		FXMLLoader loader = new FXMLLoader(Scene2.class.getResource("GamePanel.fxml"));
		Parent root;
		try {
			root = loader.load();
			

			
			Button button = (Button) root.lookup("#button");
			Label label1 = (Label) root.lookup("#label1");
// the first player will always get index 0 to 2 in arraylist of habitats
			if (player.playercount == 2) {

				label1.setText("1st: "+player.getName(0)+"\n"+"2nd: "+player.getName(1));
			}
			if (player.playercount == 3) {
				label1.setText("1st: "+player.getName(0)+"\n"+"2nd: "+player.getName(1)+"\n"+"3rd: "+player.getName(2));;

			}
			if (player.playercount == 4) {

			}
	        label1.setFont(Font.font("Arial", 30));
			
			
			
			scene = new Scene(root);
			button.setOnAction(event -> {
		
			    
			    Stage stage = (Stage) button.getScene().getWindow();
			    stage.setScene(GameMain.getScene());
			    stage.show();
			});
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public static Scene getScene() {

		return scene;
	}
}