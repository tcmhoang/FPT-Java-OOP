import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public class Animation {

    private int frameCount;                 // Counts ticks for change
    private int frameDelay;                 // frame delay 1-12 (You will have to play around with this)
    private int currentSegment;               // animations current frame
    private int totalSegments;                // total amount of frames for your animation

    private boolean stop;                // has animations stopped

    private List<BufferedImage> frames;    // Arraylist of frames

    public Animation(BufferedImage[] imgs, int framePerSec) {
        frameCount = 0;
        frameDelay = framePerSec;
        stop = false;
        frames = Arrays.asList(imgs);
        currentSegment = 0;
        totalSegments = frames.size();

    }

    public void update() {
        if (!stop) {
            frameCount++;

            if (frameCount > frameDelay) {
                frameCount = 0;
                currentSegment += 1;

                if (currentSegment > totalSegments - 1) {
                    currentSegment = 0;
                }
            }
        }

    }

    public BufferedImage getFrame(){
        return frames.get(currentSegment);
    }
}