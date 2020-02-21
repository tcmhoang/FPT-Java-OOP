import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws InterruptedException {
        Sprite hah = new Sprite("assets/player.png",70);
        JFrame test = new JFrame();
        test.setSize(500,500);
        JLabel sh = new JLabel();
        sh.setIcon( new ImageIcon(hah.getTile(0,1)));
        sh.setLocation(0,0);
        test.add(sh);
        test.setVisible(true);
        TimeUnit.SECONDS.sleep(10);
        sh.setIcon(new ImageIcon(hah.getTile(0,3)));
    }
}
