package SimpleMapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid extends GridFactory {

    private int cols;
    private int rows;

    private Rectangle grid;
    Player player;

    public Grid (int cols, int rows){
        super (cols, rows);

    }

    public void init() {

        grid = new Rectangle(GridFactory.PADDING, GridFactory.PADDING, getWidth(), getHeight());
        grid.setColor(Color.BLACK);
        grid.draw();
        drawLines();

    }


    public void drawLines(){
        Line horizontalLine = new Line(GridFactory.PADDING, GridFactory.PADDING + getCellSize(), getWidth() + GridFactory.PADDING, GridFactory.PADDING + getCellSize());
        horizontalLine.draw();
        horizontalLine.setColor(Color.BLACK);

        for(int i = 1; i <getCols(); i++) {
           if(i < getHeight()){
           int currentCol = coltoX(i);
           horizontalLine = new Line(GridFactory.PADDING, getCellSize() + currentCol, getWidth() + GridFactory.PADDING, getCellSize() + currentCol);
           horizontalLine.draw();
           horizontalLine.setColor(Color.BLACK);
           }



      }
        Line verticalLine = new Line(GridFactory.PADDING + getCellSize(), GridFactory.PADDING, GridFactory.PADDING + getCellSize(), getHeight() + GridFactory.PADDING);
        verticalLine.draw();
        verticalLine.setColor(Color.BLACK);
      for(int j = 1; j <getRows(); j++) {
          if(j < getWidth()) {
              int currentRow = rowToY(j);
              verticalLine = new Line(currentRow + getCellSize(), GridFactory.PADDING, getCellSize() + currentRow, getHeight() + GridFactory.PADDING);
              verticalLine.draw();
              verticalLine.setColor(Color.BLACK);

          }

      }

    }






}
