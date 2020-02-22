import javax.swing.*;
import java.awt.image.BufferedImage;

public class Figure {
    BufferedImage[] frames;
    Animation animation;
    Figure(String spriteSheet, int size){
        Sprite obj = new Sprite(spriteSheet, size);
        BufferedImage[] frames = {obj.getTile(0,0), obj.getTile(0,1), obj.getTile(0,2), obj.getTile(0,3)};
        animation = new Animation(frames);
    }
    public void animate (JLabel component)
    {
        component.setIcon(animation.getFrame());
        animation.update();
    }
    public void clear(JLabel component)
    {
        component.setIcon(null);
    }
}
