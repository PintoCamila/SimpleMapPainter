package SimpleMapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


import java.util.LinkedList;

public class Player extends Rectangle {
    GridFactory gridFactory;
    Grid grid;
    Rectangle rectangle1;
    LinkedList<Rectangle> rectangleLinkedList;


    public Player(Grid grid) {
        super(grid.getPadding(), grid.getPadding(), grid.getCellSize(), grid.getCellSize());
        this.grid = grid;
        setColor(Color.GREEN);
        fill();
        EventHandler eventHandler = new EventHandler(this);
        eventHandler.init();
        this.rectangleLinkedList = new LinkedList<>();

    }


    public class EventHandler implements KeyboardHandler {
        Player player;
        private boolean isPainting = false;

        public EventHandler(Player player) {
            this.player = player;
        }

        public void init() {
            Keyboard kb = new Keyboard(this);

            KeyboardEvent right = new KeyboardEvent();
            right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            right.setKey(KeyboardEvent.KEY_RIGHT);

            kb.addEventListener(right);

            KeyboardEvent left = new KeyboardEvent();
            left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            left.setKey(KeyboardEvent.KEY_LEFT);

            kb.addEventListener(left);

            KeyboardEvent up = new KeyboardEvent();
            up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            up.setKey(KeyboardEvent.KEY_UP);

            kb.addEventListener(up);

            KeyboardEvent down = new KeyboardEvent();
            down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            down.setKey(KeyboardEvent.KEY_DOWN);

            kb.addEventListener(down);

            KeyboardEvent space = new KeyboardEvent();
            space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            space.setKey(KeyboardEvent.KEY_SPACE);

            kb.addEventListener(space);

            KeyboardEvent spaceLift = new KeyboardEvent();
            spaceLift.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            spaceLift.setKey(KeyboardEvent.KEY_SPACE);

            kb.addEventListener(spaceLift);

            KeyboardEvent save = new KeyboardEvent();
            save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            save.setKey(KeyboardEvent.KEY_S);

            kb.addEventListener(save);

            KeyboardEvent load = new KeyboardEvent();
            load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            load.setKey(KeyboardEvent.KEY_L);

            kb.addEventListener(load);

            KeyboardEvent clear = new KeyboardEvent();
            load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            load.setKey(KeyboardEvent.KEY_X);

            kb.addEventListener(clear);

        }


        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_RIGHT:
                    if (player.getX() + grid.getCellSize() < grid.getWidth()) {
                        player.translate(grid.getCellSize(), 0);

                        break;
                    }
                    break;
                case KeyboardEvent.KEY_LEFT:
                    if (player.getX() + grid.getCellSize() > grid.rowToY(1)) {
                        player.translate(-grid.getCellSize(), 0);

                        break;
                    }
                    break;
                case KeyboardEvent.KEY_UP:
                    if (player.getY() + grid.getCellSize() > grid.coltoX(1)) {
                        player.translate(0, -grid.getCellSize());

                        break;
                    }
                    break;
                case KeyboardEvent.KEY_DOWN:
                    if (player.getY() + grid.getCellSize() < grid.getHeight()) {
                        player.translate(0, grid.getCellSize());

                        break;
                    }
                    break;
                case KeyboardEvent.KEY_SPACE:
                    isPainting = true;

                    if (isPainting) {

                        for (Rectangle rectangleEl : rectangleLinkedList) {

                            if (rectangleEl.getY() == player.getY() && rectangleEl.getX() == player.getX()) {

                                rectangleEl.draw();
                                rectangleLinkedList.remove(rectangleEl);

                                return;
                            }
                        }
                        rectangle1 = new Rectangle(player.getX(), player.getY(), grid.getCellSize(), grid.getCellSize());
                        paintCell();
                        rectangleLinkedList.add(rectangle1);
                    }
                    break;
                case KeyboardEvent.KEY_S:

                    FileManager.writeFile(player.toString());

                    break;
                case KeyboardEvent.KEY_L:

                    StringToGrid(FileManager.readFile());

                    break;
                case KeyboardEvent.KEY_X:

                    eraseAllCells();

                    break;
            }

        }


        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

                isPainting = false;

            }

        }

        public void paintCell() {
            if (isPainting) {
                rectangle1 = new Rectangle(player.getX(), player.getY(), grid.getCellSize(), grid.getCellSize());
                rectangle1.fill();


                }
            }

        public void eraseAllCells() {
            if (!isPainting) {
                for (int i = 0; i < rectangleLinkedList.size(); i++) {

                    rectangleLinkedList.get(i).draw();

                }
                rectangleLinkedList.removeAll(rectangleLinkedList);
            }
        }
    }


    @Override
    public String toString() {
        String result = "";

        for (Rectangle rectangleEl : rectangleLinkedList) {

            result += rectangleEl.getX() + "/" + rectangleEl.getY() + ",";
        }
        return result;

    }


    public void StringToGrid(String grid) {
        String[] cells = grid.split(",");

        for (String cell : cells) {

            String[] position = cell.split("/");

            rectangle1 = new Rectangle(Integer.parseInt(position[0]), Integer.parseInt(position[1]), this.grid.getCellSize(), this.grid.getCellSize());
            rectangle1.fill();
        }
    }


}
