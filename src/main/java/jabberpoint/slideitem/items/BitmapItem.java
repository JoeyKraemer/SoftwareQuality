package jabberpoint.slideitem.items;

import jabberpoint.slideitem.SlideItem;
import jabberpoint.style.StyleOptions;
import jabberpoint.style.styles.Style;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;


/**
 * <p>This is a  BitmapItem</p>
 * <p>Bitmap items have the responsibility to draw themselves.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */
public class BitmapItem implements SlideItem
{
    private BufferedImage bufferedImage;
    private String imageName; //path to file
    private Style style;

    @Override
    public SlideItem createSlideItem()
    {
        this.imageName = "Default.png";

        StyleOptions tempStyle = new StyleOptions();
        this.style = tempStyle.getText();

        try
        {
            this.bufferedImage = ImageIO.read(new File("./bitmapimage/" + this.imageName));
        } catch (IOException e)
        {
            System.err.println("File " + this.imageName + " not found");
        }

        return this;
    }

    @Override
    public SlideItem createSlideItem(Style style, String imageName)
    {
        this.style = style;
        if (imageName.length() < 4)
        {
            throw new IllegalArgumentException("Image needs to be at least 4 character long");
        }
        this.imageName = imageName;

        try
        {
            this.bufferedImage = ImageIO.read(new File("./bitmapimage/" + this.imageName));
        } catch (IOException e)
        {
            System.err.println("File " + this.imageName + " not found");
        }

        return this;
    }

    public String getImageName()
    {
        return imageName;
    }

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale)
    {
        return new Rectangle((int) (this.style.getIndent() * scale), 0,
                (int) (bufferedImage.getWidth(observer) * scale),
                ((int) (this.style.getLeading() * scale)) +
                        (int) (bufferedImage.getHeight(observer) * scale));
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, ImageObserver observer)
    {
        int width = x + (int) (this.style.getIndent() * scale);
        int height = y + (int) (this.style.getLeading() * scale);
        graphics.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
                (int) (bufferedImage.getHeight(observer) * scale), observer);
    }

    @Override
    public Style getStyle()
    {
        return this.style;
    }

}
