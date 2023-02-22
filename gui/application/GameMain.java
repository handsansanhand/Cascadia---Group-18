package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import player.player;

public class GameMain extends player {
	private static Scene scene;
	static int turn = 1;
	static ImageView lastClickedImage = null;
	static {
		try {
			
			
			
			
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------

			//
			//  Need to use the StartingWildlifeToken function for non starting tiles and create more cases for the split tiles 
			
			
			//
			
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			///-----------------------------------------------------------------------------------------------------------------
			FXMLLoader loader = new FXMLLoader(Scene2.class.getResource("Board.fxml"));
			//load up fxml file made with scene builder
			player.shuffletiles();
			// shuffle the tiles
			Parent root = loader.load();
			Label label1 = (Label) root.lookup("#labelone"); //getting id and referncing label made
			label1.setText("Player " + player.getName(0)); // set label to the first players name
			Label label2 = (Label) root.lookup("#labeltwo"); //new labels initialised
			Label label3 = (Label) root.lookup("#labelthree");
			Label label4 = (Label) root.lookup("#labelfour");
			Label label5 = (Label) root.lookup("#labelfive");
			Label TurnLabel = (Label) root.lookup("#TurnLabel");
			Label ScoreLabel = (Label) root.lookup("#ScoreLabel");
			TurnLabel.setText("Turn: " + turn);
			// ScoreLabel.setText("Score = " + player.getScore(player.Score));
			ImageView startingimage = (ImageView) root.lookup("#startingimage");
			ImageView image1 = (ImageView) root.lookup("#imageone");
			ImageView image2 = (ImageView) root.lookup("#imagetwo");
			ImageView image3 = (ImageView) root.lookup("#imagethree");
			ImageView image4 = (ImageView) root.lookup("#imagefour");
			ImageView pane2 = (ImageView) root.lookup("#pane2");
			ImageView pane3 = (ImageView) root.lookup("#pane3");
			ImageView pane4 = (ImageView) root.lookup("#pane4");
			ImageView pane6 = (ImageView) root.lookup("#pane6");
			ImageView pane7 = (ImageView) root.lookup("#pane7");
			ImageView pane8 = (ImageView) root.lookup("#pane8");
			ImageView pane9 = (ImageView) root.lookup("#pane9");
			ImageView pane10 = (ImageView) root.lookup("#pane10");
			ImageView pane11 = (ImageView) root.lookup("#pane11");
			ImageView pane12 = (ImageView) root.lookup("#pane12");
			ImageView pane13 = (ImageView) root.lookup("#pane13");
			ImageView pane14 = (ImageView) root.lookup("#pane14");
			ImageView pane15 = (ImageView) root.lookup("#pane15");
			ImageView pane16 = (ImageView) root.lookup("#pane16");
			ImageView pane17 = (ImageView) root.lookup("#pane17");
			ImageView pane18 = (ImageView) root.lookup("#pane17");
			ImageView pane19 = (ImageView) root.lookup("#pane18");

			Button buttonone = (Button) root.lookup("#buttonone");

			Button rotateright = (Button) root.lookup("#rotateright");
			Button rotateleft = (Button) root.lookup("#rotateleft");

			ImageView test = (ImageView) root.lookup("#tester");
			test.setImage(null);
			startingimage.setImage(player.getstarttile(player.getcurrentPlayer()));
			player.addmoretiles();
			player.shuffletiles();
			image1.setImage(player.getTile(0));
			image2.setImage(player.getTile(1));
			image3.setImage(player.getTile(2));
			image4.setImage(player.getTile(3));
			label2.setText(player.gettilename(0));
			label3.setText(player.gettilename(1));
			label4.setText(player.gettilename(2));
			label5.setText(player.gettilename(3));
			// ImageView lastClickedImage = null;

			image1.setOnMouseClicked(event -> {
				test.setOnMouseClicked(evernt -> {
					test.setImage(image1.getImage());
					lastClickedImage = test;
				});
				pane2.setOnMouseClicked(e -> {
					pane2.setImage(image1.getImage());
					lastClickedImage = pane2;
				});

				pane3.setOnMouseClicked(ev8 -> {
					pane3.setImage(image1.getImage());
					lastClickedImage = pane3;
				});
				pane4.setOnMouseClicked(e -> {
					pane4.setImage(image1.getImage());
					lastClickedImage = pane4;
				});
				pane6.setOnMouseClicked(e -> {
					pane6.setImage(image1.getImage());
					lastClickedImage = pane6;
				});
				pane7.setOnMouseClicked(e -> {
					pane7.setImage(image1.getImage());
					lastClickedImage = pane7;
				});
				pane8.setOnMouseClicked(e -> {
					pane8.setImage(image1.getImage());
					lastClickedImage = pane8;
				});
				pane9.setOnMouseClicked(e -> {
					pane9.setImage(image1.getImage());
					lastClickedImage = pane9;
				});
				pane10.setOnMouseClicked(e -> {
					pane10.setImage(image1.getImage());
					lastClickedImage = pane10;
				});
				pane11.setOnMouseClicked(e -> {
					pane11.setImage(image1.getImage());
					lastClickedImage = pane11;
				});
				pane12.setOnMouseClicked(e -> {
					pane12.setImage(image1.getImage());
					lastClickedImage = pane12;
				});
				pane13.setOnMouseClicked(e -> {
					pane13.setImage(image1.getImage());
					lastClickedImage = pane13;
				});

				pane14.setOnMouseClicked(e -> {
					pane14.setImage(image1.getImage());
					lastClickedImage = pane14;
				});
				pane15.setOnMouseClicked(e -> {
					pane15.setImage(image1.getImage());
					lastClickedImage = pane15;
				});
				pane16.setOnMouseClicked(e -> {
					pane16.setImage(image1.getImage());
					lastClickedImage = pane16;
				});
				pane17.setOnMouseClicked(e -> {
					pane17.setImage(image1.getImage());
					lastClickedImage = pane17;
				});
				pane18.setOnMouseClicked(e -> {
					pane18.setImage(image1.getImage());
					lastClickedImage = pane18;
				});
				pane19.setOnMouseClicked(e -> {
					pane19.setImage(image1.getImage());
					lastClickedImage = pane19;
				});

			});

			image2.setOnMouseClicked(event -> {
				test.setOnMouseClicked(evernt -> {
					test.setImage(image2.getImage());
					lastClickedImage = test;
				});
				pane2.setOnMouseClicked(e -> {
					pane2.setImage(image2.getImage());
					lastClickedImage = pane2;
				});

				pane3.setOnMouseClicked(ev8 -> {
					pane3.setImage(image2.getImage());
					lastClickedImage = pane3;
				});
				pane4.setOnMouseClicked(e -> {
					pane4.setImage(image2.getImage());
					lastClickedImage = pane4;
				});
				pane6.setOnMouseClicked(e -> {
					pane6.setImage(image2.getImage());
					lastClickedImage = pane6;
				});
				pane7.setOnMouseClicked(e -> {
					pane7.setImage(image2.getImage());
					lastClickedImage = pane7;
				});
				pane8.setOnMouseClicked(e -> {
					pane8.setImage(image2.getImage());
					lastClickedImage = pane8;
				});
				pane9.setOnMouseClicked(e -> {
					pane9.setImage(image2.getImage());
					lastClickedImage = pane9;
				});
				pane10.setOnMouseClicked(e -> {
					pane10.setImage(image2.getImage());
					lastClickedImage = pane10;
				});
				pane11.setOnMouseClicked(e -> {
					pane11.setImage(image2.getImage());
					lastClickedImage = pane11;
				});
				pane12.setOnMouseClicked(e -> {
					pane12.setImage(image2.getImage());
					lastClickedImage = pane12;
				});
				pane13.setOnMouseClicked(e -> {
					pane13.setImage(image2.getImage());
					lastClickedImage = pane13;
				});

				pane14.setOnMouseClicked(e -> {
					pane14.setImage(image2.getImage());
					lastClickedImage = pane14;
				});
				pane15.setOnMouseClicked(e -> {
					pane15.setImage(image2.getImage());
					lastClickedImage = pane15;
				});
				pane16.setOnMouseClicked(e -> {
					pane16.setImage(image2.getImage());
					lastClickedImage = pane16;
				});
				pane17.setOnMouseClicked(e -> {
					pane17.setImage(image2.getImage());
					lastClickedImage = pane17;
				});
				pane18.setOnMouseClicked(e -> {
					pane18.setImage(image2.getImage());
					lastClickedImage = pane18;
				});
				pane19.setOnMouseClicked(e -> {
					pane19.setImage(image2.getImage());
					lastClickedImage = pane19;
				});

			});
			image3.setOnMouseClicked(event -> {
				test.setOnMouseClicked(evernt -> {
					test.setImage(image3.getImage());
					lastClickedImage = test;
				});
				pane2.setOnMouseClicked(e -> {
					pane2.setImage(image3.getImage());
					lastClickedImage = pane2;
				});

				pane3.setOnMouseClicked(ev8 -> {
					pane3.setImage(image3.getImage());
					lastClickedImage = pane3;
				});
				pane4.setOnMouseClicked(e -> {
					pane4.setImage(image3.getImage());
					lastClickedImage = pane4;
				});
				pane6.setOnMouseClicked(e -> {
					pane6.setImage(image3.getImage());
					lastClickedImage = pane6;
				});
				pane7.setOnMouseClicked(e -> {
					pane7.setImage(image3.getImage());
					lastClickedImage = pane7;
				});
				pane8.setOnMouseClicked(e -> {
					pane8.setImage(image3.getImage());
					lastClickedImage = pane8;
				});
				pane9.setOnMouseClicked(e -> {
					pane9.setImage(image3.getImage());
					lastClickedImage = pane9;
				});
				pane10.setOnMouseClicked(e -> {
					pane10.setImage(image3.getImage());
					lastClickedImage = pane10;
				});
				pane11.setOnMouseClicked(e -> {
					pane11.setImage(image3.getImage());
					lastClickedImage = pane11;
				});

				pane12.setOnMouseClicked(e -> {
					pane12.setImage(image3.getImage());
					lastClickedImage = pane12;
				});
				pane13.setOnMouseClicked(e -> {
					pane13.setImage(image3.getImage());
					lastClickedImage = pane13;
				});

				pane14.setOnMouseClicked(e -> {
					pane14.setImage(image3.getImage());
					lastClickedImage = pane14;
				});
				pane15.setOnMouseClicked(e -> {
					pane15.setImage(image3.getImage());
					lastClickedImage = pane15;
				});
				pane16.setOnMouseClicked(e -> {
					pane16.setImage(image3.getImage());
					lastClickedImage = pane16;
				});
				pane17.setOnMouseClicked(e -> {
					pane17.setImage(image3.getImage());
					lastClickedImage = pane17;
				});
				pane18.setOnMouseClicked(e -> {
					pane18.setImage(image3.getImage());
					lastClickedImage = pane18;
				});
				pane19.setOnMouseClicked(e -> {
					pane19.setImage(image3.getImage());
					lastClickedImage = pane19;
				});

			});

			image4.setOnMouseClicked(event -> {
				test.setOnMouseClicked(evernt -> {
					test.setImage(image4.getImage());
					lastClickedImage = test;
				});
				pane2.setOnMouseClicked(e -> {
					pane2.setImage(image4.getImage());
					lastClickedImage = pane2;
				});

				pane3.setOnMouseClicked(ev8 -> {
					pane3.setImage(image4.getImage());
					lastClickedImage = pane3;
				});
				pane4.setOnMouseClicked(e -> {
					pane4.setImage(image4.getImage());
					lastClickedImage = pane4;
				});
				pane6.setOnMouseClicked(e -> {
					pane6.setImage(image4.getImage());
					lastClickedImage = pane6;
				});
				pane7.setOnMouseClicked(e -> {
					pane7.setImage(image4.getImage());
					lastClickedImage = pane7;
				});
				pane8.setOnMouseClicked(e -> {
					pane8.setImage(image4.getImage());
					lastClickedImage = pane8;
				});
				pane9.setOnMouseClicked(e -> {
					pane9.setImage(image4.getImage());
					lastClickedImage = pane9;
				});
				pane10.setOnMouseClicked(e -> {
					pane10.setImage(image4.getImage());
					lastClickedImage = pane10;
				});
				pane11.setOnMouseClicked(e -> {
					pane11.setImage(image4.getImage());
					lastClickedImage = pane11;
				});
				pane12.setOnMouseClicked(e -> {
					pane12.setImage(image4.getImage());
					lastClickedImage = pane12;
				});
				pane13.setOnMouseClicked(e -> {
					pane13.setImage(image4.getImage());
					lastClickedImage = pane13;
				});

				pane14.setOnMouseClicked(e -> {
					pane14.setImage(image4.getImage());
					lastClickedImage = pane14;
				});
				pane15.setOnMouseClicked(e -> {
					pane15.setImage(image4.getImage());
					lastClickedImage = pane15;
				});
				pane16.setOnMouseClicked(e -> {
					pane16.setImage(image4.getImage());
					lastClickedImage = pane16;
				});
				pane17.setOnMouseClicked(e -> {
					pane17.setImage(image4.getImage());
					lastClickedImage = pane17;
				});
				pane18.setOnMouseClicked(e -> {
					pane18.setImage(image4.getImage());
					lastClickedImage = pane18;
				});
				pane19.setOnMouseClicked(e -> {
					pane19.setImage(image4.getImage());
					lastClickedImage = pane19;
				});

			});

			rotateright.setOnAction(e -> {
				lastClickedImage.setRotate(lastClickedImage.getRotate() + 90);

			});

			rotateleft.setOnAction(e -> {
				lastClickedImage.setRotate(lastClickedImage.getRotate() - 90);

			});

			buttonone.setOnAction(e -> {

				// ment to add to arralist to do score
				player.AddImageView(lastClickedImage);

				// the one above is ment to so that
				// ------------------------------------------------------
				// ------------------------------------------------------
				player.shuffletiles();
				ScoreLabel.setText("Score = " + player.getScore(player.Score));
				turn = turn + 1;
				TurnLabel.setText("Turn: " + turn);
				label2.setText(player.gettilename(0));
				label3.setText(player.gettilename(1));
				label4.setText(player.gettilename(2));
				label5.setText(player.gettilename(3));
				image1.setImage(player.getTile(0));
				image2.setImage(player.getTile(1));
				image3.setImage(player.getTile(2));
				image4.setImage(player.getTile(3));
				player.CurrentPlayer = player.CurrentPlayer + 1;

				Stage stage = (Stage) buttonone.getScene().getWindow();
				stage.setScene(Gamemain2.getScene());
				stage.show();

			});

			/*
			 * image1.setOnDragDetected(event -> { Dragboard dragboard =
			 * image1.startDragAndDrop(TransferMode.MOVE); ClipboardContent content = new
			 * ClipboardContent(); content.putImage(image1.getImage());
			 * dragboard.setContent(content); event.consume(); });
			 * 
			 * 
			 * pane1.setOnDragOver(event -> { event.acceptTransferModes(TransferMode.MOVE);
			 * event.consume(); });
			 * 
			 * pane1.setOnDragDropped(event -> { Dragboard dragboard = event.getDragboard();
			 * Image image = (Image) dragboard.getContent(format); ImageView imageView = new
			 * ImageView(image); imageView.setFitWidth(pane1.getWidth());
			 * imageView.setFitHeight(pane1.getHeight());
			 * pane1.getChildren().add(imageView); event.setDropCompleted(true);
			 * event.consume(); });
			 */
			scene = new Scene(root, 800, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Scene getScene() {
		return scene;
	}
}
