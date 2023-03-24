package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

//import static player.Board.rectangles;

public class GameMain extends player {
	private static Scene scene;
	public static int i = 0;
	public static int turn = 0;
	public static int wildlifeX;
	public static int wildlifeY;
	public static List<Tile> tileList = new ArrayList<>();
	public static List<Text> labelList = new ArrayList<>();
	public static int curscore = 0;

	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------

//	
	// player 1 board
	//
	//
	// note i could just make an invisible panel and make it visible
	// if a tile is placed

	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	/// ---------------------------------------------------------------
	static {
		try {
			player.numtimesbeara.put(0, 1);
			player.numtimesbeara.put(1, 1);
			player.numtimesbeara.put(2, 1);
			player.numtimesbeara.put(3, 1);
			
			player.numtimeshawka.put(0, 1);
			player.numtimeshawka.put(1, 1);
			player.numtimeshawka.put(2, 1);
			player.numtimeshawka.put(3, 1);
			
			player.numtimeshawkb.put(0, 1);
			player.numtimeshawkb.put(1, 1);
			player.numtimeshawkb.put(2, 1);
			player.numtimeshawkb.put(3, 1);


			Thread thread = new Thread();
			ArrayList<Text> wildlifetokenplaced = new ArrayList<Text>();
			ArrayList<Double> temp12 = new ArrayList<Double>();
			ArrayList<Double> temp13 = new ArrayList<Double>();
			ArrayList<Double> temp14 = new ArrayList<Double>();
			ArrayList<Double> temp15 = new ArrayList<Double>();

			alreadycounted.put(0, temp12);
			alreadycounted.put(1, temp13);
			alreadycounted.put(2, temp14);
			alreadycounted.put(3, temp15);

			FXMLLoader loader = new FXMLLoader(Scene2.class.getResource("Board.fxml"));
			Pane root = new Pane();

			root = loader.load();
			Board board = new Board(8, 7, 60);
			Rectangle[][] rectangles = board.getRectangles(); // ptileBoard.tileBoard[0][0].rectangles.setFill(java.awt.Color.BLACK);
																// example of how to access rectangle and change its
			player.HawkCount.put(0, 1); // color
			player.HawkCount.put(1, 1);
			player.HawkCount.put(2, 1);
			player.HawkCount.put(3, 1);
			// rec1-4 display random hab tiles
			Rectangle rec1 = (Rectangle) root.lookup("#rec1");
			Rectangle rec2 = (Rectangle) root.lookup("#rec2");
			Rectangle rec3 = (Rectangle) root.lookup("#rec3");
			Rectangle rec4 = (Rectangle) root.lookup("#rec4");

			// label for the error messge ie invalid placement
			Label error = (Label) root.lookup("#error");
			error.setVisible(false);
// for score 
			Label score = (Label) root.lookup("#Score");

			// score enf
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
			text.setFont(Font.font("Arial", 7));
			text.setFill(Color.BLACK);
			text.setX(rectangles[3][3].getX() + (rectangles[3][3].getWidth() - text.getLayoutBounds().getWidth()) / 2
					- 5);
			text.setY(
					rectangles[3][3].getY() + (rectangles[3][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);

			root.getChildren().add(text);

			Text text1 = new Text(player.StartingWildlifeToken(start2));
			text1.setFont(Font.font("Arial", 7));
			text1.setFill(Color.BLACK);
			text1.setX(rectangles[3][4].getX() + (rectangles[3][4].getWidth() - text.getLayoutBounds().getWidth()) / 2
					- 5);
			text1.setY(
					rectangles[3][4].getY() + (rectangles[3][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);

			root.getChildren().add(text1);

			Text text2 = new Text(player.StartingWildlifeToken(start3));
			text2.setFont(Font.font("Arial", 7));
			text2.setFill(Color.BLACK);
			text2.setX(rectangles[4][3].getX() + (rectangles[4][3].getWidth() - text.getLayoutBounds().getWidth()) / 2
					- 5);
			text2.setY(
					rectangles[4][3].getY() + (rectangles[4][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);
			root.getChildren().add(text2);

			Label label1 = (Label) root.lookup("#label1");
			label1.setText(player.getName(player.CurrentPlayer));

			Button cull = (Button) root.lookup("#cull"); // place wildlife token

			// button to use nature tokens
			Button naturetoken = (Button) root.lookup("#naturetoken");

			// rec1 clicked

			rec1.setOnMouseClicked(event -> {
				

				rectangles[4][4].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 4, rectangles) == true) {
						naturetoken.setVisible(false);
						rectangles[4][4].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}

				});
				rectangles[3][5].setOnMouseClicked(e -> {

					if (player.isValidClick(3, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][5].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					} else {
						error.setVisible(true);
					}
				});
				rectangles[4][5].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][5].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}

				});
				rectangles[4][6].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][6].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][0].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][0].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][1].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][1].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][2].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][2].setFill(rec1.getFill());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][0].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][0].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][1].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][1].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][2].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][2].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][5].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][5].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][6].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][6].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][0].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][0].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					} else {
						error.setVisible(true);
					}

				});
				rectangles[2][1].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][1].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][2].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][2].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][3].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][3].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][4].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][4].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][5].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][5].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][6].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][6].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

				rectangles[1][0].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][0].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][2].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][2].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][3].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][3].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][4].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][4].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][5].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][5].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][0].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][0].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][1].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][1].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][2].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][2].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][3].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][3].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][4].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][4].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][5].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][5].setFill(rec1.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

			});

// rec 2 clicked 

			rec2.setOnMouseClicked(event -> {
			

				rectangles[4][4].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][4].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}

				});
				rectangles[3][5].setOnMouseClicked(e -> {

					if (player.isValidClick(3, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][5].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}
				});
				rectangles[4][5].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][5].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}
				});
				rectangles[4][6].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][6].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][0].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][0].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][1].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][1].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][2].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][2].setFill(rec2.getFill());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][0].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][0].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][1].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][1].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][2].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][2].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][5].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][5].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][6].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][6].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][0].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][0].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][1].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][1].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][2].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][2].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][3].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][3].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][4].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][4].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][5].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][5].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][6].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][6].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][0].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][0].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][2].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][2].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][3].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][3].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][4].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][4].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][5].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][5].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][0].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][0].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][1].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][1].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][2].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][2].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][3].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][3].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][4].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][4].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][5].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][5].setFill(rec2.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

			});

//rec 3 clicked 

			rec3.setOnMouseClicked(event -> {
			

				rectangles[4][4].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][4].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}

				});
				rectangles[3][5].setOnMouseClicked(e -> {

					if (player.isValidClick(3, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][5].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}
				});
				rectangles[4][5].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][5].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}
				});
				rectangles[4][6].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][6].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][0].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][0].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][1].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][1].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][2].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][2].setFill(rec3.getFill());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][0].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][0].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][1].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][1].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][2].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][2].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][5].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][5].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][6].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][6].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][0].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][0].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][1].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][1].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][2].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][2].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][3].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][3].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][4].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][4].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][5].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][5].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][6].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][6].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][0].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][0].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][2].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][2].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][3].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][3].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][4].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][4].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][5].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][5].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][0].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][0].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][1].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][1].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][2].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][2].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][3].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][3].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][4].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][4].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][5].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][5].setFill(rec3.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

			});

// rec 4 clicked 

			rec4.setOnMouseClicked(event -> {
			
				rectangles[4][4].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][4].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}

				});
				rectangles[3][5].setOnMouseClicked(e -> {

					if (player.isValidClick(3, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][5].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}
				});
				rectangles[4][5].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][5].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}

					}
				});
				rectangles[4][6].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][6].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][0].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][0].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][1].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][1].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][2].setOnMouseClicked(e -> {
					if (player.isValidClick(4, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[4][2].setFill(rec4.getFill());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][0].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 0, rectangles) == true) {
						naturetoken.setVisible(false);
						naturetoken.setVisible(false);

						rectangles[3][0].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][1].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][1].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][2].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][2].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][5].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][5].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][6].setOnMouseClicked(e -> {
					if (player.isValidClick(3, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[3][6].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][0].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][0].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][1].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][1].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][2].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][2].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][3].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][3].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][4].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][4].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][5].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][5].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][6].setOnMouseClicked(e -> {
					if (player.isValidClick(2, 6, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[2][6].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

				rectangles[1][0].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][0].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][2].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][2].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][3].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][3].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][4].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 4, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][4].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[1][5].setOnMouseClicked(e -> {
					if (player.isValidClick(1, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[1][5].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][0].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 0, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][0].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][1].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 1, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][1].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][2].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 2, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][2].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][3].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 3, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][3].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][4].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 4, rectangles) == true) {
						naturetoken.setVisible(false);
						naturetoken.setVisible(false);

						rectangles[5][4].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][5].setOnMouseClicked(e -> {
					if (player.isValidClick(5, 5, rectangles) == true) {
						naturetoken.setVisible(false);

						rectangles[5][5].setFill(rec4.getFill());
						cull.setVisible(true);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

			});

			Text gg = new Text();
			Text gg01 = new Text();
			Text gg2 = new Text();
			Text gg3 = new Text();
			Text gg4 = new Text();
			Text gg5 = new Text();
			Text gg6 = new Text();
			Text gg7 = new Text();
			Text gg8 = new Text();
			Text gg9 = new Text();
			Text gg10 = new Text();
			Text gg11 = new Text();
			Text gg12 = new Text();
			Text gg13 = new Text();
			Text gg14 = new Text();
			Text gg15 = new Text();
			Text gg16 = new Text();
			Text gg17 = new Text();
// wildlifetoken1 action listener is here 
			wildlifetoken1.setOnMouseClicked(e -> {
				System.out.println("tester");

				rectangles[3][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 3, rectangles, wildlifetoken1.getText()) == true) {

						// need to make a function to check if u can place it here
						String temp = text.getText();
						text.setText(temp + "\n" + wildlifetoken1.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}

				});
				rectangles[3][4].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(3, 4, rectangles, wildlifetoken1.getText()) == true) {
						String temp = text1.getText();
						text1.setText(temp + "\n" + wildlifetoken1.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][3].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(4, 3, rectangles, wildlifetoken1.getText()) == true) {

						String temp = text2.getText();
						text2.setText(temp + "\n" + wildlifetoken1.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}

				});
				rectangles[4][4].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(4, 4, rectangles, wildlifetoken1.getText()) == true) {

						gg01.setFont(Font.font("Arial", 7));
						gg01.setFill(Color.BLACK);
						String temp = gg01.getText();
						gg01.setText(temp + "\n" + wildlifetoken1.getText());
						gg01.setLayoutX(rectangles[4][4].getX()
								+ (rectangles[4][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg01.setLayoutY(rectangles[4][4].getY()
								+ (rectangles[4][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 5, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg.setFont(Font.font("Arial", 7));
						gg.setFill(Color.WHITE);
						String temp = gg.getText();
						gg.setText(temp + "\n" + wildlifetoken1.getText());
						gg.setLayoutX(rectangles[4][5].getX()
								+ (rectangles[4][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg.setLayoutY(rectangles[4][5].getY()
								+ (rectangles[4][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][6].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 6, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg2.setFont(Font.font("Arial", 7));
						gg2.setFill(Color.WHITE);
						String temp = gg2.getText();
						gg2.setText(temp + "\n" + wildlifetoken1.getText());
						gg2.setLayoutX(rectangles[4][6].getX()
								+ (rectangles[4][6].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg2.setLayoutY(rectangles[4][6].getY()
								+ (rectangles[4][6].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 5, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg3.setFont(Font.font("Arial", 7));
						gg3.setFill(Color.WHITE);
						String temp = gg3.getText();
						gg3.setText(temp + "\n" + wildlifetoken1.getText());
						gg3.setLayoutX(rectangles[3][5].getX()
								+ (rectangles[3][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg3.setLayoutY(rectangles[3][5].getY()
								+ (rectangles[3][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg4.setFont(Font.font("Arial", 7));
						gg4.setFill(Color.WHITE);
						String temp = gg4.getText();
						gg4.setText(temp + "\n" + wildlifetoken1.getText());
						gg4.setLayoutX(rectangles[4][2].getX()
								+ (rectangles[4][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg4.setLayoutY(rectangles[4][2].getY()
								+ (rectangles[4][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg4.setFont(Font.font("Arial", 7));
						gg4.setFill(Color.WHITE);
						String temp = gg4.getText();
						gg4.setText(temp + "\n" + wildlifetoken1.getText());
						gg4.setLayoutX(rectangles[4][1].getX()
								+ (rectangles[4][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg4.setLayoutY(rectangles[4][1].getY()
								+ (rectangles[4][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

				rectangles[3][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg6.setFont(Font.font("Arial", 7));
						gg6.setFill(Color.WHITE);
						String temp = gg6.getText();
						gg6.setText(temp + "\n" + wildlifetoken1.getText());
						gg6.setLayoutX(rectangles[3][2].getX()
								+ (rectangles[3][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg6.setLayoutY(rectangles[3][2].getY()
								+ (rectangles[3][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg7.setFont(Font.font("Arial", 7));
						gg7.setFill(Color.WHITE);
						String temp = gg7.getText();
						gg7.setText(temp + "\n" + wildlifetoken1.getText());
						gg7.setLayoutX(rectangles[3][1].getX()
								+ (rectangles[3][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg7.setLayoutY(rectangles[3][1].getY()
								+ (rectangles[3][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg8.setFont(Font.font("Arial", 7));
						gg8.setFill(Color.WHITE);
						String temp = gg8.getText();
						gg8.setText(temp + "\n" + wildlifetoken1.getText());
						gg8.setLayoutX(rectangles[2][1].getX()
								+ (rectangles[2][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg8.setLayoutY(rectangles[2][1].getY()
								+ (rectangles[2][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg9.setFont(Font.font("Arial", 7));
						gg9.setFill(Color.WHITE);
						String temp = gg9.getText();
						gg9.setText(temp + "\n" + wildlifetoken1.getText());
						gg9.setLayoutX(rectangles[2][2].getX()
								+ (rectangles[2][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg9.setLayoutY(rectangles[2][2].getY()
								+ (rectangles[2][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 3, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg10.setFont(Font.font("Arial", 7));
						gg10.setFill(Color.WHITE);
						String temp = gg10.getText();
						gg10.setText(temp + "\n" + wildlifetoken1.getText());
						gg10.setLayoutX(rectangles[2][3].getX()
								+ (rectangles[2][3].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg10.setLayoutY(rectangles[2][3].getY()
								+ (rectangles[2][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][4].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 4, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg11.setFont(Font.font("Arial", 7));
						gg11.setFill(Color.WHITE);
						String temp = gg11.getText();
						gg11.setText(temp + "\n" + wildlifetoken1.getText());
						gg11.setLayoutX(rectangles[2][4].getX()
								+ (rectangles[2][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg11.setLayoutY(rectangles[2][4].getY()
								+ (rectangles[2][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

				rectangles[2][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 5, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg12.setFont(Font.font("Arial", 7));
						gg12.setFill(Color.WHITE);
						String temp = gg12.getText();
						gg12.setText(temp + "\n" + wildlifetoken1.getText());
						gg12.setLayoutX(rectangles[2][5].getX()
								+ (rectangles[2][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg12.setLayoutY(rectangles[2][5].getY()
								+ (rectangles[2][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg13.setFont(Font.font("Arial", 7));
						gg13.setFill(Color.WHITE);
						String temp = gg13.getText();
						gg13.setText(temp + "\n" + wildlifetoken1.getText());
						gg13.setLayoutX(rectangles[5][1].getX()
								+ (rectangles[5][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg13.setLayoutY(rectangles[5][1].getY()
								+ (rectangles[5][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg14.setFont(Font.font("Arial", 7));
						gg14.setFill(Color.WHITE);
						String temp = gg14.getText();
						gg14.setText(temp + "\n" + wildlifetoken1.getText());
						gg14.setLayoutX(rectangles[5][2].getX()
								+ (rectangles[5][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg14.setLayoutY(rectangles[5][2].getY()
								+ (rectangles[5][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 3, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg15.setFont(Font.font("Arial", 7));
						gg15.setFill(Color.WHITE);
						String temp = gg15.getText();
						gg15.setText(temp + "\n" + wildlifetoken1.getText());
						gg15.setLayoutX(rectangles[5][3].getX()
								+ (rectangles[5][3].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg15.setLayoutY(rectangles[5][3].getY()
								+ (rectangles[5][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][4].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 4, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg15.setFont(Font.font("Arial", 7));
						gg15.setFill(Color.WHITE);
						String temp = gg15.getText();
						gg15.setText(temp + "\n" + wildlifetoken1.getText());
						gg15.setLayoutX(rectangles[5][4].getX()
								+ (rectangles[5][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg15.setLayoutY(rectangles[5][4].getY()
								+ (rectangles[5][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 5, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						gg16.setFont(Font.font("Arial", 7));
						gg16.setFill(Color.WHITE);
						String temp = gg16.getText();
						gg16.setText(temp + "\n" + wildlifetoken1.getText());
						gg16.setLayoutX(rectangles[5][5].getX()
								+ (rectangles[5][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						gg16.setLayoutY(rectangles[5][5].getY()
								+ (rectangles[5][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
			});

			/// cull
			root.getChildren().add(gg);
			root.getChildren().add(gg01);
			root.getChildren().add(gg2);
			root.getChildren().add(gg3);
			root.getChildren().add(gg4);
			root.getChildren().add(gg5);
			root.getChildren().add(gg6);
			root.getChildren().add(gg7);
			root.getChildren().add(gg8);
			root.getChildren().add(gg9);
			root.getChildren().add(gg10);

// this is for wildilife token 2

			Text ss = new Text();
			Text ss01 = new Text();
			Text ss2 = new Text();
			Text ss3 = new Text();
			Text ss4 = new Text();
			Text ss5 = new Text();
			Text ss6 = new Text();
			Text ss7 = new Text();
			Text ss8 = new Text();
			Text ss9 = new Text();
			Text ss10 = new Text();
			Text ss11 = new Text();
			Text ss12 = new Text();
			Text ss13 = new Text();
			Text ss14 = new Text();
			Text ss15 = new Text();
			Text ss16 = new Text();

			wildlifetoken2.setOnMouseClicked(e -> {
				System.out.println("tester");

				rectangles[3][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 3, rectangles, wildlifetoken2.getText()) == true) {

						// need to make a function to check if u can place it here
						String temp = text.getText();
						text.setText(temp + "\n" + wildlifetoken2.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}

				});
				rectangles[3][4].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(3, 4, rectangles, wildlifetoken2.getText()) == true) {
						String temp = text1.getText();
						text1.setText(temp + "\n" + wildlifetoken2.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][3].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(4, 3, rectangles, wildlifetoken2.getText()) == true) {

						String temp = text2.getText();
						text2.setText(temp + "\n" + wildlifetoken2.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}

				});
				rectangles[4][4].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(4, 4, rectangles, wildlifetoken2.getText()) == true) {

						ss01.setFont(Font.font("Arial", 7));
						ss01.setFill(Color.BLACK);
						String temp = ss01.getText();
						ss01.setText(temp + "\n" + wildlifetoken2.getText());
						ss01.setLayoutX(rectangles[4][4].getX()
								+ (rectangles[4][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss01.setLayoutY(rectangles[4][4].getY()
								+ (rectangles[4][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 5, rectangles, wildlifetoken2.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss.setFont(Font.font("Arial", 7));
						ss.setFill(Color.WHITE);
						String temp = ss.getText();
						ss.setText(temp + "\n" + wildlifetoken2.getText());
						ss.setLayoutX(rectangles[4][5].getX()
								+ (rectangles[4][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss.setLayoutY(rectangles[4][5].getY()
								+ (rectangles[4][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][6].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 6, rectangles, wildlifetoken2.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss2.setFont(Font.font("Arial", 7));
						ss2.setFill(Color.WHITE);
						String temp = ss2.getText();
						ss2.setText(temp + "\n" + wildlifetoken2.getText());
						ss2.setLayoutX(rectangles[4][6].getX()
								+ (rectangles[4][6].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss2.setLayoutY(rectangles[4][6].getY()
								+ (rectangles[4][6].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 5, rectangles, wildlifetoken2.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss3.setFont(Font.font("Arial", 7));
						ss3.setFill(Color.WHITE);
						String temp = ss3.getText();
						ss3.setText(temp + "\n" + wildlifetoken2.getText());
						ss3.setLayoutX(rectangles[3][5].getX()
								+ (rectangles[3][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss3.setLayoutY(rectangles[3][5].getY()
								+ (rectangles[3][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss4.setFont(Font.font("Arial", 7));
						ss4.setFill(Color.WHITE);
						String temp = ss4.getText();
						ss4.setText(temp + "\n" + wildlifetoken2.getText());
						ss4.setLayoutX(rectangles[4][2].getX()
								+ (rectangles[4][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss4.setLayoutY(rectangles[4][2].getY()
								+ (rectangles[4][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss4.setFont(Font.font("Arial", 7));
						ss4.setFill(Color.WHITE);
						String temp = ss4.getText();
						ss4.setText(temp + "\n" + wildlifetoken2.getText());
						ss4.setLayoutX(rectangles[4][1].getX()
								+ (rectangles[4][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss4.setLayoutY(rectangles[4][1].getY()
								+ (rectangles[4][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

				rectangles[3][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss6.setFont(Font.font("Arial", 7));
						ss6.setFill(Color.WHITE);
						String temp = ss6.getText();
						ss6.setText(temp + "\n" + wildlifetoken2.getText());
						ss6.setLayoutX(rectangles[3][2].getX()
								+ (rectangles[3][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss6.setLayoutY(rectangles[3][2].getY()
								+ (rectangles[3][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss7.setFont(Font.font("Arial", 7));
						ss7.setFill(Color.WHITE);
						String temp = ss7.getText();
						ss7.setText(temp + "\n" + wildlifetoken2.getText());
						ss7.setLayoutX(rectangles[3][1].getX()
								+ (rectangles[3][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss7.setLayoutY(rectangles[3][1].getY()
								+ (rectangles[3][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss8.setFont(Font.font("Arial", 7));
						ss8.setFill(Color.WHITE);
						String temp = ss8.getText();
						ss8.setText(temp + "\n" + wildlifetoken2.getText());
						ss8.setLayoutX(rectangles[2][1].getX()
								+ (rectangles[2][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss8.setLayoutY(rectangles[2][1].getY()
								+ (rectangles[2][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss9.setFont(Font.font("Arial", 7));
						ss9.setFill(Color.WHITE);
						String temp = ss9.getText();
						ss9.setText(temp + "\n" + wildlifetoken2.getText());
						ss9.setLayoutX(rectangles[2][2].getX()
								+ (rectangles[2][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss9.setLayoutY(rectangles[2][2].getY()
								+ (rectangles[2][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 3, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss10.setFont(Font.font("Arial", 7));
						ss10.setFill(Color.WHITE);
						String temp = ss10.getText();
						ss10.setText(temp + "\n" + wildlifetoken2.getText());
						ss10.setLayoutX(rectangles[2][3].getX()
								+ (rectangles[2][3].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss10.setLayoutY(rectangles[2][3].getY()
								+ (rectangles[2][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][4].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 4, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss11.setFont(Font.font("Arial", 7));
						ss11.setFill(Color.WHITE);
						String temp = ss11.getText();
						ss11.setText(temp + "\n" + wildlifetoken2.getText());
						ss11.setLayoutX(rectangles[2][4].getX()
								+ (rectangles[2][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss11.setLayoutY(rectangles[2][4].getY()
								+ (rectangles[2][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

				rectangles[2][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 5, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss12.setFont(Font.font("Arial", 7));
						ss12.setFill(Color.WHITE);
						String temp = ss12.getText();
						ss12.setText(temp + "\n" + wildlifetoken2.getText());
						ss12.setLayoutX(rectangles[2][5].getX()
								+ (rectangles[2][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss12.setLayoutY(rectangles[2][5].getY()
								+ (rectangles[2][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss13.setFont(Font.font("Arial", 7));
						ss13.setFill(Color.WHITE);
						String temp = ss13.getText();
						ss13.setText(temp + "\n" + wildlifetoken2.getText());
						ss13.setLayoutX(rectangles[5][1].getX()
								+ (rectangles[5][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss13.setLayoutY(rectangles[5][1].getY()
								+ (rectangles[5][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss14.setFont(Font.font("Arial", 7));
						ss14.setFill(Color.WHITE);
						String temp = ss14.getText();
						ss14.setText(temp + "\n" + wildlifetoken2.getText());
						ss14.setLayoutX(rectangles[5][2].getX()
								+ (rectangles[5][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss14.setLayoutY(rectangles[5][2].getY()
								+ (rectangles[5][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 3, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss15.setFont(Font.font("Arial", 7));
						ss15.setFill(Color.WHITE);
						String temp = ss15.getText();
						ss15.setText(temp + "\n" + wildlifetoken2.getText());
						ss15.setLayoutX(rectangles[5][3].getX()
								+ (rectangles[5][3].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss15.setLayoutY(rectangles[5][3].getY()
								+ (rectangles[5][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][4].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 4, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss15.setFont(Font.font("Arial", 7));
						ss15.setFill(Color.WHITE);
						String temp = ss15.getText();
						ss15.setText(temp + "\n" + wildlifetoken2.getText());
						ss15.setLayoutX(rectangles[5][4].getX()
								+ (rectangles[5][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss15.setLayoutY(rectangles[5][4].getY()
								+ (rectangles[5][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 5, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ss16.setFont(Font.font("Arial", 7));
						ss16.setFill(Color.WHITE);
						String temp = ss16.getText();
						ss16.setText(temp + "\n" + wildlifetoken2.getText());
						ss16.setLayoutX(rectangles[5][5].getX()
								+ (rectangles[5][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ss16.setLayoutY(rectangles[5][5].getY()
								+ (rectangles[5][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
			});

			/// cull
			root.getChildren().add(ss);
			root.getChildren().add(ss01);
			root.getChildren().add(ss2);
			root.getChildren().add(ss3);
			root.getChildren().add(ss4);
			root.getChildren().add(ss5);
			root.getChildren().add(ss6);
			root.getChildren().add(ss7);
			root.getChildren().add(ss8);
			root.getChildren().add(ss9);
			root.getChildren().add(ss10);
			root.getChildren().add(ss11);
			root.getChildren().add(ss12);
			root.getChildren().add(ss13);
			root.getChildren().add(ss14);
			root.getChildren().add(ss15);
			root.getChildren().add(ss16);

			// wildlife token 3

			Text ff = new Text();
			Text ff01 = new Text();
			Text ff2 = new Text();
			Text ff3 = new Text();
			Text ff4 = new Text();
			Text ff5 = new Text();
			Text ff6 = new Text();
			Text ff7 = new Text();
			Text ff8 = new Text();
			Text ff9 = new Text();
			Text ff10 = new Text();
			Text ff11 = new Text();
			Text ff12 = new Text();
			Text ff13 = new Text();
			Text ff14 = new Text();
			Text ff15 = new Text();
			Text ff16 = new Text();

			wildlifetoken3.setOnMouseClicked(e -> {
				System.out.println("tester");

				rectangles[3][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 3, rectangles, wildlifetoken3.getText()) == true) {

						// need to make a function to check if u can place it here
						String temp = text.getText();
						text.setText(temp + "\n" + wildlifetoken3.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}

				});
				rectangles[3][4].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(3, 4, rectangles, wildlifetoken3.getText()) == true) {
						String temp = text1.getText();
						text1.setText(temp + "\n" + wildlifetoken3.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][3].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(4, 3, rectangles, wildlifetoken3.getText()) == true) {

						String temp = text2.getText();
						text2.setText(temp + "\n" + wildlifetoken3.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}

				});
				rectangles[4][4].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(4, 4, rectangles, wildlifetoken3.getText()) == true) {

						ff01.setFont(Font.font("Arial", 7));
						ff01.setFill(Color.BLACK);
						String temp = ff01.getText();
						ff01.setText(temp + "\n" + wildlifetoken3.getText());
						ff01.setLayoutX(rectangles[4][4].getX()
								+ (rectangles[4][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff01.setLayoutY(rectangles[4][4].getY()
								+ (rectangles[4][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 5, rectangles, wildlifetoken3.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff.setFont(Font.font("Arial", 7));
						ff.setFill(Color.WHITE);
						String temp = ff.getText();
						ff.setText(temp + "\n" + wildlifetoken3.getText());
						ff.setLayoutX(rectangles[4][5].getX()
								+ (rectangles[4][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff.setLayoutY(rectangles[4][5].getY()
								+ (rectangles[4][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][6].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 6, rectangles, wildlifetoken3.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff2.setFont(Font.font("Arial", 7));
						ff2.setFill(Color.WHITE);
						String temp = ff2.getText();
						ff2.setText(temp + "\n" + wildlifetoken3.getText());
						ff2.setLayoutX(rectangles[4][6].getX()
								+ (rectangles[4][6].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff2.setLayoutY(rectangles[4][6].getY()
								+ (rectangles[4][6].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 5, rectangles, wildlifetoken3.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff3.setFont(Font.font("Arial", 7));
						ff3.setFill(Color.WHITE);
						String temp = ff3.getText();
						ff3.setText(temp + "\n" + wildlifetoken3.getText());
						ff3.setLayoutX(rectangles[3][5].getX()
								+ (rectangles[3][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff3.setLayoutY(rectangles[3][5].getY()
								+ (rectangles[3][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff4.setFont(Font.font("Arial", 7));
						ff4.setFill(Color.WHITE);
						String temp = ff4.getText();
						ff4.setText(temp + "\n" + wildlifetoken3.getText());
						ff4.setLayoutX(rectangles[4][2].getX()
								+ (rectangles[4][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff4.setLayoutY(rectangles[4][2].getY()
								+ (rectangles[4][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff4.setFont(Font.font("Arial", 7));
						ff4.setFill(Color.WHITE);
						String temp = ff4.getText();
						ff4.setText(temp + "\n" + wildlifetoken3.getText());
						ff4.setLayoutX(rectangles[4][1].getX()
								+ (rectangles[4][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff4.setLayoutY(rectangles[4][1].getY()
								+ (rectangles[4][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

				rectangles[3][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff6.setFont(Font.font("Arial", 7));
						ff6.setFill(Color.WHITE);
						String temp = ff6.getText();
						ff6.setText(temp + "\n" + wildlifetoken3.getText());
						ff6.setLayoutX(rectangles[3][2].getX()
								+ (rectangles[3][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff6.setLayoutY(rectangles[3][2].getY()
								+ (rectangles[3][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff7.setFont(Font.font("Arial", 7));
						ff7.setFill(Color.WHITE);
						String temp = ff7.getText();
						ff7.setText(temp + "\n" + wildlifetoken1.getText());
						ff7.setLayoutX(rectangles[3][1].getX()
								+ (rectangles[3][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff7.setLayoutY(rectangles[3][1].getY()
								+ (rectangles[3][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff8.setFont(Font.font("Arial", 7));
						ff8.setFill(Color.WHITE);
						String temp = ff8.getText();
						ff8.setText(temp + "\n" + wildlifetoken3.getText());
						ff8.setLayoutX(rectangles[2][1].getX()
								+ (rectangles[2][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff8.setLayoutY(rectangles[2][1].getY()
								+ (rectangles[2][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff9.setFont(Font.font("Arial", 7));
						ff9.setFill(Color.WHITE);
						String temp = ff9.getText();
						ff9.setText(temp + "\n" + wildlifetoken3.getText());
						ff9.setLayoutX(rectangles[2][2].getX()
								+ (rectangles[2][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff9.setLayoutY(rectangles[2][2].getY()
								+ (rectangles[2][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 3, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff10.setFont(Font.font("Arial", 7));
						ff10.setFill(Color.WHITE);
						String temp = ff10.getText();
						ff10.setText(temp + "\n" + wildlifetoken3.getText());
						ff10.setLayoutX(rectangles[2][3].getX()
								+ (rectangles[2][3].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff10.setLayoutY(rectangles[2][3].getY()
								+ (rectangles[2][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][4].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 4, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff11.setFont(Font.font("Arial", 7));
						ff11.setFill(Color.WHITE);
						String temp = ff11.getText();
						ff11.setText(temp + "\n" + wildlifetoken3.getText());
						ff11.setLayoutX(rectangles[2][4].getX()
								+ (rectangles[2][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff11.setLayoutY(rectangles[2][4].getY()
								+ (rectangles[2][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

				rectangles[2][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 5, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff12.setFont(Font.font("Arial", 7));
						ff12.setFill(Color.WHITE);
						String temp = ff12.getText();
						ff12.setText(temp + "\n" + wildlifetoken3.getText());
						ff12.setLayoutX(rectangles[2][5].getX()
								+ (rectangles[2][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff12.setLayoutY(rectangles[2][5].getY()
								+ (rectangles[2][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff13.setFont(Font.font("Arial", 7));
						ff13.setFill(Color.WHITE);
						String temp = ff13.getText();
						ff13.setText(temp + "\n" + wildlifetoken3.getText());
						ff13.setLayoutX(rectangles[5][1].getX()
								+ (rectangles[5][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff13.setLayoutY(rectangles[5][1].getY()
								+ (rectangles[5][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff14.setFont(Font.font("Arial", 7));
						ff14.setFill(Color.WHITE);
						String temp = ff14.getText();
						ff14.setText(temp + "\n" + wildlifetoken3.getText());
						ff14.setLayoutX(rectangles[5][2].getX()
								+ (rectangles[5][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff14.setLayoutY(rectangles[5][2].getY()
								+ (rectangles[5][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 3, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff15.setFont(Font.font("Arial", 7));
						ff15.setFill(Color.WHITE);
						String temp = ff15.getText();
						ff15.setText(temp + "\n" + wildlifetoken3.getText());
						ff15.setLayoutX(rectangles[5][3].getX()
								+ (rectangles[5][3].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff15.setLayoutY(rectangles[5][3].getY()
								+ (rectangles[5][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][4].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 4, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff15.setFont(Font.font("Arial", 7));
						ff15.setFill(Color.WHITE);
						String temp = ff15.getText();
						ff15.setText(temp + "\n" + wildlifetoken3.getText());
						ff15.setLayoutX(rectangles[5][4].getX()
								+ (rectangles[5][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff15.setLayoutY(rectangles[5][4].getY()
								+ (rectangles[5][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 5, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						ff16.setFont(Font.font("Arial", 7));
						ff16.setFill(Color.WHITE);
						String temp = ff16.getText();
						ff16.setText(temp + "\n" + wildlifetoken3.getText());
						ff16.setLayoutX(rectangles[5][5].getX()
								+ (rectangles[5][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						ff16.setLayoutY(rectangles[5][5].getY()
								+ (rectangles[5][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
			});

/// cull
			root.getChildren().add(ff);
			root.getChildren().add(ff01);
			root.getChildren().add(ff2);
			root.getChildren().add(ff3);
			root.getChildren().add(ff4);
			root.getChildren().add(ff5);
			root.getChildren().add(ff6);
			root.getChildren().add(ff7);
			root.getChildren().add(ff8);
			root.getChildren().add(ff9);
			root.getChildren().add(ff10);
			root.getChildren().add(ff11);
			root.getChildren().add(ff12);
			root.getChildren().add(ff13);
			root.getChildren().add(ff14);
			root.getChildren().add(ff15);
			root.getChildren().add(ff16);

// wildlife token 4

			Text kk = new Text();
			Text kk01 = new Text();
			Text kk2 = new Text();
			Text kk3 = new Text();
			Text kk4 = new Text();
			Text kk5 = new Text();
			Text kk6 = new Text();
			Text kk7 = new Text();
			Text kk8 = new Text();
			Text kk9 = new Text();
			Text kk10 = new Text();
			Text kk11 = new Text();
			Text kk12 = new Text();
			Text kk13 = new Text();
			Text kk14 = new Text();
			Text kk15 = new Text();
			Text kk16 = new Text();

			wildlifetoken4.setOnMouseClicked(e -> {
				System.out.println("tester");

				rectangles[3][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 3, rectangles, wildlifetoken4.getText()) == true) {

						// need to make a function to check if u can place it here
						String temp = text.getText();
						text.setText(temp + "\n" + wildlifetoken4.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}

				});
				rectangles[3][4].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(3, 4, rectangles, wildlifetoken4.getText()) == true) {
						String temp = text1.getText();
						text1.setText(temp + "\n" + wildlifetoken4.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][3].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(4, 3, rectangles, wildlifetoken4.getText()) == true) {

						String temp = text2.getText();
						text2.setText(temp + "\n" + wildlifetoken4.getText());
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}

				});
				rectangles[4][4].setOnMouseClicked(eg -> {
					// need to make a function to check if u can place it here
					if (canPlacetokenHere(4, 4, rectangles, wildlifetoken4.getText()) == true) {

						kk01.setFont(Font.font("Arial", 7));
						kk01.setFill(Color.BLACK);
						String temp = kk01.getText();
						kk01.setText(temp + "\n" + wildlifetoken4.getText());
						kk01.setLayoutX(rectangles[4][4].getX()
								+ (rectangles[4][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk01.setLayoutY(rectangles[4][4].getY()
								+ (rectangles[4][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);
						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 5, rectangles, wildlifetoken4.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk.setFont(Font.font("Arial", 7));
						kk.setFill(Color.BLACK);
						String temp = kk.getText();
						kk.setText(temp + "\n" + wildlifetoken4.getText());
						kk.setLayoutX(rectangles[4][5].getX()
								+ (rectangles[4][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk.setLayoutY(rectangles[4][5].getY()
								+ (rectangles[4][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][6].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 6, rectangles, wildlifetoken4.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk2.setFont(Font.font("Arial", 7));
						kk2.setFill(Color.BLACK);
						String temp = kk2.getText();
						kk2.setText(temp + "\n" + wildlifetoken4.getText());
						kk2.setLayoutX(rectangles[4][6].getX()
								+ (rectangles[4][6].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk2.setLayoutY(rectangles[4][6].getY()
								+ (rectangles[4][6].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 5, rectangles, wildlifetoken4.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk3.setFont(Font.font("Arial", 7));
						kk3.setFill(Color.WHITE);
						String temp = kk3.getText();
						kk3.setText(temp + "\n" + wildlifetoken4.getText());
						kk3.setLayoutX(rectangles[3][5].getX()
								+ (rectangles[3][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk3.setLayoutY(rectangles[3][5].getY()
								+ (rectangles[3][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk4.setFont(Font.font("Arial", 7));
						kk4.setFill(Color.WHITE);
						String temp = kk4.getText();
						kk4.setText(temp + "\n" + wildlifetoken4.getText());
						kk4.setLayoutX(rectangles[4][2].getX()
								+ (rectangles[4][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk4.setLayoutY(rectangles[4][2].getY()
								+ (rectangles[4][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[4][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(4, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk4.setFont(Font.font("Arial", 7));
						kk4.setFill(Color.WHITE);
						String temp = kk4.getText();
						kk4.setText(temp + "\n" + wildlifetoken4.getText());
						kk4.setLayoutX(rectangles[4][1].getX()
								+ (rectangles[4][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk4.setLayoutY(rectangles[4][1].getY()
								+ (rectangles[4][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

				rectangles[3][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk6.setFont(Font.font("Arial", 7));
						kk6.setFill(Color.WHITE);
						String temp = kk6.getText();
						kk6.setText(temp + "\n" + wildlifetoken4.getText());
						kk6.setLayoutX(rectangles[3][2].getX()
								+ (rectangles[3][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk6.setLayoutY(rectangles[3][2].getY()
								+ (rectangles[3][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[3][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(3, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk7.setFont(Font.font("Arial", 7));
						kk7.setFill(Color.WHITE);
						String temp = kk7.getText();
						kk7.setText(temp + "\n" + wildlifetoken4.getText());
						kk7.setLayoutX(rectangles[3][1].getX()
								+ (rectangles[3][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk7.setLayoutY(rectangles[3][1].getY()
								+ (rectangles[3][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk8.setFont(Font.font("Arial", 7));
						kk8.setFill(Color.WHITE);
						String temp = kk8.getText();
						kk8.setText(temp + "\n" + wildlifetoken1.getText());
						kk8.setLayoutX(rectangles[2][1].getX()
								+ (rectangles[2][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk8.setLayoutY(rectangles[2][1].getY()
								+ (rectangles[2][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk9.setFont(Font.font("Arial", 7));
						kk9.setFill(Color.WHITE);
						String temp = kk9.getText();
						kk9.setText(temp + "\n" + wildlifetoken4.getText());
						kk9.setLayoutX(rectangles[2][2].getX()
								+ (rectangles[2][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk9.setLayoutY(rectangles[2][2].getY()
								+ (rectangles[2][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 3, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk10.setFont(Font.font("Arial", 7));
						kk10.setFill(Color.WHITE);
						String temp = kk10.getText();
						kk10.setText(temp + "\n" + wildlifetoken4.getText());
						kk10.setLayoutX(rectangles[2][3].getX()
								+ (rectangles[2][3].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk10.setLayoutY(rectangles[2][3].getY()
								+ (rectangles[2][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[2][4].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 4, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk11.setFont(Font.font("Arial", 7));
						kk11.setFill(Color.WHITE);
						String temp = kk11.getText();
						kk11.setText(temp + "\n" + wildlifetoken4.getText());
						kk11.setLayoutX(rectangles[2][4].getX()
								+ (rectangles[2][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk11.setLayoutY(rectangles[2][4].getY()
								+ (rectangles[2][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});

				rectangles[2][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(2, 5, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk12.setFont(Font.font("Arial", 7));
						kk12.setFill(Color.WHITE);
						String temp = kk12.getText();
						kk12.setText(temp + "\n" + wildlifetoken4.getText());
						kk12.setLayoutX(rectangles[2][5].getX()
								+ (rectangles[2][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk12.setLayoutY(rectangles[2][5].getY()
								+ (rectangles[2][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][1].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 1, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk13.setFont(Font.font("Arial", 7));
						kk13.setFill(Color.WHITE);
						String temp = kk13.getText();
						kk13.setText(temp + "\n" + wildlifetoken4.getText());
						kk13.setLayoutX(rectangles[5][1].getX()
								+ (rectangles[5][1].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk13.setLayoutY(rectangles[5][1].getY()
								+ (rectangles[5][1].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][2].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 2, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk14.setFont(Font.font("Arial", 7));
						kk14.setFill(Color.WHITE);
						String temp = kk14.getText();
						kk14.setText(temp + "\n" + wildlifetoken4.getText());
						kk14.setLayoutX(rectangles[5][2].getX()
								+ (rectangles[5][2].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk14.setLayoutY(rectangles[5][2].getY()
								+ (rectangles[5][2].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][3].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 3, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk15.setFont(Font.font("Arial", 7));
						kk15.setFill(Color.WHITE);
						String temp = kk15.getText();
						kk15.setText(temp + "\n" + wildlifetoken1.getText());
						kk15.setLayoutX(rectangles[5][3].getX()
								+ (rectangles[5][3].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk15.setLayoutY(rectangles[5][3].getY()
								+ (rectangles[5][3].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][4].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 4, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk15.setFont(Font.font("Arial", 7));
						kk15.setFill(Color.WHITE);
						String temp = kk15.getText();
						kk15.setText(temp + "\n" + wildlifetoken4.getText());
						kk15.setLayoutX(rectangles[5][4].getX()
								+ (rectangles[5][4].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk15.setLayoutY(rectangles[5][4].getY()
								+ (rectangles[5][4].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
				rectangles[5][5].setOnMouseClicked(eg -> {
					if (canPlacetokenHere(5, 5, rectangles, wildlifetoken1.getText()) == true) {

						System.out.println("clicked");
						// need to make a function to check if u can place it here
						kk16.setFont(Font.font("Arial", 7));
						kk16.setFill(Color.WHITE);
						String temp = kk16.getText();
						kk16.setText(temp + "\n" + wildlifetoken4.getText());
						kk16.setLayoutX(rectangles[5][5].getX()
								+ (rectangles[5][5].getWidth() - text.getLayoutBounds().getWidth()) / 2 - 5);
						kk16.setLayoutY(rectangles[5][5].getY()
								+ (rectangles[5][5].getHeight() - text.getLayoutBounds().getHeight()) / 2);

						for (int i = 0; i < rectangles.length; i++) {
							for (int j = 0; j < rectangles[i].length; j++) {
								rectangles[i][j].setOnMouseClicked(null);
							}
						}
					}
				});
			});

/// cull
			root.getChildren().add(kk);
			root.getChildren().add(kk01);
			root.getChildren().add(kk2);
			root.getChildren().add(kk3);
			root.getChildren().add(kk4);
			root.getChildren().add(kk5);
			root.getChildren().add(kk6);
			root.getChildren().add(kk7);
			root.getChildren().add(kk8);
			root.getChildren().add(kk9);
			root.getChildren().add(kk10);
			root.getChildren().add(kk11);
			root.getChildren().add(kk12);
			root.getChildren().add(kk13);
			root.getChildren().add(kk14);
			root.getChildren().add(kk15);
			root.getChildren().add(kk16);

			// ----------------------------------
			cull.setOnAction(event -> {

			});
// gonna add the nature token thing here 

			naturetoken.setOnAction(event -> {
				if (hasNatureTokens(player.CurrentPlayer) == true) {
					Collections.shuffle(tileList);
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
				} else {
					naturetoken.setText("invalid number of tokens");
				}
			});
			// useful addtion here

			Button invert = (Button) root.lookup("#switch");
			AnchorPane gg1 = (AnchorPane) root.lookup("#boardPane");
			invert.setText("Invert");

			invert.setOnAction(event -> {
				

				if (i % 2 == 0) {
					gg1.setStyle("-fx-background-color: black;");
				} else {
					gg1.setStyle("-fx-background-color: blue;");
				}
				i++;
			});
			Button button = (Button) root.lookup("#Button1");
			wildlifetokenplaced.add(gg);
			wildlifetokenplaced.add(gg01);
			wildlifetokenplaced.add(gg2);
			wildlifetokenplaced.add(gg3);
			wildlifetokenplaced.add(gg3);
			wildlifetokenplaced.add(gg5);
			wildlifetokenplaced.add(gg6);
			wildlifetokenplaced.add(gg7);
			wildlifetokenplaced.add(gg8);
			wildlifetokenplaced.add(gg9);
			wildlifetokenplaced.add(gg10);
			wildlifetokenplaced.add(gg11);
			wildlifetokenplaced.add(gg12);
			wildlifetokenplaced.add(gg13);
			wildlifetokenplaced.add(gg14);
			wildlifetokenplaced.add(gg15);
			wildlifetokenplaced.add(gg16);

			// add starter tiles also
			wildlifetokenplaced.add(text);
			wildlifetokenplaced.add(text1);
			wildlifetokenplaced.add(text2);

			wildlifetokenplaced.add(ss);
			wildlifetokenplaced.add(ss01);
			wildlifetokenplaced.add(ss2);
			wildlifetokenplaced.add(ss3);
			wildlifetokenplaced.add(ss3);
			wildlifetokenplaced.add(ss5);
			wildlifetokenplaced.add(ss6);
			wildlifetokenplaced.add(ss7);
			wildlifetokenplaced.add(ss8);
			wildlifetokenplaced.add(ss9);
			wildlifetokenplaced.add(ss10);
			wildlifetokenplaced.add(ss11);
			wildlifetokenplaced.add(ss12);
			wildlifetokenplaced.add(ss13);
			wildlifetokenplaced.add(ss14);
			wildlifetokenplaced.add(ss15);
			wildlifetokenplaced.add(ss16);

			wildlifetokenplaced.add(ff);
			wildlifetokenplaced.add(ff01);
			wildlifetokenplaced.add(ff2);
			wildlifetokenplaced.add(ff3);
			wildlifetokenplaced.add(ff3);
			wildlifetokenplaced.add(ff5);
			wildlifetokenplaced.add(ff6);
			wildlifetokenplaced.add(ff7);
			wildlifetokenplaced.add(ff8);
			wildlifetokenplaced.add(ff9);
			wildlifetokenplaced.add(ff10);
			wildlifetokenplaced.add(ff11);
			wildlifetokenplaced.add(ff12);
			wildlifetokenplaced.add(ff13);
			wildlifetokenplaced.add(ff14);
			wildlifetokenplaced.add(ff15);
			wildlifetokenplaced.add(ff16);
			// for wildlife 4
			wildlifetokenplaced.add(kk);
			wildlifetokenplaced.add(kk01);
			wildlifetokenplaced.add(kk2);
			wildlifetokenplaced.add(kk3);
			wildlifetokenplaced.add(kk3);
			wildlifetokenplaced.add(kk5);
			wildlifetokenplaced.add(kk6);
			wildlifetokenplaced.add(kk7);
			wildlifetokenplaced.add(kk8);
			wildlifetokenplaced.add(kk9);
			wildlifetokenplaced.add(kk10);
			wildlifetokenplaced.add(kk11);
			wildlifetokenplaced.add(kk12);
			wildlifetokenplaced.add(kk13);
			wildlifetokenplaced.add(kk14);
			wildlifetokenplaced.add(kk15);
			wildlifetokenplaced.add(kk16);

			button.setOnAction(event -> {

// add tiles to arraylist 

				Collections.shuffle(tileList);

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

				

				naturetoken.setText("Use Nature Token");
				naturetoken.setVisible(true);

				// ake buttons more clear by aking them all black
				gg.setFill(Color.BLACK);
				gg01.setFill(Color.BLACK);
				gg2.setFill(Color.BLACK);
				gg3.setFill(Color.BLACK);
				gg4.setFill(Color.BLACK);
				gg5.setFill(Color.BLACK);
				gg6.setFill(Color.BLACK);
				gg7.setFill(Color.BLACK);
				gg8.setFill(Color.BLACK);
				gg9.setFill(Color.BLACK);
				gg10.setFill(Color.BLACK);
				gg11.setFill(Color.BLACK);
				gg12.setFill(Color.BLACK);
				gg13.setFill(Color.BLACK);
				gg14.setFill(Color.BLACK);
				gg15.setFill(Color.BLACK);
				gg16.setFill(Color.BLACK);
				gg17.setFill(Color.BLACK);
				ss.setFill(Color.BLACK);
				ss01.setFill(Color.BLACK);
				ss2.setFill(Color.BLACK);
				ss3.setFill(Color.BLACK);
				ss4.setFill(Color.BLACK);
				ss5.setFill(Color.BLACK);
				ss6.setFill(Color.BLACK);
				ss7.setFill(Color.BLACK);
				ss8.setFill(Color.BLACK);
				ss9.setFill(Color.BLACK);
				ss10.setFill(Color.BLACK);
				ss11.setFill(Color.BLACK);
				ss12.setFill(Color.BLACK);
				ss13.setFill(Color.BLACK);
				ss14.setFill(Color.BLACK);
				ss15.setFill(Color.BLACK);
				ss16.setFill(Color.BLACK);
				ff.setFill(Color.BLACK);
				ff01.setFill(Color.BLACK);
				ff2.setFill(Color.BLACK);
				ff3.setFill(Color.BLACK);
				ff4.setFill(Color.BLACK);
				ff5.setFill(Color.BLACK);
				ff6.setFill(Color.BLACK);
				ff7.setFill(Color.BLACK);
				ff8.setFill(Color.BLACK);
				ff9.setFill(Color.BLACK);
				ff10.setFill(Color.BLACK);
				ff11.setFill(Color.BLACK);
				ff12.setFill(Color.BLACK);
				ff13.setFill(Color.BLACK);
				ff14.setFill(Color.BLACK);
				ff15.setFill(Color.BLACK);
				ff16.setFill(Color.BLACK);
				kk.setFill(Color.BLACK);
				kk01.setFill(Color.BLACK);
				kk2.setFill(Color.BLACK);
				kk3.setFill(Color.BLACK);
				kk4.setFill(Color.BLACK);
				kk5.setFill(Color.BLACK);
				kk6.setFill(Color.BLACK);
				kk7.setFill(Color.BLACK);
				kk8.setFill(Color.BLACK);
				kk9.setFill(Color.BLACK);
				kk10.setFill(Color.BLACK);
				kk11.setFill(Color.BLACK);
				kk12.setFill(Color.BLACK);
				kk13.setFill(Color.BLACK);
				kk14.setFill(Color.BLACK);
				kk15.setFill(Color.BLACK);
				kk16.setFill(Color.BLACK);
				curscore = curscore +player.HawkScoringB(wildlifetokenplaced, player.CurrentPlayer)+player.BearScoringA(wildlifetokenplaced, player.CurrentPlayer);
				score.setText("Score: " + curscore);

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