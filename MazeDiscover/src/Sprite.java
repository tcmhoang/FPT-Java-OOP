import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Sprite {
    private BufferedImage sheet;
    private int title_size ;
    public Sprite(String path, int size)
    {
        __init__(path,size);
    }

    private void __init__(String fileName, int size )
    {
        try
        {
            sheet = ImageIO.read(new File(fileName));
            title_size = size;
        }
        catch (Exception e)
        {
            throw new ResourceException("FileResource: cannot access " + fileName);
        }
    }

    public BufferedImage getTile(int row, int col)
    {
        return sheet.getSubimage(col * title_size, row* title_size, title_size, title_size);
    }
}
