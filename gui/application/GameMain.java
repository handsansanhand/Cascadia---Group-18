package application;

import java.io.IOException;

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

public class GameMain extends player{
	
	private static Scene scene;

	static {
		try {
			
			FXMLLoader loader = new FXMLLoader(Scene2.class.getResource("Board.fxml"));
			player.shuffletiles();
			Parent root = loader.load();
			Label label1 = (Label) root.lookup("#labelone");
			label1.setText("Player "+player.getName(0));
			Label label2 = (Label) root.lookup("#labeltwo");
			Label label3 = (Label) root.lookup("#labelthree");
			Label label4 = (Label) root.lookup("#labelfour");
			Label label5 = (Label) root.lookup("#labelfive");
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
			
			Button buttonone = (Button) root.lookup("#buttonone");

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
			boolean picking = true;

		image1.setOnMouseClicked(event -> {
           test.setOnMouseClicked(evernt -> {
        	   test.setImage(image1.getImage()); 
           });
          pane2.setOnMouseClicked(e -> {
        	  pane2.setImage(image1.getImage());
          });
          
          pane3.setOnMouseClicked(ev8 -> {
        	  pane3.setImage(image1.getImage());
          });
          pane4.setOnMouseClicked(e -> {
        	  pane4.setImage(image1.getImage());
          });
          pane6.setOnMouseClicked(e -> {
        	  pane6.setImage(image1.getImage());
          });
          
          pane7.setOnMouseClicked(e -> {
        	  pane7.setImage(image1.getImage());
          });
		});
		
		image2.setOnMouseClicked(event -> {
	           test.setOnMouseClicked(evernt -> {
	        	   test.setImage(image2.getImage()); 
	           });
	          pane2.setOnMouseClicked(e -> {
	        	  pane2.setImage(image2.getImage());
	          });
	          pane3.setOnMouseClicked(e -> {
	        	  pane3.setImage(image2.getImage());
	          });   pane4.setOnMouseClicked(e -> {
	        	  pane4.setImage(image2.getImage());
	          });   pane6.setOnMouseClicked(e -> {
	        	  pane6.setImage(image2.getImage());
	          });
	          pane7.setOnMouseClicked(e -> {
	        	  pane7.setImage(image2.getImage());
	          });
	       
			});
		image3.setOnMouseClicked(event -> {
	           test.setOnMouseClicked(evernt -> {
	        	   test.setImage(image3.getImage()); 
	           });
	          pane2.setOnMouseClicked(e -> {
	        	  pane2.setImage(image3.getImage());
	          });
	          pane3.setOnMouseClicked(e -> {
	        	  pane3.setImage(image3.getImage());
	          });   pane4.setOnMouseClicked(e -> {
	        	  pane4.setImage(image3.getImage());
	          });   pane6.setOnMouseClicked(e -> {
	        	  pane6.setImage(image3.getImage());
	          });
	          pane7.setOnMouseClicked(e -> {
	        	  pane7.setImage(image3.getImage());
	          });
	       
			});
		
		image4.setOnMouseClicked(event -> {
	           test.setOnMouseClicked(evernt -> {
	        	   test.setImage(image4.getImage()); 
	           });
	          pane2.setOnMouseClicked(e -> {
	        	  pane2.setImage(image4.getImage());
	          });
	          pane3.setOnMouseClicked(e -> {
	        	  pane3.setImage(image4.getImage());
	          });   pane4.setOnMouseClicked(e -> {
	        	  pane4.setImage(image4.getImage());
	          });   pane6.setOnMouseClicked(e -> {
	        	  pane6.setImage(image4.getImage());
	          });
	          pane7.setOnMouseClicked(e -> {
	        	  pane7.setImage(image4.getImage());
	          });
	       
			});
		
		buttonone.setOnAction(e ->{
			player.CurrentPlayer = player.CurrentPlayer + 1;
			 Stage stage = (Stage) buttonone.getScene().getWindow();
			    stage.setScene(Gamemain2.getScene());
			    stage.show();
			    
		});
		
		
		

			/*
			image1.setOnDragDetected(event -> {
			    Dragboard dragboard = image1.startDragAndDrop(TransferMode.MOVE);
			    ClipboardContent content = new ClipboardContent();
			    content.putImage(image1.getImage());
			    dragboard.setContent(content);
			    event.consume();
			});


			pane1.setOnDragOver(event -> {
			    event.acceptTransferModes(TransferMode.MOVE);
			    event.consume();
			});

			pane1.setOnDragDropped(event -> {
			    Dragboard dragboard = event.getDragboard();
			    Image image = (Image) dragboard.getContent(format);
			    ImageView imageView = new ImageView(image);
			    imageView.setFitWidth(pane1.getWidth());
			    imageView.setFitHeight(pane1.getHeight());
			    pane1.getChildren().add(imageView);
			    event.setDropCompleted(true);
			    event.consume();
			});
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
