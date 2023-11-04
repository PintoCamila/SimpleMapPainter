package SimpleMapEditor;

import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridFactory {

    public static final int PADDING = 10;
    private final int cellSize = 20;
    private int cols;
    private int rows;
    private int numberOfCols;
    private int numberOfRows;
    private Rectangle grid;

    Rectangle mainGrid;


    public GridFactory(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {
    }
    public int getWidth() {
        return cols * cellSize;
    }

    public int getHeight() {
        return rows * cellSize;
    }

    public int getCellSize() {
        return cellSize;

    }

    public int rowToY(int row){
        return PADDING + row * cellSize;
    }

    public int coltoX(int column){
        return PADDING + column * cellSize;
    }

    public int getCols(){
        return cols;
    }

    public int getRows(){
        return rows;
    }



}
