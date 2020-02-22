import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Animation {

    private int currentSegment;              // Current Segment
    private int totalSegments;                // total amount of frames for your animation

    private List<ImageIcon> frames;    // Arraylist of frames

    public Animation(BufferedImage[] imgs) {
        currentSegment = 0;
        frames = Arrays.stream(imgs).map(ImageIcon::new).collect(Collectors.toList());
        totalSegments = frames.size();
    }

    public void update() {
                currentSegment += 1;
                if (currentSegment == totalSegments) {
                    currentSegment = 0;
                }

    }

    public ImageIcon getFrame(){
        return frames.get(currentSegment);
    }
}