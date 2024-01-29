package SimpleMapEditor;

import SimpleMapEditor.Grid;
import SimpleMapEditor.GridFactory;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid(30, 30);
        Player player = new Player(grid);

        grid.init();


        System.out.println(grid.getWidth());
        System.out.println(grid.getHeight());
    }
}
