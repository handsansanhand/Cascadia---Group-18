package player;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board {
    private Rectangle[][] rectangles;

    public Board(int numRows, int numCols, int rectSize) {
        rectangles = new Rectangle[numRows][numCols];
        int boardWidth = numCols * rectSize;
        int boardHeight = numRows * rectSize;
        int startX = (890 - boardWidth) / 2;  
        int startY = (580 - boardHeight) / 2; 

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Rectangle rect = new Rectangle(startX + col * rectSize, startY + row * rectSize, rectSize, rectSize);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.GREEN);
                rectangles[row][col] = rect;
            }
        }
        
    }

    public Rectangle[][] getRectangles() {
        return rectangles;
    }
}
