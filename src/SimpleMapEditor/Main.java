package SimpleMapEditor;

import SimpleMapEditor.Grid;
import SimpleMapEditor.GridFactory;

public class Main {
    public static void main(String[] args) {
        GridFactory gridFactory = new GridFactory(30, 30);
        Grid grid = new Grid(30, 30);
        Player player = new Player(gridFactory, grid);
       // SimpleMapEditor.Player.EventHandler eventHandler = new SimpleMapEditor.Player.EventHandler(player);
        //eventHandler.init();
        grid.init();


        System.out.println(gridFactory.getWidth());
        System.out.println(gridFactory.getHeight());
    }
}
