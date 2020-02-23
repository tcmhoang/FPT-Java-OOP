import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class Figure {
    Animation UP, DOWN, LEFT, RIGHT;

    Figure(String spriteSheet, int size) {
        Sprite obj = new Sprite(spriteSheet, size);

        BufferedImage[] downFrames = {obj.getTile(0, 0), obj.getTile(0, 1), obj.getTile(0, 2), obj.getTile(0, 3)};
        BufferedImage[] rightFrames = {obj.getTile(1, 0), obj.getTile(1, 1), obj.getTile(1, 2), obj.getTile(1, 3)};
        BufferedImage[] leftFrames = {obj.getTile(2, 0), obj.getTile(2, 1), obj.getTile(2, 2), obj.getTile(2, 3)};
        BufferedImage[] upFrames = {obj.getTile(3, 0), obj.getTile(3, 1), obj.getTile(3, 2), obj.getTile(3, 3)};

        DOWN = new Animation(downFrames);
        RIGHT = new Animation(rightFrames);
        LEFT = new Animation(leftFrames);
        UP = new Animation(upFrames);
    }

    public void animate(JLabel component, String direction) {
        switch (direction) {
            case "UP":
                component.setIcon(UP.getFrame());
                UP.update();
                break;
            case "DOWN":
                component.setIcon(DOWN.getFrame());
                DOWN.update();
                break;
            case "LEFT":
                component.setIcon(LEFT.getFrame());
                LEFT.update();
                break;
            case "RIGHT":
                component.setIcon(RIGHT.getFrame());
                RIGHT.update();
                break;
            default:
                break;
        }
    }

    public void clear(JLabel component) {
        component.setIcon(null);
    }

}
