package SimpleMapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid extends GridFactory {

    private Rectangle grid;
    Player player;

    public Grid (int cols, int rows){
        super (cols, rows);


    }

    public void init() {

        grid = new Rectangle(getPadding(), getPadding(), getWidth(), getHeight());
        grid.setColor(Color.BLACK);
        grid.draw();
        drawLines();

    }


    public void drawLines(){
        Line horizontalLine = new Line(getPadding(), getPadding() + getCellSize(), getWidth() + getPadding(), getPadding() + getCellSize());
        horizontalLine.draw();
        horizontalLine.setColor(Color.BLACK);

        for(int i = 1; i <getCols(); i++) {
           if(i < getHeight()){
           int currentCol = coltoX(i);
           horizontalLine = new Line(getPadding(), getCellSize() + currentCol, getWidth() + getPadding(), getCellSize() + currentCol);
           horizontalLine.draw();
           horizontalLine.setColor(Color.BLACK);
           }



      }
        Line verticalLine = new Line(getPadding() + getCellSize(), getPadding(), getPadding() + getCellSize(), getHeight() + getPadding());
        verticalLine.draw();
        verticalLine.setColor(Color.BLACK);
      for(int j = 1; j <getRows(); j++) {
          if(j < getWidth()) {
              int currentRow = rowToY(j);
              verticalLine = new Line(currentRow + getCellSize(), getPadding(), getCellSize() + currentRow, getHeight() + getPadding());
              verticalLine.draw();
              verticalLine.setColor(Color.BLACK);

          }

      }

    }






}
