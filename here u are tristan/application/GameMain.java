package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import player.Board;
import player.Tile;
import player.player;

public class GameMain extends player {
	private static Scene scene;
	public static int i = 0;
	public static String wildlifetokenholder;
	public static int wildlifeX;
	public static int wildlifeY;
	public static List<Tile> tileList = new ArrayList<>();

	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------

//	
	// player 1 board
	//

	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	static {
		try {

			FXMLLoader loader = new FXMLLoader(Scene2.class.getResource("Board.fxml"));
			Pane root = new Pane();

			root = loader.load();
			Board tileBoard = new TileBoard();
			Rectangle[][] rectangles = tileBoard.getRectangles();

			// rec1-4 display random hab tiles
			Rectangle rec1 = (Rectangle) root.lookup("#rec1");
			Rectangle rec2 = (Rectangle) root.lookup("#rec2");
			Rectangle rec3 = (Rectangle) root.lookup("#rec3");
			Rectangle rec4 = (Rectangle) root.lookup("#rec4");

			// these are the labels for rec 1-4
			Label label2 = (Label) root.lookup("#label2");
			Label label3 = (Label) root.lookup("#label3");
			Label label4 = (Label) root.lookup("#label4");
			Label label5 = (Label) root.lookup("#label5");

			// these labels are for the wildlife tokend of rec 1-4
			Label wildlifetoken1 = (Label) root.lookup("#label6");
			Label wildlifetoken2 = (Label) root.lookup("#label7");
			Label wildlifetoken3 = (Label) root.lookup("#label8");
			Label wildlifetoken4 = (Label) root.lookup("#label9");

			// gonna do starting tiles here
			Tile start1 = Tile.randomTile();
			Tile start2 = Tile.randomTile();
			Tile start3 = Tile.randomTile();

			for (int i = 0; i < 10; i++) {
				tileList.add(Tile.randomTile());
			}

// random tiles for rec 1-4
			Tile tile1 = Tile.randomTile();
			Tile tile2 = Tile.randomTile();
			Tile tile3 = Tile.randomTile();
			Tile tile4 = Tile.randomTile();
			label2.setText(tileList.get(0).toString());
			label3.setText(tileList.get(1).toString());
			label4.setText(tileList.get(2).toString());
			label5.setText(tileList.get(3).toString());
			wildlifetoken1.setText(player.StartingWildlifeToken(tileList.get(0)));
			wildlifetoken1.setTextFill(Color.WHITE);
			wildlifetoken2.setText(player.StartingWildlifeToken(tileList.get(1)));
			wildlifetoken2.setTextFill(Color.WHITE);
			wildlifetoken3.setText(player.StartingWildlifeToken(tileList.get(2)));
			wildlifetoken3.setTextFill(Color.WHITE);
			wildlifetoken4.setText(player.StartingWildlifeToken(tileList.get(3)));
			wildlifetoken4.setTextFill(Color.WHITE);

			rec1.setFill(player.getHabcolor(tileList.get(0)));
			rec2.setFill(player.getHabcolor(tileList.get(1)));
			rec3.setFill(player.getHabcolor(tileList.get(2)));
			rec4.setFill(player.getHabcolor(tileList.get(3)));

			for (int row = 0; row < rectangles.length; row++) {
				for (int col = 0; col < rectangles[row].length; col++) {
					root.getChildren().add(rectangles[row][col]);
				}
			}

			// satrting habs
			rectangles[3][3].setFill(player.getHabcolor(start1));
			rectangles[3][4].setFill(player.getHabcolor(start2));
			rectangles[4][3].setFill(player.getHabcolor(start3));
			Text text = new Text(player.StartingWildlifeToken(start1));
			text.setFont(Font.font("Arial", 14));
			text.setFill(Color.WHITE);
			text.setX(rectangles[3][3].getX() + (rectangles[3][3].getWidth() - text.getLayoutBounds().getWidth()) / 2
					- 5);
			text.setY(
					rectangles[3][3].getY() + (rectangles[3][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);

			root.getChildren().add(text);

			Text text1 = new Text(player.StartingWildlifeToken(start2));
			text1.setFont(Font.font("Arial", 14));
			text1.setFill(Color.WHITE);
			text1.setX(rectangles[3][4].getX() + (rectangles[3][4].getWidth() - text.getLayoutBounds().getWidth()) / 2
					- 5);
			text1.setY(
					rectangles[3][4].getY() + (rectangles[3][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);

			root.getChildren().add(text1);

			Text text2 = new Text(player.StartingWildlifeToken(start3));
			text2.setFont(Font.font("Arial", 14));
			text2.setFill(Color.WHITE);
			text2.setX(rectangles[4][3].getX() + (rectangles[4][3].getWidth() - text.getLayoutBounds().getWidth()) / 2
					- 5);
			text2.setY(
					rectangles[4][3].getY() + (rectangles[4][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);
			root.getChildren().add(text2);

			Label label1 = (Label) root.lookup("#label1");
			label1.setText(player.getName(player.CurrentPlayer));

			Button cull = (Button) root.lookup("#cull"); // place wildlife token

			// rec clicked
			rec1.setOnMouseClicked(event -> {
				wildlifetokenholder = wildlifetoken1.getText();
				rectangles[4][4].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 4, rectangles) == true) {
						rectangles[4][4].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 4;
						wildlifeY = 4;
					}
				});
				rectangles[3][5].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 5, rectangles) == true) {
						rectangles[3][5].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 5;
					}
				});
				rectangles[4][5].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 5, rectangles) == true) {
						rectangles[4][5].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 4;
						wildlifeY = 5;
					}
				});
				rectangles[4][6].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 6, rectangles) == true) {
						rectangles[4][6].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 4;
						wildlifeY = 6;
					}
				});
				rectangles[4][0].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 0, rectangles) == true) {
						rectangles[4][0].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 4;
						wildlifeY = 0;
					}
				});
				rectangles[4][1].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 1, rectangles) == true) {
						rectangles[4][1].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 4;
						wildlifeY = 1;
					}
				});
				rectangles[4][2].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 2, rectangles) == true) {
						rectangles[4][2].setFill(rec1.getFill());
						wildlifeX = 4;
						wildlifeY = 2;
					}
				});
				rectangles[3][0].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 0, rectangles) == true) {
						rectangles[3][0].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 0;
					}
				});
				rectangles[3][1].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 1, rectangles) == true) {
						rectangles[3][1].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 1;
					}
				});
				rectangles[3][2].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 2, rectangles) == true) {
						rectangles[3][2].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 2;
					}
				});
				rectangles[3][5].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 5, rectangles) == true) {
						rectangles[3][5].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 5;
					}
				});
				rectangles[3][6].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 6, rectangles) == true) {
						rectangles[3][6].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 6;
					}
				});
				rectangles[2][0].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 0, rectangles) == true) {
						rectangles[2][0].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 0;
					}
				});
				rectangles[2][1].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 1, rectangles) == true) {
						rectangles[2][1].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 1;
					}
				});
				rectangles[2][2].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 2, rectangles) == true) {
						rectangles[2][2].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 2;
					}
				});
				rectangles[2][3].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 3, rectangles) == true) {
						rectangles[2][3].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 3;
					}
				});
				rectangles[2][4].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 4, rectangles) == true) {
						rectangles[2][4].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 4;
					}
				});
				rectangles[2][5].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 5, rectangles) == true) {
						rectangles[2][5].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 5;
					}
				});
				rectangles[2][6].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 6, rectangles) == true) {
						rectangles[2][6].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 6;
					}
				});

			});

// rec 2 clicked 
			rec2.setOnMouseClicked(event -> {
				wildlifetokenholder = wildlifetoken1.getText();
				rectangles[4][4].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 4, rectangles) == true) {
						rectangles[4][4].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 4;
						wildlifeY = 4;
					}
				});
				rectangles[3][5].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 5, rectangles) == true) {
						rectangles[3][5].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 5;
					}
				});
				rectangles[4][5].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 5, rectangles) == true) {
						rectangles[4][5].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 4;
						wildlifeY = 5;
					}
				});
				rectangles[4][6].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 6, rectangles) == true) {
						rectangles[4][6].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 4;
						wildlifeY = 6;
					}
				});
				rectangles[4][0].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 0, rectangles) == true) {
						rectangles[4][0].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 4;
						wildlifeY = 0;
					}
				});
				rectangles[4][1].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 1, rectangles) == true) {
						rectangles[4][1].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 4;
						wildlifeY = 1;
					}
				});
				rectangles[4][2].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 2, rectangles) == true) {
						rectangles[4][2].setFill(rec2.getFill());
						wildlifeX = 4;
						wildlifeY = 2;
					}
				});
				rectangles[3][0].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 0, rectangles) == true) {
						rectangles[3][0].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 0;
					}
				});
				rectangles[3][1].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 1, rectangles) == true) {
						rectangles[3][1].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 1;
					}
				});
				rectangles[3][2].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 2, rectangles) == true) {
						rectangles[3][2].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 2;
					}
				});
				rectangles[3][5].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 5, rectangles) == true) {
						rectangles[3][5].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 5;
					}
				});
				rectangles[3][6].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 6, rectangles) == true) {
						rectangles[3][6].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 3;
						wildlifeY = 6;
					}
				});
				rectangles[2][0].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 0, rectangles) == true) {
						rectangles[2][0].setFill(rec1.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 0;
					}
				});
				rectangles[2][1].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 1, rectangles) == true) {
						rectangles[2][1].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 1;
					}
				});
				rectangles[2][2].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 2, rectangles) == true) {
						rectangles[2][2].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 2;
					}
				});
				rectangles[2][3].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 3, rectangles) == true) {
						rectangles[2][3].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 3;
					}
				});
				rectangles[2][4].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 4, rectangles) == true) {
						rectangles[2][4].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 4;
					}
				});
				rectangles[2][5].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 5, rectangles) == true) {
						rectangles[2][5].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 5;
					}
				});
				rectangles[2][6].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 6, rectangles) == true) {
						rectangles[2][6].setFill(rec2.getFill());
						cull.setVisible(true);
						wildlifeX = 2;
						wildlifeY = 6;
					}
				});

			});

			/// cull
			Text temptext = new Text();
			temptext.setFont(Font.font("Arial", 14));
			temptext.setFill(Color.WHITE);
			cull.setOnAction(event -> {
				temptext.setText(wildlifetokenholder);
				temptext.setX(rectangles[wildlifeX][wildlifeY].getX()
						+ (rectangles[wildlifeX][wildlifeY].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
				temptext.setY(rectangles[wildlifeX][wildlifeY].getY()
						+ (rectangles[wildlifeX][wildlifeY].getHeight() - text.getLayoutBounds().getHeight()) / 2);

			});
			root.getChildren().add(temptext);
			// useful addtion here

			Button invert = (Button) root.lookup("#switch");
			AnchorPane gg1 = (AnchorPane) root.lookup("#boardPane");
			invert.setText("Invert");

			invert.setOnAction(event -> {
				System.out.println(label2.getText());
				System.out.println(label1.getText());
				System.out.println(label3.getText());

				if (i % 2 == 0) {
					gg1.setStyle("-fx-background-color: black;");
				} else {
					gg1.setStyle("-fx-background-color: blue;");
				}
				i++;
			});
			Button button = (Button) root.lookup("#Button1");
			button.setOnAction(event -> {
				Collections.shuffle(tileList);
				System.out.println(tileList.get(0).toString());

				player.CurrentPlayer = 1;
				Stage stage = (Stage) button.getScene().getWindow();
				stage.setScene(GameMain2.getScene());
				stage.show();
				cull.setVisible(false);
				label2.setText(tileList.get(4).toString());
				wildlifetoken1.setText(player.StartingWildlifeToken(tileList.get(4)));
				wildlifetoken1.setText(player.StartingWildlifeToken(tileList.get(4)));
				rec1.setFill(player.getHabcolor(tileList.get(4)));
				
				label3.setText(tileList.get(5).toString());
				wildlifetoken2.setText(player.StartingWildlifeToken(tileList.get(5)));
				wildlifetoken2.setText(player.StartingWildlifeToken(tileList.get(5)));
				rec2.setFill(player.getHabcolor(tileList.get(5)));


				label4.setText(tileList.get(6).toString());
				wildlifetoken3.setText(player.StartingWildlifeToken(tileList.get(6)));
				wildlifetoken3.setText(player.StartingWildlifeToken(tileList.get(6)));
				rec3.setFill(player.getHabcolor(tileList.get(6)));
				
				label5.setText(tileList.get(7).toString());
				wildlifetoken4.setText(player.StartingWildlifeToken(tileList.get(7)));
				wildlifetoken4.setText(player.StartingWildlifeToken(tileList.get(7)));
				rec4.setFill(player.getHabcolor(tileList.get(7)));
			});
			scene = new Scene(root);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Scene getScene() {
		return scene;
	}

}
