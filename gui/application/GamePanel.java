package application;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import player.Habitat;
import player.player;

public class GamePanel extends player {
	ArrayList<String> names = new ArrayList<String>();

	private static Scene scene;
	static player player = new player();
	Habitat habitat = new Habitat();

	static {
		BorderPane root = new BorderPane();
		Label label = new Label("Player starting habitats");
		label.setTextFill(Color.LIGHTGREEN);
		root.setTop(label);
		root.setAlignment(label, Pos.TOP_CENTER);
		label.setStyle("-fx-font-size: 36pt;");
		root.setStyle("-fx-background-color: blue;");

		// String gg = ;
		// gg = gg + player.getName(0);
		player.shufflehabitats();
		Label label1 = new Label();

		if (player.playercount == 2) {

			label1.setText("order \n" + "1st " + player.getName(0)+" with habitat "+ player.getHabitat(0)+" Token "+Habitat.StartingWildlifeToken(0)  + "\n2nd " + player.getName(1)+" with habitat "+player.getHabitat(1)+" Token "+Habitat.StartingWildlifeToken(1));
		}
		if (player.playercount == 3) {

			label1.setText("order \n" + "1st " + player.getName(0) +" with habitat "+player.getHabitat(0)+" Token "+Habitat.StartingWildlifeToken(0)+ "\n2nd " + player.getName(1)+" with habitat"+player.getHabitat(1)+" Token "+Habitat.StartingWildlifeToken(1)+ "\n3rd " + player.getName(2)+" with habitat "+player.getHabitat(2)+" Token "+Habitat.StartingWildlifeToken(2));
		}
		if (player.playercount == 4) {

			label1.setText("order \n" + "1st " + player.getName(0) +"Token "+Habitat.WildlifeToken(0)+ "\n2nd " + player.getName(1)+"Token "+Habitat.WildlifeToken(1)+ "\n3rd " + player.getName(2)+ "\n4th " + player.getName(3)+"Token "+Habitat.WildlifeToken(3));
		}
	
	//	Image dessert = new Image("/Habitats/dessert.png");
		//ImageView imageView = new ImageView(dessert);
		//imageView.setFitHeight(200);
		//imageView.setFitWidth(300);
		//root.getChildren().add(imageView);

		label1.setTextFill(Color.LIGHTGREEN);
		label1.setStyle("-fx-font-size: 24pt;");

		Button button = new Button("Continue");
		button.setMinSize(100, 50);
		root.setRight(button);
		button.setOnAction(event -> {
		 
		    
		    Stage stage = (Stage) button.getScene().getWindow();
		    stage.setScene(GameMain.getScene());
		    stage.show();
		});
		
		
		root.setCenter(label1);
		scene = new Scene(root, 800, 600);
	}

	public static Scene getScene() {

		return scene;
	}
}