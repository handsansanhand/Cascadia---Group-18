package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import player.player;

public class Gamemain2 extends player{
	
	private static Scene scene;

	
	static {
		try {
			player.shuffletiles();
			FXMLLoader loader = new FXMLLoader(Scene2.class.getResource("Board.fxml"));
			Parent root = loader.load();
			ImageView image1 = (ImageView) root.lookup("#imageone");
			ImageView image2 = (ImageView) root.lookup("#imagetwo");
			ImageView image3 = (ImageView) root.lookup("#imagethree");
			ImageView image4 = (ImageView) root.lookup("#imagefour");
			ImageView startingimage = (ImageView) root.lookup("#startingimage");
			Label label1 = (Label) root.lookup("#labelone");
			label1.setText("Player "+player.getName(player.CurrentPlayer));
			Button buttonone = (Button) root.lookup("#buttonone");

			Label label2 = (Label) root.lookup("#labeltwo");
			Label label3 = (Label) root.lookup("#labelthree");
			Label label4 = (Label) root.lookup("#labelfour");
			Label label5 = (Label) root.lookup("#labelfive");
			startingimage.setImage(player.getstarttile(player.CurrentPlayer));
			image1.setImage(player.getTile(0));
			image2.setImage(player.getTile(1));
			image3.setImage(player.getTile(2));
			image4.setImage(player.getTile(3));
			label2.setText(player.gettilename(0));
			label3.setText(player.gettilename(1));
			label4.setText(player.gettilename(2));
			label5.setText(player.gettilename(3));
			
			
			
			buttonone.setOnAction(e ->{
				player.CurrentPlayer = player.CurrentPlayer -1;
				 Stage stage = (Stage) buttonone.getScene().getWindow();
				 player.shuffletiles();
				    stage.setScene(GameMain.getScene());
				    stage.show();
				    
			});
	
	scene = new Scene(root, 800, 600);
} catch (IOException e) {
	e.printStackTrace();
}
}
	public static Scene getScene() {
		return scene;
	}
}
